package com.gd.interviewless7.repositories;

import com.gd.interviewless7.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>  {
    Optional<Student> findByStudentName(String name);
}
