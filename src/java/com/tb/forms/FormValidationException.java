/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tb.forms;

/**
 *
 * @author sociepka
 */
public class FormValidationException extends Exception {
    /*
     * Constructeur
     */
    public FormValidationException( String message ) {
        super( message );
    }
}