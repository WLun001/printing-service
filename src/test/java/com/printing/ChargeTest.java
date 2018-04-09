package com.printing;

import com.printing.domain.Computation;
import com.printing.domain.Order;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.TestCase.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class ChargeTest {

    private Computation charge;

    @Before
    public void setup() {
        charge = new Computation();
    }

    @Test
    @Parameters(method = "getParamsForTestReceiveOrder")
    public void testReceiveOrdersValidValues(int quantity) {
        for(int i = 0; i < quantity; i++) {
            charge.receiveOrder(new Order(true, true));
        }
        assertEquals(quantity, charge.getQuantity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testReceiveOrdersInvalidValues() {
        charge.receiveOrder(null);
    }

    public Object[] getParamsForTestReceiveOrder() {
        return new Object[] {
                new Object[]{0},
                new Object[]{2},
                new Object[]{5}
        };
    }

}
