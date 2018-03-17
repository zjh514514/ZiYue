package com.superbluecat.ziyue.dao.impl;

import com.superbluecat.ziyue.dao.CommentsDao;
import com.superbluecat.ziyue.entities.CommentsEntity;
import com.superbluecat.ziyue.tools.HibernateTools;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zjh
 */
@Repository
public class CommentsDaoImpl extends HibernateTools implements CommentsDao {

    private String hql;

    @Override
    public void save(CommentsEntity commentsEntity) {
        getSession().save(commentsEntity);
    }

    @Override
    public void delete(Integer id) {
        getSession().delete(id);
    }

    @Override
    public void update(CommentsEntity commentsEntity) {
        getSession().update(commentsEntity);
    }

    @Override
    public List get(Integer userId) {
        hql = "FROM CommentsEntity c WHERE c.userId = ?";
        return getSession().createQuery(hql).setParameter(0, userId).list();
    }

    @Override
    public CommentsEntity getOne(Integer id) {
        hql = "FROM CommentsEntity c WHERE c.commentId = ?";
        List list = getSession().createQuery(hql).setParameter(0, id).list();
        if (list.size() > 0) {
            return (CommentsEntity) list.get(0);
        } else {
            return null;
        }
    }
}
