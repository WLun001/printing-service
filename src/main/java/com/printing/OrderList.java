package com.printing;

import java.util.ArrayList;

public class OrderList implements IOrdersList {
    private ArrayList<Order> orders;
    private Charge charge;

    public OrderList(){
        orders = new ArrayList<>();
    }

    @Override
    public void addOrder(boolean hasHighQualityPaper, boolean hasDesignEffect) {
        orders.add(new Order(hasHighQualityPaper, hasDesignEffect));
    }

    @Override
    public int getNumberOfOrders() {
        return orders.size();
    }

    @Override
    public void submitOrder() {
        if (orders.size() == 0){
            throw new IllegalArgumentException("Order cannot be zero");
        } else {
            charge = new Charge();
            for (Order order : orders) {
                charge.receiveOrder(order);
            }
        }
    }

    @Override
    public double getTotalCharge() {
        return charge.getTotalCharge();
    }
}
