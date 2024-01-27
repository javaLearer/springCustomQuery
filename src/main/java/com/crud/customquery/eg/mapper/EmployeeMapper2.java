package com.crud.customquery.eg.mapper;

import com.crud.customquery.eg.entity.Employee;
import com.crud.customquery.eg.pojo.EmployeeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface EmployeeMapper2 {


    // @Mapping(target = "empid", ignore = true)
    // EmployeeDTO employeeDto(Employee employee);

    // List<EmployeeDTO> convertEmpListtoDTO(List<Employee> employeeList);

}
