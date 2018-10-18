package com.bytestree.restful.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Map;

/**
 * @author bytesTree
 * @see <a href="http://www.bytestree.com/">BytesTree</a>
 */

@Setter
@Getter
public class CustomEmployeeRs implements Serializable {

    private static final long serialVersionUID = -2883410526895516483L;

    public static final String FIRST_NAME = "firstName";
    public static final String LAST_NAME = "lastName";
    public static final String DEPARTMENT_NAME = "departmentName";

    private String firstName;
    private String lastName;
    private String departmentName;

    public CustomEmployeeRs(String firstName, String lastName, String departmentName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.departmentName = departmentName;
    }

    public CustomEmployeeRs(Map<String, Object> values) {
        this.firstName = values.get(FIRST_NAME) != null ? (String) values.get(FIRST_NAME): null;
        this.lastName = values.get(LAST_NAME) != null ? (String) values.get(LAST_NAME) : null;
        this.departmentName = values.get(DEPARTMENT_NAME) != null ? (String) values.get(DEPARTMENT_NAME) : null;
    }

    public CustomEmployeeRs() {
    }
}
