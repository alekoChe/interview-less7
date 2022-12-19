package com.gd.interviewless7.entities;

//package com.geekbrains.spring.web.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "students")

public class Student {  // id, name, age.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "student_name")
    private String name;

    @Column(name = "age")
    private int age;

    @OneToOne
    @JoinColumn(name = "student_data_id")
    private StudentData studentData;
}
