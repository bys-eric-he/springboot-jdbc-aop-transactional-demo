package com.springboot.jdbc.demo.controller;

import com.springboot.jdbc.demo.model.SysDepartment;
import com.springboot.jdbc.demo.service.SysDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/department")
public class SysDepartmentController {

    @Autowired
    private SysDepartmentService departmentService;

    @PostMapping(value="/save")
    public Object save(@RequestBody SysDepartment department) {
        departmentService.save(department);
        return 1;
    }

    @GetMapping(value="/delete")
    public Object delete(@RequestParam("id") String id) {
        departmentService.delete(id);
        return 1;
    }

    @GetMapping(value="/findAll")
    public Object findAll() {
        return departmentService.findAll();
    }
}
