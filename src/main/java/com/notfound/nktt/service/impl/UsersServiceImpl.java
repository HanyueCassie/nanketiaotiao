package com.notfound.nktt.service.impl;

import com.notfound.nktt.dao.UsersMapper;
import com.notfound.nktt.model.Users;
import com.notfound.nktt.service.UsersService;
import com.notfound.nktt.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2017/07/11.
 */
@Service
@Transactional
public class UsersServiceImpl extends AbstractService<Users> implements UsersService {
    @Resource
    private UsersMapper usersMapper;

}
