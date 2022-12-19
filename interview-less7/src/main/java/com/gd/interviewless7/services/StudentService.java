package com.gd.interviewless7.services;

import com.gd.interviewless7.dtos.StudentDto;
import com.gd.interviewless7.entities.Student;
import com.gd.interviewless7.exceptions.ResourceNotFoundException;
import com.gd.interviewless7.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public Optional<Student> findByStudentName(String name) {
        return studentRepository.findByStudentName(name);
    }

    public Optional<Student> findById(Long id) {
        return studentRepository.findById(id);
    }

    @Transactional
    public Student update(StudentDto studentDto) {
        Student student = studentRepository.findById(studentDto.getId()).orElseThrow(() ->
                new ResourceNotFoundException("Невозможно обновить студента, не надйен в базе, id: " + studentDto.getId()));
        student.setName(studentDto.getName());
        student.setAge(studentDto.getAge());
        return student;
    }

    public List<Student> findAllStudents(){
        return studentRepository.findAll();
    }

    public Student save(Student student) {
        return studentRepository.save(student);
    }

    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }

}
