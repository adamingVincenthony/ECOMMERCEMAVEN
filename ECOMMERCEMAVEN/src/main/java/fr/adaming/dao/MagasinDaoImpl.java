package fr.adaming.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.entities.Categorie;
import fr.adaming.entities.Produit;
/**
 * 
 * @author Anthony Josseaume
 *@see IMagasinDao
 */
@Repository
public class MagasinDaoImpl implements IMagasinDao {

	@Autowired
	private SessionFactory sf;

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	// Récupérer toutes les catégories.
	@Override
	public List<Categorie> getAllCategories() {
		String req = "select c from Categorie c";
		Session s=sf.getCurrentSession();
		Query query = s.createQuery(req);
		return query.list();
	}

	@Override
	public List<Produit> getAllProduitsByIdCategorie(long id_cat) {
		String req = "select p from Produit p where p.categorieProduit.idCategorie=:idProduit";
		Session s=sf.getCurrentSession();
		Query query = s.createQuery(req);
		query.setParameter("idProduit", id_cat);
		return query.list();
	}

	@Override
	public List<Produit> getAllProduitsByKeyWord(String keyWord) {
		String req = "select p from Produit p where p.designation like :pseudoKWord or p.description like :pseudoKWord";
		Session s=sf.getCurrentSession();
		Query query = s.createQuery(req);
		query.setParameter("pseudoKWord", keyWord);
		List<Produit> listeProduits = query.list();
		if (listeProduits.size() != 0) {
			return listeProduits;
		} else {
			return null;
		}
	}

}
