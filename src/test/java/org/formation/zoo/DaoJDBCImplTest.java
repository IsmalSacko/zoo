/**
 * 
 */
package org.formation.zoo;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.formation.zoo.service.CagePOJO;
import org.formation.zoo.stockage.DaoJDBCImpl;
import org.formation.zoo.stockage.DaoORB;
import org.junit.jupiter.api.Test;

/**
 *@author Ismael
 *
 */
class DaoJDBCImplTest {

	/**
	 * Teste pour {@link org.formation.zoo.stockage.DaoJDBCImpl#getListe()}.
	 * 
	 */
	@Test
	void testGetListe() {
		DaoJDBCImpl dao = null;
		dao = new DaoJDBCImpl();
		assertNotNull(dao.getListe());
	}

	/**
	 * Teste pour {@link org.formation.zoo.stockage.DaoJDBCImpl#ecrireTous(java.util.List)}.
	 */
	@Test
	void testEcrireTous() {
		
	}

	/**
	 * TTeste pour {@link org.formation.zoo.stockage.DaoJDBCImpl#modifier(int, org.formation.zoo.service.CagePOJO)}.
	 */
	@Test
	void testModifier() {
		CagePOJO tmp  = null;
		tmp = new CagePOJO();
		DaoJDBCImpl dao =null;
	try {
		tmp.setCodeAnimal("Lion");
		tmp.setNom("Ismael");
		tmp.setPoids(14);
		tmp.setX(120);
		tmp.setY(150);
		tmp.setCle(12);
		dao = new DaoJDBCImpl();
//		dao.ajouter(tmp);
		dao.modifier(36,tmp);;

	} catch (Exception e) {
		fail("Oups Erreur inatendue");
	}

	}

	/**
	 * Teste pour {@link org.formation.zoo.stockage.DaoJDBCImpl#effacer(org.formation.zoo.service.CagePOJO)}.
	 */
	@Test
	void testEffacerCagePOJO() {
		
				CagePOJO tmp  = null;
				tmp = new CagePOJO();
				DaoJDBCImpl dao =null;
			try {
				tmp.setCodeAnimal("Lion");
				tmp.setNom("clarence");
				tmp.setPoids(14);
				tmp.setX(120);
				tmp.setY(150);
				tmp.setCle(12);
				dao = new DaoJDBCImpl();
				//dao.ajouter(tmp);
				assertNotNull(tmp);
				dao.effacer(tmp);
		
			} catch (Exception e) {
				fail("Oups ! Erreur inattendue");
			}

		
	}

	/**
	 * Teste pour {@link org.formation.zoo.stockage.DaoJDBCImpl#ajouter(org.formation.zoo.service.CagePOJO)}.
	 */
	@Test
	void testAjouter() {
		
		CagePOJO tmp  = null;
		tmp = new CagePOJO();
		DaoJDBCImpl dao =null;
	
		tmp.setCodeAnimal("Lion");
		tmp.setNom("ismala");
		tmp.setCle(12);
		dao = new DaoJDBCImpl();
		//dao.ajouter(tmp);
		assertNotNull(tmp);
		assertEquals("ismala",tmp.getNom());
		
	}

	/**
	 * Test method pour {@link org.formation.zoo.stockage.DaoJDBCImpl#effacer(int)}.
	 */
	@Test
	void testEffacerInt() {
			CagePOJO tmp  = null;
			tmp = new CagePOJO();
			DaoJDBCImpl dao =null;
		try {
			tmp.setCodeAnimal("Lion");
			tmp.setNom("ismala");
			tmp.setPoids(14);
			tmp.setX(120);
			tmp.setY(150);
			tmp.setCle(12);
			dao = new DaoJDBCImpl();
	//		dao.ajouter(tmp);
			dao.effacer(35);
	
		} catch (Exception e) {
			fail("Oups erreur");
		}
	}

}
