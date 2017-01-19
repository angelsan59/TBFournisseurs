<%-- 
    Document   : index
    Created on : 11 janv. 2017, 13:32:14
    Author     : sociepka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tout Bois - Gestion des fournisseurs</title>
    </head>
    <body>
         <c:import url="/inc/header.jsp" />
      
         <!-- Liens principaux -->
         
    <div class="container">
        <div class="row">
            <div class="col-sm-6 text-center">
                
  <a href="CreationFournisseur" role="button" class="btn btn-primary btn-lg">Ajouter un fournisseur</a>

            </div>
            <div class="col-sm-6 text-center">
                
  <a href="ListeFournisseurs" role="button" class="btn btn-primary btn-lg">Liste des fournisseurs</a>
                
            </div>
        </div> 
    </div>
         
        <c:import url="/inc/footer.jsp" />
    </body>
</html>
