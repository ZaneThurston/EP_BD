import javax.swing.JPanel;
import javax.swing.JScrollPane;

import net.miginfocom.swing.MigLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class panelConsFunc extends JPanel{
	// WIP -------- criaï¿½ï¿½o da interface para consulta de funcionï¿½rios
	private JTable table;
	private JComboBox filtroBox;
	private JLabel lblCargo;
	private String[] cabecalhoTabl = {"CPF",
									  "Nome",
									  "Sexo",
									  "Data nasc.",
									  "E-mail",
									  "Rua",
									  "Num.",
									  "Bairro",
									  "Complemento",
									  "Cod. Func.",
									  "Cargo",
									  "Passaporte",
									  "Necess. Especial?"};
	private DefaultTableModel model;
	private JScrollPane barraRol;
	private JButton voltar;
	private panelConsFunc thisPanel = this;
	
	public panelConsFunc(final UserInterface window, final JPanel ant) {
		setLayout(new MigLayout("", "[grow][grow]", "[][grow]"));
		
		lblCargo = new JLabel("Cargo: ");
		add(lblCargo, "cell 0 0,alignx right");
		
		filtroBox = new JComboBox();
		filtroBox.setModel(new DefaultComboBoxModel(new String[] {"Todos", "Interno", "Piloto", "Comissário", "Mecânico"}));
		add(filtroBox, "cell 1 0,alignx left");
		model = new DefaultTableModel();
		table = new JTable(model);
		barraRol = new JScrollPane(table);
		voltar = new JButton("Voltar");
		add(barraRol, "cell 0 1 2 1,grow");
		add(voltar, "cell 0 2, alignx left");
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thisPanel.setVisible(false);
                window.atualiza(thisPanel, ant);
            }
        });
		criaTabela();
		model.setNumRows(0);
		preencheTabela( filtroBox.getSelectedItem().toString());
		filtroBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				preencheTabela(filtroBox.getSelectedItem().toString());
			}
		});
		
	}
	
	void criaTabela() {
		table.setModel(model);
		model.addColumn(cabecalhoTabl[0]);
		model.addColumn(cabecalhoTabl[1]);
		model.addColumn(cabecalhoTabl[2]);
		model.addColumn(cabecalhoTabl[3]);
		model.addColumn(cabecalhoTabl[4]);
		model.addColumn(cabecalhoTabl[5]);
		model.addColumn(cabecalhoTabl[6]);
		model.addColumn(cabecalhoTabl[7]);
		model.addColumn(cabecalhoTabl[8]);
		model.addColumn(cabecalhoTabl[9]);
		model.addColumn(cabecalhoTabl[10]);
		model.addColumn(cabecalhoTabl[11]);
		model.addColumn(cabecalhoTabl[12]);
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		table.getColumnModel().getColumn(2).setPreferredWidth(20);
		table.getColumnModel().getColumn(3).setPreferredWidth(50);
		table.getColumnModel().getColumn(12).setPreferredWidth(25);
	}
	
	void preencheTabela(String param) {
		ResultSet lista = null;
		model.setNumRows(0);
		lista = BdConnector.listaFuncionarios(param);
		try{
			while (lista.next()) {
				model.addRow(new Object[] {lista.getLong(1), lista.getString(2), lista.getCharacterStream(3), lista.getString(4), lista.getString(5),
											lista.getString(6), lista.getInt(7), lista.getString(8), lista.getString(9), lista.getString(12), lista.getString(13),
											lista.getString(14), lista.getString(15)});
			}
			lista.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
