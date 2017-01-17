/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tb.beans;

/**
 *
 * @author sociepka
 */
public class Commande {
    private int id_com;
    private String date_com;
    private String date_livr;
    private String statut;
    private Fournisseur fournisseur;
    private Produit produit;

    public int getId_com() {
        return id_com;
    }

    public void setId_com(int id_com) {
        this.id_com = id_com;
    }

    public String getDate_com() {
        return date_com;
    }

    public void setDate_com(String date_com) {
        this.date_com = date_com;
    }

    public String getDate_livr() {
        return date_livr;
    }

    public void setDate_livr(String date_livr) {
        this.date_livr = date_livr;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }
    
    
}
