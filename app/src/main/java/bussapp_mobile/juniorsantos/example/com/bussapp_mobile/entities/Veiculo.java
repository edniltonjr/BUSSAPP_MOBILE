package bussapp_mobile.juniorsantos.example.com.bussapp_mobile.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "veiculo_table")
public class Veiculo {

	@PrimaryKey(autoGenerate = true)
	private Integer id_veiculo;
	private String modelo;
	private String placa;

	public Integer getId_veiculo() {
		return id_veiculo;
	}

	public void setId_veiculo(Integer id_veiculo) {
		this.id_veiculo = id_veiculo;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

}
