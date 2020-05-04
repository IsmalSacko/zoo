package org.formation.zoo.modele.metier;

import java.io.Serializable;

import org.formation.zoo.modele.technique.BeurkException;
/**
 * @author Ismael
 * Interface de base de tout le modèle...
 * C'est le contrat de base.
 */
public interface Individu extends Serializable{
	public void manger();
	public String crier();
	@Deprecated
	public String manger(Gazelle g);
	@Deprecated
	public String manger(Individu i);
	//à partir de JAVA 8
	public default String manger(Mangeable m) throws BeurkException
	{
		throw new BeurkException();
	}
	public void sauter();
	public void courir();
	public void dormir();
	public String getInfos();
	}
