package fr.adaming.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.adaming.entities.Categorie;
import fr.adaming.entities.Produit;
import fr.adaming.service.IAdminService;

@Controller
@RequestMapping("/app")
public class AdminController {

	@Autowired
	private IAdminService adminService;

	public void setAdminService(IAdminService adminService) {
		this.adminService = adminService;
	}

	//========================Gestion du logging=========================================

	@RequestMapping("/loginURL")
	public String pageLogin(){

		return "login";
	}
	
	@RequestMapping("/logoutURL")
	public String pageLogout(){

		return "login";
	}

	//========================Afficher Produits=========================================

	@RequestMapping(value= "/client/accueilAdmin", method = RequestMethod.GET)
	public String accueil(ModelMap model){

		List<Produit> listeProduit =adminService.getAllProduitService();
		model.addAttribute("listeProduit",listeProduit);
		return "accueilAdmin";
	}


	//========================Ajouter Produit=========================================
	//Afficher formulaire
	@RequestMapping(value = "/admin/ajouterP", method = RequestMethod.GET)
	public ModelAndView ajouterProduitFormulaire(){
		return new ModelAndView("soumettreAjouterP", "produitForm", new Produit());
	}

	//Soumettre formulaire
	@RequestMapping(value = "/admin/soumettreFormAjouterProduit", method = RequestMethod.POST)
	public String soumettreFormulaireAjouter( Model model, @ModelAttribute("produitForm") Produit produit, BindingResult resultatValidation){


		//Vérification de la saisie correcte
		if (resultatValidation.hasErrors()) {
			//Rester sur la meme page
			return "soumettreAjouterP";
		} else {
			//Appel de la méthode ajouter
			adminService.ajouterProduitService(produit);
			//MAJ de la liste
			List<Produit> listeProduit = adminService.getAllProduitService();
			model.addAttribute("listeProduit",listeProduit);
			return "accueil";
		}
	}


	//========================Supprimer Produit=========================================
	//Afficher formulaire
	@RequestMapping(value = "/admin/supprimerP", method = RequestMethod.GET)
	public String supprimerProduitFormulaire(){
		return "soumettreSupprimerP";
	}

	//Soumettre formulaire
	@RequestMapping(value = "/admin/soumettreFormSupprimerProduit", method = RequestMethod.GET)
	public String soumettreFormulaireSupprimer(Model model, @RequestParam("id_param") int id){
		adminService.supprimerProduitService(id);

		//MAJ de la liste
		List<Produit> listeProduit = adminService.getAllProduitService();
		model.addAttribute("listeProduit",listeProduit);
		return "accueil";
	}

	//========================Modifier Produit=========================================
	//Afficher formulaire
	@RequestMapping(value = "/admin/modifierP", method = RequestMethod.GET)
	public ModelAndView modifierEmployeFormulaire(){
		return new ModelAndView("soumettreModifierP", "produitForm", new Produit());
	}

	//Soumettre formulaire
	@RequestMapping(value = "/admin/soumettreFormModifierProduit", method = RequestMethod.POST)
	public String soumettreFormulaireModifier(Model model, Produit produit, BindingResult resultatValidation){


		if (resultatValidation.hasErrors()) {
			return "soumettreModifierP";
		} else {
			adminService.modifierProduitService(produit);

			//MAJ de la liste
			List<Produit> listeProduit = adminService.getAllProduitService();
			model.addAttribute("listeProduit",listeProduit);
			return "accueil";
		}
	}





	//====================Ajouter Categorie=============================================
	//Afficher formulaire
	@RequestMapping(value = "/superadmin/ajouterC", method = RequestMethod.GET)
	public ModelAndView ajouterCategorieFormulaire(){
		return new ModelAndView("soumettreAjouterC", "categorieForm", new Categorie());
	}

	//Soumettre formulaire
	@RequestMapping(value = "/superadmin/soumettreFormAjouterCategorie", method = RequestMethod.POST)
	public String soumettreFormulaireAjouterCategorie( Model model, @ModelAttribute("categorieForm") Categorie categorie, BindingResult resultatValidation){


		//Vérification de la saisie correcte
		if (resultatValidation.hasErrors()) {
			//Rester sur la meme page
			return "soumettreAjouterP";
		} else {
			//Appel de la méthode ajouter
			adminService.ajouterCategorieService(categorie);
			//MAJ de la liste
			List<Produit> listeProduit = adminService.getAllProduitService();
			model.addAttribute("listeProduit",listeProduit);
			return "accueil";
		}
	}








}




