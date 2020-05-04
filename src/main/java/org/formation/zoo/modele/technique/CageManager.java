/**
 * 
 */
package org.formation.zoo.modele.technique;

import org.formation.zoo.modele.metier.Animal;
import org.formation.zoo.modele.metier.Cage;
import org.formation.zoo.service.CagePOJO;
import org.formation.zoo.stockage.Dao;
import org.formation.zoo.utilitaire.Conversion;

/**
 * @author Ismael
 *
 */
public final  class CageManager {
	
	public final static String IMAGES ="images/";

	private Cage controleur;
	private CagePOJO vue;
	private Dao<CagePOJO> modele;
	
	public CageManager(CagePOJO pojo, Dao<CagePOJO> dao) {
		modele  =  dao;
		vue = pojo;
		controleur = Conversion.pojoToCage(pojo);
	}
	/**
	 * @return the vue
	 */
	public CagePOJO getVue() {
		String tmp = null;
		
		if(vue.getCodeAnimal()!=null) {	
			tmp = String.join(" ",vue.getNom(),Integer.toString(vue.getAge()),"ans",Double.toString(vue.getPoids()),"kg");
			vue.setPancarte(tmp);
			tmp = String.join("", IMAGES,vue.getCodeAnimal().toLowerCase(),".gif");
			vue.setImage(tmp);
		}
		else
		{
		vue.setPancarte("cage vide");
			tmp = String.join("", IMAGES,"cage.jpg");
			vue.setImage(tmp);
		}
		
				
		return vue;
	}
	public Cage getControleur() {
		return controleur;
	}
	public void setControleur(Cage controleur) {
		this.controleur = controleur;
	}
	/**
	 * @param vue the vue to set
	 */
	public void setVue(CagePOJO vue) {
		
				
	}
	public void entrer(Animal a) throws PorteException, CagePleineException{
	
		controleur.ouvrir();
		controleur.entrer(a);
		//mettre à jours le pojo
		//modifier le pojo

	}
	
	public void nourrir() {
		controleur.nourrir();
		if(controleur.getOccupant()!=null) {
			vue.setPoids(controleur.getOccupant().getPoids());
			modele.modifier(vue.getCle(), vue);
		}
		
	}
	@Override
	public String toString() {
		return controleur.toString();
	}
	
	
}
