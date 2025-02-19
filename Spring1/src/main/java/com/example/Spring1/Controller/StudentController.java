package com.example.Spring1.Controller;

import com.example.Spring1.DTO.StudentRequest;
import com.example.Spring1.DTO.StudentResponse;
import com.example.Spring1.Model.Student;
import com.example.Spring1.Service.StudentServiceIml;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.QueryAnnotation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    private static final Logger log = LoggerFactory.getLogger(StudentController.class);
    private StudentServiceIml studentServiceIml;

    @Autowired
    public StudentController(StudentServiceIml studentServiceIml){
        this.studentServiceIml = studentServiceIml;
    }

    @PostMapping("/save")
    public String saveStudent(@RequestBody StudentRequest studentRequest){
        studentServiceIml.save(studentRequest);
        return "Saved";
    }

    @GetMapping("/searchall")
    public List<StudentResponse> searchAllStudents(){
        return studentServiceIml.searchAll();
    }

    @GetMapping("/searchbyid/{idstudent}")
    public ResponseEntity<StudentResponse> searchStudentById(@PathVariable("idstudent") Long idStudent){
        log.info("STUDENTID: "+String.valueOf(idStudent));
        StudentResponse studentResponse = studentServiceIml.searchStudentById(idStudent);
        if (studentResponse!=null){
            return ResponseEntity.ok(studentResponse);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/searchbyid")
    public ResponseEntity<StudentResponse> searchStudentByIdQuery(@RequestParam("idstudent") Long idStudent){
        log.info("STUDENTID: "+String.valueOf(idStudent));
        StudentResponse studentResponse = studentServiceIml.searchStudentById(idStudent);
        if (studentResponse!=null){
            return ResponseEntity.ok(studentResponse);
        }
        return ResponseEntity.notFound().build();
    }

//    http://localhost:9999/student/save
}
