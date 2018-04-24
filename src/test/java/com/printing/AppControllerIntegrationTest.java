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
     * Test the Add Request button with valid values
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
     * Test the Add Request button with invalid values
     */
    @Test(expected = IllegalArgumentException.class)
    @Parameters(method = "paramsAddRequestInvalid")
    public void testAddRequestInvalid(int requestQty, int paperQty, boolean hasHighQualityPaper, boolean hasDesignEffect) {
        for (int i = 0; i < requestQty; i++) {
            controller.addRequest(new Request(paperQty, hasHighQualityPaper, hasDesignEffect));
        }
    }

    /**
     * Test the Compute Charge button
     */
    @Test
    @Parameters(method = "paramsComputeCharge")
    public void testComputeCharge(int requestQty, int paperQty, boolean hasHighQualityPaper, boolean hasDesignEffect, double expectedPrice) {
        for (int i = 0; i < requestQty; i++) {
            controller.addRequest(new Request(paperQty, hasHighQualityPaper, hasDesignEffect));
        }
        controller.submitRequest();
        assertEquals(expectedPrice, controller.getTotalCharge(), 0);
    }


    /**
     * Test the Print button
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
                new Object[]{1, 1, false, true},
                new Object[]{5, 5, false, true},
                new Object[]{1, 1, false, false},
                new Object[]{5, 5, false, false},
                new Object[]{1, 1, false, true},
                new Object[]{5, 5, false, true}

        };
    }

    public Object[] paramsAddRequestInvalid() {
        return new Object[]{
                new Object[]{1, -1, true, true},
                new Object[]{9, 0, true, true},
                new Object[]{11, 101, true, true},
        };
    }

    public Object[] paramsComputeCharge() {
        return new Object[]{
                new Object[]{1, 1, true, false, 1.1},
                new Object[]{4, 4, true, false, 12.8},
                new Object[]{10, 5, true, false, 30.0}
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
