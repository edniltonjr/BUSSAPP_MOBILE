package bussapp_mobile.juniorsantos.example.com.bussapp_mobile.dao_interface;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import bussapp_mobile.juniorsantos.example.com.bussapp_mobile.entities.Funcionario;

@Dao
public abstract class FuncionarioDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    // aqui você passa o metodo, e ele já entende o que fazer
    abstract public void insertOne(Funcionario funcionario);// a classe tem que estar mapeada, pra ele criar as colunas sozinho

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract public void insertAll(List<Funcionario> funcionarios);

    @Query("SELECT * FROM funcionario_table")
    abstract public List<Funcionario> listAll();

    @Query("DELETE FROM funcionario_table WHERE 1=1")
    abstract public void deleteAll();

    @Query("SELECT * FROM funcionario_table AS f WHERE f.id_funcionario = :id_funcionario")
    abstract public Funcionario findOneById(Integer id_funcionario);

    @Transaction
    public void insertAndDeleteAll(List<Funcionario> funcionarios) {
        deleteAll();
        insertAll(funcionarios);
    }
}
