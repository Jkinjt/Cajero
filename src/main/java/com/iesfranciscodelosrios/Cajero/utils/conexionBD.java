package com.iesfranciscodelosrios.Cajero.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;







public class conexionBD {
	public conexionBD(){}
	conexionBD(String server,String database,String username,String password){
		
	}
	
	/*
	 * Atributos
	*/

	/*
	 * Conexion con la BBDD
	*/
	private static Connection con;
	
	//url`s que cargan los metodos con el xml`s que contienen los datos de la conexion 
	public static String server= XMLreader.conexionINFO("server");
	public static String database= XMLreader.conexionINFO("database");
	public static String user= XMLreader.conexionINFO("user");
	public static String password= XMLreader.conexionINFO("password");
	
	
	/*
	 * metodo para conectar con la BBDD
	*/
		public static void conectar() {
			try {
	            //Paso 1: establecer la conexion
				Class.forName("com.mysql.cj.jdbc.Driver");

	            con = DriverManager.getConnection(server+"/"+database,user,password);
	            
	            System.out.println("Conectado correctamente a la Base de Datos");
	   
	       
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				
				} catch (SQLException e) {
					con=null;
	            e.printStackTrace();
				}
			}
		
		/*
		 * metodo para conectar en los DAO con la BBDD
		*/
		public static Connection getConexion() {
			if(con==null) {
				conectar();
			}
			
			return con;
		}
		
		
				
	}