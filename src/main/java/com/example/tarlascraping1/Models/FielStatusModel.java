package com.example.tarlascraping1.Models;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "FieldStatus")
public class FielStatusModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int field_status_id;
    @Column(name = "fieldCondition")
    private String fieldCondition;
    @Column(name = "plantType")
    private String plantType;
    private LocalDateTime date;
}
