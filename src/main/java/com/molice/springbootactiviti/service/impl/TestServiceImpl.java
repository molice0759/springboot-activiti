package com.molice.springbootactiviti.service.impl;

import com.molice.springbootactiviti.entity.Test;
import com.molice.springbootactiviti.mapper.TestMapper;
import com.molice.springbootactiviti.service.TestService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author mlc
 * @since 2019-01-03
 */
@Service
public class TestServiceImpl extends ServiceImpl<TestMapper, Test> implements TestService {

    @Override
    public List<Test> findAll() {
        Test test = new Test();
        List<Test> tests = test.selectAll();
        return tests;
    }
}
