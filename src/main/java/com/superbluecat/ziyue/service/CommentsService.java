package com.superbluecat.ziyue.service;

import java.util.List;

public interface CommentsService {

    Boolean save(String username, String password, String apiKey, String comment, String email, String nickName, Integer toCommentId, String ua, String website);

    Boolean delete(String username, String password, String apiKey, Integer id);

    Boolean update(Integer id, String comment, String email, String website);

    List get(String username, String password, String apiKey);
}
