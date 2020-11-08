package com.pooja.ecommerce.kitchenstoryapp.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Cuisine {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int cuisineId;
    private String cuisineName;

    @OneToMany(mappedBy = "cuisine", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Food> food;

    public int getCuisineId() {
        return cuisineId;
    }

    public void setCuisineId(int cuisineId) {
        this.cuisineId = cuisineId;
    }

    public String getCuisineName() {
        return cuisineName;
    }

    public void setCuisineName(String cuisineName) {
        this.cuisineName = cuisineName;
    }

    public Cuisine(int cuisineId, String cuisineName) {
        this.cuisineId = cuisineId;
        this.cuisineName = cuisineName;
    }

    public Cuisine() {
    }

}
