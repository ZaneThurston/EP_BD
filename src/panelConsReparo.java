import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class panelConsReparo extends JPanel {
	JLabel lblManutenoDaFrota,
		   lblNumSrieAeronave;
	JFormattedTextField numSerie;
	JButton btnPesquisar,
			btnVoltar;
	JScrollPane scrollPane;
	DefaultTableModel model;
	JTable table;
	panelConsReparo thisPanel = this;
	private JLabel lblGastos;
	private JTextField gastoTot;
	
	
	public panelConsReparo(final UserInterface window, final JPanel ant) {
		
		lblManutenoDaFrota = new JLabel("Manuten\u00E7\u00E3o da frota - Reparos");
		lblManutenoDaFrota.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		lblNumSrieAeronave = new JLabel("Num. s\u00E9rie Aeronave:");
		
		numSerie = new JFormattedTextField();
		numSerie.setFormatterFactory(new DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
		
		btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				preencheTabela(Integer.parseInt(numSerie.getText()));
			}
		});
		
		model = new DefaultTableModel();
		table = new JTable(model);		
		scrollPane = new JScrollPane(table);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		criaTabela();
		btnVoltar = new JButton("Voltar");	
		btnVoltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				thisPanel.setVisible(false);
                window.atualiza(thisPanel, ant);
			}
		});
		
		lblGastos = new JLabel("Gastos com manuten\u00E7\u00E3o da(s) aeronave(s) filtradas R$:");
		
		gastoTot = new JTextField();
		gastoTot.setEditable(false);
		gastoTot.setColumns(10);
		
		
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 645, Short.MAX_VALUE)
						.addComponent(lblManutenoDaFrota)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNumSrieAeronave)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(numSerie, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnPesquisar))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnVoltar)
							.addPreferredGap(ComponentPlacement.RELATED, 171, Short.MAX_VALUE)
							.addComponent(lblGastos)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(gastoTot, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblManutenoDaFrota)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNumSrieAeronave)
						.addComponent(numSerie, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnPesquisar))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnVoltar)
						.addComponent(gastoTot, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblGastos))
					.addContainerGap())
		);
		setLayout(groupLayout);
		preencheTabela(-1);
	}
	
	void criaTabela() {
		table.setModel(model);
		model.addColumn("CPF T�cnico respons�vel");
		model.addColumn("Tipo de check");
		model.addColumn("Num. s�rie Aeronave");
		model.addColumn("Data");
		model.addColumn("Valor (R$)");
		table.getColumnModel().getColumn(0).setPreferredWidth(75);
		table.getColumnModel().getColumn(1).setPreferredWidth(75);
		table.getColumnModel().getColumn(2).setPreferredWidth(130);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.getColumnModel().getColumn(4).setPreferredWidth(130);
	}

	void preencheTabela(int serial) {
		ResultSet lista1;
		ResultSet gstos;
		model.setNumRows(0);
		lista1 = BdConnector.listaReparos(serial);
		gstos = BdConnector.total_rep_orcamento_oficina(serial);
		try{
			while (lista1.next()) {
				model.addRow(new Object[] {lista1.getLong(1), lista1.getString(2),lista1.getLong(3), lista1.getString(4), lista1.getString(5)});
			}
			gstos.next();
			gastoTot.setText(gstos.getString(1));
			lista1.close();
			gstos.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
