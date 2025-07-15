package com.tien.ss05.service;

import com.tien.ss05.model.entity.Student;
import com.tien.ss05.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Integer id) {
        return studentRepository.findById(id).orElseThrow(()->new NoSuchElementException("Student not found"));
    }

    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Student student) {
        studentRepository.findById(student.getStudentId()).orElseThrow(()-> new NoSuchElementException("Student not found"));
        return studentRepository.save(student);
    }

    @Override
    public boolean deleteStudent(Integer id) {
        studentRepository.findById(id).orElseThrow(()-> new NoSuchElementException("Student not found"));
        studentRepository.deleteById(id);
        return true;
    }

    @Override
    public List<Student> getStudentByFullName(String fullName) {
        return studentRepository.getStudentsByFullNameContains(fullName);
    }

    @Override
    public List<Student> getStudentByAddress(String address) {
        return studentRepository.getStudentsByAddressContains(address);
    }

    @Override
    public List<Student> getStudentByClassName(String className) {
        return studentRepository.getStudentsByClassNameContains(className);
    }
}
