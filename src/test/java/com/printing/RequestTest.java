package com.printing;

import com.printing.domain.Order;
import com.printing.domain.Request;
import junit.framework.TestSuite;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

@RunWith(JUnitParamsRunner.class)
public class RequestTest extends TestSuite {

    private Order order;

    @Before
    public void setup() {
        order = new Order();
    }

    // Check that the id of request object can be created successfully after instantiated
    @Test
    public void testRequestId() {
        Request request = new Request(1, true, true);
        assertNotNull(request.getId());
    }

    // Check that the request object can be created successfully with valid values
    @Test
    @Parameters(method = "getValidParamsForTestPhotoOption")
    public void testPhotoOption(int quantity, boolean hasHighQualityPaper, boolean hasDesignEffect) {
        order.addRequest(new Request(quantity, hasHighQualityPaper, hasDesignEffect));
        assertEquals(quantity, order.getRequestList().get(0).getQuantity());
        assertEquals(hasHighQualityPaper, order.getRequestList().get(0).hasHighQualityPaper());
        assertEquals(hasDesignEffect, order.getRequestList().get(0).hasDesignEffect());
    }

    // Check that the request object can be created successfully with invalid values
    @Test(expected = IllegalArgumentException.class)
    @Parameters(method = "getInvalidParamsForTestPhotoOption")
    public void testPhotoQuantityInvalidValues(int quantity, boolean hasHighQualityPaper, boolean hasDesignEffect) {
        order.addRequest(new Request(quantity, hasHighQualityPaper, hasDesignEffect));
    }

    public Object[] getValidParamsForTestPhotoOption() {
        return new Object[]{
                new Object[]{1, true, true},
                new Object[]{10, false, true},
                new Object[]{100, true, false}
        };
    }

    public Object[] getInvalidParamsForTestPhotoOption() {
        return new Object[]{
                new Object[]{0, true, true},
                new Object[]{-1, false, true}
        };
    }
}
