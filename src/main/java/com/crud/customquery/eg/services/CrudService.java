package com.crud.customquery.eg.services;

import com.crud.customquery.eg.entity.Employee;
import com.crud.customquery.eg.mapper.EmployeeMapper;
import com.crud.customquery.eg.pojo.EmployeeDTO;
import com.crud.customquery.eg.repo.CrudRepoDemo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CrudService {
    private EmployeeMapper employeeMapper;

    @Autowired
    CrudRepoDemo crudRepoDemo;


    public List<EmployeeDTO> getAllEmp() {
        List<Employee> empList = crudRepoDemo.findAll();

        List<EmployeeDTO> employeeDTOList = EmployeeMapper.INSTANCE.populateEmpDTOList(empList);
        return employeeDTOList;
    }

    public void addEmpToDb(EmployeeDTO employeeDTO) {

        Employee employee = EmployeeMapper.INSTANCE.populateEmpDTO(employeeDTO);
        crudRepoDemo.save(employee);
    }

    public List<Employee> getByCrr(String crr) {
        return crudRepoDemo.findByCrr(crr);

    }

    public List<Employee> getByNemName(String name) {

        return crudRepoDemo.findByName(name);
    }

    public List<Employee> getALlEmpSortByName() {

        return crudRepoDemo.findByNameSorted();
    }

    public List<Employee> getCRRByNameSorted(String crr) {
        return crudRepoDemo.findByCrrNameSorted(crr);
    }

    public Employee getById(int empid) {
        return (Employee) crudRepoDemo.findByEmpid(empid);

    }

    public void deleteViaId(int empid) {
        crudRepoDemo.deleteById(empid);

    }
}
