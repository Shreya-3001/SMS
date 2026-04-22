package com.sms.service.impl;

import com.sms.dto.StudentDto;
import com.sms.entity.Student;
import com.sms.exception.ResourceNotFoundException;
import com.sms.mapper.StudentMapper;
import com.sms.repository.StudentRepository;
import com.sms.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor

public class StudentServiceImpl implements StudentService {

    private StudentRepository sr;

    @Override
    public StudentDto create(StudentDto dto) {

     Student s = StudentMapper.mapToStudent(dto);

     s.setCreatedDate(new Date());

     Student savedStudent = sr.save(s);

        return StudentMapper.mapToStudentDto(savedStudent);
    }

    @Override
    public StudentDto getStudentById(Long sd) {

        Student s = sr.findById(sd).
                orElseThrow(() -> new ResourceNotFoundException("Student not found:"+sd));
        return StudentMapper.mapToStudentDto(s);
    }

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students = sr.findAll();
        return students.stream().map((student -> StudentMapper.mapToStudentDto(student)))
                .collect(Collectors.toList());
    }

    @Override
    public StudentDto updateStudent(Long studentId, StudentDto updateStudent) {

        Student s = sr.findById(studentId).
                orElseThrow(() -> new ResourceNotFoundException("Student not found:"+studentId));

        s.setFirstName(updateStudent.getFirstName());
        s.setLastName(updateStudent.getLastName());
        s.setDivision(updateStudent.getDivision());
        s.setRollNo(updateStudent.getRollNo());
        s.setUpdatedDate(new Date());
        sr.save(s);
        return StudentMapper.mapToStudentDto(s);
    }



    public void deleteStudent(Long studentId) {

        sr.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id " + studentId));

        sr.deleteById(studentId);
    }
}
