package com.example.passwordstrengthmeter;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.LinearLayout;


public class MainActivity extends AppCompatActivity {

    PasswordStrengthMeter psm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
            psm = new PasswordStrengthMeter(this);

            //Skriver över algoritm för att beräkna styrkan.
            psm.calculateStrength(new calculateStrength() {
                @Override
                public int determineStrength(String password) {
                    int str=0;

                    if (password.contains("a"))
                        str++;
                    if (password.contains("b"))
                        str++;
                    if (password.contains("c"))
                        str++;
                    if (password.contains("1"))
                        str++;
                    if (password.contains("2"))
                        str++;
                    if (password.contains("3"))
                        str++;

                    return str;
                }

                @Override
                public int MAX() {
                    return 5;
                }

                @Override
                public int MIN() {
                    return 1;
                }

                @Override
                public int step() {
                    return 1;
                }
            });
            //Antal nivåer man vill ha måste stämma överäns med antal steg man kan ta. Om man kan ta fyra steg måste man ha fyra nivåer.
            psm.PasswordLevel(new PasswordLevel() {
                @Override
                public String[] levelNames() {
                    String[] names ={":(",":/",":)",":>"};
                    return names;
                }

                @Override
                public int[] levelColors() {
                    int[] colors={Color.RED,Color.YELLOW,Color.BLUE,Color.GREEN};
                    return colors;
                }
            });
        psm.setTextColor(Color.BLACK);
        linearLayout.addView(psm);
        setContentView(linearLayout);
    }
}