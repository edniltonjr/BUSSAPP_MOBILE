package bussapp_mobile.juniorsantos.example.com.bussapp_mobile.controller;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import bussapp_mobile.juniorsantos.example.com.bussapp_mobile.dao.DataBase;
import bussapp_mobile.juniorsantos.example.com.bussapp_mobile.dao_interface.FuncionarioDao;
import bussapp_mobile.juniorsantos.example.com.bussapp_mobile.entities.Funcionario;
import bussapp_mobile.juniorsantos.example.com.bussapp_mobile.retrofit.RetrofitInstance;
import bussapp_mobile.juniorsantos.example.com.bussapp_mobile.services.FuncionarioService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FuncionariosController extends BaseController {

    private DataBase dataBase;
    private Context context;
    private FuncionariosControllerInterface funcionariosControllerInterface;

    public FuncionariosController(Context context, FuncionariosControllerInterface funcionariosControllerInterface) {
        super(context);
        this.context = context;
        dataBase = DataBase.getINSTANCE(this.context);
        this.funcionariosControllerInterface = funcionariosControllerInterface;
    }

    public void getFuncionariosOffline() {
        List<Funcionario> funcionariosList = new ArrayList<>();
        FuncionarioDao funcionarioDao = dataBase.funcionarioDao();
        funcionariosControllerInterface.onGetFuncionarios(funcionarioDao.listAll());
    }

    public void setFuncionariosOffline() {
        FuncionarioService funcionarioService = RetrofitInstance.getInstance().create(FuncionarioService.class);

        funcionarioService.findAll().enqueue(new Callback<List<Funcionario>>() {
            @Override
            public void onResponse(Call<List<Funcionario>> call, Response<List<Funcionario>> response) {
                if (response.isSuccessful()) {

                    List<Funcionario> funcionarios = response.body();

                    if (funcionarios.size() > 0) {
                        DataBase dataBase = DataBase.getINSTANCE(context);
                        dataBase.funcionarioDao().insertAndDeleteAll(funcionarios);
                        alertLong("FuncionariosControllerInterface salvos com sucesso !");
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Funcionario>> call, Throwable t) {
                alertLong(t.toString());
            }
        });
    }

    public interface FuncionariosControllerInterface {
        void onGetFuncionarios(List<Funcionario> funcionarios);
    }
}
