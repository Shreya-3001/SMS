package com.sms.repository;

import com.sms.entity.Student;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


@Service
public interface StudentRepository extends JpaRepository<Student,Long> {
}
