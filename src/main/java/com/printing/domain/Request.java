package com.printing.domain;

import java.util.UUID;

public class Request {

    private String id;
    private boolean highQualityPaper;
    private boolean designEffect;
    private int quantity;

    public Request(int quantity, boolean highQualityPaper, boolean designEffect) {
        this.id = UUID.randomUUID().toString();
        this.quantity = quantity;
        this.highQualityPaper = highQualityPaper;
        this.designEffect = designEffect;
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
