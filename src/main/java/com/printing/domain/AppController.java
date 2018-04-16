package com.printing.domain;

import java.util.ArrayList;

/**
 * Manage all the functionality of the system
 * methods must be called in the following sequence
 */
public class AppController {
    private Order order;
    private Computation computation;

    public AppController() {
        order = new Order();
        computation = new Computation();
    }

    /**
     * add request to order
     *
     * @param request request
     */
    public void addRequest(Request request) {
        order.addRequest(request);
    }

    /**
     * get list of added requests
     *
     * @return ArrayList of requests
     */
    public ArrayList<Request> getRequestList() {
        return order.getRequestList();
    }

    /**
     * get number of added requests
     *
     * @return number of added requests
     */
    public int getNumberOfRequest() {
        return order.getRequestList().size();
    }

    /**
     * get number of papers
     *
     * @return total number papers including in all added requests
     */
    public int getNumberOfPaper() {
        int quantity = 0;
        for (Request request : order.getRequestList()) {
            quantity += request.getQuantity();
        }
        return quantity;
    }

    /**
     * submit added request to {@link Computation} to compute charge. <br>
     * request must be added before calling this method by calling {@link AppController#addRequest(Request)}
     */
    public void submitRequest() {
        computation.receiveRequests(order.getRequestList());
        order.setTotalCharge(computation.getTotalCharge());
    }

    /**
     * get total charge of the order. <br>
     * requests must be submitted by calling {@link AppController#submitRequest()} before use this method
     *
     * @return total charge of the order
     */
    public double getTotalCharge() {
        return order.getTotalCharge();
    }

    /**
     * set printer
     *
     * @param printer set printer
     */
    public void setPrinter(IPrintable printer) {
        order.setPrinter(printer);
    }

    /**
     * send request to printer <br>
     * printer must be set with {@link AppController#setPrinter(IPrintable)} before calling this method
     */
    public void sendToPrinter() {
        order.sendToPrinter();
    }
}
