package com.bytestree.restful.repository;

import com.bytestree.restful.dto.CustomEmployeeRs;
import com.bytestree.restful.dto.EmployeeByCloseProjectionRs;
import com.bytestree.restful.dto.EmployeeByOpenProjectionRs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bytestree.restful.model.Employee;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author bytesTree
 * @see <a href="http://www.bytestree.com/">BytesTree</a>
 * 
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<EmployeeByCloseProjectionRs> findByFirstName(String firstName);

    List<EmployeeByOpenProjectionRs> findByLastName(String lastName);

    // dynamic projection can return EmployeeByOpenProjectionRs or EmployeeByCloseProjectionRs
    <T> List<T> findByFirstName(String firstName, Class<T> tClass);

    @Query("select new com.bytestree.restful.dto.CustomEmployeeRs(e.firstName, e.lastName, e.department.name) " +
           "from Employee e")
    List<CustomEmployeeRs> findAllWithCustomObject();

    @Query("select e.firstName as "+ CustomEmployeeRs.FIRST_NAME +"," +
            " e.lastName as " + CustomEmployeeRs.LAST_NAME + ", " +
            " d.name as " + CustomEmployeeRs.DEPARTMENT_NAME +
            " from Employee e join e.department d")
    List<Map<String, Object>> findAllWithMapResult();

}
