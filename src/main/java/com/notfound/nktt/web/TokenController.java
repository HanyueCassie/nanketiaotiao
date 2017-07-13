package com.notfound.nktt.web;
import com.notfound.nktt.core.Result;
import com.notfound.nktt.core.ResultGenerator;
import com.notfound.nktt.model.Token;
import com.notfound.nktt.service.TokenService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by CodeGenerator on 2017/07/13.
*/
@RestController
@RequestMapping("/token")
public class TokenController {
    @Resource
    private TokenService tokenService;

//    @PostMapping("/add")
//    public Result add(Token token) {
//        tokenService.save(token);
//        return ResultGenerator.genSuccessResult();
//    }
//
//    @PostMapping("/delete")
//    public Result delete(Integer id) {
//        tokenService.deleteById(id);
//        return ResultGenerator.genSuccessResult();
//    }
//
//    @PostMapping("/update")
//    public Result update(Token token) {
//        tokenService.update(token);
//        return ResultGenerator.genSuccessResult();
//    }
//
//    @PostMapping("/detail")
//    public Result detail(Integer id) {
//        Token token = tokenService.findById(id);
//        return ResultGenerator.genSuccessResult(token);
//    }
//
//    @PostMapping("/list")
//    public Result list(Integer page, Integer size) {
//        PageHelper.startPage(page, size);
//        List<Token> list = tokenService.findAll();
//        PageInfo pageInfo = new PageInfo(list);
//        return ResultGenerator.genSuccessResult(pageInfo);
//    }
}
