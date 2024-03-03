package com.StudentsApp.StudentsApp.mappers;

import com.StudentsApp.StudentsApp.domain.dtos.StudentDto;

public interface Mapper <StudentEntity,StudentDto>{

    StudentDto mapTo (StudentEntity studentEntity);

    StudentEntity mapFrom (StudentDto studentDto);

}
