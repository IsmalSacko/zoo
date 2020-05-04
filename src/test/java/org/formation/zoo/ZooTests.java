package org.formation.zoo;

import org.formation.zoo.vue.Zoo;
import org.junit.jupiter.api.BeforeAll;
/**
 * 
 * @author Ismael
 *
 */
class ZooTests {

	static Zoo z;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		z = new Zoo();
	}

//	@Test
//	void testDevorer() {
//		//singe singe
//		assertEquals("INCOMPATIBLE",z.devorer(0, 0));
//		// singe lion
//		assertEquals("INCOMPATIBLE",z.devorer(0, 1));
//		//singe vide
//		assertEquals("INCOMPATIBLE",z.devorer(0,2));
//		//singe gazelle
//		assertEquals("Je n'aime pas �a",z.devorer(0, 3));
//		//Lion Lion
//		assertEquals("INCOMPATIBLE",z.devorer(1,1));
//		//lion singe
//		assertEquals("INCOMPATIBLE",z.devorer(1, 0));
//		//lion vide
//		assertEquals("INCOMPATIBLE",z.devorer(1, 2));
//		//lion gazelle
//		assertEquals("MIAM",z.devorer(1, 3));
//	}

}
