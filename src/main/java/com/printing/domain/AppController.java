package com.printing.domain;

import java.util.ArrayList;
import java.util.List;

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
