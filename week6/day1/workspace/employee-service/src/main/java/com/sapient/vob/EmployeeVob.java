package com.sapient.vob;

import lombok.Data;

import java.util.Date;

@Data
public class EmployeeVob {
    private Integer id;
    private String name;
    private String job;
    private Integer managerId;
    private Date hireDate;
    private Double salary;
    private Double commission;
    private DepartmentVob department;

}
