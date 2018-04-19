package com.superbluecat.ziyue.service;

import com.superbluecat.ziyue.entities.UsersEntity;

public interface UsersService {

    Integer userNum(String username);

    UsersEntity save(String username, String password, String nickname, String email, String tel);

    Boolean delete(String username, String password, String apiKey, Integer id);

    Boolean update(String username, String password, String nickname, String email, String tel, String apiKey);

    UsersEntity get(String username, String password, String apiKey);

    Boolean buyPackages(String username, String password, String apiKey, Integer id);

    Boolean buyThemes(String username, String password, String apiKey, Integer id);
}
