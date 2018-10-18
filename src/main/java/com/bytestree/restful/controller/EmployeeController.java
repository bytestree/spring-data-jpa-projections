package com.bytestree.restful.controller;

import com.bytestree.restful.dto.*;
import com.bytestree.restful.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * @author bytesTree
 * @see <a href="http://www.bytestree.com/">BytesTree</a>
 */
@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    final static Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    EmployeeService empService;

    /**
     * Add new employee
     *
     * @param addEmployeeRq
     * @return Added Employee
     */
   @PostMapping
    public ResponseEntity<AddEmployeeRs> addEmployee(@RequestBody AddEmployeeRq addEmployeeRq) {
        AddEmployeeRs employeeRs = empService.save(addEmployeeRq);
        logger.debug("Added:: " + employeeRs);
        return new ResponseEntity<>(employeeRs, HttpStatus.CREATED);
    }


    /**
     * Get All Employees in DB
     *
     * @return List of all Employees
     */
    @GetMapping
    public ResponseEntity<List<GetEmployeeRs>> getAllEmployees() {
        List<GetEmployeeRs> employees = empService.getAll();
        if (employees.isEmpty()) {
            logger.debug("Employees does not exists");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        logger.debug("Found " + employees.size() + " Employees");
        logger.debug(Arrays.toString(employees.toArray()));
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    /**
     * Get Employees by Close Projection
     *
     * @return List of Employees
     */
    @GetMapping("/getByCloseProjection")
    public ResponseEntity<List<EmployeeByCloseProjectionRs>> getAllByCloseProjection() {
        List<EmployeeByCloseProjectionRs> employees = empService.getAllByCloseProjection();
        if (employees.isEmpty()) {
            logger.debug("Employees does not exists");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        logger.debug("Found " + employees.size() + " Employees");
        logger.debug(Arrays.toString(employees.toArray()));
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }


    /**
     * Get Employees by Open Projection
     *
     * @return List of Employees
     */
    @GetMapping("/getByOpenProjection")
    public ResponseEntity<List<EmployeeByOpenProjectionRs>> getAllByOpenProjection() {
        List<EmployeeByOpenProjectionRs> employees = empService.getAllByOpenProjection();
        if (employees.isEmpty()) {
            logger.debug("Employees does not exists");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        logger.debug("Found " + employees.size() + " Employees");
        logger.debug(Arrays.toString(employees.toArray()));
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }


    /**
     * Get Employees by Dynamic Projection
     * @return List of Employees
     */
    @GetMapping("/getByDynamicProjection")
    public ResponseEntity<List<EmployeeByOpenProjectionRs>> getAllByDynamicProjection() {
        List<EmployeeByOpenProjectionRs> employees = empService.getAllByDynamicProjection();
        if (employees.isEmpty()) {
            logger.debug("Employees does not exists");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        logger.debug("Found " + employees.size() + " Employees");
        logger.debug(Arrays.toString(employees.toArray()));
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    /**
     * Get Employees using Class-based Projection
     * @return List of Employees
     */
    @GetMapping("/getByCustomObject")
    public ResponseEntity<List<CustomEmployeeRs>> getAllEmployeesWithCustomObject() {
        List<CustomEmployeeRs> employees = empService.getAllWithCustomObject();
        if (employees.isEmpty()) {
            logger.debug("Employees does not exists");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        logger.debug("Found " + employees.size() + " Employees");
        logger.debug(Arrays.toString(employees.toArray()));
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    /**
     * Get Employees using Class-based Projection with Map
     * @return List of Employees
     */
    @GetMapping("/getByMapResult")
    public ResponseEntity<List<CustomEmployeeRs>> getAllEmployeesWithMapResult() {
        List<CustomEmployeeRs> employees = empService.getAllWithMapResult();
        if (employees.isEmpty()) {
            logger.debug("Employees does not exists");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        logger.debug("Found " + employees.size() + " Employees");
        logger.debug(Arrays.toString(employees.toArray()));
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
}
