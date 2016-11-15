/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Marcos
 */
import java.sql.Statement;

import javax.swing.JOptionPane;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
// falta baixar o driver do postgre e botar no projeto

public class BdConnector {
   static String url = "jdbc:postgresql://localhost:5432/cia_aerea",
                    user = "postgres",
                    password = "123456";
   static Connection con;
    BdConnector() { 
    }
    
    
    public static int Connect() {
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Conectado com o banco de dados.");
            Statement stm = con.createStatement();
            //stm.executeUpdate(string script) é usado para inserir valores
            //stm.executeQuery() é usado para pesquisa
        } catch (ClassNotFoundException | SQLException e) {
            return 1;
        }
        return 0;
    }
    
    public static int CloseConnection() {
         try {
            if (!con.isClosed()) con.close();
            System.out.println("Conexão com o banco de dados fechada.");
         } catch (SQLException e) {
             System.out.println("Não foi possível fechar a conexão com o banco de dados.");
             return 1;
         }
         return 0;
    }
    
/*            M�todos para cadastro de dados                                                                                                                    */
    
    public static void insertClient() {
        
    }
    
    
    public static void insereComissario(int pes_cpf, String com_cht) {
		String sql = "INSERT INTO comissario (pes_cpf,com_cht) VALUES ('"+pes_cpf+
				"','"+com_cht+"');";
		Connect();
		try {
			Statement stm = con.createStatement();
			stm.executeUpdate(sql);
		} catch (SQLException e) {
			JOptionPane.showInternalMessageDialog(null, "N�o foi poss�vel salvar os valores");
		}
		CloseConnection();
	}
 
	static void listaComissario() {
		String sql = "SELECT * FROM comissario";
		Connect();
		try {
			Statement stm = con.createStatement();
			ResultSet consulta = stm.executeQuery(sql);
			while(consulta.next()) {
				int cpf = consulta.getInt("pes_cpf");
				String com_cht = consulta.getString("com_cht");
				System.out.println(com_cht+" - "+cpf);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CloseConnection();
	}
	
	
    public static void Search(String dbl) {
        try {
            Statement stm = con.createStatement();
            ResultSet searchRes;
            searchRes = stm.executeQuery(dbl);
        } catch (SQLException e) {
            
        }
    }
}
