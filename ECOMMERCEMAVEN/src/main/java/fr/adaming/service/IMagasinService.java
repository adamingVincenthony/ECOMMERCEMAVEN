package fr.adaming.service;

import java.util.List;


import fr.adaming.dao.IMagasinDao;
import fr.adaming.entities.Categorie;
import fr.adaming.entities.Produit;
/**
 * 
 * @author Vincent Bonillo & Anthony Josseaume
 *@see IMagasinDao
 */

public interface IMagasinService {

	public List<Categorie> getAllCategoriesService();
	
	public List<Produit> getAllProduitsByIdCategorieService(long id_cat);
	
	public List<Produit> getAllProduitsByKeyWordService(String keyWord);
}
