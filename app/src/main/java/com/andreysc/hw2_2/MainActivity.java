package com.andreysc.hw2_2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final int INPUT_NUMBER = 1;
    public static final int INPUT_ACTION = 2;
    public static final String LAST_INPUT_PARAM="LAST_INPUT_PARAM_CALC";
    public static final String CALC_PARAM="CALC_PARAM";

    private Calc calc;

    private String inputText;
    private TextView textView;
    private int lastInput;

    private void equalsCalc(){
        calc.setFirstValue(calc.getSecondValue());
        calc.setSecondValue(Float.valueOf(inputText));
        calc.calculate();
        inputText=calc.getOutputString();
        updateTextView();
    }

    private void setAllClickListener(){
        findViewById(R.id.buttonNumber0).setOnClickListener(this);
        findViewById(R.id.buttonNumber1).setOnClickListener(this);
        findViewById(R.id.buttonNumber2).setOnClickListener(this);
        findViewById(R.id.buttonNumber3).setOnClickListener(this);
        findViewById(R.id.buttonNumber4).setOnClickListener(this);
        findViewById(R.id.buttonNumber5).setOnClickListener(this);
        findViewById(R.id.buttonNumber6).setOnClickListener(this);
        findViewById(R.id.buttonNumber7).setOnClickListener(this);
        findViewById(R.id.buttonNumber8).setOnClickListener(this);
        findViewById(R.id.buttonNumber9).setOnClickListener(this);

        findViewById(R.id.buttonActionAdd).setOnClickListener(v->{
            lastInput=INPUT_ACTION;
            if (calc.getAction()!=Calc.ACTION_EQUALS){
                equalsCalc();
            }
            calc.setAction(Calc.ACTION_ADD);
            calc.setSecondValue(Float.valueOf(inputText));
        });

        findViewById(R.id.buttonActionSubstract).setOnClickListener(v->{
            lastInput=INPUT_ACTION;
            if (calc.getAction()!=Calc.ACTION_EQUALS){
                equalsCalc();
            }
            calc.setAction(Calc.ACTION_SUBSTRACT);
            calc.setSecondValue(Float.valueOf(inputText));
        });

        findViewById(R.id.buttonActionMultiple).setOnClickListener(v->{
            lastInput=INPUT_ACTION;
            if (calc.getAction()!=Calc.ACTION_EQUALS){
                equalsCalc();
            }
            calc.setAction(Calc.ACTION_MULTIPLI);
            calc.setSecondValue(Float.valueOf(inputText));
        });

        findViewById(R.id.buttonActionDivide).setOnClickListener(v->{
            lastInput=INPUT_ACTION;
            if (calc.getAction()!=Calc.ACTION_EQUALS){
                equalsCalc();
            }
            calc.setAction(Calc.ACTION_DEVIDI);
            calc.setSecondValue(Float.valueOf(inputText));
        });

        findViewById(R.id.buttonActionEquals).setOnClickListener(v->{
            lastInput=INPUT_ACTION;
            equalsCalc();
            calc.setAction(Calc.ACTION_EQUALS);
        });

        findViewById(R.id.buttonClear).setOnClickListener(v->{
            calc=new Calc();
            inputText=calc.getOutputString();
            updateTextView();
        });

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calc2_layout);
        textView = findViewById(R.id.calcLine);
        setAllClickListener();
        lastInput=INPUT_ACTION;
        if (savedInstanceState==null){
            calc = new Calc();

        } else {
            lastInput=savedInstanceState.getInt(LAST_INPUT_PARAM,INPUT_ACTION);
            calc = savedInstanceState.getParcelable(CALC_PARAM);
            if (calc==null){
                calc = new Calc();
            }
        }
        inputText=calc.getOutputString();
        updateTextView();
    }

    private void updateTextView(){
        textView.setText(inputText);
    }

    private void inputNumber(char number)
    {
        if (lastInput==INPUT_ACTION){
            inputText=""+number;
        } else {
            inputText+=number;
        }
        lastInput=INPUT_NUMBER;
        updateTextView();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case (R.id.buttonNumber0):
                inputNumber('0');
                break;
            case (R.id.buttonNumber1):
                inputNumber('1');
                break;
            case (R.id.buttonNumber2):
                inputNumber('2');
                break;
            case (R.id.buttonNumber3):
                inputNumber('3');
                break;
            case (R.id.buttonNumber4):
                inputNumber('4');
                break;
            case (R.id.buttonNumber5):
                inputNumber('5');
                break;
            case (R.id.buttonNumber6):
                inputNumber('6');
                break;
            case (R.id.buttonNumber7):
                inputNumber('7');
                break;
            case (R.id.buttonNumber8):
                inputNumber('8');
                break;
            case (R.id.buttonNumber9):
                inputNumber('9');
                break;
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        calc.setOutputString(inputText);
        outState.putInt(LAST_INPUT_PARAM,lastInput);
        outState.putParcelable(CALC_PARAM,calc);
    }

}