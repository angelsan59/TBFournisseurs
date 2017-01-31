<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Liste des fournisseurs existants</title>
        
    </head>
    <body>
        <c:import url="/inc/header.jsp" />
        <div id="corps">
        <c:choose>
            <%-- Si aucun fournisseur n'existe en session, affichage d'un message par défaut. --%>
            <c:when test="${ empty sessionScope.fournisseurs }">
                <p class="erreur">Aucun fournisseur enregistré.</p>
            </c:when>
            <%-- Sinon, affichage du tableau. --%>
            <c:otherwise>
            
             <!-- liste des fournisseurs -->
              <div class="container">
            <div class='row'>
                <div class='col-md-8 col-sm-offset-2'>
                    <div class="panel-group" id="accordion">
                        

              <%-- Parcours de la Map des fournisseurs en session, et utilisation de l'objet varStatus. --%>
                <c:forEach items="${ sessionScope.fournisseurs }" var="mapFournisseurs" varStatus="boucle">
        
                        <div class="panel panel-default">
                            <div class="panel-heading">
      <h4 class="panel-title">
        <a data-toggle="collapse" data-parent="#accordion" href="#<c:out value="${ mapFournisseurs.value.code_fou }"></c:out>">
            <c:out value="${ mapFournisseurs.value.enseigne }"></c:out></a> 
            <span style="text-align:right;"> <a href="<c:url value="/ModificationFournisseur"><c:param name="code_fou" value="${ mapFournisseurs.key }" ></c:param></c:url>"><i class="fa fa-edit" style="font-size:24px;color:blue;"></i></a> 
          <a href="<c:url value="/SuppressionFournisseur"><c:param name="code_fou" value="${ mapFournisseurs.key }" ></c:param></c:url>"  onclick="return confirm('Etes-vous sûr ?');">
              <i class="fa fa-times-circle" style="font-size:24px;color:red;"></i></a>
                </a></span>
      </h4>
                            </div>
                            <div id="<c:out value="${ mapFournisseurs.value.code_fou }"></c:out>" class="panel-collapse collapse">
      <div class="panel-body">
        SIRET <c:out value="${ mapFournisseurs.value.siret }"></c:out>  <br/>
        <i class="fa fa-home" style="font-size:24px"></i> <c:out value="${ mapFournisseurs.value.adresse }"></c:out>
                     <c:out value="${ mapFournisseurs.value.cp }"></c:out>
                     <c:out value="${ mapFournisseurs.value.ville }"></c:out>
                     <c:out value="${ mapFournisseurs.value.pays }"></c:out><br/>
        <i class="fa fa-phone" style="font-size:24px"></i> <c:out value="${ mapFournisseurs.value.telephone }"></c:out> 
        <i class="fa fa-envelope-o" style="font-size:24px"></i> <c:out value="${ mapFournisseurs.value.email }"></c:out><br/>
        
      </div>
    </div></div>
        
        </c:forEach>
                            
  </div>
  
</div>
</div>
</div>
   
  </c:otherwise>
        </c:choose>               

       
     <c:import url="/inc/footer.jsp" />
    </body>
</html>