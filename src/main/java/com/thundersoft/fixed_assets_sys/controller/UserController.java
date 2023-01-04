package com.thundersoft.fixed_assets_sys.controller;

import com.thundersoft.fixed_assets_sys.service.userService;
import com.thundersoft.fixed_assets_sys.vo.LoginUserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Resource
    private userService userService;
    @PostMapping("/login")
    public String login(@RequestBody LoginUserInfo loginUserInfo){
       log.info("loginInfo"+loginUserInfo);
        return userService.Login(loginUserInfo);
    }
}
