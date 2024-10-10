package com.example.springBootProject2;


import jakarta.persistence.*;
import lombok.Setter;
import lombok.Getter;

import java.sql.Date;
@Getter
@Setter
@Entity
@Table(name = "car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String brand;

    @Column(name = "year_of_production")
    private int yearOfProduction;

    @Column(name = "registration_date")
    private Date regDate;

    @Column(name = "owner_name")
    private String ownerName;

    // Default constructor
    public Car() {
    }

    @Override
    public String toString() {
        return "Car [id=" + id + ", brand=" + brand + ", yearOfProduction=" + yearOfProduction +
                ", regDate=" + regDate + ", ownerName=" + ownerName + "]";
    }
}
