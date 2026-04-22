package com.sms.service;

import com.sms.dto.StudentDto;

import java.util.List;

public interface StudentService {

    StudentDto create(StudentDto dto);

    StudentDto getStudentById(Long sd);

    List<StudentDto> getAllStudents();

    StudentDto updateStudent(Long studentId, StudentDto updateStudent);

    void deleteStudent(Long studentId);
}