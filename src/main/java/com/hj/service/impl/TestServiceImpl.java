package com.hj.service.impl;

import com.hj.dao.TestDao;
import com.hj.entity.Test;
import com.hj.service.TestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author huangjie
 * @time 2019-05-13 19:11
 */
@Service
public class TestServiceImpl implements TestService {

    @Resource
    private TestDao testDao;

    @Override
    public Test selectOne(Integer id) {
        return testDao.selectOne(id);
    }
}
