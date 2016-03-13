package at.sw2016.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class Calculator extends Activity implements View.OnClickListener {

    private Button buttonPlus;
    private Button buttonMinus;
    private Button buttonMultiply;
    private Button buttonDivide;
    private Button buttonEqual;
    private Button buttonClear;

    ArrayList<Button> numberButtons = new ArrayList<Button>();

    private TextView numberView;

    private State state = State.INIT;

    private int firstNumber;


    public enum Numbers {
        ZERO("Zero"), ONE("One"), TWO("Two"), THREE("Three"), FOUR("Four"),
        FIVE("Five"), SIX("Six"), SEVEN("Seven"), EIGHT("Eight"), NINE("Nine");

        private String name;

        Numbers(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public enum State {
        ADD, SUB, MUL, DIV, INIT, NUM
    }


    public void generateNumberButtons() {
        for (int i = 0; i <= 9; i++) {
            String buttonName = "button" + Numbers.values()[i].getName();

            int id = getResources().
                    getIdentifier(buttonName, "id", R.class.getPackage().getName());

            Button button = (Button) findViewById(id);
            button.setOnClickListener(this);

            numberView = (TextView) findViewById(R.id.textView);
            numberButtons.add(button);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        generateNumberButtons();


        buttonPlus = (Button) findViewById(R.id.buttonPlus);
        buttonMinus = (Button) findViewById(R.id.buttonMinus);
        buttonMultiply = (Button) findViewById(R.id.buttonMultiply);
        buttonDivide = (Button) findViewById(R.id.buttonDivide);
        buttonClear = (Button) findViewById(R.id.buttonClear);
        buttonEqual = (Button) findViewById(R.id.buttonEqual);

        numberView = (TextView) findViewById(R.id.textView);

        buttonPlus.setOnClickListener(this);
        buttonMinus.setOnClickListener(this);
        buttonMultiply.setOnClickListener(this);
        buttonDivide.setOnClickListener(this);
        buttonClear.setOnClickListener(this);
        buttonEqual.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_calculator, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        Button clickedButton = (Button) v;

        switch (clickedButton.getId()) {
            case R.id.buttonPlus:
                clearNumberView();
                state = State.ADD;
                break;
            case R.id.buttonMinus:
                clearNumberView();
                state = State.SUB;
                break;
            case R.id.buttonMultiply:
                clearNumberView();
                state = State.MUL;
                break;
            case R.id.buttonDivide:
                clearNumberView();
                state = State.DIV;
                break;
            case R.id.buttonEqual:
                calculateResult();
                state = State.INIT;
                break;
            case R.id.buttonClear:
                clearTextView();
                break;
            default:
                String recentNumber = numberView.getText().toString();
                if (state == State.INIT) {
                    recentNumber = "";
                    state = State.NUM;
                }
                recentNumber += clickedButton.getText().toString();
                numberView.setText(recentNumber);
        }
    }

    private void clearTextView() {
        numberView.setText("0");
        firstNumber = 0;
        state = State.INIT;
    }

    private void clearNumberView() {
        String tempString = numberView.getText().toString();
        if (!tempString.equals("")) {
            firstNumber = Integer.valueOf(tempString);
        }
        numberView.setText("");
    }


    private void calculateResult() {
        int secondNumber = 0;

        String tempString = numberView.getText().toString();
        if (!tempString.equals("")) {
            secondNumber = Integer.valueOf(tempString);
        }

        int result;
        switch (state) {
            case ADD:
                result = Calculations.doAddition(firstNumber, secondNumber);
                break;
            case SUB:
                result = Calculations.doSubtraction(firstNumber, secondNumber);
                break;
            case MUL:
                result = Calculations.doMultiplication(firstNumber, secondNumber);
                break;
            case DIV:
                result = Calculations.doDivision(firstNumber, secondNumber);
                break;
            default:
                result = secondNumber;
        }
        numberView.setText(Integer.toString(result));
    }

}
