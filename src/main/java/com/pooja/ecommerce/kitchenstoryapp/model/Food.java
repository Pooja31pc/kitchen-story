package com.pooja.ecommerce.kitchenstoryapp.model;

import javax.persistence.*;

@Entity
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int foodId;
    private String foodName;
    private String description;
    private double price;


//    @OneToOne(targetEntity= Cuisine.class)
//    private Cuisine cuisine;

    @ManyToOne(targetEntity= Cuisine.class)
    private Cuisine cuisine;

    public Food(String foodName, String description, double price, Cuisine category) {
        this.foodName = foodName;
        this.description = description;
        this.price = price;
        this.cuisine = category;
    }

//   @ManyToOne
//    private Cart cart;

    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Cuisine getCuisine() {
        return cuisine;
    }

    public void setCuisine(Cuisine cuisine) {
        this.cuisine = cuisine;
    }

    public Food(int foodId, String foodName, String description, double price, Cuisine cuisine) {
        this.foodId = foodId;
        this.foodName = foodName;
        this.description = description;
        this.price = price;
        this.cuisine = cuisine;
    }



    public Food() {
    }

}
