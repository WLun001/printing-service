package com.printing;

import com.printing.domain.*;
import junit.framework.TestSuite;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class AppControllerTest extends TestSuite {

    private Request request;
    @InjectMocks
    private AppController ac;
    @Mock
    private Order order;

    @Before
    public void setup() {
        request = new Request(10, true, false);
    }

    /**
     * Test the method inside addRequest had been run twice
     */
    @Test
    public void testAddRequestInvokedCount() {
        ac.addRequest(request);
        ac.addRequest(request);
        verify(order, times(2)).addRequest(request);
    }

    /**
     * Test the method inside addRequest had been run according to the sequence
     */
    @Test
    public void testAddRequestInvokedSequence() {
        Request request1 = new Request(5, false, true);
        Request request2 = new Request(10, true, false);
        ac.addRequest(request1);
        ac.addRequest(request2);
        InOrder inOrder = Mockito.inOrder(order);
        inOrder.verify(order).addRequest(request1);
        inOrder.verify(order).addRequest(request2);
    }

    /**
     * Test the method inside getRequestList had been run one time
     */
    @Test
    public void testGetRequestList() {
        ac.addRequest(request);
        List<Request> requests = ac.getRequestList();
        verify(order, times(1)).getRequestList();
    }

    /**
     * Test the method inside getNumberOfRequest had been run one time by comparing the number
     * of request added to the ArrayList<Request>
     */
    @Test
    public void testGetNumberOfRequest() {
        AppController controller = new AppController();
        for (int i = 0; i < 10; i++) {
            controller.addRequest(request);
        }
        assertEquals(10, controller.getNumberOfRequest());
    }

    @Test
    public void testGetNumberOfPaper() {
        AppController controller = new AppController();
        controller.addRequest(new Request(10, true, true));
        controller.addRequest(new Request(15, true, true));
        assertEquals(25, controller.getNumberOfPaper());

    }

    /**
     * Test the two methods inside submitRequest had been run one time by comparing the total
     * charge of the request added
     */
    @Test
    public void testSubmitRequest() {
        AppController controller = new AppController();
        controller.addRequest(request);
        controller.submitRequest();
        assertEquals(8.0, controller.getTotalCharge());
    }

    /**
     * Test the method inside getTotalCharge had been run one time
     */
    @Test
    public void testGetTotalCharge() {
        ac.addRequest(request);
        ac.submitRequest();
        ac.getTotalCharge();
        verify(order, times(1)).getTotalCharge();
    }

    /**
     * Test the method inside setPrinter had been run one time
     */
    @Test
    public void testSetPrinter() {
        IPrintable printer = new PhotoPrinter();
        ac.setPrinter(printer);
        verify(order, times(1)).setPrinter(printer);
    }
}
