package com.thundersoft.fixed_assets_sys.controller;


import com.thundersoft.fixed_assets_sys.entity.Fixed_assets_authority;
import com.thundersoft.fixed_assets_sys.service.authorityService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthorityController {

    @GetMapping("/authentication")
    public String authentication(){
        return "success";
    }

    @Resource
    private authorityService authorityService;

    @GetMapping("/menus")
    public List<Fixed_assets_authority> getMenu(){
        return authorityService.getMenus();
    }
}
