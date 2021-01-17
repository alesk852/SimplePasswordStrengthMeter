package com.example.passwordstrengthmeter;

import android.content.Context;

import android.graphics.Color;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;



public class PasswordStrengthMeter extends LinearLayout {
    TextView feedback;
    EditText input;
    calculateStrength strength;
    PasswordLevel passwordLevel;
    public int strengthPoints = 0;
    public String password="";
    public String textPass= "Password strength: ";
    public int textColor = Color.BLACK;
    int minimum;
    int maximum;
    double step;

    public PasswordStrengthMeter(Context context) {
        super(context);
        View layout = LayoutInflater.from(getContext()).inflate(R.layout.psmxml, (ViewGroup)getParent());
        feedback = layout.findViewById(R.id.textView);
        passwordLevel = new DefaultLevels();
        strength = new DefaultStrength();
        input = layout.findViewById(R.id.password);
        input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                String current = input.getText().toString();
                validate(current);
            }
        });
        addView(layout);

    }

    //Vilken nivå ska visas.
    private void validate(String password){
        feedback.setTextColor(textColor);
        //Styrke beräkning.
        strengthPoints =  strength.determineStrength(password);
        minimum = strength.MIN();
        maximum = strength.MAX();
        step = (strengthPoints-minimum)/(strength.step());

        if(password.length()==0){
            
        }else {
            //En sats som används för att titta om man ska ta ett steg.
            if(step == (int)step){
                String[] names= passwordLevel.levelNames();
                int[] colors = passwordLevel.levelColors();

                if (strengthPoints<minimum){
                    feedback.setText(textPass+names[0]);
                    feedback.setBackgroundColor(colors[0]);
                }else if(strengthPoints>=maximum){
                    feedback.setText(textPass+names[passwordLevel.levelNames().length-1]);
                    feedback.setBackgroundColor(colors[passwordLevel.levelColors().length-1]);

                } else{
                    feedback.setText(textPass+names[(int) step]);
                    feedback.setBackgroundColor(colors[(int) step]);
                }
            }
        }

    }


    public int getStrengthPoints() {
        return strengthPoints;
    }

    public void calculateStrength(calculateStrength strength){
        this.strength = strength;
        validate(password);
    }
    public void PasswordLevel(PasswordLevel passwordLevel){
        this.passwordLevel = passwordLevel;
        validate(password);
    }
    public String currentLevel(){
        String currentLevel="";
        return currentLevel;
    }
    public void passText(String textPass){
        this.textPass = textPass;
        validate(password);
    }
    public void setTextColor(int textColor){
        this.textColor = textColor;
        validate(password);
    }
}
