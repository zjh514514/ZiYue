package com.superbluecat.ziyue.service;

import java.util.List;
import java.util.Map;

public interface CommentsService {

    Map add();

    Map delete();

    Map update();

    List get(int userId);
}
