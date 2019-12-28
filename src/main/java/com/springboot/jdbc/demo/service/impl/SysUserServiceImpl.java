package com.springboot.jdbc.demo.service.impl;

import com.springboot.jdbc.demo.aop.annotation.AopTransaction;
import com.springboot.jdbc.demo.dao.SysUserDao;
import com.springboot.jdbc.demo.model.SysUser;
import com.springboot.jdbc.demo.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserDao sysUserDao;

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public void save(SysUser user) {
        sysUserDao.save(user);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public void delete(String id) {
        sysUserDao.delete(id);
    }

    @Override
    @AopTransaction(name = "find", functionName = "findAll()", className = "SysUserServiceImpl.java")
    public List<SysUser> findAll() {
        return sysUserDao.findAll();
    }

}