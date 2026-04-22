package com.sms.mapper;

import com.sms.dto.StudentDto;
import com.sms.entity.Student;

public class StudentMapper {

    public static StudentDto mapToStudentDto(Student s){
        return new StudentDto(
          s.getId(),
          s.getFirstName(),
          s.getLastName(),
          s.getRollNo(),
          s.getDivision(),
          s.getCreatedDate(),
          s.getUpdatedDate()

        );
    }

    public static Student mapToStudent(StudentDto sd){
        return new Student(
           sd.getId(),
           sd.getFirstName(),
           sd.getLastName(),
           sd.getRollNo(),
           sd.getDivision(),
           sd.getCreatedDate(),
           sd.getUpdatedDate()

        );


    }


}
