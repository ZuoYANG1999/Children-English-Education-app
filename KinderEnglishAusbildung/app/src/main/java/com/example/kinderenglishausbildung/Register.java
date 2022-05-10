package com.example.kinderenglishausbildung;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    private EditText password;
    private EditText name1;
    private EditText passwordagain;
    private Button MB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        name1 = findViewById(R.id.edname);
        password=findViewById(R.id.edp);
        passwordagain=findViewById(R.id.edpagain);
        MB=findViewById(R.id.button);
    }
    public void click(View v)
    {
        UserService a=new UserService();
        String temp1=password.getText().toString();
        String temp2=passwordagain.getText().toString();
        if(temp1.equals(temp2)){
            a.register(name1.getText().toString(),temp2);
            Toast.makeText(Register.this, "注册成功", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(Register.this, "两次输入密码不同", Toast.LENGTH_SHORT).show();
        }
    }
}