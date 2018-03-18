package com.superbluecat.ziyue.dao;

import com.superbluecat.ziyue.entities.ThemeEntity;

import java.util.List;

public interface ThemeDao {

    Integer save(ThemeEntity themeEntity);

    void update(ThemeEntity themeEntity);

    void delete(Integer id);

    List getTheme();
}
