package at.sw2016.calculator.uitest;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;

import com.robotium.solo.Solo;

import at.sw2016.calculator.Calculator;
import at.sw2016.calculator.R;


public class CalculatorTest extends ActivityInstrumentationTestCase2<Calculator> {

    private Solo mySolo;


    public CalculatorTest() {
        super(Calculator.class);
    }


    public void setUp() throws Exception {
        super.setUp();
        mySolo = new Solo(getInstrumentation(), getActivity());
    }

    public void tearDown() throws Exception {
        super.tearDown();
    }


    public void testButtons() {
        for (int i = 0; i <= 9; i++) {
            mySolo.clickOnButton(Integer.toString(i));
        }

        mySolo.clickOnButton("+");
        mySolo.clickOnButton("-");
        mySolo.clickOnButton("/");
        mySolo.clickOnButton("*");

        mySolo.clickOnButton("=");
        mySolo.clickOnButton("C");
    }


    public void testInputField() {
        mySolo.clickOnButton("4");
        mySolo.clickOnButton("2");

        mySolo.getText("42");
    }


    public void testClearButton() {
        mySolo.clickOnButton("3");
        mySolo.clickOnButton("C");


        waitAndAssertEquals("0");
    }

    private void waitAndAssertEquals(String assertion) {
        TextView textView = (TextView) mySolo.getCurrentActivity()
                .findViewById(R.id.textView);
        mySolo.sleep(300);
        assertEquals(assertion, textView.getText());
    }

}