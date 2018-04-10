package com.printing;

 import com.printing.domain.AppController;
 import com.printing.domain.Order;
 import com.printing.domain.Request;
 import com.printing.domain.RequestList;
 import junitparams.JUnitParamsRunner;
 import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;
 import org.mockito.InjectMocks;
 import org.mockito.Mock;

@RunWith(JUnitParamsRunner.class)
public class OrderTest {

    @InjectMocks
    private Order order = new Order();
    @Mock
    private RequestList requestList;

    @Test
    public void testAddRequest() {
        order.addRequest(new Request(10, true, true));

    }




}
