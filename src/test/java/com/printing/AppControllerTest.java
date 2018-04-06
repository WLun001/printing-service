package com.printing;

import com.printing.domain.AppController;
import com.printing.domain.Charge;
import com.printing.domain.Order;
import com.printing.domain.OrderList;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.internal.matchers.Or;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class AppControllerTest {

    @InjectMocks
    private
    AppController ac = new AppController();
    @Mock
    private
    OrderList od;
    @Test
    public void testAddOrder(){
        ac.addOrder(true, true);
        ac.addOrder(true, true);
        verify(od, times(2)).addOrder(true, true);
    }

    @Test
    public void testGetNumberOfOrders(){
        for (int i = 0; i < 10; i ++){
            ac.addOrder(true, true);
        }
        ac.getNumberOfOrders();
        verify(od, times(1)).getNumberOfOrders();

    }

    @Test
    public void testSubmitOrder() {
        ac.addOrder(true,true);
        ac.submitOrder();
        ac.submitOrder();
        verify(od,times(2)).submitOrder();
    }
}
