package com.printing;

import com.printing.domain.*;
import junit.framework.TestSuite;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertSame;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class OrderTest extends TestSuite {

    private Request request;
    @InjectMocks
    private Order order = new Order();
    @Mock
    private RequestList requestList;

    @Before
    public void setup() {
        request = new Request(10, true, false);
    }

    /**
     * Test the method inside addRequest had been run one time
     */
    @Test
    public void testAddRequest() {
        order.addRequest(request);
        verify(requestList, times(1)).addRequest(request);
    }

    /**
     * Check that the total charge can be set and get successfully
     */
    @Test
    public void testSetAndGetTotalCharge() {
        Order order1 = new Order();
        order1.setTotalCharge(20.0);
        assertEquals(20.0, order1.getTotalCharge());
    }

    /**
     * Test the method inside getRequestList had been run one time
     */
    @Test
    public void testGetRequestList() {
        order.getRequestList();
        verify(requestList, times(1)).getRequestList();

    }

    /**
     * Check that the printer can be set and get successfully
     */
    @Test
    public void testSetAndGetPrinter() {
        IPrintable printer = new PhotoPrinter();
        Order order1 = new Order();
        order1.setPrinter(printer);
        assertSame(printer, order1.getPrinter());
    }

    /**
     * Test the method setPrinter can be executed appropriately with invalid values
     */
    @Test(expected = NullPointerException.class)
    public void testSetPrinterInvalid() {
        Order order1 = new Order();
        order1.setPrinter(null);
    }

    /**
     * Check that the request can be sent to printer successfully by comparing the number of requests sent
     * by Order and received by PhotoPrinter
     */
    @Test
    public void testSendToPrinter() {
        IPrintable printer = new PhotoPrinter();
        Order order1 = new Order();
        order1.addRequest(new Request(10, true, true));
        order1.setPrinter(printer);
        order1.sendToPrinter();
        assertEquals(order1.getRequestList().size(), ((PhotoPrinter) printer).getRequests().size());
    }
}
