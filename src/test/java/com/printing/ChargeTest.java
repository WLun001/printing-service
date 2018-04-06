package com.printing;

import com.printing.domain.Charge;
import com.printing.domain.Order;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.TestCase.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class ChargeTest {

    @Test
    @Parameters(method = "getParamsForTestReceiveOrder")
    public void testReceiveOrders(int quantity) {
        Charge charge = new Charge();
        for(int i = 0; i < quantity; i++) {
            charge.receiveOrder(new Order(true, true));
        }
        assertEquals(quantity, charge.getQuantity());
    }

    public Object[] getParamsForTestReceiveOrder() {
        return new Object[] {
                new Object[]{0},
                new Object[]{2},
                new Object[]{5}
        };
    }

}
