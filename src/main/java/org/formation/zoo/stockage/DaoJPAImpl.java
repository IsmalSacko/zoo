/**
 * 
 */
package org.formation.zoo.stockage;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.formation.zoo.service.CagePOJO;
import org.formation.zoo.service.GazellePOJO;

/**
 * @author Ismael
 *Cette classe permet le CRUD de nos POJO
 */
public class DaoJPAImpl<T> implements Dao<T>{
	/**
	 * Entité Manager qui permet fabrique une entité dans la base de données
	 */
	private EntityManager em;
	
	/**
	 * Constructeur personnalisée de la classe {@link DaoJPAImpl}
	 */	
	public DaoJPAImpl() {
		
		EntityManagerFactory emf = null;
		emf = Persistence.createEntityManagerFactory("Zoo");
		em = emf.createEntityManager();
	}

	/**
	 * Permet d'aoujt un nouvel objet pour le blancer dans la base de données.
	 */
	@Override
	public void ajouter(T obj) {
		em.getTransaction().begin();
		em.persist(obj);
		em.getTransaction().commit();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	/**
	 * Permet de récupérer et afficher les données de l'entité depuis la base de données
	 */
	public List<T> lireTous() {
		
		return em.createNamedQuery("findAll").getResultList();
	}
	
	/**
	 * Méthode qui permet de normaliser les données pour mettre dans la base de données
	 */
	@Override
	public void ecrireTous(List<T> elt) {
		// TODO Auto-generated method stub
		
	}
	/*
	 * Permet de modifier une entrée dans la base de données en la choppant par sa clé étrangère
	 */
	@Override
	public void modifier(int cle, T obj) {
		em.getTransaction().begin();
		em.merge(obj);
		em.getTransaction().commit();
		
		
	}
	/**
	 * PErmet de modifier l'objet existant dans la base de données
	 */
	@Override
	public void modifier(T obj) {
		em.getTransaction().begin();
		em.merge(obj);
		em.getTransaction().commit();
		
	}
	/**
	 * Méthode issue de l'implémentation de {@link Dao}
	 * Permet d'effacer un objet fabrique qui exite dans la base dinnées
	 */
	@Override
	public void effacer(T obj) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * Permet d'effacer un objet fabrique qui exite dans la base dinnées
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void effacer(int cle) {
		T obj = null;
		em.getTransaction().begin();
		obj = (T) em.createNamedQuery("find").setParameter("idAnimal", cle).getSingleResult();
		em.remove(obj);
		em.getTransaction().commit();
		
	}	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/**
		 * Ici on fabrique un nouvel objet à partir des Pojos envue de l'enregistrer dans la base donées
		 */
		DaoJPAImpl<CagePOJO> jpa = null;
		jpa = new DaoJPAImpl<CagePOJO>();
		
		CagePOJO tmp = null;
		tmp = new CagePOJO();
		GazellePOJO gp = new GazellePOJO();
		
		tmp.setCle(2);
		tmp.setAge(10);
		tmp.setCodeAnimal("Singe");
		tmp.setNom("Idriss");
		tmp.setPoids(80);
		tmp.setX(500);
		tmp.setY(500);
		
		gp.setId(4);		
		gp.setLgCornes(12);		
		gp.setIdAnimal(tmp.getCle());
		
		//tmp.setGaz(gp);
		//jpa.effacer(1);
		jpa.lireTous().forEach(item->System.out.println(item));

	}



	
}
