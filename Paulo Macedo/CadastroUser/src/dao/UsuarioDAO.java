/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import factory.ConnectionFactory;
import model.Usuario;
import java.sql.*;
import java.sql.PreparedStatement;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author paulo
 */
public class UsuarioDAO {
    
    private Connection conn;
    private Long id;
    private String nome, trabalho;
    private int idade;
    
    public UsuarioDAO(){
        this.conn = new ConnectionFactory().getConnection();
    }
    public void add(Usuario user){
        String sqlconn = "INSERT INTO user(nome, trabalho, idade)VALUES(?,?,?)";
        try{
            PreparedStatement stmt = conn.prepareStatement(sqlconn);//Optei pelo PreparedStatement por questçoes de velocidade e segurança. Além da facilidade de manutenção.
            stmt.setString(1, user.getNome());
            stmt.setString(2, user.getTrabalho());
            stmt.setString(3, Integer.toString(user.getIdade()));
            stmt.execute();
            stmt.close();
        }
        catch(SQLException ex){
            System.out.println("Houve uma erro na operação solicitada: " + ex);
        }
    }
    
    public void paginacao(String sql){
        int str = 0, cnt = 5;
        
        str = str+5;
        cnt = cnt+5;
        String sqlpg = "SELECT * FROM user LIMIT ?,?";
        
        try{
           PreparedStatement pg = conn.prepareStatement(sqlpg);
           pg.setString(1, Integer.toString(str));
           pg.setString(2, Integer.toString(cnt));
           ResultSet rs = pg.executeQuery();
        }
        catch(SQLException ex){
            System.out.println("Houve um erro: " + ex);
        }
    }
}
