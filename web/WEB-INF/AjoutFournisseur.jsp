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
                <div class="info alerte">${ form.resultat }</div>
            <form method="post" action="<c:url value="/CreationFournisseur"/>">
                <fieldset>
                    <legend>Ajouter un Fournisseur</legend>
    
                   <label for="nomClient">Enseigne Fournisseur<span class="requis">*</span></label>
<input type="text" id="enseigne" name="enseigne" value="<c:out value="${fournisseur.enseigne}"/>" size="30" maxlength="30" required />
<div class="erreur">${form.erreurs['enseigne']}</div>

<label for="prenomClient">SIRET<span class="requis">*</span></label>
<input type="text" id="siret" name="siret" value="<c:out value="${fournisseur.siret}"/>" size="30" maxlength="30" required />
<div class="erreur">${form.erreurs['siret']}</div>

<label for="adresseClient">Adresse<span class="requis">*</span></label>
<input type="text" id="adresse" name="adresse" value="<c:out value="${fournisseur.adresse}"/>" size="30" maxlength="60" required />
<div class="erreur">${form.erreurs['adresse']}</div>

<label for="adresseClient">Code Postal<span class="requis">*</span></label>
<input type="text" id="cp" name="cp" value="<c:out value="${fournisseur.cp}"/>" size="30" maxlength="60" required />
<div class="erreur">${form.erreurs['cp']}</div>

<label for="adresseClient">Ville<span class="requis">*</span></label>
<input type="text" id="ville" name="ville" value="<c:out value="${fournisseur.ville}"/>" size="30" maxlength="60" required />
<div class="erreur">${form.erreurs['ville']}</div>

<label for="adresseClient">Pays<span class="requis">*</span></label>
<input type="text" id="pays" name="pays" value="<c:out value="${fournisseur.pays}"/>" size="30" maxlength="60" required />
<div class="erreur">${form.erreurs['pays']}</div>

<label for="telephoneClient">Numéro de téléphone <span class="requis">*</span></label>
<input type="text" id="telephone" name="telephone" value="<c:out value="${fournisseur.telephone}"/>" size="30" maxlength="30" />
<div class="erreur">${form.erreurs['telephone']}</div>

<label for="emailClient">Adresse email</label>
<input type="email" id="email" name="email" value="<c:out value="${fournisseur.email}"/>" size="30" maxlength="60" />
<div class="erreur">${form.erreurs['email']}</div>
<input type="hidden" id="code_fou" name="code_fou" value="<c:out value="${fournisseur.code_fou}"/>"/>
                </fieldset>
               
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
