package com.springboot.jdbc.demo.service;

import com.springboot.jdbc.demo.model.SysDepartment;

import java.util.List;

public interface SysDepartmentService {
    /**
     * 保存部門
     * @param department
     */
    void save(SysDepartment department);

    /**
     * 删除部門
     * @param id
     */
    void delete(String id);

    /**
     * 查询全部部門
     * @return
     */
    List<SysDepartment> findAll();
}
