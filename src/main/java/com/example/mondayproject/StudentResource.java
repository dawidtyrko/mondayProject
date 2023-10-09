package com.example.mondayproject;

import com.example.mondayproject.data.Student;
import com.example.mondayproject.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(path = "/students")
@RequiredArgsConstructor
public class StudentResource {

    private final StudentService studentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveStudents(@RequestBody Student student){
        studentService.saveStudent(student);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable UUID id){
        var student =  studentService.getStudentById(id);
        if(student != null){
            return ResponseEntity.ok(student);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
