package com.crud.customquery.eg.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Entity
@Table(name = "emp")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int empid;
    @NotEmpty(message = "Name is required")
    private String name;
    private Double salary;
    private String crr;
}

