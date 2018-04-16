package com.printing.domain;

import java.util.UUID;

/**
 * Printing request
 */
public class Request {

    private String id;
    private boolean highQualityPaper;
    private boolean designEffect;
    private int quantity;

    /**
     * Contructor of Request
     *
     * @param quantity         paper quantity
     * @param highQualityPaper additional option for using high quality paper
     * @param designEffect     additional option for applying design effect
     * @throws IllegalArgumentException paper quantity must be in range 1 - 100
     */
    public Request(int quantity, boolean highQualityPaper, boolean designEffect) {
        if (quantity <= 0 || quantity > 100)
            throw new IllegalArgumentException("Quantity must be within 1 - 100");

        else {
            this.id = UUID.randomUUID().toString();
            this.quantity = quantity;
            this.highQualityPaper = highQualityPaper;
            this.designEffect = designEffect;
        }
    }

    public String getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean hasHighQualityPaper() {
        return highQualityPaper;
    }

    public boolean hasDesignEffect() {
        return designEffect;
    }
}
