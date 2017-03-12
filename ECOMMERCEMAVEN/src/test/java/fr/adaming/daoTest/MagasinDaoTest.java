package fr.adaming.daoTest;


import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.adaming.dao.IAdminDao;
import fr.adaming.dao.IMagasinDao;
import fr.adaming.entities.Produit;

@RunWith(SpringJUnit4ClassRunner.class) // le runner de spring
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/application-context.xml"})
public class MagasinDaoTest {

	@Autowired
	public IMagasinDao magasinDao;
	
	public void testGetAllProduitByCategorie(){
		List<Produit> listeProduit = magasinDao.getAllProduitsByIdCategorie(3);
		assertNotNull(listeProduit);
	}
	
	public void test(){
		List<Produit> listeProduit = magasinDao.getAllProduitsByKeyWord("toto");
		assertNotNull(listeProduit);
	}
	
}
