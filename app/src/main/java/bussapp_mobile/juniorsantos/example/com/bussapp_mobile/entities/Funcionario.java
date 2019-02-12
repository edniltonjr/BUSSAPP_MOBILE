package bussapp_mobile.juniorsantos.example.com.bussapp_mobile.entities;

import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "funcionario_table")
public class Funcionario {

	@PrimaryKey(autoGenerate = true)
	private Integer id_funcionario;
	private String nome;
	private String cpf;

	@Embedded(prefix = "cargo")
	private ClasseGenerica cargo;

	@Embedded(prefix = "filial")
	private ClasseGenerica filial;

	public Funcionario() {
		cargo = new ClasseGenerica();
		filial = new ClasseGenerica();
	}

	public Integer getId_funcionario() {
		return id_funcionario;
	}

	public void setId_funcionario(Integer id_funcionario) {
		this.id_funcionario = id_funcionario;
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

	public ClasseGenerica getCargo() {
		return cargo;
	}

	public void setCargo(ClasseGenerica cargo) {
		this.cargo = cargo;
	}

	public ClasseGenerica getFilial() {
		return filial;
	}

	public void setFilial(ClasseGenerica filial) {
		this.filial = filial;
	}

}
