package com.tien.ss05.controller;

import com.tien.ss05.model.dto.response.DataResponse;
import com.tien.ss05.model.entity.Student;
import com.tien.ss05.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping
    public ResponseEntity<DataResponse<List<Student>>> getAllStudents() {
        return new ResponseEntity<>(new DataResponse<>(studentService.getAllStudents(), HttpStatus.OK), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataResponse<Student>> getStudentById(@PathVariable Integer id) {
    return new ResponseEntity<>(new DataResponse<>(studentService.getStudentById(id), HttpStatus.OK), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DataResponse<Student>> addStudent(@RequestBody Student student) {
        return new ResponseEntity<>(new DataResponse<>(studentService.addStudent(student), HttpStatus.CREATED), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<DataResponse<Student>> updateStudent(@RequestBody Student student) {
        return new ResponseEntity<>(new DataResponse<>(studentService.updateStudent(student), HttpStatus.OK), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Integer id) {
        return new  ResponseEntity<>(new DataResponse<>(studentService.deleteStudent(id),HttpStatus.NO_CONTENT),HttpStatus.NO_CONTENT);
    }

    @GetMapping("/stu-by-name/{name}")
    public ResponseEntity<DataResponse<List<Student>>> getStudentsByFullName(@PathVariable String name) {
        return new ResponseEntity<>(new DataResponse<>(studentService.getStudentByFullName(name), HttpStatus.OK), HttpStatus.OK);
    }

    @GetMapping("/stu-by-address/{address}")
    public ResponseEntity<DataResponse<List<Student>>> getStudentsByAddress(@PathVariable String address) {
        return new ResponseEntity<>(new DataResponse<>(studentService.getStudentByAddress(address), HttpStatus.OK), HttpStatus.OK);
    }

    @GetMapping("/stu-by-class/{className}")
    public ResponseEntity<DataResponse<List<Student>>> getStudentsByClassName(@PathVariable String className) {
        return new ResponseEntity<>(new DataResponse<>(studentService.getStudentByClassName(className), HttpStatus.OK), HttpStatus.OK);
    }
}
