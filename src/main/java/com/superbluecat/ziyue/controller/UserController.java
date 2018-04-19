package com.superbluecat.ziyue.controller;

import com.superbluecat.ziyue.entities.UsersEntity;
import com.superbluecat.ziyue.service.UsersService;
import com.superbluecat.ziyue.tools.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/user")
public class UserController {

    private final UsersService usersService;

    @Autowired
    public UserController(UsersService usersService) {
        this.usersService = usersService;
    }

    @RequestMapping("/register")
    public R register(@RequestParam String username, @RequestParam String password, @RequestParam String nickName, @RequestParam String email, @RequestParam String tel) {
        if (usersService.userNum(username) > 0) {
            return R.error("用户名已存在");
        }
        UsersEntity usersEntity = usersService.save(username, password, nickName, email, tel);
        if (usersEntity == null) {
            return R.error();
        }
        return R.ok().put("user", usersEntity);
    }

    @RequestMapping("/getone")
    public R getOne(@RequestParam String username, @RequestParam String password, @RequestParam String apiKey) {
        UsersEntity usersEntity = usersService.get(username, password, apiKey);
        if (usersEntity.getUserId() != 0) {
            return R.ok().put("user", usersEntity);
        }
        return R.error("用户名或密码错误");
    }

    @RequestMapping("/buypackages")
    public R buyPackages(@RequestParam String username, @RequestParam String password, @RequestParam String apiKey, @RequestParam Integer id) {
        if (usersService.buyPackages(username, password, apiKey, id)) {
            return R.ok("购买成功");
        }
        return R.error("购买失败，请联系管理员");
    }

    @RequestMapping("/buythemes")
    public R buyThemes(@RequestParam String username, @RequestParam String password, @RequestParam String apiKey, @RequestParam Integer id) {
        if (usersService.buyThemes(username, password, apiKey, id)) {
            return R.ok("购买成功");
        }
        return R.error("购买失败，请联系管理员");
    }
}
