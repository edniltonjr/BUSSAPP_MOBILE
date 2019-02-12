package bussapp_mobile.juniorsantos.example.com.bussapp_mobile.dao_interface;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import bussapp_mobile.juniorsantos.example.com.bussapp_mobile.entities.Motorista;

@Dao
public abstract class MotoristaDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract void insertOne(Motorista motorista);

    @Query("SELECT * FROM motorista_table")
    public abstract List<Motorista> findAll();

    @Query("SELECT * FROM motorista_table AS m WHERE m.cpf = :cpf")
    public abstract Motorista findOneByCpf(String cpf);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract void insertAll(List<Motorista> motoristas);

    @Query("SELECT * FROM motorista_table AS m WHERE m.id_motorista = :id_motorista")
    public abstract Motorista findOneById(Integer id_motorista);

    @Query("DELETE FROM motorista_table")
    public abstract void deleteAll();

    @Transaction
    public void insertAndDeleteAll(Motorista motorista) {
        deleteAll();
        insertOne(motorista);
    }
}
