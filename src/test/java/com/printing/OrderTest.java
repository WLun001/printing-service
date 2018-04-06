package com.printing;

import com.printing.domain.Order;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

@RunWith(JUnitParamsRunner.class)
public class OrderTest {

    @Test
    @Parameters(method = "getParamsForTestPaperOption")
    public void testPaperOption(boolean hasHighQualityPaper, boolean hasDesignEffect, boolean expectedQuality, boolean expectedDesignEffect) {
        Order order = new Order(hasHighQualityPaper, hasDesignEffect);
        assertEquals(expectedQuality, order.hasHighQualityPaper());
        assertEquals(expectedDesignEffect, order.hasDesignEffect());
    }

    @Test
    public void testGetId() {
       Order order = new Order(true, true);
       assertNotNull(order.getId());
    }

    public Object[] getParamsForTestPaperOption() {
        return new Object[] {
                new Object[] {true, true, true, true},
                new Object[] {false, true, false, true},
                new Object[] {true, false, true, false},
                new Object[] {false, false, false, false}
        };
    }

}
