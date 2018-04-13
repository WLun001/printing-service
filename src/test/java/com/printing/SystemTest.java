package com.printing;

import com.printing.domain.AppController;
import com.printing.domain.Request;
import junitparams.JUnitParamsRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class SystemTest {

    AppController appController;
    Request request;

    @Before
    public void makeClass() {
        appController = new AppController();
    }

    @Test
    public void testSystem() {
        // Check
    }
}
