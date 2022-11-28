/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package thr.connection.bd;

/**
 *
 * @author Thierry
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import static thr.connection.bd.Constant.BASE;
import static thr.connection.bd.Constant.HOST;

/**
 *
 * @author Thierry
 */
public class ConnectionDb {
      public Connection con;
     public Statement stat;//lanceur de requete
public ConnectionDb(){

  
        //chargement pilote
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");//chemain pilote
           
                    System.out.println("Pilote ok");
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
        //chargement basse de donnee;
        try {
            String curretdir=System.getProperty("user.dir");
           con=DriverManager.getConnection("jdbc:mysql://"+"localhost"+":3306/"+"chat", "root","");
            System.out.println("connetion ok");
        } catch (SQLException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null," Erreur de connection "  );
            
        }
    }
   public Connection obtenirConnexion(){
        return con;
}
}
