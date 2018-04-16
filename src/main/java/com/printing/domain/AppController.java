package com.printing.domain;

import java.util.ArrayList;

public class AppController {
    private Order order;
    private Computation computation;

    public AppController() {
        order = new Order();
        computation = new Computation();
    }

    public void addRequest(Request request) {
        order.addRequest(request);
    }

    public ArrayList<Request> getRequestList() {
        return order.getRequestList();
    }

    public int getNumberOfRequest() {
        return order.getRequestList().size();
    }

    public int getNumberOfPaper() {
        int quantity = 0;
        for (Request request : order.getRequestList()) {
            quantity += request.getQuantity();
        }
        return quantity;
    }

    public void submitRequest() {
        computation.receiveRequests(order.getRequestList());
        order.setTotalCharge(computation.getTotalCharge());
    }

    public double getTotalCharge() {
        return order.getTotalCharge();
    }

    public void setPrinter(IPrintable printer) {
        order.setPrinter(printer);
    }

    public void sendToPrinter() {
        order.sendToPrinter();
    }
}
