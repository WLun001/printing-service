package com.printing;

import com.printing.domain.Request;
import com.printing.domain.RequestList;
import junit.framework.TestSuite;
import junitparams.JUnitParamsRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.TestCase.assertSame;
import static org.mockito.Mockito.mock;

@RunWith(JUnitParamsRunner.class)
public class RequestListTest extends TestSuite {

    private RequestList requestList;

    @Before
    public void setup() {
        requestList = new RequestList();
    }

    /**
     * Check the request really can be added successfully
     */
    @Test
    public void testAddRequest() {
        Request requestMock = mock(Request.class);
        requestList.addRequest(requestMock);
        assertSame(requestList.getRequestList().get(0), requestMock);
    }

    /**
     * Check the request list really can be retrieved successfully
     */
    @Test
    public void testGetRequestList() {
        Request request = new Request(10, true, true);
        requestList.addRequest(request);
        assertSame(request, requestList.getRequestList().get(0));
    }

    /**
     * Check the number of requests really can be obtained successfully
     */
    @Test
    public void testGetNumberOfRequest() {
        requestList.addRequest(new Request(10, true, true));
        assertSame(1, requestList.getNumberOfRequest());
    }
}
