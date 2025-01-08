/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connexion;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Raina
 */
public class Connexion {    
    public static Connection postgreS() throws Exception{
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/pharmapro","postgres","pass");
  
        } catch (Exception e) {
            throw e;
        }  
       return connection;
    }
}