package bussapp_mobile.juniorsantos.example.com.bussapp_mobile.dao_interface;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import bussapp_mobile.juniorsantos.example.com.bussapp_mobile.entities.Viagem;

@Dao
public abstract class ViagemDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract Integer insertOne(Viagem viagem);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract void insertAll(List<Viagem> viagens);

    @Query("SELECT * FROM viagem_table")
    public abstract List<Viagem> findAll();

    @Query("SELECT * FROM viagem_table AS v WHERE v.id_viagem = :id_viagem")
    public abstract Viagem findOneById(Integer id_viagem);

    @Query("DELETE FROM viagem_table")
    public abstract void deleteAll();

    @Transaction
    public void insertAndDeleteAll(List<Viagem> viagens) {
        deleteAll();
        insertAll(viagens);
    }

}
