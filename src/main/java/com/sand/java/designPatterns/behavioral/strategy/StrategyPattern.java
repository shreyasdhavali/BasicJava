package com.sand.java.designPatterns.behavioral.strategy;

public class StrategyPattern {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        PaymentStrategy creditCardPayment = new CreditCardPayment("123456789", "John Doe");
        PaymentStrategy paypalPayment = new PayPalPayment("john@example.com");

        cart.setPaymentStrategy(creditCardPayment);
        cart.checkout(100);

        cart.setPaymentStrategy(paypalPayment);
        cart.checkout(200);
    }
}

