package com.example.myrpaapi.controller;

import cn.hutool.jwt.JWT;
import com.example.myrpaapi.constant.MyConstant;
import com.example.myrpaapi.constant.ResultCode;
import com.example.myrpaapi.constant.ResultJson;
import com.example.myrpaapi.entity.User;
import com.example.myrpaapi.service.UserService;
import com.example.myrpaapi.vo.SignInReq;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import java.nio.charset.StandardCharsets;
@RestController
@RequestMapping("/user")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;
    @Resource
    PasswordEncoder passwordEncoder;
    @Autowired
    UserService userService;
    @PostMapping("/register")
    public ResultJson<?> sign(@RequestBody SignInReq signInReq) {
        User user = new User();
        user.setUsername(signInReq.getUsername());
        user.setPassword(passwordEncoder.encode(signInReq.getPassword()));
        userService.save(user);
        String token = JWT.create()
                .setPayload("username", signInReq.getUsername())
                .setKey(MyConstant.JWT_SIGN_KEY.getBytes(StandardCharsets.UTF_8))
                .sign();

        return ResultJson.ok(token);
    }
    @PostMapping("/login")
    public ResultJson<?> login(@RequestBody SignInReq req) {

        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(req.getUsername(), req.getPassword());
        authenticationManager.authenticate(authenticationToken);

        //上一步没有抛出异常说明认证成功，我们向用户颁发jwt令牌
        String token = JWT.create()
                .setPayload("username", req.getUsername())
                .setKey(MyConstant.JWT_SIGN_KEY.getBytes(StandardCharsets.UTF_8))
                .sign();

        return ResultJson.ok(token);
    }

    @GetMapping("/hello")
    public String sayHello(){
        return "hello";
    }
}