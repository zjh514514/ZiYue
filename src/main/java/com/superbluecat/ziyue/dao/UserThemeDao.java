package com.superbluecat.ziyue.dao;

import com.superbluecat.ziyue.entities.UserThemeEntity;

import java.util.List;

public interface UserThemeDao {

    Integer save(UserThemeEntity userThemeEntity);

    void update(UserThemeEntity userThemeEntity);

    void delete(Integer id);

    List getUserThemes(Integer userId);
}
