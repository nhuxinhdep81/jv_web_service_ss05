package com.tien.ss05.repository;


import com.tien.ss05.model.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> getStudentsByFullNameContains(String fullName);
    List<Student> getStudentsByAddressContains(String address);
    List<Student> getStudentsByClassNameContains(String className);
}
