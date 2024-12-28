package org.chintanpatel.springbootthymeleaf.controller;

import jakarta.validation.Valid;
import org.chintanpatel.springbootthymeleaf.model.Department;
import org.chintanpatel.springbootthymeleaf.service.DepartmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/departments/getDepartment")
    public String getDepartment(Model model) {
        model.addAttribute("department", new Department());
        model.addAttribute("departmentList",departmentService.getAllDepartmentList());
        return "department-form";
    }

    @PostMapping("/departments/saveDepartment")
    public String saveDepartment(@Valid @ModelAttribute("department")Department department, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("departmentList",departmentService.getAllDepartmentList());
            return "department-form";
        }
        departmentService.addDepartment(department);
        return "redirect:/departments/getDepartment";
    }

    @GetMapping("/departments/manageDepartment/{departmentId}")
    public String manageDepartment(@PathVariable("departmentId")Long departmentId, Model model) {
        if (departmentId != null) {
            model.addAttribute("department", departmentService.getDepartmentById(departmentId));
            model.addAttribute("departmentList",departmentService.getAllDepartmentList());
        }
        return "department-form";
    }

    @GetMapping("/departments/deleteDepartment/{departmentId}")
    public String deleteDepartment(@PathVariable("departmentId")Long departmentId) {
        if (departmentId != null) {
            departmentService.deleteDepartmentById(departmentId);
        }
        return "redirect:/departments/getDepartment";
    }
}
