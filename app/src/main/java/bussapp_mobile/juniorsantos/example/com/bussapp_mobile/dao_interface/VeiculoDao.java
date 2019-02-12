package bussapp_mobile.juniorsantos.example.com.bussapp_mobile.dao_interface;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import bussapp_mobile.juniorsantos.example.com.bussapp_mobile.entities.Veiculo;

@Dao
public abstract class VeiculoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract Integer insertOne(Veiculo veiculo);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract void insertAll(List<Veiculo> veiculos);

    @Query("SELECT * FROM veiculo_table")
    public abstract List<Veiculo> listAll();

    @Query("DELETE FROM veiculo_table")
    public abstract void deleteAll();

    @Query("SELECT * FROM veiculo_table AS v WHERE v.id_veiculo = :id_veiculo")
    public abstract Veiculo findOneById(Integer id_veiculo);

    @Transaction
    public void insertAndDeleteAll(List<Veiculo> veiculos) {
        deleteAll();
        insertAll(veiculos);
    }

}
