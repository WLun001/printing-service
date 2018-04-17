package com.printing;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

// Basic classes were combined into a suite
@RunWith(value = Suite.class)
@Suite.SuiteClasses(value = {
        OrderTest.class, RequestTest.class,
        RequestListTest.class
})
public class TestSuiteClasses {
}
