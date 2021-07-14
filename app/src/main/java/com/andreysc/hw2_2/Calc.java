package com.andreysc.hw2_2;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Calc implements Parcelable {
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

    protected Calc(Parcel in) {
        if (in.readByte() == 0) {
            firstValue = null;
        } else {
            firstValue = in.readFloat();
        }
        if (in.readByte() == 0) {
            secondValue = null;
        } else {
            secondValue = in.readFloat();
        }
        if (in.readByte() == 0) {
            result = null;
        } else {
            result = in.readFloat();
        }
        outputString = in.readString();
        action = in.readInt();
    }

    public static final Creator<Calc> CREATOR = new Creator<Calc>() {
        @Override
        public Calc createFromParcel(Parcel in) {
            return new Calc(in);
        }

        @Override
        public Calc[] newArray(int size) {
            return new Calc[size];
        }
    };

    public void setAction(int action) {
        this.action = action;
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

    public void setOutputString(String outputString) {
        this.outputString = outputString;
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (firstValue == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeFloat(firstValue);
        }
        if (secondValue == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeFloat(secondValue);
        }
        if (result == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeFloat(result);
        }
        dest.writeString(outputString);
        dest.writeInt(action);
    }
}
