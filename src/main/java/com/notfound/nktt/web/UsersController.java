package com.notfound.nktt.web;
import com.notfound.nktt.core.Result;
import com.notfound.nktt.core.ResultGenerator;

import com.notfound.nktt.model.Users;
import com.notfound.nktt.service.UsersService;

import com.notfound.nktt.service.TokenService;
import com.notfound.nktt.model.Token;

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

    @Resource
    private TokenService tokenService;

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
            String tokenString = String.valueOf(jiami(user.getStudentid().toString()));
            tokenCookie.setValue(tokenString);
            stdCookie.setValue(user.getStudentid().toString());
            idCookie.setValue(user.getIuserSerialNumber().toString());
            tokenCookie.setMaxAge(72000);
            stdCookie.setMaxAge(72000);
            idCookie.setMaxAge(72000);
            httpServletResponse.addCookie(tokenCookie);
            httpServletResponse.addCookie(stdCookie);
            httpServletResponse.addCookie(idCookie);
            Token token = new Token();
            token.setUserid(user.getIuserSerialNumber());
            token.setStudentid(user.getStudentid());
            token.setTokenstring(tokenString);
            if (tokenService.findBy("userid", user.getIuserSerialNumber()) == null){
                tokenService.save(token);
            }
            else{
                tokenService.update(token);
            }
            return ResultGenerator.genSuccessResult(1, "登录成功!");
        }
        return ResultGenerator.genFailResult("密码错误！");
    }

//    @PostMapping("/logout")
//    public Result logout(@CookieValue(value = tokenName, required = false) String cookieVal,
//                         Integer studentid, Integer userid,
//                         HttpServletRequest request) {
//        private static String getTokenList(HttpSession session) {
//            Object obj = session.getAttribute(tokenName);
//            if (obj != null) {
//                return (String) obj;
//            } else {
//                String tokenList = new String();
//                ResultGenerator.setAttribute(tokenName, tokenList);
//                return tokenList;
//            }
//        }
//
//        private static void saveTokenString(String tokenStr, HttpSession session) {
//            String tokenList = getTokenList(session);
//            tokenList.add(tokenStr);
//            session.setAttribute(tokenName, tokenList);
//        }
//
//        private static String generateTokenString(){
//            return new Long(System.currentTimeMillis()).toString();
//        }
//
//        if (user.gettokenName().equals(tokenName)) {
//            return ResultGenerator.genSuccessResult(1, "注销成功！");
//        }
//        return ResultGenerator.genSuccessResult(0, "注销失败！");
//    }
    private String jiami(String data){
        return DigestUtils.md5Hex(data + secretKey + System.nanoTime());
    }

    @PostMapping("/add")
    public Result add(Users users) {
        usersService.save(users);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(Integer id) {
        usersService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

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
