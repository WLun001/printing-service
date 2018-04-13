package com.printing;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(value = Suite.class)
@Suite.SuiteClasses(value = {
        AppControllerParamsTest.class,
        AppControllerTest.class

})
public class TestSuiteAppController {
}
