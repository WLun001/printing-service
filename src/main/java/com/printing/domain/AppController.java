package com.printing.domain;

public class AppController {
    private IOrdersList ordersList;

    public AppController(){
        this.ordersList = new OrderList();
    }

    public void addOrder(Order order){
        ordersList.addOrder(order);
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
