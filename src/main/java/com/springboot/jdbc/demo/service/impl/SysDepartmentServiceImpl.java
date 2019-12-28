package com.springboot.jdbc.demo.service.impl;

import com.springboot.jdbc.demo.aop.annotation.AopTransaction;
import com.springboot.jdbc.demo.dao.SysDepartmentDao;
import com.springboot.jdbc.demo.model.SysDepartment;
import com.springboot.jdbc.demo.service.SysDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SysDepartmentServiceImpl implements SysDepartmentService {

    @Autowired
    private SysDepartmentDao departmentDao;

    @Override
    //@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    @AopTransaction(name = "save", functionName = "save()", className = "SysDepartmentServiceImpl.java")
    public void save(SysDepartment department) {
        departmentDao.save(department);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public void delete(String id) {
        departmentDao.delete(id);
    }

    @Override
    public List<SysDepartment> findAll() {
        return departmentDao.findAll();
    }
}
