<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
	<link rel = "styleSheet" type= "text/css" href = "../../resources/css/commerceStyle.css"/>
    <script src="../../resources/js/commerceJs.js"></script>
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
			<a href="modiffierP" class="tablink">Modifier un produit</a>
		</ul>
	</div>
	
	<h1 align="center">Formulaire d'ajout du client</h1>

	<form:form method="POST" action="soumettreFormAjouterProduit"  modelAttribute="produitForm">
		<!-- commandName ou  modelAttribute -->
		<table>
			<tr>
				<td><form:label path="id_produit">Identifiant : </form:label></td>
				<td><form:input path="id_produit"/></td>
				<td><form:errors path="id_produit" cssStyle="color:red"/> </td>
			</tr>
			<tr>
				<td><form:label path="designation">Désignation: </form:label></td>
				<td><form:input path="designation"/></td>
				<td><form:errors path="designation" cssStyle="color:red"/> </td>
			</tr>
			<tr>
				<td><form:label path="description">Description: </form:label></td>
				<td><form:input path="description"/></td>
				<td><form:errors path="description" cssStyle="color:red"/> </td>
			</tr>
			<tr>
				<td><form:label path="prix">Prix: </form:label></td>
				<td><form:input path="prix"/></td>
				<td><form:errors path="prix" cssStyle="color:red"/> </td>
			</tr>
			<tr>
				<td><form:label path="quantite">Quantité: </form:label></td>
				<td><form:input path="quantite"/></td>
				<td><form:errors path="quantite" cssStyle="color:red"/> </td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="value"/></td>
			</tr>
		</table>
	</form:form>
	
</body>
</html>