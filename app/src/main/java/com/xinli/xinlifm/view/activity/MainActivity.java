package com.xinli.xinlifm.view.activity;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.xinli.xinlifm.R;
import com.xinli.xinlifm.view.adapter.MainFragmentAdapter;
import com.xinli.xinlifm.view.fragment.find.FindFragment;
import com.xinli.xinlifm.view.fragment.forum.ForumFragment;
import com.xinli.xinlifm.view.fragment.home.HomeFragment;
import com.xinli.xinlifm.view.fragment.mine.MineFragment;
import com.xinli.xinlifm.view.fragment.setting.SettingFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ViewPager.OnPageChangeListener {

    //// TODO: 16-10-12 有时间就加上

    private ImageView mainMusic;  //主界面右上角
    private ImageView homeImg;  //首页tab图片
    private ImageView findImg;   //发现tab图片
    private ImageView forumImg;  //社区tab图片
    private ImageView myImg;     //我的tab图片
    private ImageView settingImg;  //设置tab图片

    private LinearLayout tab1Layout;
    private LinearLayout tab2Layout;
    private LinearLayout tab3Layout;
    private LinearLayout tab4Layout;
    private LinearLayout tab5Layout;

    private ViewPager mainPager;  //VP

    private HomeFragment homeFragment;
    private ForumFragment forumFragment;
    private FindFragment findFragment;
    private MineFragment mineFragment;
    private SettingFragment settingFragment;
    private List<Fragment> fragmentList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initEvent();
    }

    private void initView() {
        mainMusic = (ImageView) findViewById(R.id.main_music);

        homeImg = (ImageView) findViewById(R.id.main_home_image);
        findImg = (ImageView) findViewById(R.id.main_find_image);
        forumImg = (ImageView) findViewById(R.id.main_forum_image);
        myImg = (ImageView) findViewById(R.id.main_my_image);
        settingImg = (ImageView) findViewById(R.id.main_setting_image);

        tab1Layout = (LinearLayout) findViewById(R.id.main_ll_tab1);
        tab2Layout = (LinearLayout) findViewById(R.id.main_ll_tab2);
        tab3Layout = (LinearLayout) findViewById(R.id.main_ll_tab3);
        tab4Layout = (LinearLayout) findViewById(R.id.main_ll_tab4);
        tab5Layout = (LinearLayout) findViewById(R.id.main_ll_tab5);

        homeFragment = new HomeFragment();
        forumFragment = new ForumFragment();
        findFragment = new FindFragment();
        mineFragment = new MineFragment();
        settingFragment = new SettingFragment();

        fragmentList = new ArrayList<>();
        fragmentList.add(homeFragment);
        fragmentList.add(forumFragment);
        fragmentList.add(findFragment);
        fragmentList.add(mineFragment);
        fragmentList.add(settingFragment);

        mainPager = (ViewPager) findViewById(R.id.main_pager);
        mainPager.setAdapter(new MainFragmentAdapter(getSupportFragmentManager(),fragmentList));

    }

    private void initEvent() {
        tab1Layout.setOnClickListener(this);
        tab2Layout.setOnClickListener(this);
        tab3Layout.setOnClickListener(this);
        tab4Layout.setOnClickListener(this);
        tab5Layout.setOnClickListener(this);

        mainPager.addOnPageChangeListener(this);
    }

    @Override
    public void onClick(View v) {
        setNormalImg();
        setNormalBackground();

        switch (v.getId()) {
            case R.id.main_ll_tab1:

                changeTab(homeImg,R.mipmap.nav_index_act,0,tab1Layout);

                break;
            case R.id.main_ll_tab2:

                changeTab(findImg,R.mipmap.nav_find_act,1,tab2Layout);

                break;
            case R.id.main_ll_tab3:
                changeTab(forumImg,R.mipmap.nav_forum_act,2,tab3Layout);
                break;
            case R.id.main_ll_tab4:
                changeTab(myImg,R.mipmap.nav_my_act,3,tab4Layout);
                break;
            case R.id.main_ll_tab5:
                changeTab(settingImg,R.mipmap.nav_setting_act,4,tab5Layout);
                break;

        }
    }

        private void changeTab(ImageView img,int res,int position,LinearLayout linearLayout){
            img.setImageResource(res);
            mainPager.setCurrentItem(position);
            linearLayout.setBackgroundColor(getResources().getColor(R.color.tabBackground));
        }
    //图片都变成不选中
    private void setNormalImg(){
        homeImg.setImageResource(R.mipmap.nav_index);
        findImg.setImageResource(R.mipmap.nav_find);
        forumImg.setImageResource(R.mipmap.nav_forum);
        myImg.setImageResource(R.mipmap.nav_my);
        settingImg.setImageResource(R.mipmap.nav_setting);
    }
    private void setNormalBackground(){
        tab1Layout.setBackgroundColor(getResources().getColor(R.color.tabBackground_normal));
        tab2Layout.setBackgroundColor(getResources().getColor(R.color.tabBackground_normal));
        tab3Layout.setBackgroundColor(getResources().getColor(R.color.tabBackground_normal));
        tab4Layout.setBackgroundColor(getResources().getColor(R.color.tabBackground_normal));
        tab5Layout.setBackgroundColor(getResources().getColor(R.color.tabBackground_normal));
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        setNormalImg();
        setNormalBackground();
        switch (position) {
            case 0:
                changeTab(homeImg,R.mipmap.nav_index_act,0,tab1Layout);
                break;
             case 1:
                 changeTab(findImg,R.mipmap.nav_find_act,1,tab2Layout);
                break;
             case 2:
                 changeTab(forumImg,R.mipmap.nav_forum_act,2,tab3Layout);
                break;
             case 3:
                 changeTab(myImg,R.mipmap.nav_my_act,3,tab4Layout);
                break;
             case 4:
                 changeTab(settingImg,R.mipmap.nav_setting_act,4,tab5Layout);
                break;

        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {
        
    }
}
