import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTable;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class panelConsAnv extends JPanel {
	private JTable table;
	private JScrollPane scrollPane;
	private JButton btnVoltar;
	private JPanel thisPanel = this;
	private DefaultTableModel model;
	public panelConsAnv(final UserInterface window, final JPanel ant) {
		
		JLabel lblFrota = new JLabel("Frota");
		lblFrota.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		model = new DefaultTableModel();
		table = new JTable(model);
		scrollPane = new JScrollPane(table);
		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				thisPanel.setVisible(false);
                window.atualiza(thisPanel, ant);
			}
		});
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 678, Short.MAX_VALUE)
						.addComponent(lblFrota)
						.addComponent(btnVoltar))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblFrota)
					.addGap(7)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnVoltar)
					.addContainerGap())
		);
		
		
		setLayout(groupLayout);
		
		criaTabela();
		model.setNumRows(0);
		preencheTabela();
		
	}
	
	void criaTabela() {
		table.setModel(model);
		model.addColumn("Num. Serie");
		model.addColumn("Matricula");
		model.addColumn("Modelo");
		model.addColumn("Categoria");
		table.getColumnModel().getColumn(0).setPreferredWidth(60);
		table.getColumnModel().getColumn(1).setPreferredWidth(70);
		table.getColumnModel().getColumn(2).setPreferredWidth(225);
		table.getColumnModel().getColumn(3).setPreferredWidth(60);
	}
	
	void preencheTabela() {
		ResultSet lista1;
		model.setNumRows(0);
		lista1 = BdConnector.listaFrota();
		try{
			while (lista1.next()) {
				model.addRow(new Object[] {lista1.getLong(1), lista1.getString(2),lista1.getString(3), lista1.getString(4)});
			}
			lista1.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
