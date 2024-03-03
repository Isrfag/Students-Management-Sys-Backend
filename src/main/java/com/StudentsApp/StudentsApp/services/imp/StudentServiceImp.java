package com.StudentsApp.StudentsApp.services.imp;

import com.StudentsApp.StudentsApp.domain.entities.StudentEntity;
import com.StudentsApp.StudentsApp.exceptions.StudentAlreadyExistException;
import com.StudentsApp.StudentsApp.exceptions.StudentNotFoundException;
import com.StudentsApp.StudentsApp.repositories.StudentRepository;
import com.StudentsApp.StudentsApp.services.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImp implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImp (StudentRepository studentRepository) {
        this.studentRepository= studentRepository;
    }

    @Override
    public StudentEntity addStudent(StudentEntity studentEntity) {
        if (studentAlreadyExists(studentEntity.getEmail())) {

            throw new StudentAlreadyExistException(studentEntity.getEmail() + " already exist!");
        }

        return studentRepository.save(studentEntity);
    }

    @Override
    public List<StudentEntity> getStudents() {
        return studentRepository.findAll();
    }

    @Override
    public StudentEntity getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Sorry, student " + id + " not found"));
    }

    @Override
    public StudentEntity updateStudent(StudentEntity studentEntity, Long id) {
        return studentRepository.findById(id).map(st -> {

            st.setFirstName(studentEntity.getFirstName());
            st.setLastName(studentEntity.getLastName());
            st.setEmail(studentEntity.getEmail());
            st.setDepartment(studentEntity.getDepartment());
            return studentRepository.save(st);

        }).orElseThrow(() -> new StudentNotFoundException("Sorry, this student not exists in the database."));
    }

    @Override
    public void deleteStudent(Long id) {

        if(!studentRepository.existsById(id)) {

            throw new StudentNotFoundException("The student that you want to delete don 't exists");
        }else {

            studentRepository.deleteById(id);
        }
    }

    @Override
    public boolean studentAlreadyExists(String email) {

        return studentRepository.findByEmail(email).isPresent();

    }

}
