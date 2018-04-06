package com.printing.domain;

import java.util.List;

interface IOrdersList {
    void addOrder(boolean hasHighQualityPaper, boolean hasDesignEffec);
    int getNumberOfOrders();
    void submitOrder();
    double getTotalCharge();
}
