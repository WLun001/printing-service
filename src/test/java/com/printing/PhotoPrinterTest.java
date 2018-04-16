package com.printing;

import com.printing.domain.AppController;
import com.printing.domain.PhotoPrinter;
import com.printing.domain.Request;
import junit.framework.TestSuite;
import junitparams.JUnitParamsRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.mockito.Mockito.*;

@RunWith(JUnitParamsRunner.class)
public class PhotoPrinterTest extends TestSuite {

    @Test
    public void testQueueRequest() {
        AppController controller = new AppController();
        Request request = new Request(10, true, false);
        PhotoPrinter printerMock = mock(PhotoPrinter.class);
        controller.addRequest(request);
        controller.addRequest(request);
        controller.submitRequest();
        controller.setPrinter(printerMock);
        controller.sendToPrinter();
        verify(printerMock, times(2)).queueRequest();

    }

}
