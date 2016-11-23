import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTable;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;


public class PanelConsVoosComiss extends JPanel {
	private JTextField CPF;
	private JButton btnPesquisar,
					btnVoltar;
	private DefaultTableModel model;
	private JTable table;
	private JScrollPane scrollPane;
	private PanelConsVoosComiss thisPanel = this;
	private JTextField data1;
	private JTextField data2;
	
	
	public PanelConsVoosComiss(final UserInterface window, final JPanel ant) {
		
		JLabel lblConsComiss = new JLabel("Consulta de voos por comissario");
		lblConsComiss.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JLabel lblCpfComissario = new JLabel("CPF Comissario:");
		
		CPF = new JTextField();
		CPF.setColumns(10);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				thisPanel.setVisible(false);
                window.atualiza(thisPanel, ant);
			}
		});
		
		btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				preencheTabela(CPF.getText(), LocalDate.parse(data1.getText()), LocalDate.parse(data2.getText()));
			}
		});
		
		
		
		
		data1 = new JTextField();
		data1.setColumns(10);
		
		data2 = new JTextField();
		data2.setColumns(10);
		
		JLabel lblDatas = new JLabel("Datas:");
		model = new DefaultTableModel();
		table = new JTable(model);
		scrollPane = new JScrollPane(table);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		criaTabela();
		
		JLabel lblDe = new JLabel("De:");
		
		JLabel lblAte = new JLabel("Ate:");
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnVoltar)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
							.addGroup(groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
									.addComponent(lblConsComiss)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblCpfComissario)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(CPF)))
								.addGap(18)
								.addComponent(btnPesquisar)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblDatas)
								.addGap(18)
								.addComponent(lblDe)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(data1, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(lblAte)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(data2, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
							.addComponent(scrollPane, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 679, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblConsComiss)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCpfComissario)
						.addComponent(CPF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnPesquisar)
						.addComponent(data2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblAte)
						.addComponent(data1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDe)
						.addComponent(lblDatas))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
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
		table.getColumnModel().getColumn(1).setPreferredWidth(90);
		table.getColumnModel().getColumn(2).setPreferredWidth(90);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.getColumnModel().getColumn(4).setPreferredWidth(80);
		table.getColumnModel().getColumn(5).setPreferredWidth(100);
	}

	void preencheTabela(String cpf, LocalDate data1, LocalDate data2) {
		ResultSet list;
		list = BdConnector.listaVoosComiss(cpf, data1, data2);
		try{
			while (list.next()) {
				model.addRow(new Object[] {list.getInt(1), list.getString(2), list.getString(3), list.getString(4), list.getInt(5), list.getInt(6), list.getInt(7)});
				System.out.println(list.getInt(1)+" "+list.getString(2)+" "+list.getString(3)+" "+list.getString(4)+" "+list.getInt(5)+" "+list.getInt(6)+" "+list.getInt(7));
			}
			list.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
