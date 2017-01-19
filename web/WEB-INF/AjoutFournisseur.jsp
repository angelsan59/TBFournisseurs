<%-- 
    Document   : GestionFournisseur
    Created on : 11 janv. 2017, 14:52:47
    Author     : sociepka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ToutBois - Ajout de fournisseurs</title>
    </head>
    <body>
        <c:import url="/inc/header.jsp" />
        
        <div class="container">
        <div class="row">
            <div class="col-sm-6 col-sm-offset-2">
            <form method="post" action="<c:url value="/CreationFournisseur"/>">
                <fieldset>
                    <legend>Informations Fournisseur</legend>
    
                   <c:import url="/inc/fournisseurform.jsp" />
                </fieldset>
                <p class="info">${ form.resultat }</p>
                <div class="text-center">
                    <input type="submit" class="btn btn-info" value="Valider"  />
                    <input type="reset" class="btn btn-info" value="Remettre à zéro" />
                </div>    <br />
            </form>
        </div>
        </div></div>        
        
        <c:import url="/inc/footer.jsp" />
    </body>
</html>
