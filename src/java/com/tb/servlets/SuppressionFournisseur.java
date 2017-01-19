/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tb.servlets;

import com.tb.beans.Fournisseur;
import com.tb.dao.DAOException;
import com.tb.dao.DAOFactory;
import com.tb.dao.FournisseurDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author sociepka
 */
public class SuppressionFournisseur extends HttpServlet {
    
    public static final String CONF_DAO_FACTORY = "daofactory";
    public static final String PARAM_CODE_FOU  = "code_fou";
    public static final String SESSION_FOURNISSEURS  = "fournisseurs";

    public static final String VUE              = "/ListeFournisseurs";

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
            /* Récupération du paramètre */
        String code_fou = getValeurParametre( request, PARAM_CODE_FOU );
        Long id = Long.parseLong( code_fou );

        /* Récupération de la Map des clients enregistrés en session */
        HttpSession session = request.getSession();
        Map<Long, Fournisseur> fournisseurs = (HashMap<Long, Fournisseur>) session.getAttribute( SESSION_FOURNISSEURS );

        /* Si l'id du client et la Map des clients ne sont pas vides */
        if ( id != null && fournisseurs != null ) {
            try {
                /* Alors suppression du client de la BDD */
                fournisseurDAO.supprimer( fournisseurs.get( id ) );
                /* Puis suppression du client de la Map */
                fournisseurs.remove( id );
            } catch ( DAOException e ) {
                e.printStackTrace();
            }
            /* Et remplacement de l'ancienne Map en session par la nouvelle */
            session.setAttribute( SESSION_FOURNISSEURS, fournisseurs );
        }

        /* Redirection vers la fiche récapitulative */
        response.sendRedirect( request.getContextPath() + VUE );
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
        processRequest(request, response);
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
        processRequest(request, response);
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
