package com.superbluecat.ziyue.tools;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.annotation.Resource;

/**
 * @author zjh
 */
public class HibernateTools {

    @Resource
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }
}
