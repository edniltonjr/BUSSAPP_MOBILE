package bussapp_mobile.juniorsantos.example.com.bussapp_mobile.entities;

import androidx.annotation.NonNull;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "motorista_table")
public class Motorista {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    private Integer id_motorista;

    private String nome;
    private String cpf;
    private String rg;

    @Embedded(prefix = "tipo_cnh")
    private ClasseGenerica tipo_cnh;

    public Motorista() {
        tipo_cnh = new ClasseGenerica();
    }

    public Integer getId_motorista() {
        return id_motorista;
    }

    public void setId_motorista(Integer id_motorista) {
        this.id_motorista = id_motorista;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public ClasseGenerica getTipo_cnh() {
        return tipo_cnh;
    }

    public void setTipo_cnh(ClasseGenerica tipo_cnh) {
        this.tipo_cnh = tipo_cnh;
    }

}