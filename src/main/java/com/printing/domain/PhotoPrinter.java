package com.printing.domain;

import java.util.ArrayList;

/**
 * Printer class that handled by third party
 */
public class PhotoPrinter implements IPrintable {

    private ArrayList<Request> requests;

    public PhotoPrinter() {
        requests = new ArrayList<>();
    }

    @Override
    public void queueRequest(Request request) {
        requests.add(request);
    }

    public ArrayList<Request> getRequests() {
        return requests;
    }
}
