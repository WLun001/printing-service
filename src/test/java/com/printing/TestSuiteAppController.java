package com.printing;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

// AppController were combined into a suite
@RunWith(value = Suite.class)
@Suite.SuiteClasses(value = {
        AppControllerParamsTest.class,
        AppControllerTest.class

})
public class TestSuiteAppController {
}
