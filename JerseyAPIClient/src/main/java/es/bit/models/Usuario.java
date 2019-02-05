package es.bit.models;

public class Usuario {
	public int uid;
	public String nombre;
	public String email;
	public String foto;
	
	public Usuario() {
	}
	
	
	public Usuario(int uid, String nombre, String email, String foto) {
		super();
		this.uid = uid;
		this.nombre = nombre;
		this.email = email;
		this.foto = foto;
	}


	public int getUid() {
		return uid;
	}


	public void setUid(int uid) {
		this.uid = uid;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getFoto() {
		return foto;
	}


	public void setFoto(String foto) {
		this.foto = foto;
	}
	
	
	
	
}
