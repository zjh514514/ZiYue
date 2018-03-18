package com.superbluecat.ziyue.service;

import java.util.Date;
import java.util.List;

public interface UsersService {

    Boolean save(String username, String password, String nickname, String email, String tel, String apiKey, byte userType, byte isMonth, Date payTime, Integer commentsLeft);

    Boolean delete(Integer id);

    Boolean update(String username, String password, String nickname, String email, String tel, String apiKey, byte userType, byte isMonth, Date payTime, Integer commentsLeft);

    List get(String username, String password, String apiKey);
}
