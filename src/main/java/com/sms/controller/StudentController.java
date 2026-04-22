package com.sms.controller;

import com.sms.dto.StudentDto;
import com.sms.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor


public class StudentController {

    private StudentService studentService;


    @PostMapping("/add")
    public ResponseEntity<StudentDto> create(@RequestBody StudentDto dto) {

        StudentDto studentDto = studentService.create(dto);

        return new ResponseEntity<>(studentDto, HttpStatus.CREATED);
    }



    @GetMapping("/get/{id}")
    public ResponseEntity<StudentDto> getStudent(@PathVariable("id") Long studentId) {

        StudentDto studentDto = studentService.getStudentById(studentId);
        return new ResponseEntity<>(studentDto, HttpStatus.OK);
    }


    @GetMapping("/getAll")
    public ResponseEntity<List<StudentDto>> getAllStudents() {

        List<StudentDto> studentDtos = studentService.getAllStudents();
        return new ResponseEntity<>(studentDtos, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<StudentDto> getUpdateStudent(@PathVariable ("id")  Long studentId, @RequestBody StudentDto dto) {

       StudentDto studentDto = studentService.updateStudent(studentId,dto);
        return new ResponseEntity<>(studentDto, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") Long studentId) {

        studentService.deleteStudent(studentId);

        return ResponseEntity.ok("Student deleted");
    }
}
