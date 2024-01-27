package com.crud.customquery.eg.controller;

import com.crud.customquery.eg.pojo.EmployeeDTO;
import com.crud.customquery.eg.services.CrudService;
import com.crud.customquery.eg.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


//Using Controller as we are returning pages - using Thymeleaf
@Controller
@RequestMapping("/thymeleaf")
public class QueryByController {

    @Autowired
    private CrudService crudService;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        System.out.println("Inside viewHomepage");
        model.addAttribute("allemplist", crudService.getAllEmp());
        System.out.println(crudService.getAllEmp());
        return "index";
    }

    @GetMapping("/addnew")
    public String addNewEmployee(Model model) {
        System.out.println("Inside addNewEmployee");
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "newEmployee";
    }

    @GetMapping("/showFormForUpdate/{empid}")
    public String updateForm(@PathVariable int empid, Model model) {
        System.out.println("Inside updateForm");
        Employee employee = crudService.getById(empid);
        System.out.println(employee.toString());
        model.addAttribute("employee", employee);
        return "update";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") EmployeeDTO employeeDTO) {

        System.out.println("Inside SaveEmployee");
        crudService.addEmpToDb(employeeDTO);
        return "redirect:/thymeleaf/";
    }

    @GetMapping("/deleteEmployee/{id}")
    public String deleteThroughId(@PathVariable int id) {
        System.out.println("Inside deleteThroughId");
        crudService.deleteViaId(id);
        // model.addAttribute( "allemplist", crudService.getAllEmp());
        return "redirect:/thymeleaf/";

    }
}
