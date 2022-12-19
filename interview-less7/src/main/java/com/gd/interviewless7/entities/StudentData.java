package com.gd.interviewless7.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "student_data")
public class StudentData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "passport_number_and_series")
    private String passportNumberAndSeries;

    @Column(name = "gas_mask_size")
    private int gasMaskSize;
}
