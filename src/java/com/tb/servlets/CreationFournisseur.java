/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tb.servlets;

import com.tb.beans.Fournisseur;
import com.tb.dao.DAOFactory;
import com.tb.dao.FournisseurDAO;
import com.tb.forms.CreationFournisseurForm;
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
public class CreationFournisseur extends HttpServlet {
    
    public static final String CONF_DAO_FACTORY = "daofactory";
    public static final String CHEMIN           = "chemin";
    public static final String ATT_FOURNISSEUR       = "fournisseur";
    public static final String ATT_FORM         = "form";
    public static final String SESSION_FOURNISSEURS  = "fournisseurs";

    public static final String VUE_SUCCES       = "/WEB-INF/afficherFournisseur.jsp";
    public static final String VUE_FORM         = "/WEB-INF/creerFournisseur.jsp";

    private FournisseurDAO          fournisseurDAO;

    public void init() throws ServletException {
        /* Récupération d'une instance de notre DAO Utilisateur */
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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CreationFournisseur</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CreationFournisseur at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
       /* À la réception d'une requête GET, simple affichage du formulaire */
        this.getServletContext().getRequestDispatcher( VUE_FORM ).forward( request, response );
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
        CreationFournisseurForm form = new CreationFournisseurForm( fournisseurDAO );

        /* Traitement de la requête et récupération du bean en résultant */
        Fournisseur fournisseur = form.creerFournisseur( request, chemin );

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
            /* Puis ajout du client courant dans la map */
            fournisseurs.put( fournisseur.getCode_fou(), fournisseur );
            /* Et enfin (ré)enregistrement de la map en session */
            session.setAttribute( SESSION_FOURNISSEURS, fournisseurs );

            /* Affichage de la fiche récapitulative */
            this.getServletContext().getRequestDispatcher( VUE_SUCCES ).forward( request, response );
        } else {
            /* Sinon, ré-affichage du formulaire de création avec les erreurs */
            this.getServletContext().getRequestDispatcher( VUE_FORM ).forward( request, response );
        }
    }
    }

  