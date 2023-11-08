/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.codejava.elektrosqlitedatabase;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nitra
 */
public class SQLiteOpenHelp {
    public static void createSqlTable(){
        
    
  
    
    try{
        // připojení k sql
        Class.forName("org.sqlite.JDBC");
        Connection connection = DriverManager.getConnection("jdbc:sqlite:produkty.db");
        Statement statement = connection.createStatement();
//        statement.setQueryTimeout(30); // timeout 30 sekund
        
//        dropne tabuly pokud existuje
    //    statement.executeUpdate("DROP TABLE IF EXISTS produkty");
//        vytvoří tabuly Produkty
        statement.executeUpdate("create table produkty (id integer primary key unique, nazev VARCHAR (20), znacka VARCHAR (20), mnozstvi integer, cenanakup integer, cenaprodej integer)");
        
//        statement.executeUpdate("INSERT INTO produkty VALUES (1,'chlad 3602','Philco',2,4598,9890)");  
        
       
        
     }catch (SQLException e) { System.out.println("Něco se nepovedlo s vytvoření konekcí"); } catch (ClassNotFoundException ex) {
            Logger.getLogger(SQLiteOpenHelp.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
}
