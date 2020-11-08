package com.pooja.ecommerce.kitchenstoryapp.model;

public class PaymentUser {

    private String paymentMethod;
    private long cardNumber;
    private int cartId;

    public PaymentUser(String paymentMethod, long cardNumber, int cartId) {
        this.paymentMethod = paymentMethod;
        this.cardNumber = cardNumber;
        this.cartId = cartId;
    }

    public PaymentUser() {
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

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }
}
