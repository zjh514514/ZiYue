package com.superbluecat.ziyue.service.impl;

import com.superbluecat.ziyue.dao.PackagesDao;
import com.superbluecat.ziyue.dao.UsersDao;
import com.superbluecat.ziyue.entities.PackagesEntity;
import com.superbluecat.ziyue.service.PackagesService;
import com.superbluecat.ziyue.tools.HibernateTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class PackagesServiceImpl extends HibernateTools implements PackagesService {

    private final PackagesDao packagesDao;
    private final UsersDao usersDao;

    @Autowired
    public PackagesServiceImpl(PackagesDao packagesDao, UsersDao usersDao) {
        this.packagesDao = packagesDao;
        this.usersDao = usersDao;
    }

    @Override
    public Boolean add(String name, Integer money, byte type, Integer monNumber, Integer comNumber, String apiKey) {
        if (usersDao.get(apiKey).getUserType() == 1) {
            return false;
        }
        PackagesEntity packagesEntity = new PackagesEntity();
        packagesEntity.setComNumber(comNumber);
        packagesEntity.setMoney(money);
        packagesEntity.setMonNumber(monNumber);
        packagesEntity.setName(name);
        packagesEntity.setType(type);
        packagesDao.add(packagesEntity);
        return true;
    }

    @Override
    public Boolean delete(Integer id, String apiKey) {
        return null;
    }

    @Override
    public Boolean update(Integer id, String name, Integer money, Integer monNumber, Integer comNumber, String apiKey) {
        return null;
    }

    @Override
    public List getAll() {
        return Collections.emptyList();
    }
}
