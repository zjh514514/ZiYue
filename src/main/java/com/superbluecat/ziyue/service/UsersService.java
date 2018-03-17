package com.superbluecat.ziyue.service;

import java.util.Date;
import java.util.Map;

public interface UsersService {

    Map add(String username, String password, String nickname, String email, String tel, String apiKey, byte userType, byte isMonth, Date payTime, Integer commentsLeft);


}
