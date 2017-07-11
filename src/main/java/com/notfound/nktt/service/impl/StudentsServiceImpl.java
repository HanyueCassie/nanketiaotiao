package com.notfound.nktt.service.impl;

import com.notfound.nktt.dao.StudentsMapper;
import com.notfound.nktt.model.Students;
import com.notfound.nktt.service.StudentsService;
import com.notfound.nktt.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2017/07/05.
 */
@Service
@Transactional
public class StudentsServiceImpl extends AbstractService<Students> implements StudentsService {
    @Resource
    private StudentsMapper studentsMapper;

}
