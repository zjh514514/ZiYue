package com.superbluecat.ziyue.service.impl;

import com.superbluecat.ziyue.dao.CommentsDao;
import com.superbluecat.ziyue.dao.UsersDao;
import com.superbluecat.ziyue.entities.CommentsEntity;
import com.superbluecat.ziyue.entities.UsersEntity;
import com.superbluecat.ziyue.service.CommentsService;
import com.superbluecat.ziyue.tools.HibernateTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * @author zjh
 */
@Service
public class CommentsServiceImpl extends HibernateTools implements CommentsService {

    private final CommentsDao commentsDao;
    private final UsersDao usersDao;

    @Autowired
    public CommentsServiceImpl(CommentsDao commentsDao, UsersDao usersDao) {
        this.commentsDao = commentsDao;
        this.usersDao = usersDao;
    }

    @Override
    public Boolean add(String apiKey, String comment, String email, String nickName, Integer toCommentId, String ua, String website) {
        UsersEntity usersEntity = usersDao.get(apiKey);
        Date date = new Date();
        boolean judge = (usersEntity == null) || (usersEntity.getIsMonth() == 1 && usersEntity.getPayTime().compareTo(date) < 0) || (usersEntity.getIsMonth() == 0 && usersEntity.getCommentsLeft() < 0);
        if (judge) {
            return false;
        }
        CommentsEntity commentsEntity = new CommentsEntity();
        commentsEntity.setComment(comment);
        commentsEntity.setEmail(email);
        commentsEntity.setNickname(nickName);
        commentsEntity.setTime(new Timestamp(date.getTime()));
        commentsEntity.setToCommentId(toCommentId);
        commentsEntity.setUa(ua);
        commentsEntity.setWebsite(website);
        commentsEntity.setUserId(usersEntity.getUserId());
        if (usersEntity.getIsMonth() == 0) {
            usersEntity.setCommentsLeft(usersEntity.getCommentsLeft() - 1);
            usersDao.update(usersEntity);
        }
        commentsDao.save(commentsEntity);
        return true;
    }

    @Override
    public Boolean delete(String apiKey, Integer id) {
        UsersEntity usersEntity = usersDao.get(apiKey);
        CommentsEntity commentsEntity = commentsDao.getOne(id);
        if (usersEntity.getUserId() == commentsEntity.getUserId()) {
            commentsDao.delete(id);
            return true;
        }
        return false;
    }

    @Override
    public Boolean update(Integer id, String comment, String email, String nickName, Integer toCommentId, String ua, String website) {
        CommentsEntity commentsEntity = commentsDao.getOne(id);
        commentsEntity.setWebsite(website);
        commentsEntity.setComment(comment);
        commentsEntity.setEmail(email);
        commentsDao.update(commentsEntity);
        return true;
    }

    @Override
    public List get(String apiKey) {
        UsersEntity usersEntity = usersDao.get(apiKey);
        Date date = new Date();
        boolean judge = (usersEntity.getIsMonth() == 1 && usersEntity.getPayTime().compareTo(date) < 0) || (usersEntity.getIsMonth() == 0 && usersEntity.getCommentsLeft() < 0);
        if (judge) {
            return Collections.emptyList();
        }
        return commentsDao.get(usersEntity.getUserId());
    }
}
