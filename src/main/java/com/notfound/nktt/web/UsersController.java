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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;


import javax.annotation.Resource;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;

import static com.sun.javafx.tools.resource.DeployResource.Type.data;

/**
* Created by CodeGenerator on 2017/07/11.
*/


@RestController
@RequestMapping("/users")
public class UsersController {

    private static final String tokenName = "TOKEN";
    private static final String secretKey = "asfjasnfcZXMNclkmsalfas";
//    private static int maxTime = 7200;


    @Resource
    private UsersService usersService;

    @PostMapping("/login")
    public Result login(@CookieValue(value = tokenName, required = false) String cookieVal,
                        Integer studentid, String password,
                        HttpServletResponse httpServletResponse){
        Users user = usersService.findBy("studentid", studentid);
        Cookie tokenCookie = new Cookie(tokenName, null);
        tokenCookie.setMaxAge(0);
        Cookie stdCookie = new Cookie("studentid", null);
        stdCookie.setMaxAge(0);
        Cookie idCookie = new Cookie("userid", null);
        idCookie.setMaxAge(0);
        httpServletResponse.addCookie(tokenCookie);
        httpServletResponse.addCookie(stdCookie);
        httpServletResponse.addCookie(idCookie);
        if (user == null){
            return ResultGenerator.genFailResult("用户不存在！");
        }
        if (user.getPassword().equals(password)){
//            String md5 = DigestUtils.md5Hex(user.getStudentid());
            /*
            写入数据库新token
             */
            tokenCookie.setValue(String.valueOf(jiami(user.getStudentid().toString())));
            stdCookie.setValue(user.getStudentid().toString());
            idCookie.setValue(user.getIuserSerialNumber().toString());
            tokenCookie.setMaxAge(72000);
            stdCookie.setMaxAge(72000);
            idCookie.setMaxAge(72000);
            httpServletResponse.addCookie(tokenCookie);
            httpServletResponse.addCookie(stdCookie);
            httpServletResponse.addCookie(idCookie);
            return ResultGenerator.genSuccessResult(1, "登录成功！cookieValue = " + cookieVal);
        }
        return ResultGenerator.genFailResult("密码错误！");
    }

    @PostMapping("/logout")
    public Result logout(@CookieValue(value = tokenName, required = false) String cookieVal,
                         Integer studentid,
                         HttpServletRequest request){
        /*
        比对
         */
        request.getSession().invalidate();
        request.getSession().removeAttribute("studentid");
        request.getSession().removeAttribute("userid");
        request.getSession().removeAttribute(tokenName);
        /*
        往数据库中写入新的token
         */
        return ResultGenerator.genSuccessResult(1, "注销成功！");
    }

    private String jiami(String data){
        return DigestUtils.md5Hex(data + secretKey + System.nanoTime());
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
