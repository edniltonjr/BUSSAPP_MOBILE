package bussapp_mobile.juniorsantos.example.com.bussapp_mobile.dao;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import bussapp_mobile.juniorsantos.example.com.bussapp_mobile.dao_interface.FuncionarioDao;
import bussapp_mobile.juniorsantos.example.com.bussapp_mobile.dao_interface.MotoristaDao;
import bussapp_mobile.juniorsantos.example.com.bussapp_mobile.entities.Funcionario;
import bussapp_mobile.juniorsantos.example.com.bussapp_mobile.entities.Motorista;

@Database(entities = {Motorista.class, Funcionario.class}, version = 1, exportSchema = false)
public abstract class DataBase extends RoomDatabase { // criar um singletoon do database, uma instancia em toda a aplicação

    private static DataBase INSTANCE;

    public static DataBase getINSTANCE(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context, DataBase.class, "bussapp_mobile").allowMainThreadQueries().build(); //crio o banco
        }
        return INSTANCE;
    }

    public abstract MotoristaDao motoristaDao();

    public abstract FuncionarioDao funcionarioDao();

}
