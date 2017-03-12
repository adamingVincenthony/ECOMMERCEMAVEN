package fr.adaming.dao;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.hibernate.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.entities.Admin;
import fr.adaming.entities.Categorie;
import fr.adaming.entities.Client;
import fr.adaming.entities.Produit;


/**
 * 
 * @author Anthony Josseaume
 *@see IAdminDao
 */
@Repository
public class AdminDaoImpl implements IAdminDao{

	
	@Autowired
	private SessionFactory sf;

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	
	@Override
	public Admin isExist(Admin a) {
		String req="select a from Admin a where a.nom=:pNom and a.mdp=:pMdp";
		Session s=sf.getCurrentSession();
		Query query= s.createQuery(req);
		query.setParameter("pNom", a.getNom());
		query.setParameter("pMdp", a.getMdp());
		
		List<Admin> listeAdmins=query.list();
		if(listeAdmins.size()!=0){
			Admin adminRetour=listeAdmins.get(0);
			return adminRetour;
		}else{
			return null;
		}
	}

	@Override
	public Categorie ajouterCategorie(Categorie c) {
		Session s=sf.getCurrentSession();
		s.save(c);
		return null;
	}

	@Override
	public Produit ajouterProduit(Produit p) {
		Session s=sf.getCurrentSession();
		s.save(p);
		return null;
	}

	@Override
	public void supprimerProduit(long id_p) {
		Session s=sf.getCurrentSession();
		s.delete(s.get(Produit.class, id_p));
	}

	@Override
	public Produit modifierProduit(Produit p) {
		Session s=sf.getCurrentSession();
		Produit pTemp=(Produit) s.get(Produit.class, p.getId_produit());
		pTemp.setDesignation(p.getDesignation());
		pTemp.setDescription(p.getDescription());
		pTemp.setPrix(p.getPrix());
		pTemp.setCategorieProduit(p.getCategorieProduit());
		s.update(p);
		return null;
	}

	@Override
	public List<Produit> getAllProduit() {
		Session s=sf.getCurrentSession();
		String req="select p from Produit p";
		Query query= s.createQuery(req);
		List<Produit> listeP=query.list();
		
		return listeP;
	}

	@Override
	public Produit getById(long id_p) {
		Session s=sf.getCurrentSession();
		return (Produit) s.get(Produit.class, id_p);
	}

	@Override
	public Client enregistrerClient(Client cl) {
		Session s=sf.getCurrentSession();
		s.save(cl);
		return null;
	}

}
