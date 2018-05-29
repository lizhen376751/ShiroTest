package com.shiro.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.security.auth.Subject;

/**
 * Created by Administrator on 2018/5/29.
 */
@RestController
public class MainController {
    @RequestMapping("/getUser")
    public String getUser(@RequestParam String name, @RequestParam String password) {
        org.apache.shiro.subject.Subject subject = SecurityUtils.getSubject();
        AuthenticationToken authenticationToken = new UsernamePasswordToken(name, password);
        try {
            subject.login(authenticationToken);

            Object principal = subject.getPrincipal();
            return "登录成功！";
        } catch (UnknownAccountException e) {
            e.printStackTrace();
            System.out.println("用户名不存在！");
            return "用户名不存在！";
        }catch (IncorrectCredentialsException e){
            e.printStackTrace();
            System.out.println("密码错误！");
            return "密码错误";
        }
    }

    @RequestMapping("/editUser")
    public String editUser() {
        return "权限控制";
    }

    @RequestMapping("/fangquan")
    public String fangquanUser() {
        return "放弃权限控制";
    }
}
