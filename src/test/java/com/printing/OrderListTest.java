package com.printing;

import com.printing.domain.OrderList;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.TestCase.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class OrderListTest {

    @Test(expected = IllegalArgumentException.class)
    public void testSubmitOrderInvalidValues() {
        OrderList od = new OrderList();
        od.submitOrder();
    }

}