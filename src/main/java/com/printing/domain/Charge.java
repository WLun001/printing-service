package com.printing.domain;

public class Charge {
    private double currentCharge;
    private int quantity;

    public Charge() {
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalCharge() {
        return Math.round((currentCharge + calculateQuantityCharge()) * 100.0) / 100.0;
    }


    public void receiveOrder(Order order) {

        if (order == null)
            throw new IllegalArgumentException("Order cannot be null");

        calculateCharge(order);
        quantity++;
        sentToPrinter();
    }

    private void sentToPrinter() {
        PhotoPrinter printer = new PhotoPrinter();
        printer.queueRequest();
    }

    private void calculateCharge(Order order) {
        currentCharge += calculateOptionCharge(order.hasHighQualityPaper(), order.hasDesignEffect());
    }

    private double calculateQuantityCharge() {
        if (quantity <= 0)
            throw new IllegalArgumentException("Quantity cannot be zero");
        else {
            double unitPrice;
            if (quantity < 5)
                unitPrice = 1.0;
            else if (quantity < 10)
                unitPrice = 0.9;
            else if (quantity < 20)
                unitPrice = 0.7;
            else if (quantity < 50)
                unitPrice = 0.5;
            else
                unitPrice = 0.1;
            return unitPrice * quantity;
        }
    }

    private double calculateOptionCharge(boolean hasQualityPaper, boolean hasDesignEffect) {
        return checkOption(hasQualityPaper) + checkOption(hasDesignEffect);
    }

    private double checkOption(boolean option) {
        if (option) return 0.1;
        else return 0;
    }
}
