package com.StudentsApp.StudentsApp.repositories;

import com.StudentsApp.StudentsApp.domain.entities.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity,Long> {
    Optional<StudentEntity> findByEmail(String email);
}
