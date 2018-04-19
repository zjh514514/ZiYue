package com.superbluecat.ziyue.service.impl;

import com.superbluecat.ziyue.dao.ThemeDao;
import com.superbluecat.ziyue.dao.UsersDao;
import com.superbluecat.ziyue.entities.ThemeEntity;
import com.superbluecat.ziyue.entities.UsersEntity;
import com.superbluecat.ziyue.service.ThemesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThemesServiceImpl implements ThemesService {

    private final ThemeDao themeDao;
    private final UsersDao usersDao;

    @Autowired
    public ThemesServiceImpl(ThemeDao themeDao, UsersDao usersDao) {
        this.themeDao = themeDao;
        this.usersDao = usersDao;
    }

    @Override
    public Boolean save(String themeName, double money, String apiKey) {
        if (check(apiKey)) {
            ThemeEntity themeEntity = new ThemeEntity();
            themeEntity.setMoney(money);
            themeEntity.setThemeName(themeName);
            themeDao.save(themeEntity);
            return true;
        }
        return false;
    }

    @Override
    public Boolean delete(Integer themeId, String apiKey) {
        if (check(apiKey)) {
            themeDao.delete(themeId);
            return true;
        }
        return false;
    }

    @Override
    public Boolean update(Integer themeId, double money, String apiKey) {
        if (check(apiKey)) {
            ThemeEntity themeEntity = themeDao.getOne(themeId);
            themeEntity.setMoney(money);
            themeDao.update(themeEntity);
            return true;
        }
        return false;
    }

    @Override
    public List getAll() {
        return themeDao.getTheme();
    }

    private Boolean check(String apiKey) {
        UsersEntity usersEntity = usersDao.get(apiKey);
        if (usersEntity != null) {
            return usersEntity.getUserType() == 1;
        }
        return false;
    }
}
