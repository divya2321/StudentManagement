package com.example.Spring1.Service;

import com.example.Spring1.DTO.StudentRequest;
import com.example.Spring1.DTO.StudentResponse;
import com.example.Spring1.Model.Student;

import java.util.List;

public interface StudentService {
    void save(StudentRequest studentRequest);
    List<StudentResponse> searchAll();
    StudentResponse searchStudentById(Long idstudent);
}
