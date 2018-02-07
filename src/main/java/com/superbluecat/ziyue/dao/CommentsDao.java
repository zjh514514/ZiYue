package com.superbluecat.ziyue.dao;

import com.superbluecat.ziyue.model.CommentsEntity;

import java.util.List;

/**
 * @author zjh
 */
public interface CommentsDao {

    /**
     * 保存一条评论
     *
     * @param commentsEntity:保存的实体类
     */
    void save(CommentsEntity commentsEntity);

    void delete(Integer id);

    void update(CommentsEntity commentsEntity);

    List get(Integer userId);

    CommentsEntity getOne(Integer id);
}
