package com.example.kinderenglishausbildung;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button myBregister;
    private Button myBlogin;
    private EditText myuser;
    private  EditText mypass;
    private  CheckBox mybaocun;

    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myBregister = findViewById(R.id.bt_register);
        myBlogin = findViewById(R.id.bt_login);
        myuser = findViewById(R.id.ed_n);
        mypass = findViewById(R.id.ed_p);
        mybaocun = findViewById(R.id.checkBox);
        sp=getSharedPreferences("config", Context.MODE_PRIVATE);

       boolean remeberpass = sp.getBoolean("remeberpass",false);
       if(remeberpass){
           String name = sp.getString("name",null);
           String pass = sp.getString("pass",null);
           myuser.setText(name);
           mypass.setText(pass);
           mybaocun.setChecked(true);
       }
       else{
           myuser.setText(null);
           mypass.setText(null);
           mybaocun.setChecked(false);
       }
    }
    public void login(View v)
   {
       Intent intent=null;
           String name=myuser.getText().toString();
           String pass=mypass.getText().toString();
           String name1="Name";
           String pass1=null;
           UserService ud = new UserService();
           boolean flag=ud.login(name, pass);
           if (name.equals("")||pass.equals("")){
               Toast.makeText(MainActivity.this, "输入不能为空", Toast.LENGTH_LONG).show();
           }
           if(flag){
               SharedPreferences.Editor editor=sp.edit();
               if (mybaocun.isChecked()) {

                   editor.putString("name",name);
                   editor.putString("pass", pass);
                   editor.putBoolean("remeberpass",true);
                   editor.apply();
                   Toast.makeText(MainActivity.this, "密码已保存", Toast.LENGTH_LONG).show();
               }
               else {

                   editor.putBoolean("remeberpass",false);
               }
               intent=new Intent(MainActivity.this,Recognition.class);
               startActivity(intent);


               }

           else{

               Toast.makeText(MainActivity.this, "登录失败", Toast.LENGTH_LONG).show();
           }
   }
    public void register(View v)
    {
        Intent intent=null;
        intent=new Intent(MainActivity.this,Register.class);
        startActivity(intent);
    }
}