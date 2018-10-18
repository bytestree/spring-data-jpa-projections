package com.bytestree.restful.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author bytesTree
 * @see <a href="http://www.bytestree.com/">BytesTree</a>
 */

@Getter
@Setter
public class GetEmployeeRs implements Serializable {
    private static final long serialVersionUID = -8218209262175784440L;

    private Long id;
    private String firstName;
    private String lastName;
    private String designation;
    private Integer salary;
    private Long departmentId;
    private String departmentName;
}
