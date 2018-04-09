package com.printing.domain;

import java.util.List;

public class AppController {
    private Order order;
    private Computation charge;

    public AppController(){
        order = new Order();
        charge = new Computation();
    }

    public void addRequest(Request request){
        order.addRequest(request);
    }
    public List<Request> getRequestList() {
        return order.getRequestList();
    };
    public int getNumberOfRequest(){
        return order.getRequestList().size();
    }
    public void submitRequest(){
        charge.receiveRequest(order.getRequestList());
        order.setTotalCharge(charge.getTotalCharge());
    }
    public double getTotalCharge() {
        return order.getTotalCharge();
    }
}
