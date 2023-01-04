package com.thundersoft.fixed_assets_sys.service.impl;

import com.thundersoft.fixed_assets_sys.entity.Fixed_assets_User;
import com.thundersoft.fixed_assets_sys.exception.UsernameNotFoundException;
import com.thundersoft.fixed_assets_sys.mapper.userMapper;
import com.thundersoft.fixed_assets_sys.service.userService;
import com.thundersoft.fixed_assets_sys.util.JwtUtil;
import com.thundersoft.fixed_assets_sys.vo.LoginUserInfo;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class UserServiceImpl implements userService {
    @Resource
    private userMapper userMapper;
    @Resource
    private PasswordEncoder passwordEncoder;

    @Override
    public String Login(LoginUserInfo loginUserInfo) {
        Fixed_assets_User currentUser = userMapper.findUserByUserName(loginUserInfo.getUsername());
        if (currentUser == null) {
            throw new UsernameNotFoundException("暂无此用户名");
        }
        if (!passwordEncoder.matches(loginUserInfo.getPassword(), currentUser.getU_password())) {
            throw new BadCredentialsException("您的密码输入有误！");
        }
        return JwtUtil.generate(currentUser.getU_username());
    }
}
