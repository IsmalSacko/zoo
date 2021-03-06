/**
 * 
 */
package org.formation.zoo.service;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @author Ismael
 *
 */
@Entity
@Table(name="animal")
@NamedQueries({@NamedQuery(name="findAll", query="SELECT a FROM CagePOJO a"),
		@NamedQuery(name="find", query="SELECT c FROM CagePOJO c WHERE c.cle= :idAnimal"),
		@NamedQuery(name="count", query="SELECT COUNT(c.cle) FROM CagePOJO c GROUP BY c.cle")
})
public class CagePOJO {

	private int x;
	private int y;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idAnimal")//dans la base de données represente la clé
	private int cle;
	private String codeAnimal;//type de l'animal
	private String nom;
	private int age;
	private double poids;
	
	@ManyToOne(cascade = CascadeType.ALL )
	@JoinColumn(name = "idAnimal",referencedColumnName = "idAnimal", insertable = false, updatable = false)
	private GazellePOJO gaz;
	
	@Transient
	private String pancarte;
	@Transient
	private String image;
	
	/**
	 * initialise  les attributs à null
	 */
	public CagePOJO() {
		x = 0;
		y = 0;
		cle = 0;
		codeAnimal = null;
		nom = null;
		age = 0;
		poids = 0;
		gaz = null;
	}
	

	/**
	 * @return à la GazellePOJO
	 */
	public GazellePOJO getGaz() {
		return gaz;
	}


	/**
	 * @param  défeinir ou reunitialiser à gaz
	 */
	public void setGaz(GazellePOJO gaz) {
		this.gaz = gaz;
	}


	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x intialiser à x
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return retourne à y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y initialiser laposition y
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * @return retourne à laveur de l'attribut id
	 */
	public int getCle() {
		return cle;
	}

	/**
	 * @param cle 
	 */
	public void setCle(int cle) {
		this.cle = cle;
	}

	/**
	 * @return the codeAnimal
	 */
	public String getCodeAnimal() {
		return codeAnimal;
	}

	/**
	 * @param codeAnimal 
	 */
	public void setCodeAnimal(String codeAnimal) {
		this.codeAnimal = codeAnimal;
	}

	/**
	 * @return au nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom 
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return l'âge
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param initialiser l'âge à age
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return le poids
	 */
	public double getPoids() {
		return poids;
	}

	/**
	 * @param poids au poids 
	 */
	public void setPoids(double poids) {
		this.poids = poids;
	}


	@Override
	public String toString() {
		return "CagePOJO [x=" + x + ", y=" + y + ", cle=" + cle + ", codeAnimal=" + codeAnimal + ", nom=" + nom
				+ ", age=" + age + ", poids=" + poids + ", gaz=" + gaz + "]";
	}


	/**
	 * @return the pancarte
	 */
	public String getPancarte() {
		return pancarte;
	}


	/**
	 * @param initialisation de la pancarte
	 */
	public void setPancarte(String pancarte) {
		this.pancarte = pancarte;
	}


	/**
	 * @return l' image
	 */
	public String getImage() {
		return image;
	}


	/**
	 * @param image 
	 */
	public void setImage(String image) {
		this.image = image;
	}
	
	

}
