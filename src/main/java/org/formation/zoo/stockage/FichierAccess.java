package org.formation.zoo.stockage;
import java.io.*;
import java.util.List;
import java.util.Vector;

import org.formation.zoo.modele.metier.Cage;
import org.formation.zoo.modele.metier.Gazelle;
import org.formation.zoo.modele.metier.Lion;
import org.formation.zoo.modele.metier.Singe;
import org.formation.zoo.modele.technique.CagePleineException;
import org.formation.zoo.modele.technique.PorteException;
import org.formation.zoo.service.CagePOJO;

/**
 * Classe technique qui gère les accès fichier pour la sauvegarde des animaux du zoo.
 * @author Ismael
 *
 */
public class FichierAccess<T> implements Dao<T>{

	/**
	 * nom du fichier
	 */
	private String fichier;
	/**
	 * Collection des animaux lus
	 */
	private List<T> elts;
	/**
	 * constructeur
	 * @param f nom du fichier à lire et écrire
	 */
	public FichierAccess(String f)
	{
		fichier = f;
		elts = null;
		read();
	}

	/**
	 * méthode privée d'écriture de la collection
	 */
	private void write()
	{
	      ObjectOutputStream fic = null;
	      try {
	             fic= new ObjectOutputStream(new FileOutputStream(fichier));
	             fic.writeObject(elts);
	             fic.close();
	        } catch (IOException e) {
	          System.out.println(" erreur :" + e.getMessage());
	        }			
	}
	/**
	 * méthode privée de lecture de la collection dans, le fichier
	 */
	@SuppressWarnings("unchecked")
	private void read() {
	    ObjectInputStream fic = null;
		@SuppressWarnings("unused")
		File f = new File(fichier);
		try {
			fic= new ObjectInputStream(new FileInputStream(fichier));
			elts = (Vector<T>)fic.readObject();
			fic.close();
		}
		catch (IOException e) {
			//fichier inexistant tout remplir à la main en appelant init
//			init();
			DaoMemoire dm = new DaoMemoire();
			elts = (List<T>)dm.lireTous();
			
		}
		catch(ClassNotFoundException ex)
		{
			ex.printStackTrace();
		}
	}
	/**
	 * méthode privée qui rempli la liste si aucun fichier n'est trouvé
	 * @return fichier passé en aprametre
	 */
		public String getFichier() {
		return fichier;
	}

	public void setFichier(String fichier) {
		this.fichier = fichier;
	}
	/**
	 * méthode qui permet l'accès en lecture à l'information (fait partie de l'api)
	 * @return la collection lue
	 */
	@Override
	public List<T> lireTous(){
		if (elts == null){
			read();
		}
		return (List<T>) elts;
	}
	/**
	 * méthode qui permet l'accès en écriture à l'information (fait partie de l'api)
	 * @param lesCages la collection à persister
	 */
	@Override
	public void ecrireTous(List<T> lesCages) {
		elts = (List<T>) lesCages;
		write();
	}

	@Override
	public void modifier(int cle, T obj) {
		
	}

	@Override
	public void effacer(T obj) {
		
	}

	@Override
	public void ajouter(T obj) {
		
	}

	@Override
	public void effacer(int cle) {
		
		
	}

	@Override
	public void modifier(T obj) {
		
		
	}

	
}
