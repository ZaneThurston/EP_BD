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
    static void insereComissario_linguas(int com_lin_cpf, String com_lin_lingua) {
		String sql = "INSERT INTO piloto (com_lin_cpf,com_lin_lingua) VALUES ('"+com_lin_cpf+
				"','"+com_lin_lingua+"');";
		Connect();
		try {
			Statement stm = con.createStatement();
			stm.executeUpdate(sql);
		} catch (SQLException e) {
			JOptionPane.showInternalMessageDialog(null, "Não foi possível salvar os valores"); //mostra uma caixa de diálogo
		}
		CloseConnection();
	}
 
	static void lista() {
		String sql = "SELECT * FROM comissario_linguas";
		Connect();
				
		try {
			Statement stm = con.createStatement();
			ResultSet consulta = con.executeQuery(sql);
			while(consulta.next()) {
				int cpf = consulta.getInt("com_lin_cpf");
				String lingua = consulta.getString("com_lin_lingua");
				System.out.println(cpf+" - "+lingua+" - ");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CloseConnection();
	}

	static void insere_rota(int rot_codigo, String aer_icao_origem, String aer_icao_destino, String rot_frequencia) {
		String sql = "INSERT INTO piloto (rot_codigo,aer_icao_origem,aer_icao_destino,rot_frequencia) VALUES ('"+rot_codigo+
				"','"+aer_icao_origem+"','"+aer_icao_destino+"','"+rot_frequencia+"');";
		Connect();
		try {
			Statement stm = con.createStatement();
			stm.executeUpdate(sql);
		} catch (SQLException e) {
			JOptionPane.showInternalMessageDialog(null, "Não foi possível salvar os valores"); //mostra uma caixa de diálogo
		}
		CloseConnection();
	}
 
	static void lista() {
		String sql = "SELECT * FROM rota";
		Connect();		
		try {
			Statement stm = con.createStatement();
			ResultSet consulta = con.executeQuery(sql);
			while(consulta.next()) {
				int codigo = consulta.getInt("rot_codigo");
				String  origem = consulta.getString("aer_icao_origem");
				String  destino = consulta.getString("aer_icao_destino");
				String  frequencia = consulta.getSring("rot_frequencia");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CloseConnection();
	}	

	static void inserecomissario(int pes_cpf, String com_cht) {
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
 
	static void lista() {
		String sql = "SELECT * FROM comissario";
		Connect();
				
		System.out.println("com_cht - pes_cpf");
		try {
			Statement stm = con.createStatement();
			ResultSet consulta = con.executeQuery(sql);
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

	static void insereHabilitacoes(int pil_hab_cpf, String pil_hab_habilitacao) {
		String sql = "INSERT INTO piloto (pil_hab_cpf,pil_hab_habilitacao) VALUES ('"+pil_hab_cpf+
				"','"+pil_hab_habilitacao+"');";
		Connect();
		try {
			Statement stm = con.createStatement();
			stm.executeUpdate(sql);
		} catch (SQLException e) {
			JOptionPane.showInternalMessageDialog(null, "Não foi possível salvar os valores"); //mostra uma caixa de diálogo
		}
		CloseConnection();
	}
 
	static void lista() {
		String sql = "SELECT * FROM piloto_habilitacoes";
		Connect();
		try {
			Statement stm = con.createStatement();
			ResultSet consulta = con.executeQuery(sql);
			while(consulta.next()) {
				int cpf = consulta.getInt("pil_hab_cpf");
				String habilitacao = consulta.getString("pil_hab_habilitacao");
				System.out.println(cpf+" - "+habilitacao+" - ");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CloseConnection();
	}

	static void insereTecnico(int pes_cpf, String tec_anac, String tec_tipo_contrato) {
		String sql = "INSERT INTO piloto (pes_cpf,tec_anac,tec_tipo_contrato) VALUES ('"+pes_cpf+
				"','"+tec_anac+"','"+tec_tipo_contrato+"');";
		Connect();
		try {
			Statement stm = con.createStatement();
			stm.executeUpdate(sql);
		} catch (SQLException e) {
			JOptionPane.showInternalMessageDialog(null, "Não foi possível salvar os valores"); //mostra uma caixa de diálogo
		}
		CloseConnection();
	}
 
	static void lista() {
		String sql = "SELECT * FROM tecnico_manutencao";
		Connect();
				
		try {
			Statement stm = con.createStatement();
			ResultSet consulta = con.executeQuery(sql);
			while(consulta.next()) {
				int cpf = consulta.getInt("pes_cpf");
				String anac = consulta.getString("tec_anac");
				String tipo_contrato = consulta.getString("tec_tipo_contrato");
				System.out.println(cpf+" - "+anac+" - "+tipo_contrato);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CloseConnection();
	}	

	static void insere_Aeronave(int avi_serial_number, String avi_matricula, String avi_modelo, String avi_categoria, int avi_capacidade) {
		String sql = "INSERT INTO piloto (avi_serial_number,avi_matricula,avi_modelo,avi_categoria,avi_capacidade) VALUES ('"+avi_serial_number+
				"','"+avi_matricula+"','"+avi_modelo+"','"+avi_categoria+"','"+avi_capacidade+"');";
		Connect();
		try {
			Statement stm = con.createStatement();
			stm.executeUpdate(sql);
		} catch (SQLException e) {
			JOptionPane.showInternalMessageDialog(null, "Não foi possível salvar os valores"); //mostra uma caixa de diálogo
		}
	}
 
	static void lista() {
		String sql = "SELECT * FROM aeronave";
		Connect();
				
		try {
			Statement stm = con.createStatement();
			ResultSet consulta = con.executeQuery(sql);
			while(consulta.next()) {
				int numero= consulta.getInt("avi_serial_number");
				int  matricula= consulta.getString("avi_matricula");
				int  modelo = consulta.getString("avi_modelo");
				int  categoria = consulta.getSring("avi_categoria");
				int  capacidade = consulta.getInt("avi_capacidade");
				System.out.println(cpf+" - "+lingua+" - ");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CloseConnection();
	}	

	static void insereBagagem(int bag_numero, int bag_peso, int pes_cpf) {
		String sql = "INSERT INTO piloto (bag_numero,bag_peso,pes_cpf) VALUES ('"+bag_numero+
				"','"+bag_peso+"','"+pes_cpf+"');";
		Connect();
		try {
			Statement stm = con.createStatement();
			Statement stm = con.createStatement();
			stm.executeUpdate(sql);
		} catch (SQLException e) {
			JOptionPane.showInternalMessageDialog(null, "Não foi possível salvar os valores"); //mostra uma caixa de diálogo
		}
		CloseConnection();
	}
 
	static void lista() {
		String sql = "SELECT * FROM bagagem";
		Connect();
				
		try {
			Statement stm = con.createStatement();
			ResultSet consulta = con.executeQuery(sql);
			while(consulta.next()) {
				int numero= consulta.getInt("bag_numero");
				int  peso = consulta.getInt("bag_peso");
				int  cpf = consulta.getInt("pes_cpf");
				System.out.println(cpf+" - "+lingua+" - ");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CloseConnection();
	}	

	static void inserepiloto(int pes_cpf, String pil_breve, int pil_horas_voo) {
		String sql = "INSERT INTO piloto (pes_cpf,pil_breve,pil_horas_voo) VALUES ('"+pes_cpf+
				"','"+pil_breve+"','"+pil_horas_voo+"');";
		Connect();
		try {
			Statement stm = con.createStatement();
			stm.executeUpdate(sql);
		} catch (SQLException e) {
			JOptionPane.showInternalMessageDialog(null, "Não foi possível salvar os valores"); //mostra uma caixa de diálogo
		}
		CloseConnection();
	}
 
	static void listapiloto() {
		String sql = "SELECT * FROM piloto";
		Connect();
				
		try {
			Statement stm = con.createStatement();
			ResultSet consulta = con.executeQuery(sql);
			while(consulta.next()) {
				int cpf = consulta.getInt("pes_cpf");
				String breve = consulta.getString("pil_breve");
				int horas = consulta.getInt("pil_horas_voo");
				System.out.println(pil_breve+" - "+breve+" - "+horas);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CloseConnection();
	}	

	static void inserecomissario(int pes_cpf, String com_cht) {
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
 
	static void lista() {
		String sql = "SELECT * FROM comissario";
		Connect();
				
		System.out.println("com_cht - pes_cpf");
		try {
			Statement stm = con.createStatement();
			ResultSet consulta = con.executeQuery(sql);
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
}
  public static void Search(String dbl) {
        try {
            Statement stm = con.createStatement();
            ResultSet searchRes;
            searchRes = stm.executeQuery(dbl);
        } catch (SQLException e) {
            
        }
    }
