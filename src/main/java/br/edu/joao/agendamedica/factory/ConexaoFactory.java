package br.edu.joao.agendamedica.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConexaoFactory {

	private static final String DRIVER="com.mysql.jdbc.Driver";
	private static final String URL="jdbc:mysql://localhost:3306/agendaMedica";
	private static final String USER="root";
	private static final String PASSWORD="88806460";
	
	public Connection criaConexao() {
		Connection conn = null;
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL,USER,PASSWORD);
			
		} catch (Exception e) {
			System.out.println("Erro na conexão com o banco de dados" + e);
			e.printStackTrace();
		} 
			return conn;
	}
	
}
