package com.gd.interviewless7.controllers;


import com.gd.interviewless7.converters.StudentMapper;
import com.gd.interviewless7.dtos.StudentDto;
import com.gd.interviewless7.entities.Student;
import com.gd.interviewless7.exceptions.ResourceNotFoundException;
import com.gd.interviewless7.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {
    private  final StudentService studentService;
    private final StudentMapper studentMapper;

    @GetMapping("/{id}")
    public StudentDto getStudentBiId(@PathVariable Long id) {
        Student student = studentService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student not found, id: " + id));
        return  studentMapper.MAPPER.fromStudent(student);
    }

    @PostMapping
    public StudentDto saveNewStudent(@RequestBody StudentDto studentDto) {
        Student student = studentMapper.MAPPER.toStudent(studentDto);
        student = studentService.save(student);
        return studentMapper.MAPPER.fromStudent(student);
    }

    @PutMapping
    public  StudentDto updateStudent(@RequestBody StudentDto studentDto) {
        Student student = studentService.update(studentDto);
        return studentMapper.MAPPER.fromStudent(student);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        studentService.deleteById(id);
    }
}
