package fr.adaming.serviceTest;




import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.service.IAdminService;
import fr.adaming.service.IMagasinService;
import fr.adaming.entities.Categorie;
import fr.adaming.entities.Produit;

@RunWith(SpringJUnit4ClassRunner.class) // le runner de spring
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/application-context.xml"})
public class AdminServiceTest {
	
	@Autowired
	public IAdminService adminservice;

	@Autowired
	public IMagasinService magasinservice;
	
	@Test
	@Transactional
	public void testgetAllProduit(){
		int resultatAttendu = 5;
		List<Produit> listeProduit = adminservice.getAllProduitService();
		assertEquals(resultatAttendu, listeProduit.size());
	}
	
	@Test
	@Transactional
	public void testAddProduit(){
		List<Produit> listeProduit = adminservice.getAllProduitService();
		int resultatAttendu = listeProduit.size();
		adminservice.ajouterProduitService(new Produit());
		resultatAttendu ++;
		List<Produit> listeProduit2 = adminservice.getAllProduitService();
		assertEquals(resultatAttendu, listeProduit2.size());
	}
	
	
	@Test
	@Transactional
	public void testDeleteProduit(){
		Produit produit = new Produit(12, "test", "tes", 10, 10, true);
		adminservice.ajouterProduitService(produit);
		List<Produit> listeProduit = adminservice.getAllProduitService();
		adminservice.supprimerProduitService(produit.getId_produit());
		
		List<Produit> listeProduit2 = adminservice.getAllProduitService();
		assertEquals(listeProduit.size(), listeProduit2.size());
	}
	
	@Test
	@Transactional
	public void testaddCategorie(){
		List<Categorie> listeCategorie = magasinservice.getAllCategoriesService();
		Categorie categorie = new Categorie(100, "test", "test");
		adminservice.ajouterCategorieService(categorie);
		List<Categorie> listeCategorie2 = magasinservice.getAllCategoriesService();
		assertEquals(listeCategorie.size()+1, listeCategorie2.size());
	}
	
	
	
	@Test
	@Transactional
	public void testupdateProduit(){
		Produit produit = new Produit(4, "test", "tes", 10, 10, true);
		Produit produitRetour  = adminservice.modifierProduitService(produit);
		if(adminservice.getByIdService(produit.getId_produit())!=null){
			assertNotNull(produitRetour);
		}
		
	}
}
