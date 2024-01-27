package com.crud.customquery.eg.repo;

import com.crud.customquery.eg.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CrudRepoDemo extends JpaRepository<Employee, Integer> {

    public List<Employee> findByCrr(String crr);

    List<Employee> findByName(String name);

    @Query("from Employee Order By name")
    List<Employee> findByNameSorted();

    @Query("from Employee where crr=?1 order by name desc")
    List<Employee> findByCrrNameSorted(String crr);

    Employee findByEmpid(int empid);

    //void deleteByEmpid(int id);


    //List<Employee> findDistinctByName
}
