package bussapp_mobile.juniorsantos.example.com.bussapp_mobile.activity;

import android.os.Bundle;


import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import bussapp_mobile.juniorsantos.example.com.bussapp_mobile.R;
import bussapp_mobile.juniorsantos.example.com.bussapp_mobile.dao.DataBase;
import bussapp_mobile.juniorsantos.example.com.bussapp_mobile.entities.Funcionario;


public class MainActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpToolbar();
        setUpMenu();

        DataBase dataBase = DataBase.getINSTANCE(this);

        Funcionario f = new Funcionario();
        f.setCpf("111");
        f.setNome("Doni");

        dataBase.funcionarioDao().insertOne(f);

        Funcionario aa = dataBase.funcionarioDao().findOneById(1);
        aa.getCargo();
    }


    @Override
    public void onRefresh() {
    }
}
