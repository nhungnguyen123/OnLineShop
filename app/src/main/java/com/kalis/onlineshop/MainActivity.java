package com.kalis.onlineshop;

import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.kalis.gethtmlfromurl.GetHtmlFromUrl;
import com.kalis.tabs.Tab1_HomePage;
import com.kalis.tabs.Tab2_DienThoai_LapTop;
import com.kalis.tabs.Tab3_ThoiTrang_LamDep;
import com.kalis.tabs.ViewPagerAdapter;

public class MainActivity extends AppCompatActivity {

    public static String Url_News = "http://kalis.net16.net/server.php?json=news";
    public static String Url_Brands = "http://kalis.net16.net/server.php?json=brands";
    public static String Url_Products = "http://kalis.net16.net/server.php?json=products";

    public static String Url_Catalog = "http://kalis.net16.net/server.php?json=catalog";

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    private int[] tabIcons = {
            R.drawable.ic_action_person,
            R.drawable.ic_action_group,
            R.drawable.ic_action_call
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        addToolBar();
//        addTabLayoutAndViewPager();
          getData();

    }

    private void getData() {
        GetHtmlFromUrl.getData("http://xem.vn/");
    }

    private void addToolBar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
//        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
        toolbar.setNavigationIcon(R.drawable.ic_menu);
//        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    private void addTabLayoutAndViewPager() {
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setOffscreenPageLimit(6);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();
    }


    private void setupTabIcons() {
        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        tabLayout.getTabAt(2).setIcon(tabIcons[2]);
        tabLayout.getTabAt(3).setIcon(tabIcons[0]);
        tabLayout.getTabAt(4).setIcon(tabIcons[1]);
        tabLayout.getTabAt(5).setIcon(tabIcons[2]);
 ;

    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new Tab1_HomePage(), "Tab 1");
        adapter.addFragment(new Tab2_DienThoai_LapTop(), "Tab 2");
        adapter.addFragment(new Tab3_ThoiTrang_LamDep(), "Tab 3");
        adapter.addFragment(new Tab1_HomePage(), "Tab 1");
        adapter.addFragment(new Tab2_DienThoai_LapTop(), "Tab 2");
        adapter.addFragment(new Tab3_ThoiTrang_LamDep(), "Tab 3");



        viewPager.setAdapter(adapter);
    }


}
