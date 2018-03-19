package com.superbluecat.ziyue.service.impl;

import com.superbluecat.ziyue.dao.PackagesDao;
import com.superbluecat.ziyue.dao.UsersDao;
import com.superbluecat.ziyue.entities.PackagesEntity;
import com.superbluecat.ziyue.service.PackagesService;
import com.superbluecat.ziyue.tools.HibernateTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Boolean save(String name, Integer money, byte type, Integer monNumber, Integer comNumber, String apiKey) {
        if (usersDao.get(apiKey).getUserType() == 1) {
            return false;
        }
        PackagesEntity packagesEntity = new PackagesEntity();
        packagesEntity.setComNumber(comNumber);
        packagesEntity.setMoney(money);
        packagesEntity.setMonNumber(monNumber);
        packagesEntity.setName(name);
        packagesEntity.setType(type);
        return packagesDao.save(packagesEntity) > 0;
    }

    @Override
    public Boolean delete(Integer id, String apiKey) {
        if (usersDao.get(apiKey).getUserType() == 1) {
            return false;
        }
        packagesDao.delete(id);
        return true;
    }

    @Override
    public Boolean update(Integer id, String name, Integer money, Integer monNumber, Integer comNumber, String apiKey) {
        if (usersDao.get(apiKey).getUserType() == 1) {
            return false;
        }
        PackagesEntity packagesEntity = packagesDao.getOne(id);
        packagesEntity.setMoney(money);
        packagesDao.update(packagesEntity);
        return true;
    }

    @Override
    public List getAll(Integer type) {
        return packagesDao.getAll();
    }
}
