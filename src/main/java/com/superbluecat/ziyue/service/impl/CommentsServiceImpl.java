package com.superbluecat.ziyue.service.impl;

import com.superbluecat.ziyue.dao.CommentsDao;
import com.superbluecat.ziyue.service.CommentsService;
import com.superbluecat.ziyue.tools.HibernateTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CommentsServiceImpl extends HibernateTools implements CommentsService {

    @Autowired
    private CommentsDao commentsDao;

    public Map add() {
        return null;
    }

    public Map delete() {
        return null;
    }

    public Map update() {
        return null;
    }

    public List get(int userId) {
        return commentsDao.get(userId);
    }
}
