package bussapp_mobile.juniorsantos.example.com.bussapp_mobile.dao_interface;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import bussapp_mobile.juniorsantos.example.com.bussapp_mobile.entities.ViagemConteudo;

@Dao
public abstract class ViagemConteudoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract void insertOne(ViagemConteudo viagemConteudo);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract void insertAll(List<ViagemConteudo> viagensConteudo);

    @Query("SELECT * FROM viagem_conteudo_table")
    public abstract List<ViagemConteudo> viagemConteudos();

    @Query("DELETE FROM viagem_conteudo_table")
    public abstract void deleteAll();

    @Transaction
    public void insertAndDeleteAll(List<ViagemConteudo> viagensConteudo) {
        deleteAll();
        insertAll(viagensConteudo);
    }

}
