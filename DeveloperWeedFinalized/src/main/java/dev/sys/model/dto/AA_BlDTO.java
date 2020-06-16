package dev.sys.model.dto;
import java.sql.Date;

public class AA_BlDTO {
	private Integer id_bl;
	private String nombre_nave;
	private Integer num_sello;
	private String consignatario;
	private String consignante;
	private Integer peso;
	private Integer vol_cubico;
	private String mercaderia;
	private String tipo_carga;
	private Date fecha_salida;
	private Date fecha_arribo;
	private Integer unidades;
	private String carga;
	private String incoterms;
	private String pais;
	private String documentacion;
	
	public AA_BlDTO() {
		super();
	}
	public AA_BlDTO(Integer id_bl, String nombre_nave, int num_sello, String consignatario, String consignante, int peso,
			int vol_cubico, String mercaderia, String tipo_carga, Date fecha_salida, Date fecha_arribo, int unidades,
			String carga, String incoterms, String pais, String documentacion) {
		super();
		this.id_bl = id_bl;
		this.nombre_nave = nombre_nave;
		this.num_sello = num_sello;
		this.consignatario = consignatario;
		this.consignante = consignante;
		this.peso = peso;
		this.vol_cubico = vol_cubico;
		this.mercaderia = mercaderia;
		this.tipo_carga = tipo_carga;
		this.fecha_salida = fecha_salida;
		this.fecha_arribo = fecha_arribo;
		this.unidades = unidades;
		this.carga = carga;
		this.incoterms = incoterms;
		this.pais = pais;
		this.documentacion = documentacion;
	}
	
	public Integer getId_bl() {
		return id_bl;
	}
	public void setId_bl(Integer id_bl) {
		this.id_bl = id_bl;
	}
	public String getNombre_nave() {
		return nombre_nave;
	}
	public void setNombre_nave(String nombre_nave) {
		this.nombre_nave = nombre_nave;
	}
	public Integer getNum_sello() {
		return num_sello;
	}
	public void setNum_sello(Integer num_sello) {
		this.num_sello = num_sello;
	}
	public String getConsignatario() {
		return consignatario;
	}
	public void setConsignatario(String consignatario) {
		this.consignatario = consignatario;
	}
	public String getConsignante() {
		return consignante;
	}
	public void setConsignante(String consignante) {
		this.consignante = consignante;
	}
	public Integer getPeso() {
		return peso;
	}
	public void setPeso(Integer peso) {
		this.peso = peso;
	}
	public Integer getVol_cubico() {
		return vol_cubico;
	}
	public void setVol_cubico(Integer vol_cubico) {
		this.vol_cubico = vol_cubico;
	}
	public String getMercaderia() {
		return mercaderia;
	}
	public void setMercaderia(String mercaderia) {
		this.mercaderia = mercaderia;
	}
	public String getTipo_carga() {
		return tipo_carga;
	}
	public void setTipo_carga(String tipo_carga) {
		this.tipo_carga = tipo_carga;
	}
	public Date getFecha_salida() {
		return fecha_salida;
	}
	public void setFecha_salida(Date fecha_salida) {
		this.fecha_salida = fecha_salida;
	}
	public Date getFecha_arribo() {
		return fecha_arribo;
	}
	public void setFecha_arribo(Date fecha_arribo) {
		this.fecha_arribo = fecha_arribo;
	}
	public Integer getUnidades() {
		return unidades;
	}
	public void setUnidades(Integer unidades) {
		this.unidades = unidades;
	}
	public String getCarga() {
		return carga;
	}
	public void setCarga(String carga) {
		this.carga = carga;
	}
	public String getIncoterms() {
		return incoterms;
	}
	public void setIncoterms(String incoterms) {
		this.incoterms = incoterms;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getDocumentacion() {
		return documentacion;
	}
	public void setDocumentacion(String documentacion) {
		this.documentacion = documentacion;
	}
}
