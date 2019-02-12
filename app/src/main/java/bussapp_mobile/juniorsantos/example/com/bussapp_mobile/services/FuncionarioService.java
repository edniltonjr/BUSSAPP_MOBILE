package bussapp_mobile.juniorsantos.example.com.bussapp_mobile.services;

import java.util.List;

import bussapp_mobile.juniorsantos.example.com.bussapp_mobile.entities.Funcionario;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface FuncionarioService {

    @GET("funcionario/todos")
    Call<List<Funcionario>> findAll();

    @POST("funcionario/inserir")
    Call<Boolean> insertOne(@Body Funcionario funcionario); //igual aqui

    @GET("funcionario/{id_funcionario}/busca")
    Call<Funcionario> findOne(@Path("id_funcionario") Integer id_funcionario);
}
