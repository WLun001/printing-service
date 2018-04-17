package com.printing;

import com.printing.domain.AppController;
import com.printing.domain.IPrintable;
import com.printing.domain.PhotoPrinter;
import com.printing.domain.Request;
import junit.framework.TestSuite;
import junitparams.JUnitParamsRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class PhotoPrinterTest extends TestSuite {

    /**
     * Check that the quantity of request sent to the printer is same as the quantity of request added by the user
     */
    @Test
    public void testQueueRequest() {
        AppController controller = new AppController();
        IPrintable printer = new PhotoPrinter();
        controller.setPrinter(printer);
        controller.addRequest(new Request(2, true, true));
        controller.addRequest(new Request(10, false, false));
        controller.submitRequest();
        controller.sendToPrinter();
        assertEquals(controller.getNumberOfRequest(), ((PhotoPrinter) printer).getRequests().size());
    }
}
