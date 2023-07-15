package com.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "employee")
@Getter
@Setter
public class Employee {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name")
    private String name;

    @Column (name = "email")
    private String email;

    @Column(name = "birthyear")
    private int birthyear;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "leave_id", referencedColumnName = "id")
    private Leave leave;

    @Column(name = "worked_years")
    private String workedYears;

    public Employee() {
    }

    public Employee(String name, String email, int birthyear, Leave leave, String workedYears) {
        this.name = name;
        this.email = email;
        this.birthyear = birthyear;
        this.leave = leave;
        this.workedYears = workedYears;
    }




}
