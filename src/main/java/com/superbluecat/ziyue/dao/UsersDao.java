package com.superbluecat.ziyue.dao;

import com.superbluecat.ziyue.model.UsersEntity;

/**
 * @author zjh
 */
public interface UsersDao {

    void add(UsersEntity usersEntity);

    void delete(Integer id);

    void update(UsersEntity usersEntity);

    UsersEntity get(String apiKey);
}
