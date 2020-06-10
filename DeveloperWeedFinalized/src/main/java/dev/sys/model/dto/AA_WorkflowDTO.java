package dev.sys.model.dto;

public class AA_WorkflowDTO {
	private String id_flujo;
	private String nombre_flujo;
	private Integer precedente;
	public String getId_flujo() {
		return id_flujo;
	}
	public void setId_flujo(String id_flujo) {
		this.id_flujo = id_flujo;
	}
	public String getNombre_flujo() {
		return nombre_flujo;
	}
	public void setNombre_flujo(String nombre_flujo) {
		this.nombre_flujo = nombre_flujo;
	}
	public Integer getPrecedente() {
		return precedente;
	}
	public void setPrecedente(Integer precedente) {
		this.precedente = precedente;
	}
	
	
}
