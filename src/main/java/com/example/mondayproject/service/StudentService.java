package com.example.mondayproject.service;

import com.example.mondayproject.data.Student;
import com.example.mondayproject.data.StudentRepository;
import com.example.mondayproject.data.StudentUnit;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public Student saveStudent(Student student){
        var index = createIndex(student.unit());
        var toSave = new Student(student.id(), student.name(), student.unit(), index);
        studentRepository.saveStudents(toSave);
        return toSave;
    }

    public Student getStudentById(UUID id){
        return studentRepository.getStudentById(id);
    }


    private Long createIndex(StudentUnit unit){
        if(StudentUnit.GDANSK.equals(unit)){
            return 5 * studentRepository.getMaxIndex();
        }
        else {
            return 10 * studentRepository.getMaxIndex();
        }
    }
}
