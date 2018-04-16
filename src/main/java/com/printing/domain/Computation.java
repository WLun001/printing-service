package com.printing.domain;

import java.util.ArrayList;

/**
 * Compute charge of requests
 */
public class Computation {
    private double totalCharge;
    private int requestsQuantity;

    public Computation() {
    }

    /**
     * get total charge of requests
     *
     * @return total charge of requests
     */
    public double getTotalCharge() {
        return Math.round((totalCharge) * 100.0) / 100.0;
    }

    /**
     * get number of requests
     *
     * @return number of requests
     */
    public int getRequestsQuantity() {
        return requestsQuantity;
    }

    /**
     * receive list of requests from {@link AppController}
     *
     * @param requests List of requests
     */
    public void receiveRequests(ArrayList<Request> requests) {
        if (requests == null)
            throw new IllegalArgumentException("Request list cannot be null");

        totalCharge += calculateCharge(requests);
        this.requestsQuantity = requests.size();
    }

    /**
     * calculate the charge for list of requests
     *
     * @param requests list of requests to be calculated
     * @return total charge of requests
     */
    private double calculateCharge(ArrayList<Request> requests) {
        double quantityCharge = calculateQuantityCharge(getTotalQuantity(requests));
        double optionCharge = getOptionCharge(requests);
        return quantityCharge + optionCharge;
    }

    /**
     * get charge based on paper quantity
     *
     * @param quantity total papers quantity
     * @return price based on quantity
     * @throws IllegalArgumentException if paper quantity more than 100
     */
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

    /**
     * get total paper quantity from list of requests
     *
     * @param requests requests to be calculated
     * @return total paper quantity
     */
    private int getTotalQuantity(ArrayList<Request> requests) {
        int quantity = 0;
        for (Request request : requests) {
            quantity += request.getQuantity();
        }
        return quantity;
    }

    /**
     * calculate the additional charges for options for list of requests
     *
     * @param requests requests to be calculated
     * @return total charge for options if there is any
     */
    private double getOptionCharge(ArrayList<Request> requests) {
        double optionCharge = 0.0;
        for (Request request : requests) {
            for (int i = 0; i < request.getQuantity(); i++)
                optionCharge += calculateOptionCharge(request.hasHighQualityPaper(), request.hasDesignEffect());
        }
        return optionCharge;
    }

    /**
     * calculate the additional charges for options for single request
     *
     * @param hasQualityPaper whether it has high quality paper
     * @param hasDesignEffect whether it has design effect
     * @return
     */
    private double calculateOptionCharge(boolean hasQualityPaper, boolean hasDesignEffect) {
        return checkOption(hasQualityPaper) + checkOption(hasDesignEffect);
    }

    /**
     * Check the request whether it has additional options
     *
     * @param option option to be checked
     * @return return the price of option if applicable
     */
    private double checkOption(boolean option) {
        if (option) return 0.1;
        else return 0;
    }
}
