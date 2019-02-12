package bussapp_mobile.juniorsantos.example.com.bussapp_mobile.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;
import bussapp_mobile.juniorsantos.example.com.bussapp_mobile.R;
import bussapp_mobile.juniorsantos.example.com.bussapp_mobile.controller.MotoristaController;
import bussapp_mobile.juniorsantos.example.com.bussapp_mobile.entities.Motorista;


public class ConfigureActivity extends AppCompatActivity implements MotoristaController.InterfaceMotorista {

    private Button buscarMotorista;
    private TextView nomeMotorista;
    private EditText cpfMotorista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configure);

        buscarMotorista = findViewById(R.id.motoristaButton);
        nomeMotorista = findViewById(R.id.nomeMotorista);
        cpfMotorista = findViewById(R.id.cpfMotorista);

        buscarMotorista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MotoristaController motoristaController = new MotoristaController(ConfigureActivity.this);
                motoristaController.atualizarMotorista(cpfMotorista.getText().toString().trim(),  ConfigureActivity.this);
            }
        });

        buscarMotorista.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                MotoristaController motoristaController = new MotoristaController(ConfigureActivity.this);
                motoristaController.pegarMotoristaOffline(cpfMotorista.getText().toString().trim(), ConfigureActivity.this);
                Toast.makeText(ConfigureActivity.this, "Isso é offline", Toast.LENGTH_SHORT).show();
                return true;
            }
        });

    }

    @Override
    public void doSomething(Motorista motorista) {
        nomeMotorista.setText(motorista.getNome());
    }
}
