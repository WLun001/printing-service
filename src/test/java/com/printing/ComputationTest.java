package com.printing;

import com.printing.domain.Computation;
import com.printing.domain.Request;
import junit.framework.TestSuite;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class ComputationTest extends TestSuite {

    private Computation charge;

    @Before
    public void setup() {
        charge = new Computation();
    }

    /**
     * Test the method receiveRequest can be executed appropriately by comparing quantity of requests
     */
    @Test
    @Parameters(method = "getParamsForTestReceiveOrder")
    public void testReceiveRequestsValidValues(int quantity) {
        ArrayList<Request> requests = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            requests.add(new Request(1, true, true));
            charge.receiveRequests(requests);
        }
        assertEquals(quantity, charge.getRequestsQuantity());
    }

    /**
     * Test the method receiveRequest with invalid values
     */
    @Test(expected = IllegalArgumentException.class)
    public void testReceiveRequestsInvalidValues() {
        charge.receiveRequests(null);
    }

    public Object[] getParamsForTestReceiveOrder() {
        return new Object[]{
                new Object[]{0},
                new Object[]{2},
                new Object[]{5}
        };
    }
}
