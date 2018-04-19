package com.superbluecat.ziyue.service.impl;

import com.superbluecat.ziyue.dao.PackagesDao;
import com.superbluecat.ziyue.dao.ThemeDao;
import com.superbluecat.ziyue.dao.UserThemeDao;
import com.superbluecat.ziyue.dao.UsersDao;
import com.superbluecat.ziyue.entities.PackagesEntity;
import com.superbluecat.ziyue.entities.ThemeEntity;
import com.superbluecat.ziyue.entities.UserThemeEntity;
import com.superbluecat.ziyue.entities.UsersEntity;
import com.superbluecat.ziyue.service.UsersService;
import com.superbluecat.ziyue.tools.Sha256;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

@Service
public class UsersServiceImpl implements UsersService {

    private final UsersDao usersDao;
    private final PackagesDao packagesDao;
    private final ThemeDao themeDao;
    private final UserThemeDao userThemeDao;

    @Autowired
    public UsersServiceImpl(UsersDao usersDao, PackagesDao packagesDao, ThemeDao themeDao, UserThemeDao userThemeDao) {
        this.usersDao = usersDao;
        this.packagesDao = packagesDao;
        this.themeDao = themeDao;
        this.userThemeDao = userThemeDao;
    }

    @Override
    public Integer userNum(String username) {
        return usersDao.usernameNum(username);
    }

    @Override
    public UsersEntity save(String username, String password, String nickname, String email, String tel) {
        UsersEntity usersEntity = new UsersEntity();
        usersEntity.setUsername(username);
        usersEntity.setPassword(Sha256.getSHA256StrJava(password));
        String apiKey = Sha256.getSHA256StrJava(username + password + Sha256.getRandomString(4));
        usersEntity.setApiKey(apiKey);
        usersEntity.setNickname(nickname);
        usersEntity.setEmail(email);
        usersEntity.setTel(tel);
        usersEntity.setIsMonth((byte) 0);
        usersEntity.setCommentsLeft(0);
        usersEntity.setUserType((byte) 0);
        usersEntity.setPayTime(Timestamp.valueOf(LocalDateTime.now()));
        usersDao.save(usersEntity);
        return usersEntity;
    }

    @Override
    public Boolean delete(String username, String password, String apiKey, Integer id) {
        if (check(username, password, apiKey)) {
            usersDao.delete(id);
            return true;
        }
        return false;
    }

    @Override
    public Boolean update(String username, String password, String nickname, String email, String tel, String apiKey) {
        if (check(username, password, apiKey)) {
            UsersEntity usersEntity = usersDao.get(apiKey);
            usersEntity.setPassword(Sha256.getSHA256StrJava(password));
            usersEntity.setNickname(nickname);
            usersEntity.setEmail(email);
            usersEntity.setTel(tel);
            usersDao.update(usersEntity);
            return true;
        }
        return false;
    }

    @Override
    public UsersEntity get(String username, String password, String apiKey) {
        if (check(username, password, apiKey)) {
            return usersDao.get(apiKey);
        }
        return new UsersEntity();
    }

    @Override
    public Boolean buyPackages(String username, String password, String apiKey, Integer id) {
        if (check(username, password, apiKey)) {
            PackagesEntity packagesEntity = packagesDao.getOne(id);
            UsersEntity usersEntity = usersDao.get(apiKey);
            if (packagesEntity == null || usersEntity == null) {
                return false;
            }
            byte type = packagesEntity.getType();
            switch (type) {
                case 0:
                    usersEntity.setCommentsLeft(usersEntity.getCommentsLeft() + packagesEntity.getComNumber());
                    usersDao.update(usersEntity);
                    break;
                case 1:
                    usersEntity.setIsMonth(type);
                    if (usersEntity.getPayTime().compareTo(new Date()) <= 0) {
                        int month = packagesEntity.getMonNumber();
                        LocalDateTime localDateTime = LocalDateTime.now();
                        usersEntity.setPayTime(Timestamp.valueOf(localDateTime.plusMonths(month)));
                    } else {
                        usersEntity.setPayTime(Timestamp.valueOf(usersEntity.getPayTime().toLocalDateTime().plusMonths(packagesEntity.getMonNumber())));
                    }
                    break;
                default:
                    return false;
            }
            return true;
        }
        return false;
    }

    @Override
    public Boolean buyThemes(String username, String password, String apiKey, Integer id) {
        if (check(username, password, apiKey)) {
            ThemeEntity themeEntity = themeDao.getOne(id);
            UsersEntity usersEntity = usersDao.get(apiKey);
            if (themeEntity == null || usersEntity == null) {
                return false;
            }
            userThemeDao.setIsUse(usersEntity.getUserId(), (byte) 0);
            UserThemeEntity userThemeEntity = new UserThemeEntity();
            userThemeEntity.setThemeId(id);
            userThemeEntity.setUserId(usersEntity.getUserId());
            userThemeEntity.setIsUse((byte) 1);
            userThemeDao.save(userThemeEntity);
            return true;
        }
        return false;
    }

    private Boolean check(String username, String password, String apiKey) {
        UsersEntity usersEntity = usersDao.get(apiKey);
        if (usersEntity != null) {
            return (usersEntity.getUsername().equals(username) && usersEntity.getPassword().equals(Sha256.getSHA256StrJava(password)));
        }
        return false;
    }
}
