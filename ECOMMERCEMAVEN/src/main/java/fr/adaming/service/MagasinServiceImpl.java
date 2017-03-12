package fr.adaming.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.adaming.dao.IMagasinDao;
import fr.adaming.entities.Categorie;
import fr.adaming.entities.Produit;
/**
 * 
 * @author Vincent Bonillo & Anthony Josseaume
 *@see IMagasinService
 */
@Service
public class MagasinServiceImpl implements IMagasinService {

//	@Autowired
	IMagasinDao magasinDao;
	
	
	public void setMagasinDao(IMagasinDao magasinDao) {
		this.magasinDao = magasinDao;
	}

	@Override
	public List<Categorie> getAllCategoriesService() {
		return magasinDao.getAllCategories();
	}

	@Override
	public List<Produit> getAllProduitsByIdCategorieService(long id_cat) {
		return magasinDao.getAllProduitsByIdCategorie(id_cat);
	}

	@Override
	public List<Produit> getAllProduitsByKeyWordService(String keyWord) {
		return magasinDao.getAllProduitsByKeyWord(keyWord);
	}

}
