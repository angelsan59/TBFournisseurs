<%-- 
    Document   : GestionFournisseurs
    Created on : 17 janv. 2017, 10:37:46
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
        
         <!-- Search box -->
         <div class="container">
            <div class="row">
	
                <div id="custom-search-input">
                    <div class="input-group col-md-3">
                        <input type="text" class="  search-query form-control" placeholder="Chercher un fournisseur" />
                            <span class="input-group-btn">
                                <button class="btn btn-danger" type="button">
                                    <span class=" glyphicon glyphicon-search"></span>
                                </button>
                            </span>
                    </div>
                </div>
            </div>
        </div>
        <!-- fin search box -->
        
        <!-- liste des fournisseurs -->
        <div class="container">
            <div class='row'>
                <div class='col-md-12'>
                    <div class="panel-group" id="accordion">
                        <div class="panel panel-default">
                            <div class="panel-heading">
      <h4 class="panel-title">
        <a data-toggle="collapse" data-parent="#accordion" href="#ikea">
          Ikea <i class="fa fa-edit" style="font-size:24px"></i> <i class="fa fa-times-circle" style="font-size:24px"></i>
        </a>
      </h4>
                            </div>
                            <div id="ikea" class="panel-collapse collapse in">
      <div class="panel-body">
        SIRET 1234567845654  <br/>
        <i class="fa fa-home" style="font-size:24px"></i> 10 rue du Carrefour 59874 lomme France<br/>
        <i class="fa fa-phone" style="font-size:24px"></i> 0320154878 <i class="fa fa-envelope-o" style="font-size:24px"></i> lomm@ikea.fr<br/>
        
      </div>
    </div>
  </div>
  <div class="panel panel-default">
    <div class="panel-heading">
      <h4 class="panel-title">
        <a data-toggle="collapse" data-parent="#accordion" href="#szukaj">
          Znajdź nowych znajomych
        </a>
      </h4>
    </div>
    <div id="szukaj" class="panel-collapse collapse">
      <div class="panel-body">
        ... wyszukiwarka ...
      </div>
    </div>
  </div>
  <div class="panel panel-default">
    <div class="panel-heading">
      <h4 class="panel-title">
        <a data-toggle="collapse" data-parent="#accordion" href="#zaproszenia">
          Przejrzyj zaproszenia
        </a>
      </h4>
    </div>
    <div id="zaproszenia" class="panel-collapse collapse">
      <div class="panel-body">
        ... zaproszenia ...
      </div>
    </div>
  </div>
</div>
</div>
</div>
</div>        
        
 
        
<div class="container">
  <h2>Simple Collapsible</h2>
  <p>Click on the button to toggle between showing and hiding content.</p>
  <button type="button" class="btn btn-info" data-toggle="collapse" data-target="#demo">Simple collapsible</button>
  <div id="demo" class="collapse">
    Lorem ipsum dolor sit amet, consectetur adipisicing elit,
    sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
    quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
  </div>
</div>
        
        
        
         <c:import url="/inc/footer.jsp" />
    </body>
</html>
