/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tb.bdd;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author sociepka
 */
public class ConnectionMySQL {
    // url de connection
    private static String url="jdbc:mysql://localhost:3306/toutbois";
    // nom utilisateur
    private static String user="root";
    // mot de passe
    private static String mdp="";
    // objet connection
    private static Connection conn;
    
    // méthode qui retourne l'instance ou la crée si elle n'existe pas
    public static Connection getInstance(){
        if (conn==null){
            try{
                Class.forName("com.mysql.jdbc.Driver");
                conn=DriverManager.getConnection(url,user,mdp);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        return conn;
    }
}
