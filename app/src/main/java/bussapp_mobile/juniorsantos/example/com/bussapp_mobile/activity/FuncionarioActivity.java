package bussapp_mobile.juniorsantos.example.com.bussapp_mobile.activity;

import android.os.Bundle;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bussapp_mobile.juniorsantos.example.com.bussapp_mobile.R;
import bussapp_mobile.juniorsantos.example.com.bussapp_mobile.adapter.FuncionarioAdapter;
import bussapp_mobile.juniorsantos.example.com.bussapp_mobile.controller.FuncionariosController;
import bussapp_mobile.juniorsantos.example.com.bussapp_mobile.entities.Funcionario;

public class FuncionarioActivity extends AppCompatActivity implements FuncionariosController.FuncionariosControllerInterface, FuncionarioAdapter.FuncionarioAdapterInterface {

    private RecyclerView recyclerView;
    private FuncionariosController funcionariosController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_funcionario);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        funcionariosController = new FuncionariosController(this, this);
        funcionariosController.getFuncionariosOffline();
    }

    @Override
    public void onGetFuncionarios(List<Funcionario> funcionarios) {
        recyclerView.setAdapter(new FuncionarioAdapter(funcionarios, this, this));
    }
}
