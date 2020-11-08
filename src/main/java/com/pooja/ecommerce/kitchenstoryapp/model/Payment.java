package com.pooja.ecommerce.kitchenstoryapp.model;

import javax.persistence.*;

@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int paymentId;
    private String paymentMethod;
    private long cardNumber;
    private  int amount;

//    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinColumn(name = "cartId")
//    private Cart cart;

//    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinColumn(name = "userId")
//    private User user;

    @OneToOne(targetEntity= User.class)
    private User user;

    @OneToOne(targetEntity= Cart.class)
    private Cart cart;


    public Payment() {
    }

    public Payment(int paymentId, String paymentMethod, long cardNumber, int amount, User user, Cart cart) {
        this.paymentId = paymentId;
        this.paymentMethod = paymentMethod;
        this.cardNumber = cardNumber;
        this.amount = amount;
        this.user = user;
        this.cart = cart;
    }

    public Payment(User user1, Cart cart1, String paymentMethod, long cardNumber, int amount) {

        this.user = user1;
        this.cart = cart1;
        this.paymentMethod = paymentMethod;
        this.cardNumber = cardNumber;
        this.amount = amount;

    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
