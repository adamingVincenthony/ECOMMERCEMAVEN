<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link rel = "styleSheet" type= "text/css" href = "resources/css/commerceStyle.css"/>
    <script src="resources/js/commerceJs.js"></script>
	<title>Login</title>
</head>
<body>
	<div style="margin-left: 600px; margin-top: 170px">
		<h1 style="color: lightsalmon ; text-align: left;">Veuillez vous connecter</h1><br/>
		<form>
			<table columns="3">
					Nom:
					<h:inputText id="nom_id" value="#{adminMB.admin.nom}"
					required="true" label="nom" styleClass="w3-border w3-round w3-border-grey"></h:inputText>
					<h:message for="nom_id" style="color: vermillon"></h:message>
					Password:
					<h:inputSecret id="password_id"
					value="#{adminMB.admin.mdp}" required="true"
					label="password" styleClass="w3-border w3-round w3-border-grey"></h:inputSecret>
					<h:message for="password_id" style="color: vermillon"></h:message>

				<h:message for="password_id" style="color: vermillon"></h:message>
				<br/>

			</table>
			<h:commandButton value="Se connecter" styleClass="w3-btn btnLog" 
				action="#{adminMB.connecter}" />
			<h:messages style="color: red" />
		</form>
	</div>
</body>
</html>