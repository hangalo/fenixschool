/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.util;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Aisha Lubadika
 */
public class TesteConexao {
    public static void main(String[] args) {
        try {
            Connection con = Conexao.getConnection();
            System.out.println("Conexão Aberta!");
            con.close();
        } catch (SQLException e) {
            System.out.println("Falha na conexão: " + e.getMessage());
        }
    }
}
