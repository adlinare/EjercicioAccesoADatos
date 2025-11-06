package com.prueba;

import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;

public class PersonaO implements SQLData{
	private String typeName;
	private String dni;
	private String nombre;
	private String apellido;
	private Integer edad;
	
	public PersonaO(String typeName,String dni, String nombre, String apellido, Integer edad) {
		super();
		this.typeName = typeName;
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
	}

	public PersonaO() {
		super();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	@Override
	public String getSQLTypeName() throws SQLException {
		// TODO Auto-generated method stub
		return this.typeName;
	}

	@Override
	public void readSQL(SQLInput stream, String typeName) throws SQLException {
		// TODO Auto-generated method stub
		this.typeName = typeName;
		this.dni = stream.readString();
		this.nombre = stream.readString();
		this.apellido = stream.readString();
		this.edad = stream.readInt();
	}

	@Override
	public void writeSQL(SQLOutput stream) throws SQLException {
		// TODO Auto-generated method stub
		stream.writeString(this.dni);
		stream.writeString(this.nombre);
		stream.writeString(this.apellido);
		stream.writeInt(this.edad);
		
	}
	
	
	

}
