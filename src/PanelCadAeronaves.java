
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
	static JButton jButtonVoltar,
                jButtonSave,
                jButtonClean;
    PanelCadAeronaves thisPanel = this;
    static private JLabel lblCadAero,
    					  lblNmeroDeSrie,
    					  lblMatrculaCaracteres,
    					  lblModelo,
    					  lblCat;
    static private JFormattedTextField NumSerie;
    static private JTextField Matricula,
    						  Modelo;
    static private JComboBox catBox;
    
    public PanelCadAeronaves(UserInterface window, BdConnector conectorBD, InitialPanel init) {

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
        
        lblCadAero = new JLabel("Cadastro de Aeronave na frota");
        lblCadAero.setFont(new Font("Tahoma", Font.PLAIN, 12));
        
        lblNmeroDeSrie = new JLabel("N\u00FAmero de s\u00E9rie:");
        
        NumSerie = new JFormattedTextField();
        NumSerie.setFormatterFactory(new DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        lblMatrculaCaracteres = new JLabel("Matr\u00EDcula (5 caracteres, ex.: PTLSG):");
        
        Matricula = new JTextField();
        Matricula.setColumns(10);
        
        lblModelo = new JLabel("Modelo");
        
        Modelo = new JTextField();
        Modelo.setColumns(10);
        
        lblCat = new JLabel("Categoria:");
        
        catBox = new JComboBox();
        catBox.setModel(new DefaultComboBoxModel(new String[] {"Medium", "Heavy"}));
        catBox.setMaximumSize(new Dimension(150, 20));
        catBox.setFont(new Font("Dialog", Font.BOLD, 11));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(jButtonVoltar)
        					.addPreferredGap(ComponentPlacement.RELATED, 183, Short.MAX_VALUE)
        					.addComponent(jButtonClean)
        					.addGap(18)
        					.addComponent(jButtonSave))
        				.addComponent(lblCadAero)
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(lblNmeroDeSrie)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(NumSerie, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE))
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(lblMatrculaCaracteres)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(Matricula, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        				.addGroup(layout.createParallelGroup(Alignment.TRAILING, false)
        					.addGroup(Alignment.LEADING, layout.createSequentialGroup()
        						.addComponent(lblCat)
        						.addPreferredGap(ComponentPlacement.RELATED)
        						.addComponent(catBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        					.addGroup(Alignment.LEADING, layout.createSequentialGroup()
        						.addComponent(lblModelo)
        						.addPreferredGap(ComponentPlacement.RELATED)
        						.addComponent(Modelo, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE))))
        			.addContainerGap())
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(lblCadAero)
        			.addGap(18)
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
        				.addComponent(Modelo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblCat)
        				.addComponent(catBox, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED, 176, Short.MAX_VALUE)
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
    
    static void limpaCampos() {
    	NumSerie.setValue(null);
       	Matricula.setText("");
    	Modelo.setText("");	
    }
    
    static void salvaCampos() {
    	BdConnector.insere_aeronave(Integer.parseInt(NumSerie.getText()),
    								Matricula.getText(),
    								Modelo.getText(),
    								catBox.getSelectedItem().toString(),
    								avi_capacidade);
    }
    
}
