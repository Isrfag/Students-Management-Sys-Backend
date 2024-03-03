package com.StudentsApp.StudentsApp.mappers.imp;

import com.StudentsApp.StudentsApp.domain.dtos.StudentDto;
import com.StudentsApp.StudentsApp.domain.entities.StudentEntity;
import com.StudentsApp.StudentsApp.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class MapperImp implements Mapper<StudentEntity, StudentDto> {

    private ModelMapper modelMapper;

    public MapperImp (ModelMapper modelMapper) {
        this.modelMapper=modelMapper;
    }

    @Override
    public StudentDto mapTo(StudentEntity studentEntity) {
        return modelMapper.map(studentEntity,StudentDto.class);
    }

    @Override
    public StudentEntity mapFrom(StudentDto studentDto) {
        return modelMapper.map(studentDto,StudentEntity.class);
    }
}
