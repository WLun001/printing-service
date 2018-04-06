package com.printing.domain;

interface IOrdersList {
    void addOrder(Order order);

    int getNumberOfOrders();

    void submitOrder();

    double getTotalCharge();
}
