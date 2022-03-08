package com.sapient.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name="EMP")
public class Employee {
    @Id
    @Column(name="EMPNO")
    private Integer id;
    @Column(name="ENAME")
    private String name;
    private String job;
    @Column(name="MGR")
    private Integer managerId;
    private Date hireDate;
    @Column(name="SAL")
    private Double salary;
    @Column(name="COMM")
    private Double commission;
    @Column(name="DEPTNO")
    private Integer departmentId;
}
