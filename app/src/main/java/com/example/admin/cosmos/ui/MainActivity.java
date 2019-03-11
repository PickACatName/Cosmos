package com.example.admin.cosmos.ui;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.admin.cosmos.R;
import com.example.admin.cosmos.fragment.ActFragment;
import com.example.admin.cosmos.fragment.MystarFragment;
import com.example.admin.cosmos.fragment.SearchFragment;
import com.example.admin.cosmos.fragment.UserFragment;
import com.example.admin.cosmos.utils.BottomNavigationViewHelper;

import java.util.ArrayList;
import java.util.List;
/*****
 * created by cjr
 * 1057809324@qq.com
 *****/
public class MainActivity extends AppCompatActivity {
    private BottomNavigationView mBottomNavigationView;

    private int lastIndex;
    List<Fragment> mFragments;

      @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
          initView();
          initBottomNavigation();
          initData();
    }
    public void initView() {

    }
    public void initData() {
        mFragments = new ArrayList<>();
        mFragments.add(new ActFragment());
        mFragments.add(new MystarFragment());
        mFragments.add(new SearchFragment());
        mFragments.add(new UserFragment());
        // 初始化展示MessageFragment
        setFragmentPosition(0);
    }
    public void initBottomNavigation() {
        mBottomNavigationView = findViewById(R.id.bottom_Navigation);
        // 解决当item大于三个时，非平均布局问题
        BottomNavigationViewHelper.disableShiftMode(mBottomNavigationView);
        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_home:
                        setFragmentPosition(0);
                        break;
                    case R.id.menu_search:
                        setFragmentPosition(2);
                        break;
                    case R.id.menu_star:
                        setFragmentPosition(1);
                        break;
                    case R.id.menu_me:
                        setFragmentPosition(3);
                        break;
                    default:
                        break;
                }
                // 这里注意返回true,否则点击失效
                return true;
            }
        });
    }
    private void setFragmentPosition(int position) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        Fragment currentFragment = mFragments.get(position);
        Fragment lastFragment = mFragments.get(lastIndex);
        lastIndex = position;
        ft.hide(lastFragment);
        if (!currentFragment.isAdded()) {
            getSupportFragmentManager().beginTransaction().remove(currentFragment).commit();
            ft.add(R.id.ll_frameLayout, currentFragment);
        }
        ft.show(currentFragment);
        ft.commitAllowingStateLoss();
    }
}
