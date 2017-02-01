<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Affichage d'un fournisseurt</title>
    </head>
    <body>
       <c:import url="/inc/header.jsp" />
        
 <!-- Affichage de la fiche du fournisseur entré -->
 
 <div class="container">
            <div class='row'>
                <div class='col-md-8 col-sm-offset-2 alert alert-success'>
                    Le fournisseur a été modifié avec succès. Retrouvez ses détails ci-dessous :
                </div>
            </div>
            <div class='row'>
                <div class='col-md-8 col-sm-offset-2'>
                    
    <div class="panel panel-default">
        <div class="panel-heading"><b><c:out value="${ fournisseur.enseigne }"/></b></div>
        <div class="panel-body">
            Siret : <c:out value="${ fournisseur.siret }"/><br/>
            <i class="fa fa-address-card-o" style="font-size:24px;margin:10px;"></i> <c:out value="${ fournisseur.adresse }"/>  <c:out value="${ fournisseur.cp }"/>  
                <c:out value="${ fournisseur.ville }"/>  <c:out value="${ fournisseur.pays }"/><br/>
                <i class="fa fa-phone" style="font-size:24px;margin:10px;"></i> <c:out value="${ fournisseur.telephone }"/><br/>
                <i class="fa fa-envelope-o" style="font-size:24px;margin:10px;"></i> <c:out value="${ fournisseur.email }"/>
        </div>
    </div>   
    </div></div>
        <div class='row'>
            <div class="col-sm-12 text-center">
                
  <a href="ListeFournisseurs" role="button" class="btn btn-primary btn-lg">Liste des fournisseurs</a>
                
            </div>
        </div>
 </div>  
     <c:import url="/inc/footer.jsp" />
    </body>
</html>
