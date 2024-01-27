package com.crud.customquery.eg.pojo;

import jakarta.persistence.*;
import lombok.*;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class EmployeeDTO {

    private int empid;
    private String name;
    private Double salary;
    private String crr;
}

