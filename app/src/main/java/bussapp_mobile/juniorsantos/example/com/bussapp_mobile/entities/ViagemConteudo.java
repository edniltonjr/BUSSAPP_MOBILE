package bussapp_mobile.juniorsantos.example.com.bussapp_mobile.entities;

import androidx.room.Embedded;
import androidx.room.Entity;

@Entity(tableName = "viagem_conteudo_table")
public class ViagemConteudo {

    @Embedded(prefix = "viagem")
    private Viagem viagem;

    @Embedded(prefix = "funcionario")
    private Funcionario funcionario;

    public ViagemConteudo() {
        viagem = new Viagem();
        funcionario = new Funcionario();
    }

    public Viagem getViagem() {
        return viagem;
    }

    public void setViagem(Viagem viagem) {
        this.viagem = viagem;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

}
