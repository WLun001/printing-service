package com.printing;

public class Charge {
    private double currentCharge;
    private int quantity;

    public Charge(){
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalCharge() {
        return Math.round((currentCharge + quantityCharge()) * 100.0) / 100.0;
    }


    public void receiveOrder(Order order){
        calculateCharge(order);
        quantity ++;
    }

    public void submit(){
        sentToPrinter();
    }

    private void sentToPrinter(){
        PhotoPrinter printer = new PhotoPrinter();
        printer.queueRequest();
    }

    private void calculateCharge(Order order) {
        currentCharge += optionCharge(order.hasDesignEffect(), order.hasHighQualityPaper());
    }

    private double quantityCharge(){
        double unitPrice;
        if (quantity < 5)
            unitPrice = 1.0;
        else if(quantity < 10)
            unitPrice = 0.9;
        else if (quantity < 20)
            unitPrice = 0.7;
        else if (quantity < 50)
            unitPrice = 0.5;
        else
            unitPrice = 0.1;
        return unitPrice * quantity;
    }

    private double optionCharge(boolean hasDesignEffect, boolean hasQualityPaper){
        return checkOption(hasDesignEffect) + checkOption(hasQualityPaper);
    }

    private double checkOption(boolean option){
        if (option) return 0.1; else return 0;
    }
}
