<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<label for="nomClient">Enseigne Fournisseur<span class="requis">*</span></label>
<input type="text" id="enseigne" name="enseigne" value="<c:out value="${fournisseur.enseigne}"/>" size="30" maxlength="30" required />
<span class="erreur">${form.erreurs['enseigne']}</span>
<br />

<label for="prenomClient">SIRET<span class="requis">*</span></label>
<input type="text" id="siret" name="siret" value="<c:out value="${fournisseur.siret}"/>" size="30" maxlength="30" required />
<span class="erreur">${form.erreurs['siret']}</span>
<br />

<label for="adresseClient">Adresse<span class="requis">*</span></label>
<input type="text" id="adresse" name="adresse" value="<c:out value="${fournisseur.adresse}"/>" size="30" maxlength="60" required />
<span class="erreur">${form.erreurs['adresse']}</span>
<br />

<label for="adresseClient">Code Postal<span class="requis">*</span></label>
<input type="text" id="cp" name="cp" value="<c:out value="${fournisseur.cp}"/>" size="30" maxlength="60" required />
<span class="erreur">${form.erreurs['cp']}</span>
<br />

<label for="adresseClient">Ville<span class="requis">*</span></label>
<input type="text" id="ville" name="ville" value="<c:out value="${fournisseur.ville}"/>" size="30" maxlength="60" required />
<span class="erreur">${form.erreurs['ville']}</span>
<br />

<label for="adresseClient">Pays<span class="requis">*</span></label>
<input type="text" id="pays" name="pays" value="<c:out value="${fournisseur.pays}"/>" size="30" maxlength="60" required />
<span class="erreur">${form.erreurs['pays']}</span>
<br />

<label for="telephoneClient">Numéro de téléphone <span class="requis">*</span></label>
<input type="text" id="telephone" name="telephone" value="<c:out value="${fournisseur.telephone}"/>" size="30" maxlength="30" />
<span class="erreur">${form.erreurs['telephone']}</span>
<br />

<label for="emailClient">Adresse email</label>
<input type="email" id="email" name="email" value="<c:out value="${fournisseur.email}"/>" size="30" maxlength="60" />
<span class="erreur">${form.erreurs['email']}</span>
<br />
