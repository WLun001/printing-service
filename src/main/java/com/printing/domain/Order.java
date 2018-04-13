package com.printing.domain;

import java.util.ArrayList;
import java.util.UUID;

public class Order {
    private String id;
    private IRequestList requestList;
    private double totalCharge;
    private PhotoPrinter printer;

    public Order() {
        this.id = UUID.randomUUID().toString();
        requestList = new RequestList();
        printer = new PhotoPrinter();
    }

    public void addRequest(Request request) {
        requestList.addRequest(request);
    }

    public double getTotalCharge() {
        return totalCharge;
    }

    public void setTotalCharge(double totalCharge) {
        this.totalCharge = totalCharge;
    }

    public ArrayList<Request> getRequestList() {
        return requestList.getRequestList();
    }

    public void sendToPrinter() {
        for(Request request: requestList.getRequestList()) {
            printer.queueRequest(request);
        }
    }
}
