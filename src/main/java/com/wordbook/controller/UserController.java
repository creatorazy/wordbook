package com.wordbook.controller;

import com.wordbook.entity.User;
import com.wordbook.entity.Word;
import com.wordbook.service.UserService;
import com.wordbook.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService us;

    @RequestMapping(value = "login")
    public Result login(User user) {
        User u = us.loginByPassword(user);
        Result result = new Result(u == null ? 400 : 200, u == null ? "登陆失败" : "登陆成功", u);
        return result;
    }

    @RequestMapping(value = "logout")
    public Result logout(Integer id, HttpServletRequest req) {
        req.getSession().removeAttribute("user" + id);
        Result result = new Result(200, "退出登陆成功");
        return result;
    }

    @RequestMapping("/reg")
    public Result reg(User user) {
        user.setImg("http://tupian.qqjay.com/tou2/2018/1106/60bdf5b88754650e51ccee32bb6ac8ae.jpg");
        boolean b = us.reg(user);
        return new Result(b ? 200 : 400, b ? "注册成功" : "注册失败");
    }

    @RequestMapping("/up")
    public Result up(User user) {
        boolean b = us.up(user);
        Result result = new Result(b ? 200 : 400, b ? "更新密码成功" : "更新密码失败");
        return result;
    }
}
