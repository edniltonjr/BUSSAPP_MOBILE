package bussapp_mobile.juniorsantos.example.com.bussapp_mobile.services;

import java.util.List;

import bussapp_mobile.juniorsantos.example.com.bussapp_mobile.entities.Motorista;
import bussapp_mobile.juniorsantos.example.com.bussapp_mobile.entities.Veiculo;
import bussapp_mobile.juniorsantos.example.com.bussapp_mobile.entities.ViagemConteudo;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ViagemConteudoService {

    @GET("viagem_conteudo/{id_viagem}/todos")
    Call<List<ViagemConteudo>> findAll(@Path("id_viagem") Integer id_viagem);

    @POST("viagem_conteudo/{id_viagem}/inserir")
    Call<Boolean> insertAll(@Body List<Integer> id_funcionarios, @Path("id_viagem") Integer id_viagem);

}
