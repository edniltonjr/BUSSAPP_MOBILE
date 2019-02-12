package bussapp_mobile.juniorsantos.example.com.bussapp_mobile.services;

import java.util.List;

import bussapp_mobile.juniorsantos.example.com.bussapp_mobile.entities.Viagem;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface ViagemService {

    @GET("viagem/todos")
    Call<List<Viagem>> findAll();

    @POST("viagem/inserir")
    Call<Integer> insertOne(@Body Viagem viagem); // recupera o id da viagem gerado, pra posteriormente inserir as pessoas

    @PUT("viagem/update")
    Call<Boolean> findOne(@Body Viagem viagem);
}
