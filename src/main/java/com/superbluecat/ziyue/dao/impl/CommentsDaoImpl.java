package com.superbluecat.ziyue.dao.impl;

import com.superbluecat.ziyue.dao.CommentsDao;
import com.superbluecat.ziyue.model.CommentsEntity;
import com.superbluecat.ziyue.tools.HibernateTools;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommentsDaoImpl extends HibernateTools implements CommentsDao {

    private String hql;

    public void save(CommentsEntity commentsEntity) {
        getSession().save(commentsEntity);
    }

    public void delete(Integer id) {
        getSession().delete(id);
    }

    public void update(CommentsEntity commentsEntity) {
        getSession().update(commentsEntity);
    }

    public List get(Integer userId) {
        hql = "FROM CommentsEntity c WHERE c.userId = ?";
        return getSession().createQuery(hql).setParameter(0, userId).list();
    }
}
