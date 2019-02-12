package bussapp_mobile.juniorsantos.example.com.bussapp_mobile.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    private static String baseUrl = "http://10.0.2.2:8080/BUSSAPP_API/ws/"; // 10.0.2.2 pega o ip do seu computador, quando o servidor ta local, se estiver na net, voce passa o da net

    private static Retrofit retrofit;

    public static Retrofit getInstance() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build();
        }

        return retrofit;
    }



}
