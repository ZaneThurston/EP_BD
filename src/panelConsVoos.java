import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

@SuppressWarnings("serial")
public class panelConsVoos extends JPanel {
	private JTextField Orig,
					   Dest,
					   Data;
	private JLabel lblOrigem,
				   lblDestino,
				   lblConsultaDeVoos,
				   lblData;
	private JButton btnPesquisar,
					btnVoltar;
	private JScrollPane scrollPane;
	private DefaultTableModel model;
	private JTable table;
	
	private panelConsVoos thisPanel = this; 
	
	public panelConsVoos(final UserInterface window, final JPanel ant) {
		
		lblConsultaDeVoos = new JLabel("Consulta de voos");
		lblConsultaDeVoos.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		lblOrigem = new JLabel("Origem:");
		
		Orig = new JTextField();
		
		lblDestino = new JLabel("Destino:");
		
		Dest = new JTextField();
		
		lblData = new JLabel("Data:");
		
		Data = new JTextField();
		btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				preencheTabela(Orig.getText(), Dest.getText(), LocalDate.parse(Data.getText())); //dia
			}
		});
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				thisPanel.setVisible(false);
                window.atualiza(thisPanel, ant);
			}
		});
		
		model = new DefaultTableModel();
		table = new JTable(model);		
		scrollPane = new JScrollPane(table);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		criaTabela();
		
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 643, Short.MAX_VALUE)
								.addComponent(lblConsultaDeVoos)
								.addComponent(btnVoltar))
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblOrigem)
							.addGap(16)
							.addComponent(Orig, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblDestino)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(Dest, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblData)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(Data, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnPesquisar)
							.addGap(98))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblConsultaDeVoos)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblOrigem)
						.addComponent(Orig, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDestino)
						.addComponent(Dest, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblData)
						.addComponent(Data, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnPesquisar))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnVoltar)
					.addContainerGap())
		);
		setLayout(groupLayout);
	}
	
	void criaTabela() {
		table.setModel(model);
		model.addColumn("ID Voo");
		model.addColumn("Data");
		model.addColumn("ETD (Hora de saida)");
		model.addColumn("ETA (Hora de chegada)");
		model.addColumn("Aeronave");
		model.addColumn("ID Rota");
		model.addColumn("CPF Piloto");
		table.getColumnModel().getColumn(0).setPreferredWidth(75);
		table.getColumnModel().getColumn(1).setPreferredWidth(90);
		table.getColumnModel().getColumn(2).setPreferredWidth(90);
		table.getColumnModel().getColumn(3).setPreferredWidth(90);
		table.getColumnModel().getColumn(4).setPreferredWidth(100);
		table.getColumnModel().getColumn(5).setPreferredWidth(80);
		table.getColumnModel().getColumn(6).setPreferredWidth(100);
		
	}
	
	void preencheTabela(String orig, String dest, LocalDate data) {
		ResultSet list = BdConnector.listaVoos(orig, dest, data);

		model.setNumRows(0);
		try{
			while (list.next()) {
				model.addRow(new Object[] {list.getInt(1), list.getString(2), list.getString(3), list.getString(4), list.getInt(5), list.getInt(6), list.getInt(7)});
			}
			list.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
