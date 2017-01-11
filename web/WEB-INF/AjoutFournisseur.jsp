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
        <title>ToutBois - Gestion des fournisseurs</title>
    </head>
    <body>
        <c:import url="/inc/header.jsp" />
        
        <div>
            <form method="post" action="<c:url value="/CreationClientServlet"/>">
                <fieldset>
                    <legend>Informations client</legend>
    
                   <c:import url="/inc/fournisseurform.jsp" />
                </fieldset>
                <p class="info">${ form.resultat }</p>
                <input type="submit" value="Valider"  />
                <input type="reset" value="Remettre à zéro" /> <br />
            </form>
        </div>
                
        
        <c:import url="/inc/footer.jsp" />
    </body>
</html>
