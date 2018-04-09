package com.printing.domain;

import java.util.ArrayList;
import java.util.UUID;

public class Order {
    private String id;
    private IRequestList requestList;
    private double totalCharge;

    public Order() {
        this.id = UUID.randomUUID().toString();
        requestList = new RequestList();
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
}
