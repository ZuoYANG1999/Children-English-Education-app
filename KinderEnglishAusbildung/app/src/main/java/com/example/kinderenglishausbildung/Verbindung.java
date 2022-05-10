package com.example.kinderenglishausbildung;

import android.Manifest;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import android.util.Log;
import java.sql.Statement;
import java.util.HashMap;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.InputStream;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import java.util.Properties;


public class Verbindung {
    private static Statement st;
    private static ResultSet rs;
    private Connection conn = null;
    private String currentDatabase = "sqlserver";
    private String dbURL = "";
    private Properties prop;
    private static Connection  a=null;
    private  static String ssql;
    private  static String qsql;
    private  static String deletesql;//专门用来删除的sql防止删除更新的时候sql发生了改变
    private  static String cl [];
    private  static int flag;
    private  static int flag1;
    private  static boolean res;
    private int rownum;




    private static Verbindung instance;


    public Verbindung(){
        try{Class.forName("com.mysql.jdbc.Driver");System.out.println("1"); }catch(Exception ex){}
    }
    public static Verbindung getInstance(){
        if (instance ==null){
            instance = new Verbindung();
        }
        return instance;
    }

    public int denglu(String sql) {
//        flag = 0;
        qsql=sql;
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                String ip = "47.97.97.130"; //IP
                String dbName = "android";             //自己的数据库名
                String url = "jdbc:mysql://" + ip + ":3306/" + dbName +"?useUnicode=true&characterEncoding=UTF-8";
                String user = "aloneone";
                String password = "123456";
                try {
                    Connection conn1 = DriverManager.getConnection(url, user, password);
                    st=(Statement)conn1.createStatement();
                    ResultSet tt=st.executeQuery(qsql);
                    System.out.println("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
                    while (tt.next()) {
                        System.out.println(qsql);
                        System.out.println("daaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
                        flag1 = 1;
                    }

                    conn1.close();
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        while (thread.isAlive())
        {

        }
//        try{Thread.sleep(500);}catch (Exception e){}
        return flag1;
    }

    //浏览函数的主体
    public  String [] select(String sql ,int changdu) {
//        flag = 0;
        String []  liulanall = new String [changdu];
        ssql=sql;
        System.out.println(ssql);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                String ip = "47.97.97.130"; //IP
                String dbName = "android";             //自己的数据库名
                String url = "jdbc:mysql://" + ip + ":3306/" + dbName +"?useUnicode=true&characterEncoding=UTF-8";
                String user = "aloneone";
                String password = "123456";
                try {
                    Connection conn1 = DriverManager.getConnection(url, user, password);
                    st=(Statement)conn1.createStatement();
                    ResultSet tt=st.executeQuery(ssql);
                    int  a=0;


                    while (tt.next()) {
                        liulanall [a] = tt.getString("english");
                        a++;


                    }

                    conn1.close();
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        while (thread.isAlive())
        {
        }
//        try{Thread.sleep(500);}catch (Exception e){}
        return liulanall;
    }
    public  String [] jiancha3(String sql ,int num) {
//        flag = 0;
        String []  liulanall =new String[2];
        ssql=sql;
        System.out.println(ssql);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                String ip = "47.97.97.130"; //IP
                String dbName = "android";             //自己的数据库名
                String url = "jdbc:mysql://" + ip + ":3306/" + dbName +"?useUnicode=true&characterEncoding=UTF-8";
                String user = "aloneone";
                String password = "123456";
                try {
                    Connection conn1 = DriverManager.getConnection(url, user, password);
                    st=(Statement)conn1.createStatement();
                    ResultSet tt=st.executeQuery(ssql);
                    int a=0;


                   while(tt.next()) {
                       if(a==num) {
                           liulanall[0] = tt.getString("english");
                           liulanall[1] = tt.getString("chinese");

                       }
                        a++;
                   }


                    conn1.close();
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        while (thread.isAlive())
        {
        }
//        try{Thread.sleep(500);}catch (Exception e){}
        return liulanall;
    }
    public void insert(String sql)
    {
        ssql=sql;
        System.out.println(ssql);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                String ip = "47.97.97.130"; //IP
                String dbName = "android";             //自己的数据库名
                String url = "jdbc:mysql://" + ip + ":3306/" + dbName +"?useUnicode=true&characterEncoding=UTF-8";
                String user = "aloneone";
                String password = "123456";
                try {
                    Connection conn1 = DriverManager.getConnection(url, user, password);
                    st=(Statement)conn1.createStatement();
                    st.executeUpdate(ssql);
                    conn1.close();
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }
    public void delete(String sql)
    {
        deletesql=sql;
        System.out.println(ssql);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                String ip = "47.97.97.130"; //IP
                String dbName = "android";             //自己的数据库名
                String url = "jdbc:mysql://" + ip + ":3306/" + dbName +"?useUnicode=true&characterEncoding=UTF-8";
                String user = "aloneone";
                String password = "123456";
                try {
                    Connection conn1 = DriverManager.getConnection(url, user, password);
                    st=(Statement)conn1.createStatement();
                    st.executeUpdate(deletesql);
                    conn1.close();
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        while (thread.isAlive())
        {

        }
    }
    public  String [] select2(String sql ,int changdu) {
//        flag = 0;
        String []  liulanall = new String [changdu];
        ssql=sql;
        System.out.println(ssql);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                String ip = "47.97.97.130"; //IP
                String dbName = "android";             //自己的数据库名
                String url = "jdbc:mysql://" + ip + ":3306/" + dbName +"?useUnicode=true&characterEncoding=UTF-8";
                String user = "aloneone";
                String password = "123456";
                try {
                    Connection conn1 = DriverManager.getConnection(url, user, password);
                    st=(Statement)conn1.createStatement();
                    ResultSet tt=st.executeQuery(ssql);
                    int  a=0;


                    while (tt.next()) {
                        liulanall [a] = tt.getString("chinese");
                        a++;


                    }

                    conn1.close();
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        while (thread.isAlive())
        {
        }
//        try{Thread.sleep(500);}catch (Exception e){}
        return liulanall;
    }


    //label对比的函数

    public String [] search(String sql)
    {
        String [] cla = new String [2];
        ssql=sql;
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                String ip = "47.97.97.130"; //IP
                String dbName = "android";             //自己的数据库名
                String url = "jdbc:mysql://" + ip + ":3306/" + dbName +"?useUnicode=true&characterEncoding=UTF-8";
                String user = "aloneone";
                String password = "123456";
                try {
                    Connection conn1 = DriverManager.getConnection(url, user, password);
                    st=(Statement)conn1.createStatement();
                    ResultSet result = st.executeQuery(ssql);
                    while(result.next()) {
                        cla[0] = result.getString("cnname");
                        cla[1] = result.getString("enname");
                    }

                    conn1.close();
                }
                catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
        thread.start();
        while (thread.isAlive())
        {
        }
        return cla;
    }

    public String [] jiancha(String sql)
    {
        String [] cla = new String [2];
        ssql=sql;
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                String ip = "47.97.97.130"; //IP
                String dbName = "android";             //自己的数据库名
                String url = "jdbc:mysql://" + ip + ":3306/" + dbName +"?useUnicode=true&characterEncoding=UTF-8";
                String user = "aloneone";
                String password = "123456";
                try {
                    Connection conn1 = DriverManager.getConnection(url, user, password);
                    st=(Statement)conn1.createStatement();
                    ResultSet result = st.executeQuery(ssql);
                    while(result.next()) {
                        cla[0] = result.getString("english");
                        cla[1] = result.getString("chinese");

                        System.out.println(cla[0]);
                        System.out.println("jiancha");
                    }

                    conn1.close();
                }
                catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
        thread.start();
        while (thread.isAlive())
        {
        }
        return cla;
    }
    public int count(String sql)
    {
        ssql=sql;
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                String ip = "47.97.97.130"; //IP
                String dbName = "android";             //自己的数据库名
                String url = "jdbc:mysql://" + ip + ":3306/" + dbName +"?useUnicode=true&characterEncoding=UTF-8";
                String user = "aloneone";
                String password = "123456";
                try {
                    Connection conn1 = DriverManager.getConnection(url, user, password);
                    st=(Statement)conn1.createStatement();
                    ResultSet result = st.executeQuery(ssql);
                    while(result.next()) {
                        rownum = result.getRow();



                        System.out.println("jiancha");
                    }

                    conn1.close();
                }
                catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
        thread.start();
        while (thread.isAlive())
        {
        }
        return rownum;
    }

    public static Connection getConnection(String name) {
        Connection conn = null;
        return conn;
    }

}