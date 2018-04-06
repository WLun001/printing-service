package com.printing;

import com.printing.domain.AppController;
import com.printing.domain.Charge;
import com.printing.domain.OrderList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class AppControllerTest {

    @InjectMocks
    AppController ac = new AppController();
    @Mock
    OrderList od;

    @Test
    public void testSubmitOrder() {
        ac.addOrder(true,true);
        ac.submitOrder();
        ac.submitOrder();
        verify(od,times(2)).submitOrder();
    }





}
