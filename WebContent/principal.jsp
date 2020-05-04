<%@page import="java.util.Vector"%>
<%@page import="org.formation.zoo.controleur.Manager"%>
<%@page import="org.formation.zoo.service.CagePOJO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Bienvenue DANS le ZOO</title>
<link rel="stylesheet" type="text/css" href="style.css"></link>
</head>
<body>

<header>
<img class="logoGauche" alt="" src="images/logo.png"/>
<img class="logoDroit" alt="" src="images/logo.png"/><p>Le zoo en folie</p>
</header>
<form name="fzoo" action="servlet.html" method="GET">
<nav>
<ul class="m">
	<li class="m"><a href="<%= request.getContextPath()+"/MangerServlet"%>">TOUT le monde mange (defaut)</a></li>
	
	<li class="m"><a href="<% request.getAttribute("devore");%>" onClick="fzoo.submit();">FAIRE manger les animaux selectionnes</a></li>
	<li class="m"><a href="#">Ajouter un animal</a></li>
	<li class="m"><a href="#">Supprimer un animal</a></li>
</ul>
</nav>
<article>
<%
 List<CagePOJO> zanimaux = null;
 zanimaux = (Vector)request.getAttribute("listeAnimal");
 String texte = null;

%>
<img  alt="mon zoo" src="images/plan.gif">

<%
for(int i = 0; i < zanimaux.size(); i++){
	texte = String.join("","<div id=\"animal", Integer.toString(i),"\" style=\"position:absolute;top:",
	Integer.toString(zanimaux.get(i).getY()), "px;left:", Integer.toString(zanimaux.get(i).getX()),"px\">");
	out.print(texte);
	texte = String.join("","<img alt=\"\" src=\"",zanimaux.get(i).getImage(),"\" class=\"animal\"/>");
	out.print(texte);
	texte = String.join("","<div class=\"afficheAnimal\" >",zanimaux.get(i).getPancarte(),"</div><br><input type=\"radio\" id=\"mangeur\" name=\"mangeur\" value=\"mangeur\">",
	"<label>Mangeur</label><br><input type=\"radio\" id=\"mange\" name=\"mange\" value=\"mange\"><label>Mange</label></div>");
	out.print(texte);
}
%>

<br>
<% out.print(request.getAttribute("devore")) ;%>

</article>
<footer>
Etat en temps reel...
</footer>
</form>
</body>
</html>
