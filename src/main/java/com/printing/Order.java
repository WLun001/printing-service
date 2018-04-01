package com.printing;

import java.util.UUID;

public class Order {
    private String id;
    private int quantity;
    private boolean highQualityPaper;
    private boolean designEffect;

    public Order(int quality, boolean highQualityPaper, boolean designEffect){
        this.id = UUID.randomUUID().toString();
        this.quantity = quality;
        this.highQualityPaper = highQualityPaper;
        this.designEffect = designEffect;
    }

    public String getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean hasHighQualityPaper(){
        return highQualityPaper;
    }

    public boolean hasDesignEffect(){
        return designEffect;
    }

    public void sentToCaluclateCharge(){

    }

}
