package com.pooja.ecommerce.kitchenstoryapp.model;

public class AddFoodAdmin {

    private String foodName;
    private String description;
    private double price;
    private int cuisineId;

    public AddFoodAdmin() {
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

    public int getCuisineId() {
        return cuisineId;
    }

    public void setCuisineId(int cuisineId) {
        this.cuisineId = cuisineId;
    }

    public AddFoodAdmin(String foodName, String description, double price, int cuisineId) {
        this.foodName = foodName;
        this.description = description;
        this.price = price;
        this.cuisineId = cuisineId;
    }

}
