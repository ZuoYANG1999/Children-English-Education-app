package com.example.kinderenglishausbildung;

import android.util.Log;



import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;

public class UserService {

    private ArrayList<String> usernameList = new ArrayList<>();

    private String s = null;
    private static final String TAG = "DBUtils";
    Verbindung d = Verbindung.getInstance();
    //第一个参数为数据库名称，第二个参数为数据库账号 第三个参数为数据库密码
    Connection conn = d.getConnection("PN");

    //登录用
    public boolean login(String name,String password) {
        if(d.denglu("select * from user where username='"+ name +"' and password='"+password+"'") == 1)
            return true;
        else
            return false;
    }

    //注册用
     public boolean register(String name,String password) {
        d.insert("insert into user (username,password) values('"+ name +"','"+password+"')");
            return true;

    }

    public String [] search(String label) {
        System.out.println(d.search("select * from recognition  where labelnum = "+ label)+"zgegejieguo");
        return d.search("select * from recognition  where labelnum = "+ label);

    }
    //一下代码存在相关错误，仅供参考
//    public int danci(String english ,String num) {
//        int flag1 =d.select("select * from words where number='"+ num +"'  and english='"+ english +"'");
//
//       if(flag1 == 1) {
//           System.out.println("duide      de  d e d e");
//           return 1;
//       }
//       else{
//           System.out.println("cuode    de  d e d e");
//
//           return 0;
//       }
//
//
//    }
    public String  [] jiancha(String num) {

        return d.jiancha("select * from words where number='"+num+"'");

    }
    public String  [] jiancha2(int num) {

        return d.jiancha("select * from cuoti where number='"+num+"'");

    }
public void insert(String english,String chinese){
        String name ="lpx";
        int num=1;
    d.insert("insert into cuoti (english,chinese,username) values('"+ english +"','"+ chinese +"','"+ name +"')");
    num=num+1;
}
    public void delete(String english){

        d.delete("delete from cuoti where english = '"+english+"'");

    }
    public int count() {

        return d.count("select * from cuoti");

    }
    public String  [] jiancha3(int num) {

        return d.jiancha3("select * from cuoti",num);

    }
    public String []  liulan(int a)
    {
        return  d.select("select * from cuoti",a);
    }
    public String []  liulan1(int a)
    {
        return  d.select2("select * from cuoti",a);
    }
}