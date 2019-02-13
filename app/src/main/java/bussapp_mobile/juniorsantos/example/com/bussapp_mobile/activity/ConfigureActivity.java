package bussapp_mobile.juniorsantos.example.com.bussapp_mobile.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import bussapp_mobile.juniorsantos.example.com.bussapp_mobile.R;
import bussapp_mobile.juniorsantos.example.com.bussapp_mobile.controller.FuncionariosController;
import bussapp_mobile.juniorsantos.example.com.bussapp_mobile.entities.Funcionario;


public class ConfigureActivity extends AppCompatActivity implements FuncionariosController.FuncionariosControllerInterface {

    private FuncionariosController funcionariosController;
    private Button sincronizar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configure);

        funcionariosController = new FuncionariosController(this, this);

        sincronizar = findViewById(R.id.motoristaButton);

        sincronizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                funcionariosController.setFuncionariosOffline();
            }
        });
    }

    @Override
    public void onGetFuncionarios(List<Funcionario> funcionarios) {

    }
}
