package com.printing;

import com.printing.domain.AppController;
import junit.framework.TestSuite;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(value = Suite.class)
@Suite.SuiteClasses(value = {
        AppControllerParamsTest.class,
        AppControllerTest.class

})
public class TestSuiteAppController {
//    public static TestSuite testSuite;
//
//    public static TestSuite suite() {
//        testSuite = new TestSuite();
//        testSuite.addTestSuite(AppControllerTest.class);
//        testSuite.addTestSuite(AppControllerParamsTest.class);
//
//        return testSuite;
//    }
}
