package bussapp_mobile.juniorsantos.example.com.bussapp_mobile.entities;

import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "funcionario_table") // nome da tabela da classe
public class Funcionario {

	@PrimaryKey(autoGenerate = true) // toda classe tem que ter uma foreign key, você pode passar ela, ai ele não gera
	private Integer id_funcionario;// o resto nao precisa ser mapeado
	private String nome;
	private String cpf;

	@Embedded(prefix = "cargo")
	private ClasseGenerica cargo; // exceto esse tipo de classe, complexa, a notação embedded diz que tudo o estiver dentro vira coluna da tabela. algo como cargoid, cargonome, na mesma
	//tabela do funcionario_table

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
