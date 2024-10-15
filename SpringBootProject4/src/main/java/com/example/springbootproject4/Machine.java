package com.example.springbootproject4;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "machine")
public class Machine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String equipmentType;
    private String equipmentGroup;

    private LocalDateTime importDate;
    private LocalDateTime exportDate;

    private String driverFullName;

    public Machine() {
    }

    @Override
    public String toString() {
        return "Machine [id=" + id + ", equipmentType=" + equipmentType + ", equipmentGroup=" + equipmentGroup +
                ", importDate=" + importDate + ", exportDate=" + exportDate + ", driverFullName=" + driverFullName + "]";
    }
}

