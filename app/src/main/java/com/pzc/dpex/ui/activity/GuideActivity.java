package com.pzc.dpex.ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.pzc.dpex.R;
import com.pzc.dpex.base.BaseActivity;
import com.pzc.dpex.ui.fragment.guide.GuideFragment1;
import com.pzc.dpex.ui.fragment.guide.GuideFragment2;
import com.pzc.dpex.ui.fragment.guide.GuideFragment3;
import com.pzc.dpex.ui.fragment.guide.GuideFragment4;
import com.pzc.dpex.ui.fragment.guide.GuideFragment5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GuideActivity extends BaseActivity{

    private ViewPager guideViewPager;
    List<Fragment> list;
    private LinearLayout layout;
    ImageView[] icons;
    Fragment[] fragments;

    @Override
    protected int initLayout() {
        return R.layout.activity_guide;
    }

    @Override
    protected void init() {
        list = new ArrayList<>();
        fragments = new Fragment[]{new GuideFragment1(), new GuideFragment2(), new GuideFragment3(),  new GuideFragment4(),new GuideFragment5()};
        icons = new ImageView[fragments.length];
        guideViewPager = (ViewPager) findViewById(R.id.guide_viewPager);
        layout = (LinearLayout) findViewById(R.id.layout);
        //使图片增添更方便
        //得到ImageView对象
        list.addAll(Arrays.asList(fragments));
        //初始化下标
        initSubscript();
        //viewPager点击事件
        setOnClickListener();

        guideViewPager.setAdapter(new GuideAdapter(getSupportFragmentManager()));
    }

    private void setOnClickListener() {
        guideViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < fragments.length; i++) {
                    icons[i].setSelected(false);
                }
                //将当前下标的指示图片  选中
                icons[position].setSelected(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initSubscript() {
        LinearLayout layout = (LinearLayout) findViewById(R.id.layout);

        for (int i = 0; i < icons.length; i++) {
            //将布局中的指示图片放进数组里
            icons[i] = (ImageView) layout.getChildAt(i);
            //设置是否响应事件
            icons[i].setSelected(false);
            //给指示图片添加下标
            icons[i].setTag(i);
            icons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    guideViewPager.setCurrentItem((Integer) view.getTag());
                }
            });
            icons[0].setSelected(true);
        }
    }

    class GuideAdapter extends FragmentStatePagerAdapter {


        public GuideAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }

        @Override
        public int getCount() {
            return list.size();
        }
    }
}