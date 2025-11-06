package com.prueba;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PersonaDAO {
	
	
	
	public ObservableList<Persona> getAll() {
        ObservableList<Persona> personas = FXCollections.observableArrayList();

        String sql = "SELECT DNI, NOMBRE, APELLIDO, EDAD FROM PERSONAS";

        try (Connection conn = Conexion.conectar();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Persona p = new Persona(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4)
                );
                personas.add(p);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return personas;
    }
	
	public String crearDDL() {
	    String sql = "CREATE TABLE PERSONAS (DNI VARCHAR2(9) PRIMARY KEY,NOMBRE VARCHAR2(50),APELLIDO VARCHAR2(50),EDAD NUMBER)";
	    String error ="";
	    try (Connection conn = Conexion.conectar();
	         PreparedStatement ps = conn.prepareStatement(sql)) {

	        ps.executeUpdate();
	        System.out.println("Tabla PERSONAS creada correctamente.");

	    } catch (SQLException e) {
	        if (e.getErrorCode() == 955) {
	           error = "La tabla PERSONAS ya existe.";
	        } else {
	            e.printStackTrace();
	        }
	    }
	    return error;
	}
	
	public String add(Persona p) {
		
		String sql = "INSERT INTO PERSONAS VALUES(?,?,?,?)";
		String error ="";
		try (Connection conn = Conexion.conectar();
				PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setString(1, p.getDni());
			ps.setString(2, p.getNombre());
			ps.setString(3, p.getApellido());
			ps.setInt(4, p.getEdad());
			ps.execute();
			
		}catch (SQLException e) {
			error = "Se ha producido un error al añadir a la persona";
		}
		return error;
		
	}
	
	public String update(Persona p) {
		String error = "";
		String sql = "UPDATE PERSONAS SET NOMBRE=?, APELLIDO=?, EDAD=? WHERE DNI=?";
		try (Connection con = Conexion.conectar(); 
				PreparedStatement ps = con.prepareStatement(sql)
				){
			ps.setString(1, p.getNombre());
			ps.setString(2, p.getApellido());
			ps.setInt(3, p.getEdad());
			ps.setString(4, p.getDni());
			ps.execute();
		}catch (SQLException e) {
			error="Se ha producido un error actualizando los campos";
		}
		return error;
		
		
		
	}
		
		



	
	
	

}
