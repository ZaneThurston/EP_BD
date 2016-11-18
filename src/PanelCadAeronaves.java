
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.text.DefaultFormatterFactory;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFormattedTextField;
import javax.swing.GroupLayout;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Dimension;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSeparator;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Marcos
 */
public class PanelCadAeronaves extends JPanel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JRadioButton rdbtnCadFrota,
						rdbtnCadModl;
	
	private JButton jButtonVoltar,
                jButtonSave,
                jButtonClean;
    PanelCadAeronaves thisPanel = this;
    private JLabel lblNmeroDeSrie,
    					  lblMatrculaCaracteres,
    					  lblModelo,
    					  lblCat;
    private JFormattedTextField NumSerie,
    								   Capac,
    								   ModlCadPax;
    private JTextField Matricula;
    						  
    @SuppressWarnings("rawtypes")
	private JComboBox catBox,
							 Modelo;
    private final ButtonGroup buttonGroup = new ButtonGroup();
    private JTextField txtCadModl;
    
    public PanelCadAeronaves(UserInterface window, InitialPanel init) {

        jButtonVoltar = new javax.swing.JButton();
        jButtonSave = new javax.swing.JButton();
        jButtonClean = new javax.swing.JButton();

        jButtonVoltar.setText("Voltar");
        jButtonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thisPanel.setVisible(false);
                window.atualiza(thisPanel, init);
            }
        });

        jButtonSave.setText("Salvar");

        jButtonClean.setText("Limpar Campos");
        jButtonClean.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				limpaCampos();
			}
		});
        
        lblNmeroDeSrie = new JLabel("N\u00FAmero de s\u00E9rie:");
        
        NumSerie = new JFormattedTextField();
        NumSerie.setFormatterFactory(new DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        lblMatrculaCaracteres = new JLabel("Matr\u00EDcula (5 caracteres, ex.: PTLSG):");
        
        Matricula = new JTextField();
        Matricula.setColumns(10);
        
        lblModelo = new JLabel("Modelo");
        
        Modelo = new JComboBox();
        
        
        lblCat = new JLabel("Categoria:");
        
        catBox = new JComboBox();
        catBox.setModel(new DefaultComboBoxModel(new String[] {"Medium", "Heavy"}));
        catBox.setMaximumSize(new Dimension(150, 20));
        catBox.setFont(new Font("Dialog", Font.BOLD, 11));
        
        JLabel lblCapacidadeDePassageiros = new JLabel("Capacidade de passageiros:");
        
        Capac = new JFormattedTextField();
        Capac.setFormatterFactory(new DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        Capac.setEditable(false);
        
        JSeparator separator = new JSeparator();
        
        rdbtnCadFrota = new JRadioButton("Cadastro de nova aeronave na frota");
        buttonGroup.add(rdbtnCadFrota);
        
        rdbtnCadModl = new JRadioButton("Cadastro de novo modelo");
        buttonGroup.add(rdbtnCadModl);
        
        JLabel lblModelo_1 = new JLabel("Modelo: ");
        
        txtCadModl = new JTextField();
        txtCadModl.setColumns(10);
        
        JLabel lblCapacidadeDePassageiros_1 = new JLabel("Capacidade de passageiros:");
        
        ModlCadPax = new JFormattedTextField();
        ModlCadPax.setFormatterFactory(new DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        
        rdbtnCadFrota.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				txtCadModl.setEnabled(false);
				ModlCadPax.setEnabled(false);
				NumSerie.setEnabled(true);
				Matricula.setEnabled(true);
				Modelo.setEnabled(true);
				catBox.setEnabled(true);
				Capac.setEnabled(true);
			}
		});
        
        rdbtnCadModl.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				NumSerie.setEnabled(false);
				Matricula.setEnabled(false);
				Modelo.setEnabled(false);
				catBox.setEnabled(false);
				Capac.setEnabled(false);
				txtCadModl.setEnabled(true);
				ModlCadPax.setEnabled(true);
			}
		});
        rdbtnCadFrota.setSelected(true);
        txtCadModl.setEnabled(false);
		ModlCadPax.setEnabled(false);
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(jButtonVoltar)
        					.addPreferredGap(ComponentPlacement.RELATED, 411, Short.MAX_VALUE)
        					.addComponent(jButtonClean)
        					.addGap(18)
        					.addComponent(jButtonSave))
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(lblNmeroDeSrie)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(NumSerie, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE))
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(lblMatrculaCaracteres)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(Matricula, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        				.addGroup(layout.createSequentialGroup()
        					.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
        						.addGroup(layout.createSequentialGroup()
        							.addComponent(lblCat)
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(catBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        						.addGroup(layout.createSequentialGroup()
        							.addComponent(lblModelo)
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(Modelo, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)))
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(lblCapacidadeDePassageiros)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(Capac, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
        				.addComponent(rdbtnCadFrota)
        				.addGroup(layout.createSequentialGroup()
        					.addGap(4)
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(separator, GroupLayout.PREFERRED_SIZE, 620, GroupLayout.PREFERRED_SIZE)
        						.addGroup(layout.createSequentialGroup()
        							.addGroup(layout.createParallelGroup(Alignment.TRAILING, false)
        								.addGroup(Alignment.LEADING, layout.createSequentialGroup()
        									.addComponent(lblModelo_1)
        									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        									.addComponent(txtCadModl, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        								.addComponent(rdbtnCadModl, Alignment.LEADING)
        								.addComponent(lblCapacidadeDePassageiros_1, Alignment.LEADING))
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(ModlCadPax, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)))))
        			.addContainerGap())
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(14)
        			.addComponent(rdbtnCadFrota)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblNmeroDeSrie)
        				.addComponent(NumSerie, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblMatrculaCaracteres)
        				.addComponent(Matricula, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblModelo)
        				.addComponent(Modelo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblCapacidadeDePassageiros)
        				.addComponent(Capac, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblCat)
        				.addComponent(catBox, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
        			.addGap(20)
        			.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(rdbtnCadModl)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblModelo_1)
        				.addComponent(txtCadModl, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblCapacidadeDePassageiros_1)
        				.addComponent(ModlCadPax, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jButtonVoltar)
        				.addComponent(jButtonSave)
        				.addComponent(jButtonClean))
        			.addContainerGap())
        );
        this.setLayout(layout);
        jButtonSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//BdConnector.insereAeronave();
				
			}
		});
    }
    
    void limpaCampos() {
    	NumSerie.setValue(null);
       	Matricula.setText("");
    	Capac.setValue(null);
    	ModlCadPax.setValue(null);
    	txtCadModl.setText("");
    }
    
    void salvaCampos() {
    	
    	BdConnector.insere_aeronave(Integer.parseInt(NumSerie.getText()),
    								Matricula.getText(),
    								Modelo.getSelectedItem().toString(),
    								catBox.getSelectedItem().toString(),
    								Integer.parseInt(Capac.getText()));
    }
}
