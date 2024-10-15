package com.example.springbootproject3;


import jakarta.persistence.*;
import lombok.Setter;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "seance")
public class Seance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String movieTitle;

    private String studio;

//      @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime sessionDateTime;

    private int ticketCount;

    public Seance() {
    }

    @Override
    public String toString() {
        return "Seance [id=" + id + ", movieTitle=" + movieTitle + ", studio=" + studio +
                ", sessionDateTime=" + sessionDateTime + ", ticketCount=" + ticketCount + "]";
    }


}