package bussapp_mobile.juniorsantos.example.com.bussapp_mobile.activity;

import android.os.Bundle;


import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import bussapp_mobile.juniorsantos.example.com.bussapp_mobile.R;


public class MainActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpToolbar();
        setUpMenu();
    }


    @Override
    public void onRefresh() {
    }
}
