package com.pooja.ecommerce.kitchenstoryapp.model;

public class AddItemUser {

    private int foodId;
    private int userId;
    private int quantity;

    public AddItemUser(int foodId, int userId, int quantity) {
        this.foodId = foodId;
        this.userId = userId;
        this.quantity = quantity;
    }

    public AddItemUser() {
    }

    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
