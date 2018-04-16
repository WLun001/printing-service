package com.printing.domain;

import java.util.ArrayList;

public class Computation {
    private double totalCharge;
    private int requestsQuantity;

    public Computation() {
    }

    public double getTotalCharge() {
        return Math.round((totalCharge) * 100.0) / 100.0;
    }

    public int getRequestsQuantity() {
        return requestsQuantity;
    }

    public void receiveRequests(ArrayList<Request> requests) {
        if (requests == null)
            throw new IllegalArgumentException("Request list cannot be null");

        totalCharge += calculateCharge(requests);

        this.requestsQuantity = requests.size();
    }

    private double calculateCharge(ArrayList<Request> requests) {
        double quantityCharge = calculateQuantityCharge(getTotalQuantity(requests));
        double optionCharge = getOptionCharge(requests);
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
        else if (quantity <= 100)
            unitPrice = 0.1;
        else
            throw new IllegalArgumentException("Cannot more than 100 papers");
        return unitPrice * quantity;
    }

    private int getTotalQuantity(ArrayList<Request> requests) {
        int quantity = 0;
        for (Request request : requests) {
            quantity += request.getQuantity();
        }
        return quantity;
    }

    private double getOptionCharge(ArrayList<Request> requests) {
        double optionCharge = 0.0;
        for (Request request : requests) {
            for (int i = 0; i < request.getQuantity(); i++)
                optionCharge += calculateOptionCharge(request.hasHighQualityPaper(), request.hasDesignEffect());
        }
        return optionCharge;
    }

    private double calculateOptionCharge(boolean hasQualityPaper, boolean hasDesignEffect) {
        return checkOption(hasQualityPaper) + checkOption(hasDesignEffect);
    }

    private double checkOption(boolean option) {
        if (option) return 0.1;
        else return 0;
    }
}
