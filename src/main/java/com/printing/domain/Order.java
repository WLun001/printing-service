package com.printing.domain;

import java.util.ArrayList;
import java.util.UUID;

public class Order {
    private String id;
    private IRequestList requestList;
    private double totalCharge;
    private IPrintable printer;

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

    public void setPrinter(IPrintable printer) {
        if (printer == null)
            throw new NullPointerException("Printer cannot be null");
        this.printer = printer;
    }

    public void sendToPrinter() {
        for (Request request : requestList.getRequestList()) {
            printer.queueRequest(request);
        }
    }
}
