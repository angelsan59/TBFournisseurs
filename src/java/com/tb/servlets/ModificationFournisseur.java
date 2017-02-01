/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tb.servlets;

import com.tb.beans.Fournisseur;
import com.tb.dao.DAOFactory;
import com.tb.dao.FournisseurDAO;
import com.tb.forms.ModificationFournisseurForm;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author sociepka
 */
@WebServlet(name = "ModificationFournisseur", urlPatterns = {"/ModificationFournisseur"})
public class ModificationFournisseur extends HttpServlet {
    
    public static final String CONF_DAO_FACTORY = "daofactory";
    public static final String CHEMIN           = "chemin";
    public static final String ATT_FOURNISSEUR       = "fournisseur";
    public static final String ATT_FORM         = "form";
    public static final String SESSION_FOURNISSEURS  = "fournisseurs";
    public static final String PARAM_CODE_FOU  = "code_fou";
    public static final String VUE_SUCCES = "/WEB-INF/modFournisseur.jsp";
    public static final String VUE_FORM = "/WEB-INF/ModifieFournisseur.jsp";

    private FournisseurDAO          fournisseurDAO;

    public void init() throws ServletException {
        /* Récupération d'une instance de notre DAO Fournisseur */
        this.fournisseurDAO = ( (DAOFactory) getServletContext().getAttribute( CONF_DAO_FACTORY ) ).getFournisseurDAO();
    }
    
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
          
        
        }
    }

    /*
     * Méthode utilitaire qui retourne null si un paramètre est vide, et son
     * contenu sinon.
     */
    private static String getValeurParametre( HttpServletRequest request, String nomChamp ) {
        String valeur = request.getParameter( nomChamp );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur;
        }
        }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          String code_fou = getValeurParametre( request, PARAM_CODE_FOU );
        Long id = Long.parseLong( code_fou );

                Fournisseur fournisseur = fournisseurDAO.trouver( id );
               
        request.setAttribute( ATT_FOURNISSEUR, fournisseur );
           String enseigne = fournisseur.getEnseigne() ;
            
            System.out.println("Enseigne : " + enseigne);
             this.getServletContext().getRequestDispatcher( VUE_FORM ).forward( request, response );
  //  }
    }
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*
         * Lecture du paramètre 'chemin' passé à la servlet via la déclaration
         * dans le web.xml
         */
        String chemin = this.getServletConfig().getInitParameter( CHEMIN );
        
        /* Préparation de l'objet formulaire */
        ModificationFournisseurForm form = new ModificationFournisseurForm( fournisseurDAO );

        /* Traitement de la requête et récupération du bean en résultant */
        Fournisseur fournisseur = form.modifierFournisseur( request, chemin );

        /* Ajout du bean et de l'objet métier à l'objet requête */
        request.setAttribute( ATT_FOURNISSEUR, fournisseur );
        request.setAttribute( ATT_FORM, form );

        /* Si aucune erreur */
        if ( form.getErreurs().isEmpty() ) {
            /* Alors récupération de la map des clients dans la session */
            HttpSession session = request.getSession();
            Map<Long, Fournisseur> fournisseurs = (HashMap<Long, Fournisseur>) session.getAttribute( SESSION_FOURNISSEURS );
            /* Si aucune map n'existe, alors initialisation d'une nouvelle map */
            if ( fournisseurs == null ) {
                fournisseurs = new HashMap<Long, Fournisseur>();
            }
            fournisseurs.put( fournisseur.getCode_fou(), fournisseur );
            
            /* Et enfin (ré)enregistrement de la map en session */
            session.setAttribute( SESSION_FOURNISSEURS, fournisseurs );

            /* Affichage de la fiche récapitulative */
            System.out.println("vue succes peut etre");
            this.getServletContext().getRequestDispatcher( VUE_SUCCES ).forward( request, response );
        } else {
            /* Sinon, ré-affichage du formulaire de création avec les erreurs */
            this.getServletContext().getRequestDispatcher( VUE_FORM ).forward( request, response );
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
