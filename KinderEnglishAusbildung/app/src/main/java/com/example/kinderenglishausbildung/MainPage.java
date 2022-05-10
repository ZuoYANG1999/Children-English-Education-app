package com.example.kinderenglishausbildung;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainPage extends AppCompatActivity implements View.OnClickListener {
    ViewPager2 viwePager;
    Fragment BlankFragment;
    Fragment BlankFragment2;
    Fragment BlankFragment3;
    private LinearLayout llshibie,llpinxie,llgushi;
    private ImageView ivshibie,ivpinxie,ivgushi,ivcurrent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        initpager();
        initTabView();

    }
    private void initTabView()
    {
        llshibie=findViewById(R.id.id_tab_shibie);
        llshibie.setOnClickListener(this);
        llpinxie=findViewById(R.id.id_tab_pinxie);
        llpinxie.setOnClickListener(this);
        llgushi=findViewById(R.id.id_tab_gushi);
        llgushi.setOnClickListener(this);
        ivshibie=findViewById(R.id.tab_iv_shibie);
        ivpinxie=findViewById(R.id.tab_iv_pinxie);
        ivgushi=findViewById(R.id.tab_iv_gushi);
        ivshibie.setSelected(true);
        ivcurrent=ivshibie;
    }
    private void initpager(){
        viwePager=findViewById(R.id.id_viewpager);
        BlankFragment2=new BlankFragment2();
        BlankFragment3=new BlankFragment3();
        BlankFragment=new BlankFragment();
        ArrayList<Fragment> fragments=new ArrayList<>();
        fragments.add(BlankFragment);
        fragments.add(BlankFragment2);
        fragments.add(BlankFragment3);
        MyFragmentPagerAdapter pagerAdapter=new MyFragmentPagerAdapter(getSupportFragmentManager(),getLifecycle(),fragments);
        viwePager.setAdapter(pagerAdapter);
        viwePager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                changeTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });
    }

    private void changeTab(int position) {
        ivcurrent.setSelected(false);
        switch (position){
            case R.id.id_tab_shibie:
                viwePager.setCurrentItem(0);
            case 0:
                ivshibie.setSelected(true);
                ivcurrent=ivshibie;
                break;
            case R.id.id_tab_pinxie:
                viwePager.setCurrentItem(1);
            case 1:
                ivpinxie.setSelected(true);
                ivcurrent=ivpinxie;
                break;
            case R.id.id_tab_gushi:
                viwePager.setCurrentItem(2);
            case 2:
                ivgushi.setSelected(true);
                ivcurrent=ivgushi;
                break;



        }
    }

    @Override
    public void onClick(View v) {
         changeTab(v.getId());
    }
}