
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.JCheckBox;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Marcos
 */
@SuppressWarnings("serial")
public class PanelCadAeroportos  extends JPanel {
    JButton jButtonVoltar,
                jButtonSave,
                jButtonClean;
    PanelCadAeroportos thisPanel = this;
    private JLabel lblCadAero;
    private JLabel lblNewLabel;
    private JLabel lblAerNome;
    private JLabel lblCidade;
    private JTextField ICAO;
    private JTextField nome;
    private JTextField cidade;
    private JCheckBox chkHub;
    private JCheckBox chkOficina;
    
    public PanelCadAeroportos(UserInterface window, BdConnector conectorBD, InitialPanel init) {

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
        jButtonSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
        
        
        jButtonClean.setText("Limpar Campos");
        jButtonClean.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				limpaCampos();
			}
		});
        
        
        lblCadAero = new JLabel("Cadastro de Aeroportos");
        lblCadAero.setFont(new Font("Tahoma", Font.PLAIN, 13));
        
        lblNewLabel = new JLabel("C\u00F3digo ICAO (4 caracteres ex.: SBSP):");
        
        lblAerNome = new JLabel("Nome:");
        
        lblCidade = new JLabel("Cidade");
        
        ICAO = new JTextField();
        ICAO.setColumns(10);
        
        nome = new JTextField();
        nome.setColumns(10);
        
        cidade = new JTextField();
        cidade.setColumns(10);
        
        chkOficina = new JCheckBox("Possui Oficina?");
        
        chkHub = new JCheckBox("Hub da companhia?");
        
        JCheckBox chkPark = new JCheckBox("Possui estacionamento de aeronaves?");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(chkPark)
        				.addComponent(chkHub)
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(jButtonVoltar)
        					.addPreferredGap(ComponentPlacement.RELATED, 366, Short.MAX_VALUE)
        					.addComponent(jButtonClean)
        					.addGap(18)
        					.addComponent(jButtonSave))
        				.addComponent(lblCadAero)
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(lblCidade)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(cidade, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE))
        				.addGroup(layout.createParallelGroup(Alignment.TRAILING, false)
        					.addGroup(Alignment.LEADING, layout.createSequentialGroup()
        						.addComponent(lblAerNome)
        						.addPreferredGap(ComponentPlacement.UNRELATED)
        						.addComponent(nome))
        					.addGroup(Alignment.LEADING, layout.createSequentialGroup()
        						.addComponent(lblNewLabel)
        						.addPreferredGap(ComponentPlacement.UNRELATED)
        						.addComponent(ICAO, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
        				.addComponent(chkOficina))
        			.addContainerGap())
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(lblCadAero)
        			.addGap(18)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblNewLabel)
        				.addComponent(ICAO, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblAerNome)
        				.addComponent(nome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblCidade)
        				.addComponent(cidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(chkOficina)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(chkHub)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(chkPark)
        			.addPreferredGap(ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jButtonVoltar)
        				.addComponent(jButtonSave)
        				.addComponent(jButtonClean))
        			.addContainerGap())
        );
        this.setLayout(layout);
    }
    
    public void limpaCampos() {
    	ICAO.setText("");
    	nome.setText("");
    	cidade.setText("");
    	chkHub.setSelected(false);
    	chkOficina.setSelected(false);
    }
    
}
