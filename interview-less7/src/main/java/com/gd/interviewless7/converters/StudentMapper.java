package com.gd.interviewless7.converters;

import com.gd.interviewless7.dtos.StudentDto;
import com.gd.interviewless7.entities.Student;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface StudentMapper {

    StudentMapper MAPPER = Mappers.getMapper(StudentMapper.class);

    Student toStudent(StudentDto studentDto);

    @InheritInverseConfiguration
    StudentDto fromStudent(Student student);

    List<Student> toStudentList(List<StudentDto> studentDtos);
    List<StudentDto> fromStudentList(List<Student> students);

}
