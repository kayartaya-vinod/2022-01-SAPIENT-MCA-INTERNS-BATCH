package com.sapient.service;

import com.sapient.dao.EmployeeDao;
import com.sapient.entity.Employee;
import com.sapient.vob.DepartmentVob;
import com.sapient.vob.EmployeeVob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class EmployeeService {

    @Autowired
    EmployeeDao dao;

    @Value("${department.service.url}")
    String departmentServiceUrl;



    private EmployeeVob toEmployeeVob(Employee emp) {
        EmployeeVob employeeVob = new EmployeeVob();
        // copy from entity to vob
        employeeVob.setId(emp.getId());
        employeeVob.setName(emp.getName());
        employeeVob.setCommission(emp.getCommission());
        employeeVob.setJob(emp.getJob());
        employeeVob.setHireDate(emp.getHireDate());
        employeeVob.setManagerId(emp.getManagerId());
        employeeVob.setSalary(emp.getSalary());

        employeeVob.setDepartment(toDepartmentVob(emp.getDepartmentId()));
        return employeeVob;
    }

    private DepartmentVob toDepartmentVob(Integer departmentId) {
        // go to department-service url
        // collect the JSON
        // convert the same into DepartmentVob object and return the same

        try {
            return WebClient.create(departmentServiceUrl)
                    .get()
                    .uri("/" + departmentId)
                    .retrieve()
                    .bodyToMono(DepartmentVob.class)
                    .block();
        } catch (Exception e) {
            log.warn("There was an error in EmployeeController.toDepartmentVob()", e);
            return null;
        }


    }
    public EmployeeVob getEmployeeById(Integer id) {
        Optional<Employee> result = dao.findById(id);
        if (result.isPresent()) {
            EmployeeVob employeeVob = toEmployeeVob(result.get());
            return employeeVob;
        }
        return null;
    }

    public List<EmployeeVob> getAll() {
        return dao.findAll()
                .stream()
                .map(this::toEmployeeVob)
                .collect(Collectors.toList());
    }
}
