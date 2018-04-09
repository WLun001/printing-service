//package com.printing;
//
//import com.printing.domain.AppController;
//import com.printing.domain.Order;
//import junitparams.JUnitParamsRunner;
//import junitparams.Parameters;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//
//@RunWith(JUnitParamsRunner.class)
//public class AppControllerParamsTest {
//
//    private AppController ac;
//
//    @Before
//    public void setup() {
//        ac = new AppController();
//    }
//
//    @Test(expected = IllegalArgumentException.class)
//    @Parameters(method = "getParamsForAddOrderInvalidValues")
//    public void testAddOrderInvalidValues(boolean hasHighQualityPaper, boolean hasDesignEffect ) {
//        ac.addOrder(new Order(hasHighQualityPaper, hasDesignEffect));
//    }
//
//    public Object[] getParamsForAddOrderInvalidValues(){
//        return new Object[] {
//                new Object[] {null, null},
//                new Object[] {null, true},
//                new Object[] {true, null},
//                new Object[] {null, false},
//                new Object[] {false, null},
//                new Object[] {0, 0}
//        };
//    }
//
//
//
//}
