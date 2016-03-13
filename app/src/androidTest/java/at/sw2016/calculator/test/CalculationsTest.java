package at.sw2016.calculator.test;

import junit.framework.TestCase;

import at.sw2016.calculator.Calculations;


public class CalculationsTest extends TestCase {

    public void testDoAddition() {
        int result = Calculations.doAddition(2, 3);
        assertEquals(5, result);
    }

    public void testDoSubtraction() {
        int result = Calculations.doSubtraction(7, 2);
        assertEquals(5, result);
    }

    public void testDoMultiplication() {
        int result = Calculations.doMultiplication(2, 3);
        assertEquals(6, result);
    }

    public void testDoDivision() {
        int result = Calculations.doDivision(8, 4);
        assertEquals(2, result);
    }

    public void testDoDivision1() {
        int result = Calculations.doDivision(8, 0);
        assertEquals(0, result);
    }

    public void testDoDivision2() {
        int result = Calculations.doDivision(11, 4);
        assertEquals(2, result);
    }
}

