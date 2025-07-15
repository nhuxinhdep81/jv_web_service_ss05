package com.tien.ss05.service;

import com.tien.ss05.model.entity.Book;
import com.tien.ss05.model.entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudents();
    Student getStudentById(Integer id);
    Student addStudent(Student student);
    Student updateStudent(Student student);
    boolean deleteStudent(Integer id);
    List<Student> getStudentByFullName(String fullName);
    List<Student> getStudentByAddress(String address);
    List<Student> getStudentByClassName(String className);
}
