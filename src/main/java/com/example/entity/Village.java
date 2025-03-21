package com.example.entity;

import jakarta.persistence.*;

@Entity
public class Village {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "district_id")
    private District district;

    public Village() {}
    public Village(String name, District district) {
        this.name = name;
        this.district = district;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public District getDistrict() { return district; }
    public void setDistrict(District district) { this.district = district; }
}
