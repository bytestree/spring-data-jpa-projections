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
public class AddEmployeeRs implements Serializable {
    private static final long serialVersionUID = -120657133365989893L;

    private Long id;
    private String firstName;
    private String lastName;
    private Long departmentId;


}
