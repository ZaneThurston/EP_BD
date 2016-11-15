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
            //stm.executeUpdate(string script) Ã© usado para inserir valores
            //stm.executeQuery() Ã© usado para pesquisa
        } catch (ClassNotFoundException | SQLException e) {
            return 1;
        }
        return 0;
    }
    
    public static int CloseConnection() {
         try {
            if (!con.isClosed()) con.close();
            System.out.println("ConexÃ£o com o banco de dados fechada.");
         } catch (SQLException e) {
             System.out.println("NÃ£o foi possÃ­vel fechar a conexÃ£o com o banco de dados.");
             return 1;
         }
         return 0;
    }
    
/*            Métodos para cadastro de dados                                                                                                                    */
    
    public static void insertClient() {
        
    }
    
    /*
     * Cada método precisa chamar o método Connect() para conectar ao BD e CloseConnection() para fechar a conexão
     * Objeto statement: pra ele é passado a string com o comando sql e executada no BD
     * É necessário um bloco try catch para capturar a exceção do sql quando usar o objeto statement
     * Os métodos de inserção devem receber as variáveis já no formato correto
     * 
     * 
     * 
     * 
     */
    public static void insereComissario(int pes_cpf, String com_cht) {
		String sql = "INSERT INTO comissario (pes_cpf,com_cht) VALUES ('"+pes_cpf+
				"','"+com_cht+"');";
		Connect();
		try {
			Statement stm = con.createStatement();
			stm.executeUpdate(sql);
		} catch (SQLException e) {
			JOptionPane.showInternalMessageDialog(null, "Não foi possível salvar os valores"); //mostra uma caixa de diálogo
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
