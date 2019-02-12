package bussapp_mobile.juniorsantos.example.com.bussapp_mobile.services;

import java.util.List;

import bussapp_mobile.juniorsantos.example.com.bussapp_mobile.entities.Motorista;
import bussapp_mobile.juniorsantos.example.com.bussapp_mobile.entities.Veiculo;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface VeiculoService {

    //@GET, @POST

    @GET("veiculo/todos")
    Call<List<Veiculo>> findAll();

    @POST("veiculo/inserir")
    Call<Boolean> insertOne(@Body Veiculo veiculo);

    @GET("veiculo/{id_veiculo}/busca/")
    Call<Veiculo> findOne(@Path("id_veiculo") Integer id_veiculo);
}
