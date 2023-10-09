package com.example.mondayproject.service;

import com.example.mondayproject.data.Student;
import com.example.mondayproject.data.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public void saveStudent(Student student){
        studentRepository.saveStudents(student);
    }

    public Student getStudentById(UUID id){
        return studentRepository.getStudentById(id);
    }

}
