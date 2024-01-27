package com.crud.customquery.eg.controller;

import com.crud.customquery.eg.services.CrudService;
import com.crud.customquery.eg.entity.Employee;
import com.crud.customquery.eg.pojo.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emp")
public class CrudController {

    @Autowired
    CrudService crudService;

    @GetMapping("/allEmp")
    public void getAllEmp() {
        List<EmployeeDTO> employeeList = crudService.getAllEmp();
        System.out.println("Print employee" + employeeList.toString());

    }

    @PostMapping("/addEmp")
    public void addEmp(@RequestBody EmployeeDTO employeeDTO) {
        crudService.addEmpToDb(employeeDTO);
        List<EmployeeDTO> employeeList = crudService.getAllEmp();
        System.out.println("Print employee" + employeeList.toString());

    }

    @GetMapping("/empByCrr")
    public void getEmyByCrr(@RequestParam("crr") String crr) {
        List<Employee> employeeList = crudService.getByCrr(crr);
        System.out.println("Print employee" + employeeList.toString());

    }

    @GetMapping("/empByName/{name}")
    public void getEmyByName(@PathVariable String name) {
        List<Employee> employeeList = crudService.getByNemName(name);
        System.out.println("Print employee" + employeeList.toString());

    }

    @GetMapping("/sortByName")
    public List<Employee> getALlEmpSortByName() {
        List<Employee> employeeList = crudService.getALlEmpSortByName();
        System.out.println("Print employee" + employeeList.toString());
        return employeeList;

    }

    @GetMapping("/getCRRByNameSort/{crr}")
    public List<Employee> getCRRByNameSorted(@PathVariable String crr) {
        List<Employee> employeeList = crudService.getCRRByNameSorted(crr);
        System.out.println("Print employee" + employeeList.toString());
        return employeeList;
    }

}
