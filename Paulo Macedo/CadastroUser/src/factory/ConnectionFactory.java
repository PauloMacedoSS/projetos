/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;
import java.sql.Connection;//conexão SQL para java.
import java.sql.DriverManager;//driver de conexão SQL para Java.
import java.sql.SQLException;//classe para tratamento de excessões.

/**
 *
 * @author paulo
 */
public class ConnectionFactory {
    public Connection getConnection(){
        try{
           return DriverManager.getConnection("jdbc:mysql://localhost/caduser", "root", "Rasen*12");
        }
        catch(SQLException ex){
            throw new RuntimeException(ex);
        }
    }
}
