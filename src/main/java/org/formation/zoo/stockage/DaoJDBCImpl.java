/**
 * 
 */
package org.formation.zoo.stockage;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Vector;

import org.formation.zoo.service.CagePOJO;
import org.formation.zoo.service.GazellePOJO;

/**
 * @author Ismael
 *Cette classe joue le même rôle {@link DaoJPAImpl} = CRUD
 */
public class DaoJDBCImpl implements Dao<CagePOJO> {

	DaoMemoire daomemoire;
	private DaoORB connecteur;
	private List<CagePOJO> liste;
	/**
	 * Contructeur personnalisé
	 */
	public DaoJDBCImpl() {
		liste = new Vector<>();
		connecteur = new DaoORB();
		daomemoire = new DaoMemoire();
	}
	@Override
	/**
	 * Elle permet la lecture des fichiers depuis la base de données
	 */
	public List<CagePOJO> lireTous() {
		
//		String req = "SELECT * FROM animal as gauche left join gazelle as droite on gauche.idAnimal = droite.idAnimal;";
		String req = "SELECT * FROM animal as gauche left join gazelle as droite on gauche.idAnimal = droite.idAnimal;";
		List<CagePOJO> lesCagePojo = null;
		CagePOJO tmp = null;
		GazellePOJO gaz =null;
		
		Statement st = null;
		ResultSet rs = null;
		
		try {
			lesCagePojo = new Vector<>();
			st = connecteur.getConnection().createStatement();
			rs = st.executeQuery(req);
			if(rs != null) {
				while(rs.next()) {
					tmp = new CagePOJO();
					tmp.setX(rs.getInt("x"));
					tmp.setY(rs.getInt("Y"));
					tmp.setCle(rs.getInt("idAnimal"));
					if(rs.getString("codeAnimal")!=null) {
						
						tmp.setAge(rs.getInt("age"));
						tmp.setNom(rs.getString("nom"));
						tmp.setPoids(rs.getDouble("poids"));
						tmp.setCodeAnimal(rs.getString("codeAnimal"));
						
						//si c'est une gazelle
						if (tmp.getCodeAnimal().contentEquals("Gazelle")) {
							gaz = new GazellePOJO();
							gaz.setId(rs.getInt("id"));
							gaz.setIdAnimal(rs.getInt("idAnimal"));
							gaz.setLgCornes(rs.getInt("lgCornes"));
							tmp.setGaz(gaz);
					
					     }
						
					}
					
					lesCagePojo.add(tmp);

				}
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lesCagePojo;
	}
	/**
	 * Permet d'écrire tous les fichiers pour la base de données
	 */
	@Override
	public void ecrireTous(List<CagePOJO> elt) {
				
		CagePOJO  tmp = null;
		
		tmp = new CagePOJO();
		if(tmp != null) {
		tmp.setCodeAnimal("Lion");
		tmp.setNom("Roi");
		tmp.setCle(10);
		tmp.setAge(12);
		tmp.setPoids(82);
		tmp.setX(450);
		tmp.setY(330);
		this.ajouter(tmp);
		elt.add(tmp);
		}
		
		tmp = new CagePOJO();
		if(tmp!=null) {
			tmp.setCodeAnimal("Singe");
			tmp.setNom("DOUDOU");
			tmp.setCle(11);
			tmp.setAge(11);
			tmp.setPoids(60);
			tmp.setX(400);
			tmp.setY(200);
			this.ajouter(tmp);
			elt.add(tmp);
		
		}
		tmp = new CagePOJO();
		if(tmp!=null) {
		tmp.setCodeAnimal("Lion");
		tmp.setNom("Yerinté");
		tmp.setAge(20);
		tmp.setPoids(80);
		tmp.setX(400);
		tmp.setY(469);
		this.ajouter(tmp);
		elt.add(tmp);
	
		}
		
			
	}
	
	
	/**
	 * Permet de moidifier pou mettre la liste d'animaux
	 */
	@SuppressWarnings("resource")
	@Override
	public void modifier(int cle, CagePOJO obj) {
//		 Statement st = null;
		 PreparedStatement prepareSt = null;
		 String sql1 = null;
		 String req1 = null;
		
//		 req = "UPDATE animal set nom ='"+obj.getNom()+"', age = "+obj.getAge()+", poids = "+obj.getPoids()+","
//				+ " x = "+obj.getX()+", y = "+obj.getY()+" where idAnimal = "+cle+"  ";

		    req1 = "UPDATE animal set nom =?, age = ?, poids = ?, x = ?, y = ? where idAnimal = ? ";
//			System.out.println(req);
			try {
				prepareSt = connecteur.getConnection().prepareStatement(req1);
				prepareSt.setString(1, obj.getNom());
				prepareSt.setInt(2, obj.getAge());
				prepareSt.setDouble(3, obj.getPoids());
				prepareSt.setInt(4, obj.getX());
				prepareSt.setInt(5, obj.getY());
				prepareSt.setInt(6, cle);
//				st = connecteur.getConnection().createStatement();
			    prepareSt.executeUpdate();
//				st.executeUpdate(req);
			    if(obj.getCodeAnimal().equals("Gazelle"))
			    {
//			    	sql1 = "UPDATE gazelle set lgCornes = '"+obj.getGaz().getLgCornes()+"  "+"'";
			    	 sql1 = "UPDATE gazelle set lgCornes = ?";
			    	 prepareSt = connecteur.getConnection().prepareStatement(sql1);
//			    	 System.out.println(sql1);
//			    	 st.executeUpdate(sql1);
			    	
			    	 prepareSt.setObject(1, obj.getGaz().getLgCornes());

			    	 prepareSt.executeUpdate();
			    }
				
			}
			catch (SQLException e) {
				e.printStackTrace();
			}finally {
				try {
					prepareSt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		
	}
	@Override
	/**
	 * Permet d'effacer un enregistremeent 
	 */
	public void effacer(CagePOJO obj) {
		PreparedStatement prepareStatement = null;
		//Statement st = null;
//		String req = "DELETE FROM animal where idAnimal ="+obj.getCle()+"";
//		String req2 = "DELETE FROM gazelle where idAnimal = "+obj.getCle()+"";
		String req = "DELETE FROM animal where idAnimal = ?";
		String req2 = "DELETE FROM gazelle where idAnimal = ?";
		//String requete = String.join("","DELETE FROM animal where", Integer.toString(this.getListe().get(tmp.getCle())),"= cle" );
		
		try {
			prepareStatement = connecteur.getConnection().prepareStatement(req);
			prepareStatement = connecteur.getConnection().prepareStatement(req2);
			prepareStatement.setInt(1, obj.getCle());
			//prepareStatement.setString(1, obj.getCodeAnimal());
			//prepareStatement.executeUpdate();
			prepareStatement.executeUpdate();
//			st.executeUpdate(req);
//			st.executeUpdate(req2);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			try {
				prepareStatement.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
	}
	@SuppressWarnings("resource")
	@Override
	/**
	 * Petmet d'ajout un nouvel enregistremet en base de données
	 */
	public void ajouter(CagePOJO obj) {
		//Statement st = null;
		PreparedStatement preparst = null;
		
		String requete = "INSERT INTO animal(codeAnimal,nom,age,poids,x,y) VALUES (?,?,?,?,?,?);";
		//System.out.println(requete);
		try {
			
			preparst = connecteur.getConnection().prepareStatement(requete);
			preparst.setString(1, obj.getCodeAnimal());
			preparst.setString(2, obj.getNom());
			preparst.setInt(3, obj.getAge());
			preparst.setDouble(4, obj.getPoids());
			preparst.setInt(5, obj.getX());
			preparst.setInt(6, obj.getY());
			preparst.executeUpdate();
			
//			st = connecteur.getConnection().createStatement();
//		    st.executeUpdate(sql);
		    if(obj.getCodeAnimal().equals("Gazelle"))
		    {
//		    	String sql1 = "INSERT INTO gazelle values (null,"+getLassId()+","+obj.getGaz().getLgCornes()+")";
		    	String insertsql =  "INSERT INTO gazelle(idAnimal, lgCornes) VALUES (?,?);";
		    	
		    	preparst = connecteur.getConnection().prepareStatement(insertsql);
		    	System.out.println(insertsql);
		    	preparst.setInt(1, getLastId());
		    	preparst.setInt(2, obj.getGaz().getLgCornes());
		    	preparst.executeUpdate();
//		    	 st.executeUpdate(sql1);
		    }
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				preparst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	
	}	
	/**
	 * Permet d'effacer une enregistrement par sa clé 
	 */
	@Override
	public void effacer(int cle) {
		@SuppressWarnings("unused")
		CagePOJO tmp = null;
		@SuppressWarnings("unused")
		PreparedStatement prepareStatement = null;
		Statement st = null;
		tmp = new CagePOJO();
		String req = "DELETE FROM animal where idAnimal="+cle+"" ;
		String req2 = "DELETE FROM gazelle where idAnimal="+ cle+"";
		//String requete = String.join("","DELETE FROM animal where", Integer.toString(this.getListe().get(tmp.getCle())),"= cle" );
		
		try {
			st = connecteur.getConnection().createStatement();
			st.executeUpdate(req);
			st.executeUpdate(req2);
		
//			prepareStatement = connecteur.getConnection().prepareStatement(req);
//			prepareStatement.setInt(1, tmp.getCle());
//			prepareStatement.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	/**
	 * Elle récupère le  drenier enregistrement d'une table de la base de données
	 * @return id 
	 */
	private int getLastId()
	{
		String req = "select MAX(idAnimal) as idAnimal from animal";
		Statement st = null;
		ResultSet rs = null;
		int id = 0;
		try {
			st = connecteur.getConnection().createStatement();
			rs = st.executeQuery(req);
			rs.next();
			id = rs.getInt("idAnimal");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return id;
	}
	
	/**
	 * @return  retourne au daomemoire
	 */
	public DaoMemoire getDaomemoire() {
		return daomemoire;
	}
	
	/**
	 * @return retourne à la liste d'animaux dans CagePOJO
	 */
	public List<CagePOJO> getListe() {
		return liste;
	}
	/**
	 * @param liste à initialiser à partir CagePOJO
	 */
	public void setListe(List<CagePOJO> liste) {
		this.liste = liste;
	}
	
	public static void main(String [] args) {
		
		DaoJDBCImpl daojdbc = new DaoJDBCImpl();
		//daojdbc.ajouter(new CagePOJO());
//		daojdbc.effacer(6);
		//daojdbc.effacer();
		//daojdbc.lireTous().forEach(System.out::println);
//		daojdbc.ecrireTous(daojdbc.getDaomemoire().lireTous());
//		daojdbc.lireTous().forEach(System.out::println);
	//	daojdbc.ecrireTous(daojdbc.getListe());
		//System.out.println(daojdbc.getLassId());
		CagePOJO cp= new CagePOJO();
		GazellePOJO gp = new GazellePOJO();
		
		cp.setAge(20);
		cp.setCodeAnimal("Gazelle");
		cp.setNom("Lea");
		cp.setPoids(80);
		cp.setX(600);
		cp.setY(500);
		cp.setCle(10);
		gp.setLgCornes(11);
		gp.setIdAnimal(10);
		gp.setId(11);
		cp.setGaz(gp);
		
		//daojdbc.ajouter(cp);
		
		//daojdbc.effacer(30);	
//		daojdbc.modifier(5, cp);
	
		daojdbc.lireTous().forEach(System.out::println);
		
		
	}
	@Override
	public void modifier(CagePOJO obj) {
		
		
	}
	
	
		
}

