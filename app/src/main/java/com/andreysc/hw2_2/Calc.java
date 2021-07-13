package com.andreysc.hw2_2;

import java.io.Serializable;

public class Calc implements Serializable {
    private Float firstValue;
    private Float secondValue;
    private Float result;
    private String outputString;
    private int action;

    public static final int ACTION_ADD=1;
    public static final int ACTION_DEVIDI=2;
    public static final int ACTION_MULTIPLI=3;
    public static final int ACTION_SUBSTRACT=4;
    public static final int ACTION_EQUALS=5;

    public Calc(){
        this(0f,0f,ACTION_EQUALS);
    }

    public Calc(Float firstValue, Float secondValue, int action){
        this.firstValue=firstValue;
        this.secondValue=secondValue;
        this.action=action;
        this.outputString=secondValue.toString();
    }

    public void setAction(int action) {
        this.action = action;
    }

    public Float getFirstValue() {
        return firstValue;
    }

    public void setFirstValue(Float firstValue) {
        this.firstValue = firstValue;
    }

    public Float getSecondValue() {
        return secondValue;
    }

    public void setSecondValue(Float secondValue) {
        this.secondValue = secondValue;
    }

    public String getOutputString() {
        return outputString;
    }

    public int getAction() {
        return action;
    }

    public void calculate() {
        outputString="";
        switch (action){
            case (ACTION_ADD):
                secondValue=firstValue+secondValue;
                break;
            case(ACTION_DEVIDI):
                if (secondValue==0){
                    outputString="ERROR dev by zero";
                    secondValue=0f;
                } else {
                    secondValue=firstValue/secondValue;
                }
                break;
            case (ACTION_MULTIPLI):
                secondValue=firstValue*secondValue;
                break;
            case(ACTION_SUBSTRACT):{
                secondValue=firstValue-secondValue;
                break;
            }
            case (ACTION_EQUALS):
                break;
        }
        if (outputString==""){
            outputString=secondValue.toString();
        }
    }
}
