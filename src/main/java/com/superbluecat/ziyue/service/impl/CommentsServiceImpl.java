package com.superbluecat.ziyue.service.impl;

import com.superbluecat.ziyue.dao.CommentsDao;
import com.superbluecat.ziyue.dao.UsersDao;
import com.superbluecat.ziyue.model.CommentsEntity;
import com.superbluecat.ziyue.model.UsersEntity;
import com.superbluecat.ziyue.service.CommentsService;
import com.superbluecat.ziyue.tools.HibernateTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zjh
 */
@Service
public class CommentsServiceImpl extends HibernateTools implements CommentsService {

    private Map<String, Object> map = new HashMap<String, Object>(16);

    private final CommentsDao commentsDao;
    private final UsersDao usersDao;

    @Autowired
    public CommentsServiceImpl(CommentsDao commentsDao, UsersDao usersDao) {
        this.commentsDao = commentsDao;
        this.usersDao = usersDao;
    }

    public Map add(String apiKey, String comment, String email, String nickName, Integer toCommentId, String ua, String website) {
        try {
            UsersEntity usersEntity = usersDao.get(apiKey);
            Date date = new Date();
            boolean judge = (usersEntity.getIsMonth() == 1 && usersEntity.getPayTime().compareTo(date) < 0) || (usersEntity.getIsMonth() == 0 && usersEntity.getCommentsLeft() < 0);
            if (judge) {
                map.put("message", "该用户暂未续费，暂时无法评论");
                return map;
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
            map.put("message", "success");
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            map.put("message", "服务器错误");
            return map;
        }
    }

    public Map delete(Integer id) {
        try {
            commentsDao.delete(id);
            map.put("message", "success");
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            map.put("message", "服务器错误");
            return map;
        }
    }

    public Map update(Integer id, String comment, String email, String nickName, Integer toCommentId, String ua, String website) {
        try {
            CommentsEntity commentsEntity = commentsDao.getOne(id);
            commentsEntity.setWebsite(website);
            commentsEntity.setComment(comment);
            commentsEntity.setEmail(email);
            commentsDao.update(commentsEntity);
            map.put("message", "success");
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            map.put("message", "该条评论未找到，可能已被删除");
            return map;
        }
    }

    public Map get(String apiKey) {
        UsersEntity usersEntity = usersDao.get(apiKey);
        Date date = new Date();
        boolean judge = (usersEntity.getIsMonth() == 1 && usersEntity.getPayTime().compareTo(date) < 0) || (usersEntity.getIsMonth() == 0 && usersEntity.getCommentsLeft() < 0);
        if (judge){
            map.put("message","当前资费不足，请及时充值");
        }
        map.put("data", commentsDao.get(usersEntity.getUserId()));
        return map;
    }
}
