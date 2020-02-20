package com.example.tablayoutwithviewpager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener{

    TabLayout tabLayout;
    ViewPager viewPager;
    TabItem tabChat,tabStatus,tabCall;
    PagerAdapter pagerAdapter;

    public void setIds(){
        tabLayout = findViewById(R.id.id_tablayout);
        viewPager = findViewById(R.id.id_view_pager);
        tabChat = findViewById(R.id.id_chat);
        tabStatus = findViewById(R.id.id_status);
        tabCall = findViewById(R.id.id_calls);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("TabLayout With ViewPager");
        setIds();

        pagerAdapter = new PageAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);

        //listener to Tab Layout
        tabLayout.addOnTabSelectedListener(this);
        //Set Tab Layout to ViewPager.
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }

    /*
    Operation on Tab layout
     */

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        viewPager.setCurrentItem(tab.getPosition());
        FragmentManager fragmentManager = getSupportFragmentManager();

        switch (tab.getPosition()){
            //chat fragment
            case 0:
            //    fragmentManager.beginTransaction().add(R.id.id_chat_fragment,new CallFragment()).addToBackStack("1").commit();
                break;
            //status fragmentnew
            case 1:
           //     fragmentManager.beginTransaction().add(R.id.id_call_fragment,new ChatFragment()).addToBackStack("2").commit();
                break;
            //call fragment
            case 2:
          //      fragmentManager.beginTransaction().add(R.id.id_status_fragment,new StatusFragment()).addToBackStack("3").commit();
                break;
        }//end

    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {
        FragmentManager fragmentManager = getSupportFragmentManager();

    }
}
