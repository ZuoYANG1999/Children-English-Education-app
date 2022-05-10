package com.example.kinderenglishausbildung;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;


public class Recognition extends AppCompatActivity {
private Uri imageuri;
private ImageView getimage;
private Handler handler;
private TextView name1;
private TextView caro1;
String na;
String car;
String  check;
String base64;
ImageButton choose;
    private  UserService ud2 = new UserService();
//请求头
private static final String URL = "http://tupapi.xfyun.cn/v1/currency";
    // 应用ID
    private static final String APPID = "43d37b21";
    // 接口密钥
    private static final String API_KEY = "5a0df8805f1f4d633cc1eb02f3a4cca3";
    // 图片名称
    private static final String IMAGE_NAME = "ang.jpg";
    // 图片url
    //private static final String IMAGE_URL = "/home/hsboy/AndroidStudioProjects/MyApplication5/app/src/main/res/drawable/ang.jpg";

    // 图片地址
    private static final String PATH = "/home";

    private String en;
    private String cn;


public  static final int CHOOSE_PHOTO=2;
public  static final int Take_Photo=1;//请求码
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recognition_page);
        UserService ud = new UserService();
        //ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CAMERA,Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
        getimage=findViewById(R.id.showimage);
        ImageButton takephoto=findViewById(R.id.takephoto);
        ImageButton morefuction=findViewById(R.id.morefuction);
        ImageButton imageButton1=findViewById(R.id.imageButton);
        ImageButton imageButton2=findViewById(R.id.imageButton2);
        name1=findViewById(R.id.nam);
//        caro1=findViewById(R.id.caro);
        handler =new Handler(){
            public void handleMessage(Message msg){
                try{

//                    Map<String, String> header = buildHttpHeader();
//                    byte[] imageByteArray = FileUtil.read(PATH);
//                    String result = HttpUtil.doPost1(URL, header, imageByteArray);
//                    System.out.println("接口调用结果：" + result);

//                    JSONObject json=new JSONObject((String)msg.obj);
//                    na=new JSONObject((String)json.getJSONArray("result").get(0)).getString("name");
//                    car=new JSONObject((String)json.getJSONArray("result").get(0)).getString("calorie");
                    JSONObject object=new JSONObject((String)msg.obj);
                    System.out.println("response below");
                    System.out.println(object);
                    JSONObject jsonArray1=object.getJSONObject("data");
                    JSONArray jsonArray=jsonArray1.getJSONArray("fileList");
                    System.out.println("dadad");
                    System.out.println(jsonArray);

                    check=jsonArray.getJSONObject(0).getString("label");
                    na=jsonArray.getJSONObject(0).getString("rate");
                    String [] cla  = ud.search(check);
                    System.out.println(cla);
                    if(cla != null) {
                        name1.setText(cla[0]+"\n"+cla[1]);
                        cn = cla[0];
                        en = cla[1];
//                        caro1.setText("这个英文名字叫:" + cla[1]);


                    }




                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        };


        takephoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


//                    File image1=new File(getExternalCacheDir(),"outimage.jpg");
//                try {
//                    if(image1.exists()){
//                        image1.delete();
//                    }
//                    image1.createNewFile();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//                    if (Build.VERSION.SDK_INT>=24){
//                        imageuri= FileProvider.getUriForFile(MainActivity.this,"com.example.myapplication.fileprovider",image1);
//                        //（项目名，作者（不做要求，随便写），文件名）
//                    }else{
//                        imageuri=Uri.fromFile(image1);
//                    }

                Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);//调用相机
                //intent.putExtra(MediaStore.EXTRA_OUTPUT,imageuri);
              //  startActivity(intent);
                  startActivityForResult(intent,Take_Photo);//回传？


            }
        });


        choose=findViewById(R.id.picture);
        choose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i, CHOOSE_PHOTO);

            }
        });

        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String l = "http://dict.youdao.com/speech?audio="+en;
                MediaPlayer mp=new MediaPlayer();
                try {
                    mp.setDataSource(l);
                    mp.prepare();
                    mp.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });

        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ud2.insert(cn,en);
                Toast toast =new Toast(Recognition.this);
                toast.setText("加入成功！！！");
                toast.setGravity(Gravity.BOTTOM, 0 , 0);
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.show();


            }
        });


        morefuction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Recognition.this,MainPage.class);
                startActivityForResult(i,3);

            }
        });


    }
//回传
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK){//如果回传成功
            Bitmap bitmap=null;

            if (requestCode == Take_Photo){//回传值如果是1

                try {
                      Bundle bundle=data.getExtras();
                      bitmap = (Bitmap) bundle.get("data");
                      getimage.setImageBitmap(bitmap);

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

            if(requestCode==CHOOSE_PHOTO){//如果是2


                try {

                     imageuri=data.getData();
                     bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(imageuri));
                     getimage.setImageBitmap(bitmap);

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

            }

                        base64=MyTools.bitmapToBase64(bitmap);
                        final Map<String,String> params=new HashMap<String, String>();
                        params.put("image",base64);
                        params.put("top_n25um","5");




                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    //String strUrlPath="https://aip.baidubce.com/rest/2.0/image-classify/v2/dish?access_token=24.5962c531ca3b11475931148a17b751f3.2592000.1627048567.282335-24317616";
                                    String strUrlPath="http://tupapi.xfyun.cn/v1/currency";
                                    Map<String, String> header = buildHttpHeader();
                                   //byte[] imageByteArray = FileUtil.read(PATH);
                                    byte[] imageByteArray = Base64.decodeBase64(base64);//这一步还是比较关键的，最后一个参数要求的是，图片base64编码后的二进制
                                    String result = HttpUtil.doPost1(URL, header, imageByteArray);
                                    System.out.println(result);
                                    //System.out.println("接口调用结果：" + result);
                                   // String result=MyTools.submitPostData(strUrlPath,params,"utf-8",header);
                                    Message msg = Message.obtain();
                                    //System.out.println(result);
                                    msg.obj = result;//传递的数
                                    handler.sendMessage(msg);


                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        }).start();

        }

    }

    private static Map<String, String> buildHttpHeader() throws UnsupportedEncodingException {

        String curTime = System.currentTimeMillis() / 1000L + "";
        String param = "{\"image_name\":\"" + IMAGE_NAME + "\"}";
        String paramBase64 = new String(Base64.encodeBase64(param.getBytes("UTF-8")));
        String checkSum = DigestUtils.md5Hex(API_KEY + curTime + paramBase64);
        Map<String, String> header = new HashMap<String, String>();
        header.put("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
        header.put("X-Param", paramBase64);
        header.put("X-CurTime", curTime);
        header.put("X-CheckSum", checkSum);
        header.put("X-Appid", APPID);
        return header;
    }


    public void moreFunction(View view){
        Intent intent=new Intent(Recognition.this,MainPage.class);
        startActivity(intent);
    }




}