package com.printing;

import com.printing.domain.AppController;
import com.printing.domain.Request;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.TestCase.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class DecisionTableParameterised {

    private AppController appController;

    @Before
    public void setup() {
        appController = new AppController();
    }

    /**
     * Test the method addRequest can be executed appropriately with single request
     */
    @Test
    @Parameters(method = "getParamsForTestAddOneRequestValidValues")
    public void testAddOneRequestValidValues(int paperQty, boolean hasHighQualityPaper, boolean hasDesignEffect, double expectedTotalPrice) {
        appController.addRequest(new Request(paperQty, hasHighQualityPaper, hasDesignEffect));
        appController.submitRequest();
        double result = appController.getTotalCharge();
        assertEquals(expectedTotalPrice, result, 0);
    }

    /**
     * Test the method addRequest with invalid values for one request
     */
    @Test(expected = IllegalArgumentException.class)
    @Parameters(method = "getParamsForTestAddOneRequestsInvalidValues")
    public void testAddOneRequestInvalidValues(int paperQty, boolean hasHighQualityPaper, boolean hasDesignEffect) {
        appController.addRequest(new Request(paperQty, hasHighQualityPaper, hasDesignEffect));
    }

    /**
     * Test the method addRequest can be executed appropriately with multiples requests
     */
    @Test
    @Parameters(method = "getParamsForTestAddMultipleRequestsValidValues")
    public void testAddMultipleRequestsValidValues(int requestQty, int paperQty, boolean hasHighQualityPaper, boolean hasDesignEffect, double expectedTotalPrice) {
        for (int i = 0; i < requestQty; i++)
            appController.addRequest(new Request(paperQty, hasHighQualityPaper, hasDesignEffect));
        appController.submitRequest();
        double result = appController.getTotalCharge();
        assertEquals(expectedTotalPrice, result, 0);
    }

    /**
     * TTest the method addRequest with invalid values for multiple requests
     */
    @Test(expected = IllegalArgumentException.class)
    @Parameters(method = "getParamsForTestAddMultipleRequestsInvalidValues")
    public void testAddMultipleRequestsInvalidValues(int requestQty, int paperQty, boolean hasHighQualityPaper, boolean hasDesignEffect) {
        for (int i = 0; i < requestQty; i++)
            appController.addRequest(new Request(paperQty, hasHighQualityPaper, hasDesignEffect));
    }

    public Object[] getParamsForTestAddOneRequestValidValues() {
        return new Object[]{
                new Object[]{1, true, false, 1.1}, new Object[]{4, true, false, 4.4}, new Object[]{5, true, false, 5.0}, new Object[]{10, true, false, 10.0},
                new Object[]{11, true, false, 8.8}, new Object[]{20, true, false, 16.0}, new Object[]{21, true, false, 12.6}, new Object[]{50, true, false, 30.0},
                new Object[]{51, true, false, 10.2},  new Object[]{100, true, false, 20.0},
                new Object[]{1, true, true, 1.2}, new Object[]{4, true, true, 4.8}, new Object[]{5, true, true, 5.5}, new Object[]{10, true, true, 11.0},
                new Object[]{11, true, true, 9.9}, new Object[]{20, true, true, 18.0}, new Object[]{21, true, true, 14.7}, new Object[]{50, true, true, 35.0},
                new Object[]{51, true, true, 15.3}, new Object[]{100, true, true, 30.0},
                new Object[]{1, false, false, 1.0}, new Object[]{4, false, false, 4.0}, new Object[]{5, false, false, 4.5}, new Object[]{10, false, false, 9.0},
                new Object[]{11, false, false, 7.7}, new Object[]{20, false, false, 14.0}, new Object[]{21, false, false, 10.5}, new Object[]{50, false, false, 25.0},
                new Object[]{51, false, false, 5.1}, new Object[]{100, false, false, 10.0},
                new Object[]{1, false, true, 1.1}, new Object[]{4, false, true, 4.4}, new Object[]{5, false, true, 5.0}, new Object[]{10, false, true, 10.0},
                new Object[]{11, false, true, 8.8}, new Object[]{20, false, true, 16.0}, new Object[]{21, false, true, 12.6}, new Object[]{50, false, true, 30.0},
                new Object[]{51, false, true, 10.2},  new Object[]{100, false, true, 20.0},
        };
    }

    public Object[] getParamsForTestAddOneRequestsInvalidValues() {
        return new Object[]{
                new Object[]{0, true, true},
                new Object[]{101, true, true},
                new Object[]{0, true, false},
                new Object[]{101, true, false},
                new Object[]{0, false, true},
                new Object[]{101, false, true},
                new Object[]{0, false, false},
                new Object[]{101, false, false}
        };
    }

    public Object[] getParamsForTestAddMultipleRequestsValidValues() {
        return new Object[]{
                new Object[]{1, 1, true, false, 1.1},
                new Object[]{4, 4, true, false, 12.8},
                new Object[]{10, 5, true, false, 30.0}
        };
    }

    public Object[] getParamsForTestAddMultipleRequestsInvalidValues() {
        return new Object[]{
                new Object[]{2, 0, true, true},
                new Object[]{2, 101, true, true},
                new Object[]{2, 0, true, false},
                new Object[]{2, 101, true, false},
                new Object[]{2, 0, false, true},
                new Object[]{2, 101, false, true},
                new Object[]{2, 0, false, false},
                new Object[]{2, 101, false, false}
        };
    }
}
