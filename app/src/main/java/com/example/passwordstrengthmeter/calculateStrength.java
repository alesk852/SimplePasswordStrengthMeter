package com.example.passwordstrengthmeter;

public interface calculateStrength {
    //Algoritm som avgör styrkan
    public int determineStrength(String password);
    //Det bästa värdet man kan ha.
    public int MAX();
    //Det värdet av str som krävs för att nå den nivå 0.
    public int MIN();
    //Hur många steg ska resultera i byte av nivå.
    public int step();
}
