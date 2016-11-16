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
     static void insere_comissario_linguas(int com_lin_cpf, String com_lin_lingua) {
		String sql = "INSERT INTO comissario_linguas (com_lin_cpf,com_lin_lingua) VALUES ('"+com_lin_cpf+
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
 
	static void lista_comissario_linguas() {
		String sql = "SELECT * FROM comissario_linguas";
		Connect();
				
		try {
			Statement stm = con.createStatement();
			ResultSet consulta = con.executeQuery(sql);
			while(consulta.next()) {
				int cpf = consulta.getInt("com_lin_cpf");
				String lingua = consulta.getString("com_lin_lingua");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CloseConnection();
	}
	static void insere_voo(int voo_id, date voo_data, char voo_horario_saida, char voo_horario_chegada, int avi_serial_number, int rot_codigo, int  pes_cpf) {
		String sql = "INSERT INTO voo (voo_id,voo_data,voo_horario_saida,voo_horario_chegada) VALUES ('"+voo_id+
				"','"+voo_data+"','"+voo_horario_saida+"','"+voo_horario_chegada+"','"+avi_serial_number+"','"+rot_codigo+"','"+pes_cpf+"');";
		Connect();
		try {
			Statement stm = con.createStatement();
			stm.executeUpdate(sql);
		} catch (SQLException e) {
			JOptionPane.showInternalMessageDialog(null, "Não foi possível salvar os valores"); //mostra uma caixa de diálogo
		}
		CloseConnection();
	}
 
	static void lista_voo() {
		String sql = "SELECT * FROM voo";
		Connect();	
		try {
			Statement stm = con.createStatement();
			ResultSet consulta = con.executeQuery(sql);
			while(consulta.next()) {
				int avi_serial_number, int rot_codigo, int  pes_cpf
				int id = consulta.getInt("voo_id");
				String  data = consulta.getString("voo_data");
				String  saida = consulta.getString("voo_horario_saida");
				String  chegada = consulta.getString("voo_horario_chegada");
				int serial_number = consulta.getInt("avi_serial_number");
				int codigo = consulta.getInt("rot_codigo");
				int cpf = consulta.getInt("pes_cpf");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CloseConnection();
	}
	public static void insere_reparo(int tec_cpf, String man_codigo, int avi_serial_number, date rep_date, float rep_orcamento) {
		String sql = "INSERT INTO reparo (tec_cpf,man_codigo) VALUES ('"+tec_cpf+
				"','"+man_codigo+"','"+avi_serial_number+"','"+rep_date+"','"+rep_orcamento+"');";
		Connect();
		try {
			Statement stm = con.createStatement();
			stm.executeUpdate(sql);
		} catch (SQLException e) {
			JOptionPane.showInternalMessageDialog(null, "Não foi possível salvar os valores"); //mostra uma caixa de diálogo
		}
		CloseConnection();
	}
 
	static void lista_reparo() {
		String sql = "SELECT * FROM reparo";
		Connect();
		try {
			Statement stm = con.createStatement();
			ResultSet consulta = con.executeQuery(sql);
			while(consulta.next()) {
				int cpf = consulta.getInt("tec_cpf");
				int man_codigo = consulta.getInt("man_codigo");
				int serial_number = consulta.getInt("avi_serial_number");
				date data = consulta.getDate("man_data");
				float orcamento = consulta.getFloat("rep_orcamento");

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CloseConnection();
	}

	static void insere_rota(int rot_codigo, String aer_icao_origem, String aer_icao_destino, String rot_frequencia) {
		String sql = "INSERT INTO rota (rot_codigo,aer_icao_origem,aer_icao_destino,rot_frequencia) VALUES ('"+rot_codigo+
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
 
	static void lista_rota() {
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
	create table aeroporto_portoes(
    aer_icao char(4) not null,
    aer_por_portao char(2) not null, 
    
    static void insere_aeroporto_portoes(String  aer_icao, String aer_por_portao) {
		String sql = "INSERT INTO aeroporto_portoes (aer_icao,aer_por_portao,pas_classe) VALUES ('"+aer_icao+"','"+aer_por_portao+"');";
		Connect();
		try {
			Statement stm = con.createStatement();
			stm.executeUpdate(sql);
		} catch (SQLException e) {
			JOptionPane.showInternalMessageDialog(null, "Não foi possível salvar os valores"); //mostra uma caixa de diálogo
		}
		CloseConnection();
	}
 
	static void lista_aeroporto_portoes() {
		String sql = "SELECT * FROM aeroporto_portoes";
		Connect();			
		try {
			Statement stm = con.createStatement();
			ResultSet consulta = con.executeQuery(sql);
			while(consulta.next()) {
				String  icao = consulta.getString("aer_icao");
				String  por_portao = consulta.getString("aer_por_portao");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CloseConnection();
	}	
	static void insere_manutencao(int man_codigo , String man_nome, String man_desricao) {
		String sql = "INSERT INTO manutencao(man_codigo ,man_nome,man_descricao,pas_classe) VALUES ('"+man_codigo +"','"+man_nome+"','"+man_desricao+"');";
		Connect();
		try {
			Statement stm = con.createStatement();
			stm.executeUpdate(sql);
		} catch (SQLException e) {
			JOptionPane.showInternalMessageDialog(null, "Não foi possível salvar os valores"); //mostra uma caixa de diálogo
		}
		CloseConnection();
	}
 
	static void lista_manutencao() {
		String sql = "SELECT * FROM manutencao";
		Connect();				
		try {
			Statement stm = con.createStatement();
			ResultSet consulta = con.executeQuery(sql);
			while(consulta.next()) {
				String  codigo = consulta.getString("man_codigo ");
				String  nome = consulta.getString("man_nome");
				String  descricao= consulta.getString("man_descricao");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CloseConnection();
	}
		
	    public static void insere_passagem(String pas_coluna, String pas_fileira,int voo_id,String pas_classe,date pas_data_compra) {
		String sql = "INSERT INTO passagem (pas_coluna,pas_fileira) VALUES ('"+pas_coluna+"','"+pas_fileira+"',
			'"+voo_id+"','"+pas_classe+"','"+pas_data_compra+"','"+pas_coluna+"');";
		Connect();
		try {
			Statement stm = con.createStatement();
			stm.executeUpdate(sql);
		} catch (SQLException e) {
			JOptionPane.showInternalMessageDialog(null, "Não foi possível salvar os valores"); //mostra uma caixa de diálogo
		}
		CloseConnection();
	}
 
	static void lista_passagem() {
		String sql = "SELECT * FROM passagem";
		Connect();
		try {
			Statement stm = con.createStatement();
			ResultSet consulta = con.executeQuery(sql);
			while(consulta.next()) {
				String coluna= consulta.getInt("pas_coluna");
				String pas_fileira = consulta.getString("pas_fileira");
				int voo_id = consulta.getInt("voo_id");
				String classe = consulta.getString("pas_classe");
				date data_compra = consulta.getDate("pas_data_compra");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CloseConnection();
	}


	static void insere_aeroporto(String aer_icao, String aer_nome, String aer_cidade, String aer_estado, boolean aer_oficina, int aer_hub, String aer_park) {
		String sql = "INSERT INTO aeroporto (aer_icao,aer_nome,aer_cidade,aer_estado,aer_oficina,aer_hub,aer_park) VALUES ('"+aer_icao+
				"','"+aer_nome+"','"+aer_cidade+"','"+aer_estado+"','"+aer_oficina+"','"+aer_hub+"','"+aer_park+"');";
		Connect();
		try {
			Statement stm = con.createStatement();
			stm.executeUpdate(sql);
		} catch (SQLException e) {
			JOptionPane.showInternalMessageDialog(null, "Não foi possível salvar os valores"); //mostra uma caixa de diálogo
		}
		CloseConnection();
	}
 
	static void lista_aeroporto() {
		String sql = "SELECT * FROM aeroporto";
		Connect();				
		try {
			Statement stm = con.createStatement();
			ResultSet consulta = con.executeQuery(sql);
			while(consulta.next()) {
				String icao = consulta.getString("aer_icao");
				String  nome = consulta.getString("aer_nome");
				String  cidade = consulta.getString("aer_cidade");
				String  estado = consulta.getSring("aer_estado");
				boolean  oficina = consulta.getBoolean("aer_oficina");
				int  hub = consulta.getInt("aer_hub");
				String  park = consulta.getString("aer_park");

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CloseConnection();
	}	

	static void insere_comissario(int pes_cpf, String com_cht) {
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
 
	static void lista_comissario() {
		String sql = "SELECT * FROM comissario";
		Connect();
				
		try {
			Statement stm = con.createStatement();
			ResultSet consulta = con.executeQuery(sql);
			while(consulta.next()) {
				int cpf = consulta.getInt("pes_cpf");
				String com_cht = consulta.getString("com_cht");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CloseConnection();
	}	

	static void insere_habilitacoes(int pil_hab_cpf, String pil_hab_habilitacao) {
		String sql = "INSERT INTO piloto_habilitacoes (pil_hab_cpf,pil_hab_habilitacao) VALUES ('"+pil_hab_cpf+
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
 
	static void lista_habilitacoes() {
		String sql = "SELECT * FROM piloto_habilitacoes";
		Connect();
		try {
			Statement stm = con.createStatement();
			ResultSet consulta = con.executeQuery(sql);
			while(consulta.next()) {
				int cpf = consulta.getInt("pil_hab_cpf");
				String habilitacao = consulta.getString("pil_hab_habilitacao");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CloseConnection();
	}

	static void insere_tecnico(int pes_cpf, String tec_anac, String tec_tipo_contrato) {
		String sql = "INSERT INTO tecnico_manutencao (pes_cpf,tec_anac,tec_tipo_contrato) VALUES ('"+pes_cpf+
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
 
	static void lista_tecnico() {
		String sql = "SELECT * FROM tecnico_manutencao";
		Connect();
				
		try {
			Statement stm = con.createStatement();
			ResultSet consulta = con.executeQuery(sql);
			while(consulta.next()) {
				int cpf = consulta.getInt("pes_cpf");
				String anac = consulta.getString("tec_anac");
				String tipo_contrato = consulta.getString("tec_tipo_contrato");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CloseConnection();
	}	

	static void insere_aeronave(int avi_serial_number, String avi_matricula, String avi_modelo, String avi_categoria, int avi_capacidade) {
		String sql = "INSERT INTO aeronave (avi_serial_number,avi_matricula,avi_modelo,avi_categoria,avi_capacidade) VALUES ('"+avi_serial_number+
				"','"+avi_matricula+"','"+avi_modelo+"','"+avi_categoria+"','"+avi_capacidade+"');";
		Connect();
		try {
			Statement stm = con.createStatement();
			stm.executeUpdate(sql);
		} catch (SQLException e) {
			JOptionPane.showInternalMessageDialog(null, "Não foi possível salvar os valores"); //mostra uma caixa de diálogo
		}
	}
 
	static void lista_aeronave() {
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
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CloseConnection();
	}	

	static void insere_bagagem(int bag_numero, int bag_peso, int pes_cpf) {
		String sql = "INSERT INTO bagagem (bag_numero,bag_peso,pes_cpf) VALUES ('"+bag_numero+
				"','"+bag_peso+"','"+pes_cpf+"');";
		Connect();
		try {
			Statement stm = con.createStatement();
			stm.executeUpdate(sql);
		} catch (SQLException e) {
			JOptionPane.showInternalMessageDialog(null, "Não foi possível salvar os valores"); //mostra uma caixa de diálogo
		}
		CloseConnection();
	}
 
	static void lista_bagagem() {
		String sql = "SELECT * FROM bagagem";
		Connect();
				
		try {
			Statement stm = con.createStatement();
			ResultSet consulta = con.executeQuery(sql);
			while(consulta.next()) {
				int numero= consulta.getInt("bag_numero");
				int  peso = consulta.getInt("bag_peso");
				int  cpf = consulta.getInt("pes_cpf");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CloseConnection();
	}	

	static void insere_piloto(int pes_cpf, String pil_breve, int pil_horas_voo) {
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
 
	static void lista_piloto() {
		String sql = "SELECT * FROM piloto";
		Connect();
				
		try {
			Statement stm = con.createStatement();
			ResultSet consulta = con.executeQuery(sql);
			while(consulta.next()) {
				int cpf = consulta.getInt("pes_cpf");
				String breve = consulta.getString("pil_breve");
				int horas = consulta.getInt("pil_horas_voo");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CloseConnection();
	}	
	
public static void insere_pessoa(int pes_cpf, String pes_nome,char pes_sexo,date pes_bday,String pes_mail,String pes_rua,int pes_numero,String pes_bairro,String pes_complemento,
	boolean pes_flag_cliente, boolean pes_flag_empregado, int pes_cod_func, String pes_tipo_func, String pes_passaporte, String pes_necessidades_especiais) {
		String sql = "INSERT INTO pessoa (pes_cpf, pes_nome, pes_sexo, pes_bday, pes_mail, pes_rua, pes_numero, pes_bairro, pes_complemento, pes_flag_cliente, pes_flag_empregado, 
		pes_cod_func, pes_tipo_func, pes_passaporte, pes_necessidades_especiais) VALUES ('"+pes_cpf+"','"+pes_nome+"','"+pes_sexo+"','"+pes_bday+"','"+pes_mail+"','"+pes_rua+"',
		'"+pes_numero+"','"+pes_bairro+"','"+pes_complemento+"','"+pes_flag_cliente+"','"+pes_flag_empregado+"','"+pes_cod_func+"','"+pes_tipo_func+"','"+pes_passaporte+"','"+pes_necessidades_especiais+"');";
		Connect();
		try {
			Statement stm = con.createStatement();
			stm.executeUpdate(sql);
		} catch (SQLException e) {
			JOptionPane.showInternalMessageDialog(null, "Não foi possível salvar os valores"); //mostra uma caixa de diálogo
		}
		CloseConnection();
	}
 
	static void lista_pessoa() {
		String sql = "SELECT * FROM pessoa";
		Connect();
		try {
			Statement stm = con.createStatement();
			ResultSet consulta = con.executeQuery(sql);
			while(consulta.next()) {
				int cpf = consulta.getInt("pes_cpf");
				String nome = consulta.getString("pes_nome");
				String sexo = consulta.getString("pes_sexo");
				date bday = consulta.getDate("pes_bday");
				String mail = consulta.getString("pes_mail");
				String rua = consulta.getString("pes_rua");
				int numero = consulta.getInt("pes_numero");
				String bairro = consulta.getString("pes_bairro");
				String complemento = consulta.getString("pes_complemento");
				boolean cliente =consulta.getBoolean("pes_flag_cliente");
				boolean empregado = consulta.getBoolean("pes_flag_empregado");
				int codigo_func = consulta.getInt("pes_cod_func");
				String tipo_func = consulta.getString("pes_tipo_func");
				String passaporte = consulta.getString("pes_passaporte");
				String necessidades_especiais = consulta.getString("pes_necessidades_especiais");
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
