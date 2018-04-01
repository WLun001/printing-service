package com.printing;

public class Charge {

    public static double totalCharge(Order order){
        return quantityCharge(order.getQuantity()) + optionCharge(order.getQuantity(),order.hasDesignEffect(), order.hasHighQualityPaper());
    }

    private static double quantityCharge(int quantity){
        double unitPrice = 0.0;
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

    private static double optionCharge(int quantity, boolean hasDesignEffect, boolean hasQualityPaper){
        return (quantity * checkOption(hasDesignEffect)) + (quantity * checkOption(hasQualityPaper));
    }

    private static double checkOption(boolean option){
        if (option) return 0.1; else return 0;
    }
}
