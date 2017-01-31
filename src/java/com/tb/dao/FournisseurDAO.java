/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tb.dao;

import com.tb.beans.Fournisseur;
import java.util.List;
/**
 *
 * @author sociepka
 */
public interface FournisseurDAO {
    void creer(Fournisseur fournisseur) throws DAOException;
    Fournisseur trouver(Long code_fou) throws DAOException;
    Fournisseur modifier(Fournisseur fournisseur) throws DAOException;
    List<Fournisseur> lister() throws DAOException;
    void supprimer( Fournisseur fournisseur ) throws DAOException;
}
