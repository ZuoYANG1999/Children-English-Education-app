package com.example.kinderenglishausbildung;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class BlankFragment extends Fragment {

    private View root;
    private View view;
    private TextView textViewchiniese;
    private TextView textViewright;
    private int num=1;
    private EditText textViewenglish;
    private Button button;
    private int flag;

    private  UserService ud = new UserService();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if (root == null) {
            root = inflater.inflate(R.layout.fragment_blank, container, false);
        }
        textViewchiniese = root.findViewById(R.id.textView7);
        textViewenglish=root.findViewById(R.id.editTextTextPersonName);
        textViewright=root.findViewById(R.id.textView9);
       // Random r = new Random(1);
        //num = r.nextInt(5);

        String nuum=String.valueOf(num);
        String[] word= ud.jiancha(nuum);
        System.out.println(word[1]);
        System.out.println(word[1]);
        textViewchiniese.setText(word[1]);






        return root;
    }

    public void onActivityCreated( Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        button = getActivity().findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String english=textViewenglish.getText().toString();
                String chiniese=textViewchiniese.getText().toString();
                String right=textViewright.getText().toString();
                System.out.println(english);
                System.out.println(chiniese);




                System.out.println("kkkkkkkkkkkkkkk");
                String nuum1=String.valueOf(num);
                String[] word1= ud.jiancha(nuum1);
//               flag= ud.danci(english,nuum1);
                System.out.println(flag);
                System.out.println("ffffffffffffffffffffffffffffffff");
               if(word1[0].equals(english)){
                      num=num+1;
                   System.out.println("jiayi");
                      System.out.println(num);
                   String nuum=String.valueOf(num);
                   String[] word= ud.jiancha(nuum);
                   textViewchiniese.setText(word[1]);
                   textViewenglish.setText(null);
                   textViewright.setText(null);
                   textViewright.setText("答对啦！试试下一个吧");
               }
               else{
                   String nuum=String.valueOf(num);
                   String[] word2= ud.jiancha(nuum);
                   textViewright.setText(word2[0]);
                   textViewenglish.setText(null);
                   ud.insert(word2[0],word2[1]);
               }
            }
        });
    }
}

