package com.printing;

import com.printing.domain.AppController;
import com.printing.domain.Request;
import junit.framework.TestSuite;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import static junit.framework.TestCase.assertEquals;

public class DecisionTableTestReadFromFile extends TestSuite {

    private static ArrayList<String[]> validValues;
    private static ArrayList<String[]> invalidValues;
    private static Scanner inputStream = null;


    @BeforeClass
    public static void readFromTextFile() {
        String validFileName = "./res/decisionTableValid.txt";
        String invalidFileName = "./res/decisionTableInvalid.txt";
        validValues = new ArrayList<>();
        invalidValues = new ArrayList<>();
        readFile(validValues, validFileName);
        readFile(invalidValues, invalidFileName);
    }

    @AfterClass
    public static void endClass() {
        System.out.println("Closing input file");
        inputStream.close();
    }

    private static void readFile(ArrayList<String[]> values, String fileName) {
        System.out.println("Reading test validValues from file " + fileName + "\n");
        try {
            inputStream = new Scanner(new File(fileName));
            while (inputStream.hasNextLine()) {
                values.add(inputStream.nextLine().split(","));
            }
            System.out.println(values.size() + "");
        } catch (FileNotFoundException e) {
            System.out.println("Error opening the file " + fileName);
            System.exit(0);
        }
    }

    /**
     * Test the method addRequest can be executed appropriately with one request
     */
    @Test
    public void testAddOneRequestsValidValues() {
        for (String[] requests : validValues) {
            int quantity = Integer.valueOf(requests[0]);
            boolean hasHighQualityPaper = Boolean.parseBoolean(requests[1]);
            boolean hasDesignEffect = Boolean.parseBoolean(requests[2]);
            double expectedTotalPrice = Double.valueOf(requests[3]);

            AppController controller = new AppController();
            controller.addRequest(new Request(quantity, hasHighQualityPaper, hasDesignEffect));
            controller.submitRequest();
            assertEquals(expectedTotalPrice, controller.getTotalCharge(), 0);
        }
    }


    /**
     * Test the method addRequest with invalid values
     */
    @Test(expected = IllegalArgumentException.class)
    public void testAddOneRequestInvalidValues() {
        for (String[] requests : invalidValues) {
            int paperQty = Integer.valueOf(requests[0]);
            boolean hasHighQualityPaper = Boolean.parseBoolean(requests[1]);
            boolean hasDesignEffect = Boolean.parseBoolean(requests[2]);
            AppController controller = new AppController();
            controller.addRequest(new Request(paperQty, hasHighQualityPaper, hasDesignEffect));
            controller.submitRequest();
        }
    }
}
