package com.example.tarlascraping1.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "OtherCosts")
@Data
public class OtherCostsModels {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private int otherCosts_id;
    @Column(name = "otherCostsExplanation")
    private String otherCostsExplanation;
    @Column(name = "otherCosts")
    private long otherCosts;
    // Exapmle Litre
    @Column(name = "piece")
    private String unitName;
    // Example 5.7
    @Column(name = "unit")
    private double unit;
    @ManyToOne
    @JoinColumn(name = "field_id",nullable = false)
    @JsonIgnore
    private FieldProcessModel fieldProcessModel;

}
