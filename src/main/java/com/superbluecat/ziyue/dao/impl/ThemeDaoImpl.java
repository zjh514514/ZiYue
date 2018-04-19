package com.superbluecat.ziyue.dao.impl;

import com.superbluecat.ziyue.dao.ThemeDao;
import com.superbluecat.ziyue.entities.ThemeEntity;
import com.superbluecat.ziyue.tools.HibernateTools;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ThemeDaoImpl extends HibernateTools implements ThemeDao {

    private String hql;

    @Override
    public Integer save(ThemeEntity themeEntity) {
        return (Integer) getSession().save(themeEntity);
    }

    @Override
    public void update(ThemeEntity themeEntity) {
        getSession().update(themeEntity);
    }

    @Override
    public void delete(Integer id) {
        getSession().delete(id);
    }

    @Override
    public List getTheme() {
        hql = "FROM ThemeEntity ";
        return getSession().createQuery(hql).list();
    }

    @Override
    public ThemeEntity getOne(Integer id) {
        hql = "FROM ThemeEntity t WHERE t.id = ?";
        List list = getSession().createQuery(hql).setParameter(0, id).list();
        if (list.size() > 0) {
            return (ThemeEntity) list.get(0);
        } else {
            return null;
        }
    }
}
