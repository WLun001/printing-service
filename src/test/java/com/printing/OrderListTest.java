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

    private OrderList od;

    @Before
    public void setup() {
        od = new OrderList();
    }

    @Test
    @Parameters(method = "getParamsForTestAddOrdersValidValues")
    public void testAddOrdersValidValues(int quantity, boolean hasHighQualityPaper, boolean hasDesignEffect, double expectedTotalPrice) {
        for(int i = 0; i < quantity; i++)
            od.addOrder(hasHighQualityPaper, hasDesignEffect);
        od.submitOrder();
        double result = od.getTotalCharge();
        assertEquals(expectedTotalPrice, result, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSubmitOrderInvalidValues() {
        od.submitOrder();
    }

    public Object[] getParamsForTestAddOrdersValidValues() {
        return new Object[] {
                new Object[] {1,true,false,1.1}, new Object[] {4,true,false,4.4}, new Object[] {5,true,false,5.0}, new Object[] {9,true,false,9.0},
                new Object[] {10,true,false,8.0}, new Object[] {19,true,false,15.2}, new Object[] {20,true,false,12.0}, new Object[] {49,true,false,29.4},
                new Object[] {1,true,true,1.2}, new Object[] {4,true,true,4.8}, new Object[] {5,true,true,5.5}, new Object[] {9,true,true,9.9},
                new Object[] {10,true,true,9.0}, new Object[] {19,true,true,17.1}, new Object[] {20,true,true,14.0}, new Object[] {49,true,true,34.3},
                new Object[] {1,false,false,1.0}, new Object[] {4,false,false,4.0}, new Object[] {5,false,false,4.5}, new Object[] {9,false,false,8.1},
                new Object[] {10,false,false,7.0}, new Object[] {19,false,false,13.3}, new Object[] {20,false,false,10.0}, new Object[] {49,false,false,24.5},
                new Object[] {1,false,true,1.1}, new Object[] {4,false,true,4.4}, new Object[] {5,false,true,5.0}, new Object[] {9,false,true,9.0},
                new Object[] {10,false,true,8.0}, new Object[] {19,false,true,15.2}, new Object[] {20,false,true,12.0}, new Object[] {49,false,true,29.4}
        };
    }

}