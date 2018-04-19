package com.superbluecat.ziyue.controller;

import com.superbluecat.ziyue.service.CommentsService;
import com.superbluecat.ziyue.tools.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/comments")
public class CommentsController {

    private final CommentsService commentsService;

    @Autowired
    public CommentsController(CommentsService commentsService) {
        this.commentsService = commentsService;
    }

    @RequestMapping("/add")
    public R addComments(@RequestParam String username, @RequestParam String password, @RequestParam String apiKey, @RequestParam String comment, @RequestParam String email, @RequestParam String nickName, @RequestParam String ua, @RequestParam String webSite, @RequestParam Integer toCommentId) {
        if (nickName != null && comment != null && ua != null) {
            return commentsService.save(username, password, apiKey, comment, email, nickName, toCommentId, ua, webSite) ? R.ok() : R.error("评论失败，请稍后再试");
        }
        return R.error(201, "信息不完整，请检查");
    }

    @RequestMapping("/delete")
    public R deleteComments(@RequestParam String username, @RequestParam String password, @RequestParam String apiKey, @RequestParam Integer id) {
        if (id != null) {
            return commentsService.delete(username, password, apiKey, id) ? R.ok("删除评论成功") : R.error();
        }
        return R.error(201, "信息不完整，请检查");
    }
}
