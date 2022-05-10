package com.example.kinderenglishausbildung;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class BlankFragment2 extends Fragment {

    private View root2;
    private View view;
    private TextView textViewchiniese2;
    private TextView textViewright;
    private TextView liulanall;
    private int num2=0;
    private TextView textViewenglish2;
    private TextView hangshu;
    private int hangnum;
    private Button button1;
    private Button button2;
    private Button button6;
    private Button button7;

    public String[] data1 = { "Apple", "Banana", "Orange", "Watermelon",
            "Pear", "Grape", "Pineapple", "Strawberry", "Cherry", "Mango" };
    private  SimpleAdapter smp;
    private  List<Map<String,Object>>  mlist;
    private  ListView mlv;





    private int flag;
    private  UserService ud2 = new UserService();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if(root2==null){
            root2 = inflater.inflate(R.layout.fragment_blank2, container, false);
        }
        textViewchiniese2 = root2.findViewById(R.id.textView6);
        button1=root2.findViewById(R.id.button5);
        button2=root2.findViewById(R.id.button2);
        button6=root2.findViewById(R.id.button6);
        button7=root2.findViewById(R.id.button7);
        hangshu=root2.findViewById(R.id.textView14);
        textViewenglish2=root2.findViewById(R.id.textView8);


//
//        Map <String,String> map=new HashMap<>();
//        map.put("dad","dadad");
//        map.put("dadadadadad,","dadad");
//        Set<String> set=map.keySet();
//        Iterator<String> it=set.iterator();
//        System.out.println("key中集合元素：");
//        while(it.hasNext()){
//            System.out.println(it.next());
//        }
//        Collection<String> coll=map.values();
//        it=coll.iterator();
//        System.out.println("value中集合元素：");
//        while(it.hasNext()){
//            System.out.println(it.next());
//        }
//        List<Map<String, Object>> data = new ArrayList<Map<String,Object>>();
//        Map<String,Object> item;
//        item = new HashMap<String,Object>();
//        item.put("姓名","张三");
//        item.put("性别","男");
//        data.add(item);
//        item = new HashMap<String,Object>();
//        item.put("姓名","李四");
//        item.put("性别","女");
//        data.add(item);
//







//
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
//                root2.getContext(), android.R.layout.simple_list_item_1,data1);
//        ListView listView = (ListView)root2.findViewById(R.id.list_view);
//        listView.setAdapter(adapter);
//        mlist =new ArrayList<>();
//        mlv = root2.findViewById(R.id.list_view);
//        for (int i= 0;i<50;i++)
//        {
//            Map<String,Object> map = new HashMap<>();
//            map.put("aaa","dad");
//            map.put("bbb","dad");
//            mlist.add(map);
//        }
//        smp = new SimpleAdapter(root2.getContext(), mlist,R.layout.listlayout,new String[]{"aaa","bbb"},new int[]{R.id.tv1,R.id.tv2});
//        mlv.setAdapter(smp);














        String[] word= ud2.jiancha3(num2);
        System.out.println(word[1]);
        System.out.println(word[1]);
        textViewchiniese2.setText(word[1]);
        textViewenglish2.setText(word[0]);
        hangnum=ud2.count();
        String s2=String.valueOf(hangnum);
        hangshu.setText(s2);


        return root2;
    }
    public void onActivityCreated( Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        button1 = getActivity().findViewById(R.id.button5);
        button2 = getActivity().findViewById(R.id.button2);
        button6 = getActivity().findViewById(R.id.button6);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num2=num2+1;

                String[] word= ud2.jiancha3(num2);
                if(word[0]!=null) {
                    System.out.println(word[1]);
                    System.out.println(word[1]);
                    textViewchiniese2.setText(word[1]);
                    textViewenglish2.setText(word[0]);
                }
                else {
                    textViewchiniese2.setText("没有更多了，可以重新学习哦");
                }

            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] word2= ud2.jiancha3(num2);
                num2=num2+1;

                String[] word= ud2.jiancha3(num2);

                    System.out.println(word[1]);
                    System.out.println(word[1]);
                    textViewchiniese2.setText(word[1]);
                    textViewenglish2.setText(word[0]);
                    ud2.delete(word2[0]);
                    hangnum = ud2.count();
                    String s2 = String.valueOf(hangnum);
                    hangshu.setText(s2);





            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num2=0;

                String[] word= ud2.jiancha3(num2);
                System.out.println(word[1]);
                System.out.println(word[1]);
                textViewchiniese2.setText(word[1]);
                textViewenglish2.setText(word[0]);


            }
        });

        button7.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mlist =new ArrayList<>();
                mlv = root2.findViewById(R.id.list_view);




                int length = ud2.count();
                int l=0;
                String ll [] = new String[length];
                while (l<length)
                {
                    Map<String,Object> map = new HashMap<>();
//                    ll[l]= ud2.liulan(length)[l];
                    map.put("en",ud2.liulan(length)[l]);
                    map.put("cn",ud2.liulan1(length)[l]);
                    System.out.println(ll[l]);
                    System.out.println(ud2.liulan1(length)[l]);

                    mlist.add(map);
                    l++;

                }

                smp = new SimpleAdapter(root2.getContext(), mlist,R.layout.listlayout,new String[] {"en","cn"},new int[]{R.id.tv1,R.id.tv2});
                mlv.setAdapter(smp);


            }
        });
    }

}