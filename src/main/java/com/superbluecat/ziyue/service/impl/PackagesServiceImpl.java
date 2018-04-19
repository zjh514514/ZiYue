package com.superbluecat.ziyue.service.impl;

import com.superbluecat.ziyue.dao.PackagesDao;
import com.superbluecat.ziyue.dao.UsersDao;
import com.superbluecat.ziyue.entities.PackagesEntity;
import com.superbluecat.ziyue.entities.UsersEntity;
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
        if (check(apiKey)) {
            PackagesEntity packagesEntity = new PackagesEntity();
            packagesEntity.setComNumber(comNumber);
            packagesEntity.setMoney(money);
            packagesEntity.setMonNumber(monNumber);
            packagesEntity.setName(name);
            packagesEntity.setType(type);
            return packagesDao.save(packagesEntity) > 0;
        }
        return false;
    }

    @Override
    public Boolean delete(Integer id, String apiKey) {
        if (check(apiKey)) {
            packagesDao.delete(id);
            return true;
        }
        return false;
    }

    @Override
    public Boolean update(Integer id, String name, Integer money, Integer monNumber, Integer comNumber, String apiKey) {
        if (check(apiKey)) {
            PackagesEntity packagesEntity = packagesDao.getOne(id);
            if (packagesEntity == null) {
                return false;
            }
            packagesEntity.setMoney(money);
            packagesDao.update(packagesEntity);
            return true;
        }
        return false;
    }

    @Override
    public List getAll(Integer type) {
        return packagesDao.getAll();
    }

    private Boolean check(String apiKey) {
        UsersEntity usersEntity = usersDao.get(apiKey);
        if (usersEntity != null) {
            return usersEntity.getUserType() == 1;
        }
        return false;
    }
}
