package com.notfound.nktt.web;
import com.notfound.nktt.service.StudentsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
* Created by CodeGenerator on 2017/07/05.
*/
@RestController
@RequestMapping("/students")
public class StudentsController {
    @Resource
    private StudentsService studentsService;

//    @PostMapping("/login")
//    public String login(Integer studentid, String password){
//        Students students = studentsService.findById(studentid);
//        if (students == null){
//            return "0";
//        }
//        if (students.getPassword().equals(password)){
//            return "1";
//        }
//        return "0";
//    }

    @RequestMapping("/test3")
    public String test3(){
        return String.valueOf(1);
    }

//    @PostMapping("/add")
//    public Result add(Students students) {
//        studentsService.save(students);
//        return ResultGenerator.genSuccessResult();
//    }
//
//    @PostMapping("/delete")
//    public Result delete(Integer id) {
//        studentsService.deleteById(id);
//        return ResultGenerator.genSuccessResult();
//    }
//
//    @PostMapping("/update")
//    public Result update(Students students) {
//        studentsService.update(students);
//        return ResultGenerator.genSuccessResult();
//    }
//
//    @PostMapping("/detail")
//    public Result detail(Integer id) {
//        Students students = studentsService.findById(id);
//        return ResultGenerator.genSuccessResult(students);
//    }
//
//    @PostMapping("/list")
//    public Result list(Integer page, Integer size) {
//        PageHelper.startPage(page, size);
//        List<Students> list = studentsService.findAll();
//        PageInfo pageInfo = new PageInfo(list);
//        return ResultGenerator.genSuccessResult(pageInfo);
//    }

//    @RequestMapping("list2")
//    public String list2(Integer page, Integer size){
//        PageHelper.startPage(page, size);
//        List<Students> list = studentsService.findAll();
//        PageInfo pageInfo = new PageInfo(list);
//        return pageInfo.toString();
//    }
}
