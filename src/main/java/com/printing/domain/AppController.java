package com.printing.domain;

import java.util.List;

public class AppController {
    private IOrdersList ordersList;

    public AppController(){
        this.ordersList = new OrderList();
    }

    public void addOrder(Order order){
        ordersList.addOrder(order);
    }
    public List<Order> getOrderList() {
        return ordersList.getOrderList();
    };
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
