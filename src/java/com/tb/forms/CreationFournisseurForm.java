/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tb.forms;

import com.tb.beans.Fournisseur;
import com.tb.dao.DAOException;
import com.tb.dao.FournisseurDAO;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
/**
 *
 * @author sociepka
 */


public final class CreationFournisseurForm {
    private static final String CHAMP_ENSEIGNE  = "enseigne";
    private static final String CHAMP_SIRET     = "siret";
    private static final String CHAMP_ADRESSE   = "adresse";
    private static final String CHAMP_TELEPHONE = "telephone";
    private static final String CHAMP_EMAIL     = "email";
    private static final String CHAMP_CP        = "cp";
    private static final String CHAMP_VILLE     = "ville";
    private static final String CHAMP_PAYS      = "pays";

    private static final int    TAILLE_TAMPON   = 10240;                        // 10ko

    private String              resultat;
    private Map<String, String> erreurs         = new HashMap<String, String>();
    private FournisseurDAO           fournisseurDAO;

    public CreationFournisseurForm( FournisseurDAO fournisseurDAO ) {
        this.fournisseurDAO = fournisseurDAO;
    }

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public String getResultat() {
        return resultat;
    }

    public Fournisseur creerFournisseur( HttpServletRequest request, String chemin ) {
        String enseigne = getValeurChamp( request, CHAMP_ENSEIGNE );
        String siret = getValeurChamp( request, CHAMP_SIRET );
        String adresse = getValeurChamp( request, CHAMP_ADRESSE );
        String telephone = getValeurChamp( request, CHAMP_TELEPHONE );
        String email = getValeurChamp( request, CHAMP_EMAIL );
        String cp = getValeurChamp( request, CHAMP_CP );
        String ville = getValeurChamp( request, CHAMP_VILLE );
        String pays = getValeurChamp( request, CHAMP_PAYS );
       

        Fournisseur fournisseur = new Fournisseur();

        traiterEnseigne( enseigne, fournisseur );
        traiterSiret( siret, fournisseur );
        traiterAdresse( adresse, fournisseur );
        traiterTelephone( telephone, fournisseur );
        traiterEmail( email, fournisseur );
        traiterVille( ville, fournisseur );
        traiterCp( cp, fournisseur );
        traiterPays( pays, fournisseur );

        try {
            if ( erreurs.isEmpty() ) {
                fournisseurDAO.creer( fournisseur );
                resultat = "Succès de la création du fournisseur.";
            } else {
                resultat = "Échec de la création du fournisseur.";
            }
        } catch ( DAOException e ) {
            setErreur( "imprévu", "Erreur imprévue lors de la création." );
            resultat = "Échec de la création du client : une erreur imprévue est survenue, merci de réessayer dans quelques instants.";
            e.printStackTrace();
        }

        return fournisseur;
    }

    private void traiterEnseigne( String enseigne, Fournisseur fournisseur ) {
        try {
            validationEnseigne( enseigne );
        } catch ( FormValidationException e ) {
            setErreur( CHAMP_ENSEIGNE, e.getMessage() );
        }
        fournisseur.setEnseigne( enseigne );
    }

    private void traiterSiret( String siret, Fournisseur fournisseur ) {
        try {
            validationSiret( siret );
        } catch ( FormValidationException e ) {
            setErreur( CHAMP_SIRET, e.getMessage() );
        }
        fournisseur.setSiret( siret );
    }

    private void traiterAdresse( String adresse, Fournisseur fournisseur ) {
        try {
            validationAdresse( adresse );
        } catch ( FormValidationException e ) {
            setErreur( CHAMP_ADRESSE, e.getMessage() );
        }
        fournisseur.setAdresse( adresse );
    }

    private void traiterTelephone( String telephone, Fournisseur fournisseur ) {
        try {
            validationTelephone( telephone );
        } catch ( FormValidationException e ) {
            setErreur( CHAMP_TELEPHONE, e.getMessage() );
        }
        fournisseur.setTelephone( telephone );
    }

    private void traiterEmail( String email, Fournisseur fournisseur ) {
        try {
            validationEmail( email );
        } catch ( FormValidationException e ) {
            setErreur( CHAMP_EMAIL, e.getMessage() );
        }
        fournisseur.setEmail( email );
    }

    private void traiterVille( String ville, Fournisseur fournisseur ) {
        try {
            validationVille(ville );
        } catch ( FormValidationException e ) {
            setErreur( CHAMP_VILLE, e.getMessage() );
        }
        fournisseur.setEmail( ville );
    }
    
    private void traiterCp( String cp, Fournisseur fournisseur ) {
        try {
            validationCp( cp );
        } catch ( FormValidationException e ) {
            setErreur( CHAMP_CP, e.getMessage() );
        }
        fournisseur.setCp( cp );
    }
    
    private void traiterPays( String pays, Fournisseur fournisseur ) {
        try {
            validationPays( pays );
        } catch ( FormValidationException e ) {
            setErreur( CHAMP_PAYS, e.getMessage() );
        }
        fournisseur.setPays( pays );
    }

    private void validationEnseigne( String enseigne ) throws FormValidationException {
        if ( enseigne != null ) {
            if ( enseigne.length() < 2 ) {
                throw new FormValidationException( "Le nom de l'enseigne doit contenir au moins 2 caractères." );
            }
        } else {
            throw new FormValidationException( "Merci d'entrer un nom d'enseigne." );
        }
    }

