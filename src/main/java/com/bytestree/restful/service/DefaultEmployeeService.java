package com.bytestree.restful.service;

import com.bytestree.restful.dto.*;
import com.bytestree.restful.model.Employee;
import com.bytestree.restful.repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author bytesTree
 * @see <a href="http://www.bytestree.com/">BytesTree</a>
 */
@Service
public class DefaultEmployeeService implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public AddEmployeeRs save(AddEmployeeRq addEmployeeRq) {
        Employee employee = new Employee();
        employee.setFirstName(addEmployeeRq.getFirstName());
        employee.setLastName(addEmployeeRq.getLastName());
        employee.setDesignation(addEmployeeRq.getDesignation());
        employee.setSalary(addEmployeeRq.getSalary());
        employee.setDepartmentId(addEmployeeRq.getDepartmentId());
        employee = employeeRepository.save(employee);

        AddEmployeeRs addEmployeeRs = new AddEmployeeRs();
        BeanUtils.copyProperties(employee, addEmployeeRs);
        return addEmployeeRs;
    }

    @Override
    public List<GetEmployeeRs> getAll() {
        List<Employee> employees = employeeRepository.findAll();
        List<GetEmployeeRs> employeeRsList = new ArrayList<>();

        for (Employee employee : employees ) {
            GetEmployeeRs employeeRs = new GetEmployeeRs();
            employeeRs.setId(employee.getId());
            employeeRs.setDepartmentId(employee.getDepartmentId());
            employeeRs.setDepartmentName(employee.getDepartment().getName());
            employeeRs.setDesignation(employee.getDesignation());
            employeeRs.setFirstName(employee.getFirstName());
            employeeRs.setLastName(employee.getLastName());
            employeeRs.setSalary(employee.getSalary());
            employeeRsList.add(employeeRs);
        }
        return employeeRsList;
    }

    @Override
    public List<EmployeeByCloseProjectionRs> getAllByCloseProjection() {
        return employeeRepository.findByFirstName("A");
    }

    @Override
    public List<EmployeeByOpenProjectionRs> getAllByOpenProjection() {
        return employeeRepository.findByLastName("B");
    }

    @Override
    public List<EmployeeByOpenProjectionRs> getAllByDynamicProjection() {
        return employeeRepository.findByFirstName("A", EmployeeByOpenProjectionRs.class);
    }

    @Override
    public List<CustomEmployeeRs> getAllWithCustomObject() {
        return employeeRepository.findAllWithCustomObject();
    }

    @Override
    public List<CustomEmployeeRs> getAllWithMapResult() {
        List<Map<String, Object>> results = employeeRepository.findAllWithMapResult();
        return results.stream().map(result -> new CustomEmployeeRs(result)).collect(Collectors.toList());
    }
}
