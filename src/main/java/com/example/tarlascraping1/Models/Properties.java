package com.example.tarlascraping1.Models;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "Properties")
public class Properties {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int properties_id;
    @Column(name = "ilceAd")
    private String ilceAd;
    @Column(name = "mevkii")
    private String mevkii;
    @Column(name = "parselNo")
    private String parselNo;
    @Column(name = "nitelik")
    private String nitelik;
    @Column(name = "mahalleAd")
    private String mahalleAd;
    @Column(name = "alan")
    private String alan;
    @Column(name = "adaNo")
    private String adaNo;
    @Column(name = "ilAd")
    private String ilAd;
    @Column(name = "pafta")
    private String pafta;
    @OneToMany(mappedBy = "properties")
    private Set<FieldProcessModel> fieldProcessModel;
}
