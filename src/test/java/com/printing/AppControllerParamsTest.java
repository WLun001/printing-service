package com.printing;

import com.printing.domain.AppController;
import com.printing.domain.Request;
import junit.framework.TestSuite;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class AppControllerParamsTest extends TestSuite {

    private AppController ac;

    @Before
    public void setup() {
        ac = new AppController();
    }

    /**
     * Test the method addOrder can be executed appropriately with invalid values
     */
    @Test(expected = IllegalArgumentException.class)
    @Parameters(method = "getParamsForAddOrderInvalidValues")
    public void testAddOrderInvalidValues(int quantity, boolean hasHighQualityPaper, boolean hasDesignEffect) {
        ac.addRequest(new Request(quantity, hasHighQualityPaper, hasDesignEffect));
    }

    public Object[] getParamsForAddOrderInvalidValues() {
        return new Object[]{
                new Object[]{null, null, null},
                new Object[]{null, null, true},
                new Object[]{null, true, null},
                new Object[]{null, null, false},
                new Object[]{null, false, null},
                new Object[]{0, 0, 0}
        };
    }
}