    private void validationSiret( String siret ) throws FormValidationException {
        if ( siret != null && siret.length() < 12 ) {
            throw new FormValidationException( "Le SIRET doit contenir 12 chiffres." );
        }
    }

    private void validationAdresse( String adresse ) throws FormValidationException {
        if ( adresse != null ) {
            if ( adresse.length() < 10 ) {
                throw new FormValidationException( "L'adresse doit contenir au moins 10 caractères." );
            }
        } else {
            throw new FormValidationException( "Merci d'entrer une adresse de livraison." );
        }
    }

    private void validationTelephone( String telephone ) throws FormValidationException {
        if ( telephone != null ) {
            if ( !telephone.matches( "^\\d+$" ) ) {
                throw new FormValidationException( "Le numéro de téléphone doit uniquement contenir des chiffres." );
            } else if ( telephone.length() < 4 ) {
                throw new FormValidationException( "Le numéro de téléphone doit contenir au moins 4 chiffres." );
            }
        } else {
            throw new FormValidationException( "Merci d'entrer un numéro de téléphone." );
        }
    }

    private void validationEmail( String email ) throws FormValidationException {
        if ( email != null && !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
            throw new FormValidationException( "Merci de saisir une adresse mail valide." );
        }
    }

    private void validationVille( String ville ) throws FormValidationException {
        if ( ville != null ) {
            if ( ville.length() < 2 ) {
                throw new FormValidationException( "Le nom de la ville doit contenir au moins 2 caractères." );
            }
        } else {
            throw new FormValidationException( "Merci d'entrer un nom de ville." );
        }
    }
    
     private void validationCp( String cp ) throws FormValidationException {
        if ( cp != null ) {
            if ( cp.length() < 2 ) {
                throw new FormValidationException( "Le code postal doit contenir au moins 2 caractères." );
            }
        } else {
            throw new FormValidationException( "Merci d'entrer un code postal." );
        }
    }
     
     private void validationPays( String pays ) throws FormValidationException {
        if ( pays != null ) {
            if ( pays.length() < 2 ) {
                throw new FormValidationException( "Le nom du pays doit contenir au moins 2 caractères." );
            }
        } else {
            throw new FormValidationException( "Merci d'entrer un nom de pays." );
        }
    } 

    /*
     * Ajoute un message correspondant au champ spécifié à la map des erreurs.
     */
    private void setErreur( String champ, String message ) {
        erreurs.put( champ, message );
    }

    /*
     * Méthode utilitaire qui retourne null si un champ est vide, et son contenu
     * sinon.
     */
    private static String getValeurChamp( HttpServletRequest request, String nomChamp ) {
        String valeur = request.getParameter( nomChamp );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur;
        }
    }

    /*
     * Méthode utilitaire qui a pour unique but d'analyser l'en-tête
     * "content-disposition", et de vérifier si le paramètre "filename" y est
     * présent. Si oui, alors le champ traité est de type File et la méthode
     * retourne son nom, sinon il s'agit d'un champ de formulaire classique et
     * la méthode retourne null.
     */
    private static String getNomFichier( Part part ) {
        /* Boucle sur chacun des paramètres de l'en-tête "content-disposition". */
        for ( String contentDisposition : part.getHeader( "content-disposition" ).split( ";" ) ) {
            /* Recherche de l'éventuelle présence du paramètre "filename". */
            if ( contentDisposition.trim().startsWith( "filename" ) ) {
                /*
                 * Si "filename" est présent, alors renvoi de sa valeur,
                 * c'est-à-dire du nom de fichier sans guillemets.
                 */
                return contentDisposition.substring( contentDisposition.indexOf( '=' ) + 1 ).trim().replace( "\"", "" );
            }
        }
        /* Et pour terminer, si rien n'a été trouvé... */
        return null;
    }

    /*
     * Méthode utilitaire qui a pour but d'écrire le fichier passé en paramètre
     * sur le disque, dans le répertoire donné et avec le nom donné.
     */
    private void ecrireFichier( InputStream contenuFichier, String nomFichier, String chemin )
            throws FormValidationException {
        /* Prépare les flux. */
        BufferedInputStream entree = null;
        BufferedOutputStream sortie = null;
        try {
            /* Ouvre les flux. */
            entree = new BufferedInputStream( contenuFichier, TAILLE_TAMPON );
            sortie = new BufferedOutputStream( new FileOutputStream( new File( chemin + nomFichier ) ),
                    TAILLE_TAMPON );

            /*
             * Lit le fichier reçu et écrit son contenu dans un fichier sur le
             * disque.
             */
            byte[] tampon = new byte[TAILLE_TAMPON];
            int longueur = 0;
            while ( ( longueur = entree.read( tampon ) ) > 0 ) {
                sortie.write( tampon, 0, longueur );
            }
        } catch ( Exception e ) {
            throw new FormValidationException( "Erreur lors de l'écriture du fichier sur le disque." );
        } finally {
            try {
                sortie.close();
            } catch ( IOException ignore ) {
            }
            try {
                entree.close();
            } catch ( IOException ignore ) {
            }
        }
    }
}