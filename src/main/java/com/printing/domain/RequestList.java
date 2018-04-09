package com.printing.domain;

import java.util.ArrayList;

public class RequestList implements IRequestList {

    private ArrayList<Request> requests;

    public RequestList() {
        requests = new ArrayList<>();
    }

    @Override
    public void addRequest(Request request) {
        requests.add(request);
    }

    @Override
    public ArrayList<Request> getRequestList() {
        return requests;
    }

    @Override
    public int getNumberOfRequest() {
        return requests.size();
    }
}
