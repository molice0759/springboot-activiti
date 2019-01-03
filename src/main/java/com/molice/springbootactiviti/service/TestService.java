package com.molice.springbootactiviti.service;

import com.molice.springbootactiviti.entity.Test;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author mlc
 * @since 2019-01-03
 */
public interface TestService extends IService<Test> {

    List<Test> findAll();
}
