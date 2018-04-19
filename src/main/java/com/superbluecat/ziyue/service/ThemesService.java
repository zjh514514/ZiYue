package com.superbluecat.ziyue.service;

import java.util.List;

public interface ThemesService {

    Boolean save(String themeName, double money, String apiKey);

    Boolean delete(Integer themeId, String apiKey);

    Boolean update(Integer themeId, double money, String apiKey);

    List getAll();
}
