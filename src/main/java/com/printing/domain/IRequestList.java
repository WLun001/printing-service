package com.printing.domain;

import java.util.ArrayList;

interface IRequestList {
    void addRequest(Request request);

    ArrayList<Request> getRequestList();

    int getNumberOfRequest();
}
