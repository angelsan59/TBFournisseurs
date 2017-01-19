<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <!-- Menu de haut de page -->
  <nav class="navbar navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <a class="navbar-brand" href="/ToutBoisFournisseurs">ToutBois</a>
    </div>
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav navbar-right">
        <li class="active"><a href="/ToutBoisFournisseurs">Accueil <span class="sr-only">(current)</span></a></li>
        <li><a href="CreationFournisseur">Ajout Fournisseurs</a></li>
		<li><a href="ListeFournisseurs">Liste Fournisseurs</a></li>
		
		
      </ul>
      <form class="navbar-form navbar-left">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="rechercher">
        </div>
        <button type="submit" class="btn btn-default">Ok</button>
      </form>
      
    </div>
  </div>
</nav>
<!-- fin menu -->