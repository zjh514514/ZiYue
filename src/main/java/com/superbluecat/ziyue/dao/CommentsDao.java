package com.superbluecat.ziyue.dao;

import com.superbluecat.ziyue.entities.CommentsEntity;

import java.util.List;

public interface CommentsDao {

    Integer save(CommentsEntity commentsEntity);

    void delete(Integer id);

    void update(CommentsEntity commentsEntity);

    List get(Integer userId);

    CommentsEntity getOne(Integer id);
}
