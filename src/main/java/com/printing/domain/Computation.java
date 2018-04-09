package com.printing.domain;

import java.util.ArrayList;

public class Computation {
    private double totalCharge;

    public Computation() {
    }

    public double getTotalCharge() {
        return Math.round((totalCharge) * 100.0) / 100.0;
    }

    public void receiveRequest(ArrayList<Request> requestList) {
        if (requestList == null)
            throw new IllegalArgumentException("Request cannot be null");

        for (Request request : requestList) {
            totalCharge += calculateCharge(request);
        }
    }

    private double calculateCharge(Request request) {
        double quantityCharge = calculateQuantityCharge(request.getQuantity());
        double optionCharge = calculateOptionCharge(request.hasHighQualityPaper(), request.hasDesignEffect());
        return quantityCharge + optionCharge;
    }

    private double calculateQuantityCharge(int quantity) {
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

    private double calculateOptionCharge(boolean hasQualityPaper, boolean hasDesignEffect) {
        return checkOption(hasQualityPaper) + checkOption(hasDesignEffect);
    }

    private double checkOption(boolean option) {
        if (option) return 0.1;
        else return 0;
    }
}
