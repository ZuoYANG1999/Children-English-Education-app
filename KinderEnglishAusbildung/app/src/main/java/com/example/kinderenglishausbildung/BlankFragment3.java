package com.example.kinderenglishausbildung;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class BlankFragment3 extends Fragment {

    private View root;
    private int temp=1;
    private Button button;
    private BlankFragment3 blankFragment3;

    private TextView textView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if(root==null){
            root = inflater.inflate(R.layout.fragment_blank3, container, false);
        }
        textView=root.findViewById(R.id.ftextstory);
        String string =getFromAssets(this, "story1.txt");
        textView.setText(string);
        blankFragment3=this;
       button=root.findViewById(R.id.button4);
        return root;
    }
    public static String getFromAssets(BlankFragment3 context, String fileName) {
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
    public void onActivityCreated( Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        button = getActivity().findViewById(R.id.button4);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(temp<4) {

                    String name = "story";
                    String weiba = ".txt";
                    temp = temp + 1;
                    String s=String.valueOf(temp);
                    String concat1= name.concat(s);
                    String concat2= concat1.concat(weiba);

                    String string2 = getFromAssets(BlankFragment3.this, concat2);
                    textView.setText(string2);
                }
                else{
                    temp=0;
                    String name = "story";
                    String weiba = ".txt";
                    temp = temp + 1;
                    String filename0 = name + temp + weiba;
                    String string2 = getFromAssets(BlankFragment3.this, filename0);
                    textView.setText(string2);
                }
            }
        });
    }


     /*   if(temp<4) {

            String name = "story";
            String weiba = ".txt";
            temp = temp + 1;
            String s=String.valueOf(temp);
            String concat1= name.concat(s);
            String concat2= concat1.concat(weiba);

            String string2 = getFromAssets(this, concat2);
            textView.setText(string2);
        }
        else{
            temp=0;
            String name = "story";
            String weiba = ".txt";
            temp = temp + 1;
            String filename0 = name + temp + weiba;
            String string2 = getFromAssets(this, filename0);
            textView.setText(string2);
        }*/


}