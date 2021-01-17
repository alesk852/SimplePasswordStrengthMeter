package com.example.passwordstrengthmeter;

import android.graphics.Color;

public class DefaultLevels implements PasswordLevel{
    @Override
    public String[] levelNames() {
        String[] levels = {"Dåligt!","OK","Bra","Utmärkt"};
        return levels;
    }

    @Override
    public int[] levelColors() {
        int[] levels ={Color.RED,Color.YELLOW,Color.BLUE,Color.GREEN};
        return levels;
    }

}
