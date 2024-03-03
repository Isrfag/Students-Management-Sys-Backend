package com.StudentsApp.StudentsApp.controllers;

import com.StudentsApp.StudentsApp.config.MapperConfig;
import com.StudentsApp.StudentsApp.domain.dtos.StudentDto;
import com.StudentsApp.StudentsApp.domain.entities.StudentEntity;
import com.StudentsApp.StudentsApp.mappers.Mapper;
import com.StudentsApp.StudentsApp.services.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/students")
public class StudentController {
    private final Mapper<StudentEntity,StudentDto> mapper;
    private final StudentService studentService;

    public StudentController(Mapper<StudentEntity,StudentDto> mapper,StudentService studentService) {
        this.mapper = mapper;
        this.studentService=studentService;
    }


    @PostMapping("/add")
    public ResponseEntity<StudentDto> addStudent (@RequestBody StudentDto studentDto) {

        StudentEntity savedStudent = studentService.addStudent(mapper.mapFrom(studentDto));
        StudentDto returnedStudent = mapper.mapTo(savedStudent);
        return new ResponseEntity<>(returnedStudent, HttpStatus.CREATED);

    }

    @GetMapping
    public ResponseEntity<List<StudentDto>> getAllStudents () {

        List<StudentEntity> listEntity = studentService.getStudents();

        List<StudentDto> listDto = listEntity.stream()
                .map(mapper::mapTo).toList();

        return new ResponseEntity<>(listDto,HttpStatus.FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity <StudentDto> getOneStudent (@PathVariable Long id) {

        StudentDto studentDto = mapper.mapTo(studentService.getStudentById(id));
        return new ResponseEntity<>(studentDto,HttpStatus.FOUND);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable Long id, @RequestBody StudentDto studentDto) {

        StudentEntity updatedStudent = studentService.updateStudent(mapper.mapFrom(studentDto),id);
        return new ResponseEntity<>(mapper.mapTo(updatedStudent),HttpStatus.ACCEPTED);

    }

    @DeleteMapping("/delete/{id}")
    public  ResponseEntity<Void> deleteStudent (@PathVariable Long id) {

        studentService.deleteStudent(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }

}
