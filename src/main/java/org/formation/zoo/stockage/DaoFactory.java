/**
 * 
 */
package org.formation.zoo.stockage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;
import org.formation.zoo.service.CagePOJO;

/**
 * @author Ismael
 *
 */
public class DaoFactory {

	private static DaoFactory instance  = new DaoFactory();
	Class<?> classe;
	Dao<CagePOJO> dao;
	Properties properties;
	
	/**
	 * Constructeur personnalisé de la classe {@link DaoFactory}
	 */
	@SuppressWarnings("unchecked")
	private DaoFactory() {
		properties = new Properties();
		charger();
		try {
			try {
				try {
					//classe = (Class<CagePOJO>) classe.forName(properties.getProperty("CLASS")).getConstructor().newInstance(null);
					classe = (Class<?>) Class.forName(properties.getProperty("CLASS"));
					dao = (Dao<CagePOJO>) classe.getDeclaredConstructor(null).newInstance(null);
					
				} catch (IllegalArgumentException e) {
					
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					
					e.printStackTrace();
				} catch (SecurityException e) {
				
					e.printStackTrace();
				}
			} catch (InstantiationException e) {
				 
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				 
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			 
			e.printStackTrace();
		}
		
	}
	
	/**
	 * @return the properties
	 */
	public Properties getProperties() {
		return properties;
	}

	public void charger() {
		try {
			//properties.load(new FileInputStream("classConfig.properties"));
			properties.load(DaoFactory.class.getResourceAsStream("classConfig.properties"));
			
		} catch (FileNotFoundException e) {
			 
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	/**
	 * @return the instance
	 */
	public static DaoFactory getInstance() {
		return instance;
	}
	
	public Dao<CagePOJO>getDao(){
	
		return new DaoJDBCImpl();
//		return new DaoMemoire();
	}
	public Dao<CagePOJO>getClassDao(){
		
			return dao;
		
	}

}
