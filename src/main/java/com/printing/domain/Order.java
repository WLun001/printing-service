package com.printing.domain;

import java.util.UUID;

public class Order {
    private String id;
    private boolean highQualityPaper;
    private boolean designEffect;

    public Order(boolean highQualityPaper, boolean designEffect) {
        this.id = UUID.randomUUID().toString();
        this.highQualityPaper = highQualityPaper;
        this.designEffect = designEffect;
    }

    public String getId() {
        return id;
    }

    public boolean hasHighQualityPaper() {
        return highQualityPaper;
    }

    public boolean hasDesignEffect() {
        return designEffect;
    }
}
