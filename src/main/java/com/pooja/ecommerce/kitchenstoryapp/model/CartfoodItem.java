package com.pooja.ecommerce.kitchenstoryapp.model;

import javax.persistence.*;

@Entity
public class CartfoodItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int cartitemId;
    private int quantity;

    @ManyToOne
    @JoinColumn(name="cartId", nullable=false)
    private Cart cart;


    @OneToOne(targetEntity= Food.class)
    private Food food;

    public CartfoodItem(int cartitemId, int quantity, Cart cart, Food food) {
        this.cartitemId = cartitemId;
        this.quantity = quantity;
        this.cart = cart;
        this.food = food;
    }

    public CartfoodItem(Food food, Cart cart, int quantity) {
        this.quantity = quantity;
        this.cart = cart;
        this.food = food;
    }

    public int getCartitemId() {
        return cartitemId;
    }

    public void setCartitemId(int cartitemId) {
        this.cartitemId = cartitemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public CartfoodItem() {
    }

}
