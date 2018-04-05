package com.printing.domain;

interface IOrdersList {
    void addOrder(boolean hasHighQualityPaper, boolean hasDesignEffec);
    int getNumberOfOrders();
    void submitOrder();
    double getTotalCharge();
}
