package com.bytestree.restful.dto;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author bytesTree
 * @see <a href="http://www.bytestree.com/">BytesTree</a>
 */
public interface EmployeeByOpenProjectionRs {
    Long getId();

    @Value("#{target.firstName} #{target.lastName}")
    String getFullName();

    @Value("#{target.department.name}")
    String getDepartmentName();
}
