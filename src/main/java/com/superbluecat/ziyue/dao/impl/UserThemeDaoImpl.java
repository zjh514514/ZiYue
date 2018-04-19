package com.superbluecat.ziyue.dao.impl;

import com.superbluecat.ziyue.dao.UserThemeDao;
import com.superbluecat.ziyue.entities.UserThemeEntity;
import com.superbluecat.ziyue.tools.HibernateTools;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserThemeDaoImpl extends HibernateTools implements UserThemeDao {

    private String hql;

    @Override
    public Integer save(UserThemeEntity userThemeEntity) {
        return (Integer) getSession().save(userThemeEntity);
    }

    @Override
    public void update(UserThemeEntity userThemeEntity) {
        getSession().update(userThemeEntity);
    }

    @Override
    public void delete(Integer id) {
        getSession().delete(id);
    }

    @Override
    public List getUserThemes(Integer userId) {
        hql = "FROM UserThemeEntity u WHERE u.userId = ?";
        return getSession().createQuery(hql).setParameter(0, userId).list();
    }

    @Override
    public void setIsUse(Integer userId, byte isUse) {
        hql = "UPDATE UserThemeEntity u SET u.isUse = ? WHERE u.userId = ?";
        getSession().createQuery(hql).setParameter(0, userId).setParameter(1, isUse).executeUpdate();
    }
}
