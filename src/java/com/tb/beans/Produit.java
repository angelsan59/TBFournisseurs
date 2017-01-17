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
public class Produit {
    private int code_prod;
    private String designation;
    private String image;
    private double pu;
    private Fournisseur fournisseur;

    public int getCode_prod() {
        return code_prod;
    }

    public void setCode_prod(int code_prod) {
        this.code_prod = code_prod;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getPu() {
        return pu;
    }

    public void setPu(double pu) {
        this.pu = pu;
    }

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }
    
    
}
