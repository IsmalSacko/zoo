/**
 * 
 */
package org.formation.zoo.stockage;

import java.util.List;
import java.util.Vector;
import org.formation.zoo.service.CagePOJO;

/**
 *@author Ismael
 *C'est la classe de stockage de nos fichiers en mémoire
 */
public class DaoMemoire implements Dao<CagePOJO> {

	private List<CagePOJO> elts;
	
	/**
	 * Constructeur personnalisé 
	 */
	public DaoMemoire() {
		init();
	}

	@Override
	public List<CagePOJO> lireTous() {
		
		return elts;
	}

	@Override
	/**
	 * Permet la lecture de ficheirs
	 */
	public void ecrireTous(List<CagePOJO> elt) {}
	
	/**
	 * Permet d'initialiser les pojos pour la normalisation
	 */
	private void init()
	{
		CagePOJO tmp = null;
		elts = new Vector<>();
	
			tmp = new CagePOJO();
			tmp.setCodeAnimal("Singe");
			tmp.setCle(0);
			tmp.setX(100);
			tmp.setY(400);
			tmp.setAge(20);
			tmp.setPoids(75.0);
			tmp.setNom("baloo");
			elts.add(tmp);
			
			tmp = new CagePOJO();
			tmp.setX(150);
			tmp.setY(400);
			tmp.setCle(1);
			elts.add(tmp);
			
//			tmp = new CagePOJO();
//			tmp.setCodeAnimal("Gazelle");
//			tmp.setCle(2);
//			tmp.setX(100);
//			tmp.setY(500);
//			tmp.setAge(25);
//			tmp.setPoids(100);
//			tmp.setGaz(new GazellePOJO());
//			elts.add(tmp);
			
	}

	@Override
	/**
	 * Permet la modification
	 */
	public void modifier(int cle, CagePOJO obj) {
		elts.set(cle, obj);
		
	}

	@Override
	/**
	 * Permet d'effacer
	 */
	public void effacer(CagePOJO obj) {
		elts.remove(obj);
	}
	/**
	 * Permet d'ajouter un objet
	 */
	@Override
	public void ajouter(CagePOJO obj) {
		elts.add(obj);
		
	}
	/**
	 * Permet d'effacerer un objet
	 */
	@Override
	public void effacer(int cle) {
		elts.remove(cle);
		
	}
	/**
	 * Permet de modifier un objet
	 */
	@Override
	public void modifier(CagePOJO obj) {
		
	}

}
