package com.printing;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

// The other remaining classes were combined into a suite
@RunWith(value = Suite.class)
@Suite.SuiteClasses(value = {
        PhotoPrinterTest.class, ComputationTest.class,
        DecisionTableTest.class
})
public class TestSuiteOthers {
}
