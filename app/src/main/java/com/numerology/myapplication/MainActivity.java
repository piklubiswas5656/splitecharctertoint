package com.numerology.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    String name = "piklis one of the".replaceAll("\\s", "").toUpperCase();
    String[] result = name.split("");
    TextView hello;
    int tempint;
    int temp, temptwo, temptree;

    int digitvalue;
    int finaldigit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hello = findViewById(R.id.hellow);
//        hello.setText(name);
        for (int x = 1; x < result.length; x++) {

            tempint = tempint + getPersonalityNumber(result[x]);
////            hello.append(String.valueOf(getPersonalityNumber(result[x])));
//            hello.append((String.valueOf(tempint) + "\n\n"));
        }
        if (tempint > 9) {
            digitvalue = tempint;

            List<Integer> digits = new ArrayList<Integer>();

            collectDigits(digitvalue, digits);
            for (int x = 0; x < digits.size(); x++) {

                temp = temp + digits.get(x);
////            hello.append(String.valueOf(getPersonalityNumber(result[x])));
//            hello.append((String.valueOf(tempint) + "\n\n"));
            }
            if (temp > 9) {

                List<Integer> digittwo = new ArrayList<Integer>();

                collectDigits(temp, digittwo);
                for (int x = 0; x < digittwo.size(); x++) {

                    temptwo = temptwo + digittwo.get(x);
////
                }
                if (temptwo > 9) {
                    List<Integer> digitthree = new ArrayList<Integer>();

                    collectDigits(temptwo, digitthree);
                    for (int x = 0; x < digitthree.size(); x++) {

                        temptree = temptree + digitthree.get(x);
////
                    }
                    finaldigit = temptree;
                } else {
                    finaldigit = temptwo;
                }


            } else {
                finaldigit = temp;
            }

        } else {
            finaldigit = tempint;

        }
        hello.setText(String.valueOf(finaldigit));

    }

    //for digit split
    private static void collectDigits(int num, List<Integer> digits) {
        if (num / 10 > 0) {
            collectDigits(num / 10, digits);
        }
        digits.add(num % 10);
    }

    private int getPersonalityNumber(String chr) {
        int number = 0;
        if (chr.equals("J") || chr.equals("A") || chr.equals("S")) {
            number = 1;
        } else if (chr.equals("B") || chr.equals("K") || chr.equals("T")) {
            number = 2;
        } else if (chr.equals("C") || chr.equals("L") || chr.equals("U")) {
            number = 3;
        } else if (chr.equals("D") || chr.equals("M") || chr.equals("V")) {
            number = 4;
        } else if (chr.equals("N") || chr.equals("W") || chr.equals("E")) {
            number = 5;
        } else if (chr.equals("F") || chr.equals("X") || chr.equals("O")) {
            number = 6;
        } else if (chr.equals("G") || chr.equals("P") || chr.equals("Y")) {
            number = 7;
        } else if (chr.equals("H") || chr.equals("Q") || chr.equals("Z")) {
            number = 8;
        } else if (chr.equals("R") || chr.equals("I")) {
            number = 9;
        }


        return number;
    }

}