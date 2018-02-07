package com.superbluecat.ziyue.service;

import java.util.Map;

/**
 * @author zjh
 */
public interface CommentsService {

    /**
     * 增加一条留言
     * @param apiKey 判断是否注册
     * @param comment 留言内容
     * @param email Email
     * @param nickName 昵称
     * @param toCommentId 回复对象
     * @param ua 浏览器标识
     * @param website 网址
     * @return 是否添加成功
     */
    Map add(String apiKey, String comment, String email, String nickName, Integer toCommentId, String ua, String website);

    /**
     * 删除一条评论
     * @param id 评论的id
     * @return 是否删除成功
     */
    Map delete(Integer id);

    /**
     *
     * @param id
     * @param comment
     * @param email
     * @param nickName
     * @param toCommentId
     * @param ua
     * @param website
     * @return
     */
    Map update(Integer id, String comment, String email, String nickName, Integer toCommentId, String ua, String website);

    /**
     *
     * @param apiKey
     * @return
     */
    Map get(String apiKey);
}
