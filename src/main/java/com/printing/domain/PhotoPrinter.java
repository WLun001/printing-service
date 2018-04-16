package com.printing.domain;

import java.util.ArrayList;

public class PhotoPrinter implements IPrintable {

    private ArrayList<Request> requests;

    @Override
    public void queueRequest(Request request) {
        requests.add(request);
    }

    public ArrayList<Request> getRequests() {
        return requests;
    }
}
