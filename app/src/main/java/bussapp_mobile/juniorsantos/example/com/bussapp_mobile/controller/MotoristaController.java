package bussapp_mobile.juniorsantos.example.com.bussapp_mobile.controller;

import android.content.Context;
import android.widget.Toast;

import bussapp_mobile.juniorsantos.example.com.bussapp_mobile.dao.DataBase;
import bussapp_mobile.juniorsantos.example.com.bussapp_mobile.entities.Motorista;
import bussapp_mobile.juniorsantos.example.com.bussapp_mobile.retrofit.RetrofitInstance;
import bussapp_mobile.juniorsantos.example.com.bussapp_mobile.services.MotoristaService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MotoristaController {

    private Context context;

    public MotoristaController(Context context) {
        this.context = context;
    }

    public void atualizarMotorista(final String cpf, final InterfaceMotorista interfaceMotorista) {

        MotoristaService motoristaService = RetrofitInstance.getInstance().create(MotoristaService.class);

        motoristaService.findOne(cpf).enqueue(new Callback<Motorista>() {
            @Override
            public void onResponse(Call<Motorista> call, Response<Motorista> response) {
                if (response.isSuccessful()) {
                    Motorista motorista = response.body();

                    if (motorista != null) {
                        DataBase dataBase = DataBase.getINSTANCE(context);
                        dataBase.motoristaDao().insertAndDeleteAll(motorista);
                        Motorista motoristaBaixado = dataBase.motoristaDao().findOneByCpf(cpf);
                        interfaceMotorista.doSomething(motoristaBaixado);
                    } else {
                        alert("Motorista is null", context);
                    }
                } else {
                    alert("Responde is false", context);
                }
            }

            @Override
            public void onFailure(Call<Motorista> call, Throwable t) {
                alert(t.toString(), context);
            }
        });
    }

    public void pegarMotoristaOffline(String cpf, InterfaceMotorista interfaceMotorista){
        DataBase base = DataBase.getINSTANCE(context);

        Motorista motoristaOffline = base.motoristaDao().findOneByCpf(cpf);

        if(motoristaOffline != null){
            interfaceMotorista.doSomething(motoristaOffline);
        }
    }

    private void alert(String s, Context context) {
        Toast.makeText(context, s, Toast.LENGTH_LONG).show();
    }

    public interface InterfaceMotorista {
        void doSomething(Motorista motorista);
    }
}
