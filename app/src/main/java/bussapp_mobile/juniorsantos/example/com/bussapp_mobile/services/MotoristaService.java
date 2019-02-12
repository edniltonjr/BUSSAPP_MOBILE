package bussapp_mobile.juniorsantos.example.com.bussapp_mobile.services;


import java.util.List;

import bussapp_mobile.juniorsantos.example.com.bussapp_mobile.entities.Motorista;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface MotoristaService {

    @GET("motorista/todos")
    Call<List<Motorista>> findAll();

    @POST("motorista/inserir")
    Call<Boolean> insertOne(@Body Motorista motorista);

    @GET("motorista/{cpf}/busca/cpf")
    Call<Motorista> findOne(@Path("cpf") String cpf);
}
