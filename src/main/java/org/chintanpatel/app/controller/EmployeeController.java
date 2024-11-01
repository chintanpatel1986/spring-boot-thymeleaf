package org.chintanpatel.app.controller;

import jakarta.validation.Valid;
import org.chintanpatel.app.entities.Employee;
import org.chintanpatel.app.service.DepartmentService;
import org.chintanpatel.app.service.EmployeeService;
import org.chintanpatel.app.service.RoleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {

    private final EmployeeService employeeService;
    private final DepartmentService departmentService;
    private final RoleService roleService;

    public EmployeeController(EmployeeService employeeService, DepartmentService departmentService, RoleService roleService) {
        this.employeeService = employeeService;
        this.departmentService = departmentService;
        this.roleService = roleService;
    }


    @GetMapping("/employees/getEmployee")
    public String getEmployee(Model model) {
        model.addAttribute("employee", new Employee());
        model.addAttribute("departmentList", departmentService.getAllDepartmentList());
        model.addAttribute("roleList", roleService.getAllRoleList());
        model.addAttribute("employeeList",employeeService.getAllEmployeeList());
        return "employee-form";
    }


    @PostMapping("/employees/saveEmployee")
    public String saveEmployee(@Valid @ModelAttribute("employee")Employee employee, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("departmentList", departmentService.getAllDepartmentList());
            model.addAttribute("roleList", roleService.getAllRoleList());
            model.addAttribute("employeeList",employeeService.getAllEmployeeList());
            return "employee-form";
        }
        employeeService.addEmployee(employee);
        return "redirect:/employees/getEmployee";
    }


    @GetMapping("/employees/manageEmployee/{employeeId}")
    public String manageEmployee(@PathVariable Long employeeId, Model model) {
        if (employeeId != null) {
            model.addAttribute("employee", employeeService.getEmployeeById(employeeId));
            model.addAttribute("departmentList", departmentService.getAllDepartmentList());
            model.addAttribute("roleList", roleService.getAllRoleList());
            model.addAttribute("employeeList",employeeService.getAllEmployeeList());
        }
        return "employee-form";
    }


    @GetMapping("/employees/deleteEmployee/{employeeId}")
    public String deleteEmployee(@PathVariable Long employeeId) {
        if (employeeId != null) {
            employeeService.deleteEmployeeById(employeeId);
        }
        return "redirect:/employees/getEmployee";
    }
}
