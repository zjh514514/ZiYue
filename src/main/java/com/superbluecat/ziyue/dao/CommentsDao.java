package com.superbluecat.ziyue.dao;

import com.superbluecat.ziyue.model.CommentsEntity;

import java.util.List;

public interface CommentsDao {

    void save(CommentsEntity commentsEntity);

    void delete(Integer id);

    void update(CommentsEntity commentsEntity);

    List get(Integer userId);
}
