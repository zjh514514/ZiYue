package com.superbluecat.ziyue.dao;

import com.superbluecat.ziyue.entities.PackagesEntity;

import java.util.List;

public interface PackagesDao {

    void add(PackagesEntity packagesEntity);

    void delete(Integer id);

    void update(PackagesEntity packagesEntity);

    List getAll(Integer... type);
}
