package com.bankex.pay.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.bankex.pay.R;
import com.bankex.pay.entity.Onboarding;

import java.util.List;

public class OnBoardingActivity extends AppCompatActivity {


    static {
        Onboarding favourites = new Onboarding(R.drawable.x35, R.string.favorite_list, R.string.add_your_contacts);
        Onboarding standart = new Onboarding(R.drawable.x36, R.string.ERC20_standart, R.string.support_any_tokens);
        Onboarding network = new Onboarding(R.drawable.x37, R.string.custom_network, R.string.add_your_network);
        Onboarding[] onboardings = new Onboarding[]{favourites, standart, network};
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_boarding);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    class OnBoardingPagerAdapter extends FragmentPagerAdapter {

        private final List<Onboarding> list;

        public OnBoardingPagerAdapter(List<Onboarding> list, FragmentManager fm) {
            super(fm);
            this.list = list;
        }

        public Fragment getItem(int position) {
            Onboarding get = list.get(position);
            Fragment fragment = ContentOnBoardingFragment.newInstance(get.getId(), get.getTitle(), get.getDesc());
            return fragment;
        }

        public int getCount() {
            return 3;
        }
    }
}


