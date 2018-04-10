package com.printing;

import com.printing.domain.Computation;
import com.printing.domain.Request;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class ComputationTest {

    private Computation charge;

    @Before
    public void setup() {
        charge = new Computation();
    }

    @Test
    @Parameters(method = "getParamsForTestReceiveOrder")
    public void testReceiveRequestsValidValues(int quantity) {
        ArrayList<Request> requests = new ArrayList<>();
        for(int i = 0; i < quantity; i++) {
            requests.add(new Request(1, true, true));
            charge.receiveRequests(requests);
        }
        assertEquals(quantity, charge.getRequestsQuantity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testReceiveRequestsInvalidValues() {
        charge.receiveRequests(null);
    }

    public Object[] getParamsForTestReceiveOrder() {
        return new Object[] {
                new Object[]{0},
                new Object[]{2},
                new Object[]{5}
        };
    }

}