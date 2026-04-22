package com.sms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class StudentDto {

    private Long id;
    private String firstName;
    private String lastName;
    private Long rollNo;
    private Character division;
    private Date createdDate;
    private Date updatedDate;

}
