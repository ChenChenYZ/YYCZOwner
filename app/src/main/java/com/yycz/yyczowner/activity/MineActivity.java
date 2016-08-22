package com.yycz.yyczowner.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.LinearLayout;

import com.yycz.yyczowner.R;
import com.yycz.yyczowner.fragment.PersonalCenterFragment;
import com.yycz.yyczowner.fragment.SystemMessageFragment;
import com.yycz.yyczowner.fragment.SystemSettingsFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Chen on 16/8/21.
 */
public class MineActivity extends FragmentActivity {

    @BindView(R.id.mine_btn_personalCenter)
    LinearLayout mineBtnPersonalCenter;
    @BindView(R.id.mine_btn_systemMessage)
    LinearLayout mineBtnSystemMessage;
    @BindView(R.id.mine_btn_systemSettings)
    LinearLayout mineBtnSystemSettings;
    @BindView(R.id.mine_viewPager)
    ViewPager mineViewPager;
    private List<Fragment> fragmentList = new ArrayList<>();
    private ViewPager viewPager;
    private FragmentStatePagerAdapter fragmentStatePagerAdapter;

    private PersonalCenterFragment personalCenterFragment;
    private SystemMessageFragment systemMessageFragment;
    private SystemSettingsFragment systemSettingsFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mine);
        ButterKnife.bind(this);

        init();

    }

    private void init() {

        viewPager = (ViewPager) findViewById(R.id.mine_viewPager);

        personalCenterFragment = new PersonalCenterFragment();
        systemMessageFragment = new SystemMessageFragment();
        systemSettingsFragment = new SystemSettingsFragment();
        fragmentList.add(personalCenterFragment);
        fragmentList.add(systemMessageFragment);
        fragmentList.add(systemSettingsFragment);

        fragmentStatePagerAdapter = new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragmentList.get(position);
            }

            @Override
            public int getCount() {
                return fragmentList.size();
            }
        };
        viewPager.setAdapter(fragmentStatePagerAdapter);
        viewPager.setCurrentItem(0);


    }
}
