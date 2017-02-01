<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <!-- Menu de haut de page -->
  <nav class="navbar navbar-default navbar-fixed-top">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <a class="navbar-brand" href="/ToutBoisFournisseurs">ToutBois</a>
    </div>
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav navbar-right">
        <li class="active"><a href="http://localhost:88/ToutBoisFournisseurs/">Accueil <span class="sr-only">(current)</span></a></li>
        <li><a href="http://localhost:88/ToutBoisFournisseurs/CreationFournisseur">Nouveau fournisseur</a></li>
	<li><a href="http://localhost:88/ToutBoisFournisseurs/ListeFournisseurs">Gestion des fournisseurs</a></li>
        <li><a href="http://localhost:88/ToutBoisFournisseurs_lot2/CCommande.action">Nouvelle commande</a></li>
	<li><a href="http://localhost:88/ToutBoisFournisseurs_lot2/gestionCommandes">Gestion des commandes</a></li>	
      </ul>
      
      
    </div>
  </div>
</nav>
<!-- fin menu -->