package com.printing;

import com.printing.domain.AppController;
import com.printing.domain.IPrintable;
import com.printing.domain.PhotoPrinter;
import com.printing.domain.Request;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class AppControllerIntegrationTest {

    private AppController controller;

    @Before
    public void setup() {
        controller = new AppController();
    }

    /**
     * Test the method addRequest can be executed appropriately
     */
    @Test
    @Parameters(method = "paramsAddRequestValid")
    public void testAddRequestValid(int requestQty, int paperQty, boolean hasHighQualityPaper, boolean hasDesignEffect) {
        for (int i = 0; i < requestQty; i++) {
            controller.addRequest(new Request(paperQty, hasHighQualityPaper, hasDesignEffect));
        }
        assertEquals(requestQty, controller.getNumberOfRequest());
        assertEquals(requestQty * paperQty, controller.getNumberOfPaper());
        assertEquals(hasHighQualityPaper, controller.getRequestList().get(0).hasHighQualityPaper());
        assertEquals(hasDesignEffect, controller.getRequestList().get(0).hasDesignEffect());
    }

    /**
     * Test the method addRequest can be executed appropriately with invalid values
     */
    @Test(expected = IllegalArgumentException.class)
    @Parameters(method = "paramsAddRequestInvalid")
    public void testAddRequestInvalid(int requestQty, int paperQty, boolean hasHighQualityPaper, boolean hasDesignEffect) {
        for (int i = 0; i < requestQty; i++) {
            controller.addRequest(new Request(paperQty, hasHighQualityPaper, hasDesignEffect));
        }
    }

    /**
     * Test the method computeCharge can be executed appropriately
     */
    @Test
    @Parameters(method = "paramsComputeChargeValid")
    public void testComputeCharge(int requestQty, int paperQty, boolean hasHighQualityPaper, boolean hasDesignEffect, double expectedPrice) {
        for (int i = 0; i < requestQty; i++) {
            controller.addRequest(new Request(paperQty, hasHighQualityPaper, hasDesignEffect));
        }
        controller.submitRequest();
        assertEquals(expectedPrice, controller.getTotalCharge(), 0);
    }


    /**
     * Test the method queueRequest can be executed appropriately
     */
    @Test
    @Parameters(method = "paramsQueueRequest")
    public void testQueueRequest(int requestQty, int paperQty, boolean hasHighQualityPaper, boolean hasDesignEffect) {
        IPrintable printer = new PhotoPrinter();
        for (int i = 0; i < requestQty; i++) {
            controller.addRequest(new Request(paperQty, hasHighQualityPaper, hasDesignEffect));
        }
        controller.submitRequest();
        controller.setPrinter(printer);
        controller.sendToPrinter();
        assertEquals(controller.getNumberOfRequest(), ((PhotoPrinter) printer).getRequests().size());
    }

    public Object[] paramsAddRequestValid() {
        return new Object[]{
                new Object[]{1, 1, true, true},
                new Object[]{5, 5, true, true},
                new Object[]{9, 12, false, true},
                new Object[]{11, 55, false, true},
                new Object[]{13, 77, false, false},
                new Object[]{15, 99, false, true}

        };
    }

    public Object[] paramsAddRequestInvalid() {
        return new Object[]{
                new Object[]{1, -1, true, true},
                new Object[]{9, 0, false, true},
                new Object[]{11, 101, false, true},
        };
    }

    public Object[] paramsComputeChargeValid() {
        return new Object[]{
                new Object[]{1, 1, true, false, 1.1},
                new Object[]{4, 4, true, false, 12.8},
                new Object[]{10, 5, true, false, 10.0}
        };
    }

    public Object[] paramsQueueRequest() {
        return new Object[]{
                new Object[]{1, 1, true, false},
                new Object[]{4, 4, true, false},
                new Object[]{10, 5, true, false}
        };
    }
}
