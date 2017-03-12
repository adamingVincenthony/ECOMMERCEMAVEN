<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  	<link rel = "styleSheet" type= "text/css" href = "../../resources/css/commerceStyle.css"/>
    <script src="../../resources/js/commerceJs.js"></script>
<title>Accueil administrateur</title>
</head>
<body>

	<!-- Bloc header -->
	<jsp:include page="../../templates/header.jsp"></jsp:include>

	<!-- Barre de Menu -->
	<div class="w3-sidenav w3-white w3-card-2" style="width: 130px;">
		<div class="w3-container">
			<h2 class="menu">Menu</h2>
		</div>
		<ul class="nav nav-pills">
			<a href="accueilAdmin" class="tablink w3-green">Home Admin</a> 
			<a href="accueil" class="tablink">Home</a>
			<a href="ajouterP" class="tablink">Ajouter un produit</a> 
			<a href="ajouterC" class="tablink">Ajouter une catégorie</a>
			<a href="supprimerP" class="tablink">Supprimer un produit</a>
			<a href="modifierP" class="tablink">Modifier un produit</a>
		</ul>
	</div>
			
	<div style="margin-left: 200px; margin-top: 50px; ">
		<h3 style="w3-text-green">Vous êtes connecté en tant qu'administrateur.</h3>
		<h3 style="w3-text-green">Choisissez une opération à effectuer.</h3>
	</div>
	

</body>
</html>