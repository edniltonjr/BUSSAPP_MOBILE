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
    Call<Boolean> insertOne(@Body Motorista motorista); //igual aqui

    @GET("motorista/{cpf}/busca/cpf")
    Call<Motorista> findOne(@Path("cpf") String cpf);
}


//nao entendo como isso funciona a gente da um select e ele joga pro banco?? Sqlite nao tem nada a ver com o web service, mas pensa, se dessemos o direito de um motorista
// criar um peril pra ele, a partir do mobile, a gente ia fazer o select da classe, ia retornar um Motorista, e a gente ia chamar a url do web service passando o motorista

//armazeno os dados localmente com sqlite, ai depois quando sincronizo, ele da um select na classe, e dependendo do meotodo ela insere ? É, ou exclui, os metodos tem retorno boolean pra que
//depois eu possa apagar localmente, a viagem, por exemplo e todas as pessoas daquela viagem, entendi agora hehe  Tá facil no web service tem varios serviços, só você copiar a url e o que ele precisa
// dentro de cada interface, e depois a gente faz alguma coisa pra baixar o perfil do motorista e salvar, pra você entender como vai ser, vou criar os servicos