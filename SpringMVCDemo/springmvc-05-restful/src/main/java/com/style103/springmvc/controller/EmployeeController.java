package com.style103.springmvc.controller;

import com.style103.springmvc.dao.EmployeeDao;
import com.style103.springmvc.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;

/**
 * create by 103style on 2025/1/5 18:23
 * github:https://github.com/103style
 * <p>
 * 功能列表：
 * 查询所有的员工信息 /employee --->get
 * 跳转添加页面 /to/add --->get
 * 添加员工信息 /employee --->post
 * 跳转修改页面 /employee/1 --->get
 * 修改员工信息 /employee --->put
 * 通过id删除员工信息 /employee/1 --->delete
 */
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;


    @GetMapping("/employee")
    public String getAllEmployees(Model model) {
        Collection<Employee> all = employeeDao.getAll();
        // 共享到请求域
        model.addAttribute("allEmployees", all);
        return "employee_list";
    }

    @PostMapping("/employee")
    public String addEmployee(Employee employee) {
        // 保存
        employeeDao.save(employee);
        // 重定向到员工列表
        return "redirect:/employee";
    }
}
