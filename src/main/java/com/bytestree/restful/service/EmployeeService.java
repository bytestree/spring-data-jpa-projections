package com.bytestree.restful.service;

import com.bytestree.restful.dto.*;

import java.util.List;

/**
 * @author bytesTree
 * @see <a href="http://www.bytestree.com/">BytesTree</a>
 */
public interface EmployeeService {
    AddEmployeeRs save(AddEmployeeRq employee);

    List<GetEmployeeRs> getAll();

    List<EmployeeByCloseProjectionRs> getAllByCloseProjection();

    List<EmployeeByOpenProjectionRs> getAllByOpenProjection();

    List<EmployeeByOpenProjectionRs> getAllByDynamicProjection();

    List<CustomEmployeeRs> getAllWithCustomObject();

    List<CustomEmployeeRs> getAllWithMapResult();
}
