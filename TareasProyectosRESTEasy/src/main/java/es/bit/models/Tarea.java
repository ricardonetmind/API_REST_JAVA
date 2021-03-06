package es.bit.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tarea")
public class Tarea {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String nombre;
	
	@Column
	private double duracion;
	
	@ManyToOne
    @JoinColumn(name="proyecto", nullable=false)
	private Proyecto proyecto;
	
	@ManyToOne
    @JoinColumn(name="responsable", nullable=false)	
	private Usuario responsable;
	
	public Tarea() {
		
	}

	public Tarea(int id, String nombre, double duracion, Proyecto proyecto, Usuario responsable) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.duracion = duracion;
		this.proyecto = proyecto;
		this.responsable = responsable;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getDuracion() {
		return duracion;
	}

	public void setDuracion(double duracion) {
		this.duracion = duracion;
	}

	public Proyecto getProyecto() {
		return proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

	public Usuario getResponsable() {
		return responsable;
	}

	public void setResponsable(Usuario responsable) {
		this.responsable = responsable;
	}
	
	

}
