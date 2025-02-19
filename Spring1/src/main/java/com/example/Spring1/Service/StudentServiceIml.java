package com.example.Spring1.Service;

import com.example.Spring1.DTO.StudentRequest;
import com.example.Spring1.DTO.StudentResponse;
import com.example.Spring1.Model.Student;
import com.example.Spring1.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Component
public class StudentServiceIml implements StudentService {


    private StudentRepository studentRepository;

    @Autowired
    public void setStudentResponse(StudentResponse studentResponse) {
        this.studentResponse = studentResponse;
    }

    private StudentResponse studentResponse;

    @Autowired
    public StudentServiceIml(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void save(StudentRequest studentRequest) {
        Function<StudentRequest, Student> studentMapper = studentRequest1 ->
                new Student(
                        studentRequest.getFirstName(),
                        studentRequest.getLastName(),
                        studentRequest.getEmail()
                );
        studentRepository.save(studentMapper.apply(studentRequest));
    }

    @Override
    public List<StudentResponse> searchAll() {
        List<Student> students = studentRepository.findAll();
        List<StudentResponse> studentList = new ArrayList<>();
        StudentResponse studentResponse1;
        for (Student student: students){
            studentResponse1 = new StudentResponse();
            studentResponse1.setFirstName(student.getFirstName());
            studentResponse1.setLastName(student.getLastName());
            studentResponse1.setEmail(student.getEmail());
            studentList.add(studentResponse1);
        }
        if (!studentList.isEmpty()) {
            return studentList;
        }
        return null;

    }

    @Override
    public StudentResponse searchStudentById(Long idstudent) {
        Optional<Student> studentOptional = studentRepository.findById(idstudent);
        if (studentOptional.isPresent()){
            Student student = studentOptional.get();
            studentResponse.setFirstName(student.getFirstName());
            studentResponse.setLastName(student.getLastName());
            studentResponse.setEmail(student.getEmail());
            return studentResponse;
        }
        return null;
    }


}
