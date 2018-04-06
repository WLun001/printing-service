package com.printing;

import com.printing.domain.AppController;
import com.printing.domain.Order;
import com.printing.domain.OrderList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class AppControllerTest {

    @InjectMocks
    private
    AppController ac = new AppController();
    @Mock
    private
    OrderList od;

    @Test
    public void testAddOrder() {
        ac.addOrder(new Order(true, true));
        ac.addOrder(new Order(true, true));
        verify(od, times(2)).addOrder(new Order(true, true));
    }

    @Test
    public void testGetNumberOfOrders() {
        for (int i = 0; i < 10; i++) {
            ac.addOrder(new Order(true, true));
        }
        int numOfOrders = ac.getNumberOfOrders();
        verify(od, times(1)).getNumberOfOrders();
    }

    @Test
    public void testSubmitOrder() {
        ac.addOrder(new Order(true, true));
        ac.submitOrder();
        ac.submitOrder();
        verify(od, times(2)).submitOrder();
    }

    @Test
    public void testGetTotalCharge() {
        ac.addOrder(new Order(true, true));
        ac.submitOrder();
        ac.getTotalCharge();
        verify(od, times(1)).getTotalCharge();
    }
}
