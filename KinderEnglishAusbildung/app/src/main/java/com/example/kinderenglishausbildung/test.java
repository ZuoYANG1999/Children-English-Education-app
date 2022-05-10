package com.example.kinderenglishausbildung;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test extends AppCompatActivity {
private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

       textView= findViewById(R.id.textstory1);
        String string =getFromAssets(this, "story1.txt");
        textView.setText(string);

    }
    public static String getFromAssets(Context context, String fileName) {
        InputStreamReader inputReader = null;
        try {
            inputReader = new InputStreamReader(context.getResources().getAssets().open(fileName));
            BufferedReader bufReader = new BufferedReader(inputReader);
            StringBuilder result = new StringBuilder();
            String line;
            while ((line = bufReader.readLine()) != null) {
                result.append(line);
            }
            String var6 = result.toString();
            return var6;
        } catch (Exception var16) {
            var16.printStackTrace();
        } finally {
            if (null != inputReader) {
                try {
                    inputReader.close();
                } catch (IOException var15) {
                    var15.printStackTrace();
                }
            }
        }
        return null;

    }
}