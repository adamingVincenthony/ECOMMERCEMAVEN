package fr.adaming.daoTest;




import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IAdminDao;
import fr.adaming.dao.IMagasinDao;
import fr.adaming.entities.Categorie;
import fr.adaming.entities.Produit;

@RunWith(SpringJUnit4ClassRunner.class) // le runner de spring
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/application-context.xml"})
public class AdminDaoTest {
	
	@Autowired
	public IAdminDao adminDao;
	
	public IMagasinDao magasinDao;
	
	@Test
	@Transactional
	public void testgetAllProduit(){
		int resultatAttendu = 5;
		List<Produit> listeProduit = adminDao.getAllProduit();
		assertEquals(resultatAttendu, listeProduit.size());
	}
	
	@Test
	@Transactional
	public void testAddProduit(){
		List<Produit> listeProduit = adminDao.getAllProduit();
		int resultatAttendu = listeProduit.size();
		adminDao.ajouterProduit(new Produit());
		resultatAttendu ++;
		List<Produit> listeProduit2 = adminDao.getAllProduit();
		assertEquals(resultatAttendu, listeProduit2.size());
	}
	
	
	@Test
	@Transactional
	public void testDeleteProduit(){
		Produit produit = new Produit(12, "test", "tes", 10, 10, true);
		adminDao.ajouterProduit(produit);
		List<Produit> listeProduit = adminDao.getAllProduit();
		adminDao.supprimerProduit(produit.getId_produit());
		
		List<Produit> listeProduit2 = adminDao.getAllProduit();
		assertEquals(listeProduit.size(), listeProduit2.size());
	}
	
	@Test
	@Transactional
	public void testaddCategorie(){
		List<Categorie> listeCategorie = magasinDao.getAllCategories();
		Categorie categorie = new Categorie(100, "test", "test");
		adminDao.ajouterCategorie(categorie);
		
		List<Categorie> listeCategorie2 = magasinDao.getAllCategories();
		assertEquals(listeCategorie.size()+1, listeCategorie2.size());
	}
	
	
	
	@Test
	@Transactional
	public void testupdateProduit(){
		Produit produit = new Produit(4, "test", "tes", 10, 10, true);
		Produit produitRetour  = adminDao.modifierProduit(produit);
		if(adminDao.getById(produit.getId_produit())!=null){
			assertNotNull(produitRetour);
		}
		
	}
}
