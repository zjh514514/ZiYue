package com.superbluecat.ziyue.dao;

import com.superbluecat.ziyue.entities.PackagesEntity;

import java.util.List;

public interface PackagesDao {

    Integer save(PackagesEntity packagesEntity);

    void delete(Integer id);

    void update(PackagesEntity packagesEntity);

    PackagesEntity getOne(Integer id);

    List getAll();
}
