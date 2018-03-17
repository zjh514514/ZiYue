package com.superbluecat.ziyue.dao.impl;

import com.superbluecat.ziyue.dao.PackagesDao;
import com.superbluecat.ziyue.entities.PackagesEntity;
import com.superbluecat.ziyue.tools.HibernateTools;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PackagesDaoImpl extends HibernateTools implements PackagesDao {

    private String hql;

    @Override
    public void add(PackagesEntity packagesEntity) {
        getSession().save(packagesEntity);
    }

    @Override
    public void delete(Integer id) {
        getSession().delete(id);
    }

    @Override
    public void update(PackagesEntity packagesEntity) {
        getSession().update(packagesEntity);
    }

    @Override
    public List getAll(Integer... type) {
        if (type != null) {
            hql = "FROM PackagesEntity";
        } else {
            hql = "FROM PackagesEntity p WHERE p.type = ?";
        }
        return getSession().createQuery(hql).setParameter(0, type).list();
    }
}
