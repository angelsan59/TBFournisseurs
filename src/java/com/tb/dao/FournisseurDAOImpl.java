/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tb.dao;

import com.tb.beans.Fournisseur;
import static com.tb.dao.DAOUtilitaire.fermeturesSilencieuses;
import static com.tb.dao.DAOUtilitaire.initialisationRequetePreparee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sociepka
 */
public class FournisseurDAOImpl implements FournisseurDAO {
    private DAOFactory          daoFactory;
    
    // requetes
    private static final String SQL_SELECT_PAR_CODE_FOU = "SELECT * FROM fournisseur WHERE code_fou = ?";
    private static final String SQL_INSERT = "INSERT INTO fournisseur (enseigne,adresse,cp,ville,pays,email,telephone,siret) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_SELECT        = "SELECT * FROM fournisseur ORDER BY code_fou";
    private static final String SQL_DELETE_PAR_CODE_FOU = "DELETE FROM fournisseur WHERE code_fou = ?";

    // Mapping entre le bean Fournisseur et la table fournisseur
    private static Fournisseur map( ResultSet resultSet ) throws SQLException {
    Fournisseur fournisseur = new Fournisseur();
    fournisseur.setCode_fou( resultSet.getLong( "code_fou" ) );
    fournisseur.setEnseigne( resultSet.getString( "enseigne" ) );
    fournisseur.setAdresse( resultSet.getString( "adresse" ) );
    fournisseur.setCp( resultSet.getString( "cp" ) );
    fournisseur.setVille( resultSet.getString( "ville" ) );
    fournisseur.setPays( resultSet.getString( "pays" ) );
    fournisseur.setEmail( resultSet.getString( "email" ) );
    fournisseur.setTelephone( resultSet.getString( "telephone" ) );
    fournisseur.setSiret( resultSet.getString( "siret" ) );
    return fournisseur;
}

    // Constructeur de FournisseurDAOImpl
    FournisseurDAOImpl( DAOFactory daoFactory ) {
        this.daoFactory = daoFactory;
    }

    // Méthode pour ajouter un fournisseur
     @Override
    public void creer( Fournisseur fournisseur ) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet valeursAutoGenerees = null;

    try {
        /* Récupération d'une connexion depuis la Factory */
        connexion = daoFactory.getConnection();
        preparedStatement = initialisationRequetePreparee( connexion, SQL_INSERT, true, 
                fournisseur.getEnseigne(), fournisseur.getAdresse(), fournisseur.getCp(), 
                fournisseur.getVille(), fournisseur.getPays(), fournisseur.getEmail(), 
                fournisseur.getTelephone(), fournisseur.getSiret());
        int statut = preparedStatement.executeUpdate();
        /* Analyse du statut retourné par la requête d'insertion */
        if ( statut == 0 ) {
            throw new DAOException( "Échec de la création du fournisseur, aucune ligne ajoutée dans la table." );
        }
        /* Récupération de l'id auto-généré par la requête d'insertion */
        valeursAutoGenerees = preparedStatement.getGeneratedKeys();
        if ( valeursAutoGenerees.next() ) {
            /* Puis initialisation de la propriété id du bean Fournisseur avec sa valeur */
            fournisseur.setCode_fou( valeursAutoGenerees.getLong( 1 ) );
        } else {
            throw new DAOException( "Échec de la création du fournisseur en base, aucun ID auto-généré retourné." );
        }
    } catch ( SQLException e ) {
        throw new DAOException( e );
    } finally {
        fermeturesSilencieuses( valeursAutoGenerees, preparedStatement, connexion );
    }
    }
    
     // Méthode pour trouver un fournisseur par code_fou
    @Override
    public Fournisseur trouver( long code_fou ) throws DAOException {
        return trouver( SQL_SELECT_PAR_CODE_FOU, code_fou );

    }
    
     // Méthode pour modifier un fournisseur
    @Override
    public Fournisseur modifier( long code_fou ) throws DAOException {
        return null;
    }
   
     // Méthode pour supprimer un fournisseur
    @Override
    public void supprimer( Fournisseur fournisseur ) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee( connexion, SQL_DELETE_PAR_CODE_FOU, true, fournisseur.getCode_fou() );
            int statut = preparedStatement.executeUpdate();
            if ( statut == 0 ) {
                throw new DAOException( "Échec de la suppression du fournisseur, aucune ligne supprimée de la table." );
            } else {
                fournisseur.setCode_fou( null );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( preparedStatement, connexion );
        }
    }
    
     // Méthode pour donner la liste des fournisseurs
    @Override
    public List<Fournisseur> lister() throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Fournisseur> fournisseurs = new ArrayList<Fournisseur>();

        try {
            connection = daoFactory.getConnection();
            preparedStatement = connection.prepareStatement( SQL_SELECT );
            resultSet = preparedStatement.executeQuery();
            while ( resultSet.next() ) {
                fournisseurs.add( map( resultSet ) );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( resultSet, preparedStatement, connection );
        }

        return fournisseurs;
    }
}

