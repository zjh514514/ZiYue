package com.superbluecat.ziyue.dao.impl;

import com.superbluecat.ziyue.dao.UsersDao;
import com.superbluecat.ziyue.model.UsersEntity;
import com.superbluecat.ziyue.tools.HibernateTools;
import org.springframework.stereotype.Repository;

/**
 * @author zjh
 */
@Repository
public class UsersDaoImpl extends HibernateTools implements UsersDao {

    private String hql;

    public void add(UsersEntity usersEntity) {
        getSession().save(usersEntity);
    }

    public void delete(Integer id) {
        getSession().delete(id);
    }

    public void update(UsersEntity usersEntity) {
        getSession().update(usersEntity);
    }

    public UsersEntity get(String apiKey) {
        hql = "FROM UsersEntity u WHERE u.apiKey = ?";
        return (UsersEntity) getSession().createQuery(hql).setParameter(0, apiKey).getSingleResult();
    }
}
