package com.bytestree.restful.dto;

/**
 * @author bytesTree
 * @see <a href="http://www.bytestree.com/">BytesTree</a>
 */
public interface EmployeeByCloseProjectionRs {
    Long getId();

    String getFirstName();

    String getLastName();

    DepartmentRs getDepartment();

    interface DepartmentRs {
        String getName();
    }
}
