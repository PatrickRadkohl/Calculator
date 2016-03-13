package at.sw2016.calculator;

/**
 * Created by mint on 3/13/16.
 */
public class Calculations {

    private Calculations() {
    }

    public static int doAddition(int firstNumber, int secondNumber) {
        return firstNumber + secondNumber;
    }

    public static int doSubtraction(int firstNumber, int secondNumber) {
        return firstNumber - secondNumber;
    }

    public static int doMultiplication(int firstNumber, int secondNumber) {
        return firstNumber * secondNumber;
    }

    public static int doDivision(int firstNumber, int secondNumber) {

        if (secondNumber == 0) {
            return 0;
        }
        return firstNumber / secondNumber;
    }

}
