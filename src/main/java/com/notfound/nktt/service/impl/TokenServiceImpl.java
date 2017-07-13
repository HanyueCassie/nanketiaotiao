package com.notfound.nktt.service.impl;

import com.notfound.nktt.dao.TokenMapper;
import com.notfound.nktt.model.Token;
import com.notfound.nktt.service.TokenService;
import com.notfound.nktt.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2017/07/13.
 */
@Service
@Transactional
public class TokenServiceImpl extends AbstractService<Token> implements TokenService {
    @Resource
    private TokenMapper tokenMapper;

}
