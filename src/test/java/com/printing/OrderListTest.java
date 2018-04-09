package com.printing;

import com.printing.domain.Order;
import junitparams.JUnitParamsRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;


@RunWith(JUnitParamsRunner.class)
public class OrderListTest {

    private OrderList od;

    @Before
    public void setup() {
        od = new OrderList();
    }

    @Test
    public void testAddOrder() {
        Order oMock = mock(Order.class);
        od.addOrder(oMock);
        assertSame(od.getOrderList().get(0), oMock);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testSubmitOrderInvalidValues() {
        od = new OrderList();
        od.submitOrder();
    }



}