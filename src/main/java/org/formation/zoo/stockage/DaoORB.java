/**
 * 
 */
package org.formation.zoo.stockage;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author Ismael
 *La classe permet d'établir la connexion entre l'application et la base de données
 */
public  class DaoORB  {
	Connection connection;
//	private final static String URL = "jdbc:mysql://localhost:3306/zoo";
//	private final static String LOGIN = "root";
//	private final static String PSWD = "";
	private Properties properties;
	/**
	 * Constructeur personnalisé pour la connexion
	 */
	public DaoORB() {
		 properties = new Properties();
		 this.charger();
//			connection = DriverManager.getConnection(properties.getProperty("URL"), properties.getProperty("LOGIN"),properties.getProperty("PSWD"));
//             connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/zoo","root","");
	}
	/*
	 * Elle charge le fichier de configuration pour connexion à la base de données
	 */
	private void charger() {
		try {
//			properties.load(new FileInputStream("mysql.properties"));
			properties.load(DaoFactory.class.getResourceAsStream("mysql.properties"));
			
		}catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		return connection;
	}
	
	public static void main(String [] args) {
		
		@SuppressWarnings("unused")
		DaoORB daoORB = new DaoORB();
//		daoORB.charger();
	}
	
}
