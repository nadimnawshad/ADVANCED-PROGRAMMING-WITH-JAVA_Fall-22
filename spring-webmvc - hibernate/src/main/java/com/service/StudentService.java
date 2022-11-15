package com.service;

import com.domain.Student;
import com.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

@Service
@Transactional
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Transactional
    public boolean insert(Student student) throws SQLException {
        student.setFirstname(student.getFirstname().toUpperCase());
        student.setLastname(student.getLastname().toUpperCase());
        return studentRepository.create(student);
    }
}
