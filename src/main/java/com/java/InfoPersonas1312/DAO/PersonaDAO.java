package com.java.InfoPersonas1312.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.java.InfoPersonas1312.Conexion.Conexion;
import com.java.InfoPersonas1312.modelo.Persona;

public class PersonaDAO {
private static Connection conexion;
	
	public static ArrayList<Persona> listarPersonas() throws SQLException{
		conexion= Conexion.getConexion();
		ArrayList<Persona> listado= new ArrayList<Persona>();
		String query= "SELECT * FROM persona";
		PreparedStatement ps=conexion.prepareStatement(query);
		ResultSet rs= ps.executeQuery(query);
		
		while(rs.next()) {
			listado.add(new Persona(rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5)));
		}
		
		
		return listado;
		
	}

}
