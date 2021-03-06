package com.superbluecat.ziyue.dao;

import com.superbluecat.ziyue.entities.UsersEntity;

public interface UsersDao {

    Integer save(UsersEntity usersEntity);

    void delete(Integer id);

    void update(UsersEntity usersEntity);

    UsersEntity get(String apiKey);

    Integer usernameNum(String username);
}
