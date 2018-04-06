package com.printing.domain;

import java.util.List;

interface IOrdersList {
    void addOrder(Order order);

    List<Order> getOrderList();

    int getNumberOfOrders();

    void submitOrder();

    double getTotalCharge();
}
