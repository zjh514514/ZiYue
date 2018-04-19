package com.superbluecat.ziyue.dao.impl;

import com.superbluecat.ziyue.dao.UsersDao;
import com.superbluecat.ziyue.entities.UsersEntity;
import com.superbluecat.ziyue.tools.HibernateTools;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zjh
 */
@Repository
public class UsersDaoImpl extends HibernateTools implements UsersDao {

    private String hql;

    @Override
    public Integer save(UsersEntity usersEntity) {
        return (Integer) getSession().save(usersEntity);
    }

    @Override
    public void delete(Integer id) {
        getSession().delete(id);
    }

    @Override
    public void update(UsersEntity usersEntity) {
        getSession().update(usersEntity);
    }

    @Override
    public UsersEntity get(String apiKey) {
        hql = "FROM UsersEntity u WHERE u.apiKey = ?";
        List list = getSession().createQuery(hql).setParameter(0, apiKey).list();
        if (list.size() > 0) {
            return (UsersEntity) list.get(0);
        } else {
            return null;
        }
    }

    @Override
    public Integer usernameNum(String username) {
        hql = "SELECT count(*) FROM UsersEntity u WHERE u.username = ?";
        return ((Number) getSession().createQuery(hql).setParameter(0, username).uniqueResult()).intValue();
    }
}
