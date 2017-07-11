package com.notfound.nktt.web;
import com.notfound.nktt.core.Result;
import com.notfound.nktt.core.ResultGenerator;
import com.notfound.nktt.model.Users;
import com.notfound.nktt.service.UsersService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CookieValue;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;


import javax.annotation.Resource;
import java.util.List;

/**
* Created by CodeGenerator on 2017/07/11.
*/
@RestController
@RequestMapping("/users")
public class UsersController {
    @Resource
    private UsersService usersService;

    @PostMapping("/login")
    public Result login(@CookieValue(value = "test", required = false) String cookieVal,
                        Integer studentid, String password,
                        HttpServletResponse httpServletResponse){
        Users user = usersService.findBy("studentid", studentid);
        if (user == null){
            Cookie cookie = new Cookie("test", null);
            httpServletResponse.addCookie(cookie);
            return ResultGenerator.genFailResult("用户不存在！");
        }
        if (user.getPassword().equals(password)){
            Cookie cookie = new Cookie("test", String.valueOf(System.nanoTime()));
            httpServletResponse.addCookie(cookie);
            return ResultGenerator.genSuccessResult("登录成功！cookieValue = " + cookieVal);
        }
        Cookie cookie = new Cookie("test", null);
        httpServletResponse.addCookie(cookie);
        return ResultGenerator.genFailResult("密码错误！");
    }

//    @PostMapping("/add")
//    public Result add(Users users) {
//        usersService.save(users);
//        return ResultGenerator.genSuccessResult();
//    }
//
//    @PostMapping("/delete")
//    public Result delete(Integer id) {
//        usersService.deleteById(id);
//        return ResultGenerator.genSuccessResult();
//    }
//
//    @PostMapping("/update")
//    public Result update(Users users) {
//        usersService.update(users);
//        return ResultGenerator.genSuccessResult();
//    }
//
//    @PostMapping("/detail")
//    public Result detail(Integer id) {
//        Users users = usersService.findById(id);
//        return ResultGenerator.genSuccessResult(users);
//    }
//
    @PostMapping("/list")
    public Result list(Integer page, Integer size) {
        PageHelper.startPage(page, size);
        List<Users> list = usersService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
