package com.example.administrator.googleplayer.ui.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.googleplayer.R;
import com.example.administrator.googleplayer.adapter.MainAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    private static final String TAG = "MainActivity";
    @BindView(R.id.tool_bar)
    Toolbar mToolBar;
    @BindView(R.id.tab_layout)
    TabLayout mTabLayout;
    @BindView(R.id.view_page)
    ViewPager mViewPage;
    private ActionBar supportActionBar;
    @BindView(R.id.navigation_view)
    NavigationView mNavigationView;
    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;

    private ActionBarDrawerToggle mActionBarDrawerToggle;
    private String[] mTitles;


    @Override
    public int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    protected void init() {
        super.init();
        mNavigationView.setNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        mTitles = getResources().getStringArray(R.array.main_titles);
        initActionBar();
        initViewPager();

    }

    private void initViewPager() {
        mViewPage.setAdapter(new MainAdapter(mTitles,getSupportFragmentManager()));
        mTabLayout.setupWithViewPager(mViewPage);
    }
    private PagerAdapter mPagerAdapter = new PagerAdapter() {
        @Override
        public int getCount() {
            return mTitles.length;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            TextView textView = new TextView(MainActivity.this);
            textView.setText(mTitles[position]);
            container.addView(textView);
            return textView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles[position];
        }
    };
    private void initActionBar() {
        setSupportActionBar(mToolBar);
        supportActionBar = getSupportActionBar();

        supportActionBar.setDisplayHomeAsUpEnabled(true);//显示返回按钮
       /* supportActionBar.setTitle("标题");
        supportActionBar.setSubtitle("副标题");
        supportActionBar.setDisplayShowTitleEnabled(false);*/
        mActionBarDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);
        //同步
        mActionBarDrawerToggle.syncState();
        mDrawerLayout.addDrawerListener(mActionBarDrawerToggle);
    }

    /**
     * 创建菜单按钮
     *
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbar_menu, menu);
        return true;
    }

    /**
     * 处理ActionBarDrawerToggle的点击事件
     *
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mActionBarDrawerToggle.onOptionsItemSelected(item);
                break;

        }

        return super.onOptionsItemSelected(item);
    }

    private NavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new NavigationView.OnNavigationItemSelectedListener() {
        //返回true就是选中状态

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            //mDrawerLayout.closeDrawer(GravityCompat.START);
            // mNavigationView.setCheckedItem(item.getItemId());
            Log.d(TAG, "onNavigationItemSelected: ");
            return true;
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
