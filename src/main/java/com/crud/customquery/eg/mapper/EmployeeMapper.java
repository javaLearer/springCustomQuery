package com.crud.customquery.eg.mapper;

import com.crud.customquery.eg.entity.Employee;
import com.crud.customquery.eg.pojo.EmployeeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    Employee populateEmpDTO(EmployeeDTO employeeDTO);

    EmployeeDTO populateEmpPojo(Employee employee);

    List<EmployeeDTO> populateEmpDTOList(List<Employee> employee);
}
