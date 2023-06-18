package com.example.tarlascraping1.Models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "fieldProcessModel")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FieldProcessModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int field_id;
    @Column(name = "plantType")
    private String plantType;
    @Column(name = "fieldStatus")
    private String fieldStatus;
    @Column(name = "fieldType")
    private String fieldType;
    @Column(name = "explanation")
    private String axplanation;
    @Column(name = "unitFuelCost")
    private int  unitFuelCost;
    @OneToMany(mappedBy = "fieldProcessModel")
    private Set<OtherCostsModels> otherCostsModels;
    @Column(name = "date")
    private LocalDateTime date;
    @Column(name = "rate_usdtry")
    private double rate_usdtry;
    @Column(name = "rate_eurtry")
    private double rate_eurtry;
    @ManyToOne
    @JoinColumn(name = "properties_id")
    private Properties properties;



}
