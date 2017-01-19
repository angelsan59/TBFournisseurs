/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tb.filters;

import com.tb.beans.Fournisseur;
import com.tb.dao.DAOFactory;
import com.tb.dao.FournisseurDAO;
import static com.tb.servlets.SuppressionFournisseur.CONF_DAO_FACTORY;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author sociepka
 */
public class PrechargementFilter implements Filter {
    public static final String CONF_DAO_FACTORY      = "daofactory";
    public static final String ATT_SESSION_FOURNISSEURS   = "fournisseurs";

    private FournisseurDAO          fournisseurDAO;

    public void init( FilterConfig config ) throws ServletException {
        /* Récupération d'une instance de la DAO Fournisseurs */
       this.fournisseurDAO = ( (DAOFactory) config.getServletContext().getAttribute( CONF_DAO_FACTORY ) ).getFournisseurDAO();
    }

    public void doFilter( ServletRequest req, ServletResponse res, FilterChain chain ) throws IOException,
            ServletException {
        /* Cast de l'objet request */
        HttpServletRequest request = (HttpServletRequest) req;

        /* Récupération de la session depuis la requête */
        HttpSession session = request.getSession();

        /*
         * Si la map des clients n'existe pas en session, alors l'utilisateur se
         * connecte pour la première fois et nous devons précharger en session
         * les infos contenues dans la BDD.
         */
        if ( session.getAttribute( ATT_SESSION_FOURNISSEURS ) == null ) {
            /*
             * Récupération de la liste des fournisseurs existants, et enregistrement
             * en session
             */
            List<Fournisseur> listeFournisseurs = fournisseurDAO.lister();
            Map<Long, Fournisseur> mapFournisseurs = new HashMap<Long, Fournisseur>();
            for ( Fournisseur fournisseur : listeFournisseurs ) {
                mapFournisseurs.put( fournisseur.getCode_fou(), fournisseur );
            }
            session.setAttribute( ATT_SESSION_FOURNISSEURS, mapFournisseurs );
        }


        /* Pour terminer, poursuite de la requête en cours */
        chain.doFilter( request, res );
    }

    public void destroy() {
    }
}