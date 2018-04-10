package com.printing;

 import com.printing.domain.Order;
 import com.printing.domain.Request;
 import com.printing.domain.RequestList;
 import org.junit.Before;
 import org.junit.Test;
import org.junit.runner.RunWith;
 import org.mockito.InjectMocks;
 import org.mockito.Mock;
 import org.mockito.runners.MockitoJUnitRunner;

 import static junit.framework.TestCase.assertEquals;
 import static org.mockito.Mockito.times;
 import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class OrderTest {

    private Request request;

    @Before
    public void setup() {
        request = new Request(10, true, false);
    }

    @InjectMocks
    private Order order = new Order();
    @Mock
    private RequestList requestList;

    /**
     * Test the method inside addRequest had been run one time
     */
    @Test
    public void testAddRequest() {
        order.addRequest(request);
        verify(requestList, times(1)).addRequest(request);
    }

    /**
     * Test the method inside setTotalCharge and getTotalCharge can be executed in an appropriate way
     */
    @Test
    public void testSetAndGetTotalCharge() {
        Order order1 = new Order();
        order1.setTotalCharge(20.0);
        assertEquals(20.0, order1.getTotalCharge());
    }
}
