package com.example.mondayproject.service;

import com.example.mondayproject.data.Student;
import com.example.mondayproject.data.StudentRepository;
import com.example.mondayproject.data.StudentUnit;
import lombok.extern.java.Log;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
@Log

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private  StudentService studentService;



    @BeforeAll
    static void setUpAll(){
        log.info("Before all test unit this setup is called");
    }
    @BeforeEach
    void setUp(){
        log.info("Before each test unit this setup is called");
    }
    @AfterEach
    void cleanUp(){
        log.info("After each test unit this setup is called");
    }
    @AfterAll
    static void cleanUpAll(){
        log.info("After each test unit this setup is called");
    }

    @Test
    void givenGdanskUnitWhenSaveStudentThenGetIndex(){

        //given
        var student = new Student(UUID.fromString("14ebf294-3647-429f-b7d8-236d92cd6a94"),"Jan", StudentUnit.GDANSK,null);
        when(studentRepository.getMaxIndex()).thenReturn(70L);

        //when
        var savedStudent =  studentService.saveStudent(student);

        //then
        assertEquals(student.id(), savedStudent.id());
        assertEquals(student.name(), savedStudent.name());
        assertEquals(student.unit(), savedStudent.unit());
        assertEquals(36, savedStudent.index());
        verify(studentRepository,times(1)).saveStudents(any());

    }
}
