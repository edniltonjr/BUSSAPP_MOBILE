package bussapp_mobile.juniorsantos.example.com.bussapp_mobile.entities;

import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "viagem_table")
public class Viagem {

    @PrimaryKey(autoGenerate = true)
    private Integer id_viagem;
    private Motorista motorista;

    @Embedded(prefix = "veiculo")
    private Veiculo veiculo;

    private String tipo_viagem;
    private Long data_viagem;

    public Viagem() {
        motorista = new Motorista();
        veiculo = new Veiculo();
    }

    public Integer getId_viagem() {
        return id_viagem;
    }

    public void setId_viagem(Integer id_viagem) {
        this.id_viagem = id_viagem;
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public String getTipo_viagem() {
        return tipo_viagem;
    }

    public void setTipo_viagem(String tipo_viagem) {
        this.tipo_viagem = tipo_viagem;
    }

    public Long getData_viagem() {
        return data_viagem;
    }

    public void setData_viagem(Long data_viagem) {
        this.data_viagem = data_viagem;
    }

}
