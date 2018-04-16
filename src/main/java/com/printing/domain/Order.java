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

    /**
     * add request to order
     *
     * @param request
     */
    public void addRequest(Request request) {
        requestList.addRequest(request);
    }

    /**
     * get total charge of order
     *
     * @return total charge of order
     */
    public double getTotalCharge() {
        return totalCharge;
    }

    /**
     * set total charge of order that calculated by {@link Computation}
     *
     * @param totalCharge calculated total charge of order
     */
    public void setTotalCharge(double totalCharge) {
        this.totalCharge = totalCharge;
    }

    /**
     * get list of requests
     *
     * @return list of requests
     */
    public ArrayList<Request> getRequestList() {
        return requestList.getRequestList();
    }

    /**
     * set printer
     *
     * @param printer printer to set
     */
    public void setPrinter(IPrintable printer) {
        if (printer == null)
            throw new NullPointerException("Printer cannot be null");
        this.printer = printer;
    }

    /**
     * send request to printer
     */
    public void sendToPrinter() {
        for (Request request : requestList.getRequestList()) {
            printer.queueRequest(request);
        }
    }
}
