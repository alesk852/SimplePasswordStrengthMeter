package com.example.passwordstrengthmeter;

public class DefaultStrength implements calculateStrength{
    @Override
    public int determineStrength(String password) {
        int strength = 0;

        if (password.length()<4)
            return 0;
        if (!password.toLowerCase().equals(password)){
            strength++;
        }
        //Tittar efter integers.
        if (password.matches(".*\\d.*")){
            strength++;
        }
        if (password.length()>10){
            strength++;
        }

        return strength;

    }

    @Override
    public int MAX() {
        return 3;
    }

    @Override
    public int MIN() {
        return 0;
    }

    @Override
    public int step() {
        return 1;
    }
}
