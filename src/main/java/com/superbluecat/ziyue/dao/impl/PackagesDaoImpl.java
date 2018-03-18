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
    public Integer save(PackagesEntity packagesEntity) {
        return (Integer) getSession().save(packagesEntity);
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
    public PackagesEntity getOne(Integer id) {
        hql = "FROM PackagesEntity p WHERE p.id = ?";
        List list = getSession().createQuery(hql).setParameter(0, id).list();
        if (list.size() > 0) {
            return (PackagesEntity) list.get(0);
        } else {
            return null;
        }
    }

    @Override
    public List getAll() {
        hql = "FROM PackagesEntity";
        return getSession().createQuery(hql).list();
    }
}
