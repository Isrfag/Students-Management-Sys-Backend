package com.StudentsApp.StudentsApp.services;

import com.StudentsApp.StudentsApp.domain.entities.StudentEntity;

import java.util.List;

public interface StudentService {

    StudentEntity addStudent(StudentEntity studentEntity);
    List<StudentEntity> getStudents();
    StudentEntity getStudentById(Long id);
    StudentEntity updateStudent (StudentEntity studentEntity,Long id);
    void deleteStudent(Long id);

    boolean studentAlreadyExists(String email);

}
