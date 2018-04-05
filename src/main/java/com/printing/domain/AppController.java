package com.printing.domain;

public class AppController {
    private IOrdersList ordersList;

    public AppController(){
        this.ordersList = new OrderList();
    }

    public void addOrder(boolean hasHighQualityPaper, boolean hasDesignEffec){
        ordersList.addOrder(hasHighQualityPaper, hasDesignEffec);
    }
    public int getNumberOfOrders(){
        return ordersList.getNumberOfOrders();
    }
    public void submitOrder(){
        ordersList.submitOrder();
    }
    public double getTotalCharge(){
        return ordersList.getTotalCharge();
    }
}
