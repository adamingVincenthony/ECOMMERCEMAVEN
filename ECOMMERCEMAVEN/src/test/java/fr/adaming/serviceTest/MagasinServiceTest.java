package fr.adaming.serviceTest;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.adaming.entities.Produit;
import fr.adaming.service.IMagasinService;

@RunWith(SpringJUnit4ClassRunner.class) // le runner de spring
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/application-context.xml"})
public class MagasinServiceTest {

	@Autowired
	public IMagasinService magasinService;
	
	public void testGetAllProduitByCategorie(){
		List<Produit> listeProduit = magasinService.getAllProduitsByIdCategorieService(3);
		assertNotNull(listeProduit);
	}
	
	public void test(){
		List<Produit> listeProduit = magasinService.getAllProduitsByKeyWordService("toto");
		assertNotNull(listeProduit);
	}
	
}
