package com.printing.domain;

import java.util.List;

public class AppController {
    private IOrdersList ordersList;

    public AppController(){
        this.ordersList = new OrderList();
    }

    public void addOrder(boolean hasHighQualityPaper, boolean hasDesignEffect){
        ordersList.addOrder(hasHighQualityPaper, hasDesignEffect);
    }
    public int getNumberOfOrders(){
        return ordersList.getNumberOfOrders();
    }
    public void submitOrder(){
        ordersList.submitOrder();
    }
    public double getTotalCharge() {
        return ordersList.getTotalCharge();
    }
}
