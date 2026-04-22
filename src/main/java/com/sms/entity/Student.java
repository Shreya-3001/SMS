package com.sms.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable= false)
    private String firstName;

    @Column(name ="last_name", nullable=false)
    private String lastName;

    @Column(name = "roll_no",nullable=false, unique = true)
    private Long rollNo;

    @Column(name = "division",nullable=false)
    private Character division;

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "updated_date")
    private Date updatedDate;
}
