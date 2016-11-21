
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFormattedTextField;
import javax.swing.GroupLayout;

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
public class PanelCadReparo  extends JPanel {
    JButton jButtonVoltar,
                jButtonSave,
                jButtonClean;
    
    PanelCadReparo thisPanel = this;
    private JLabel lblReparoDeAeronaves;
    private JLabel lblCpfDoTcnico;
    private JLabel lblNumDeSrie;
    private JLabel lblDataDeExecuo;
    private JLabel lblOradoEmR;
    private JFormattedTextField CPFtec;
    private JFormattedTextField serialAnv;
    private JFormattedTextField data;
    private JFormattedTextField preco;
    
    public PanelCadReparo(final UserInterface window, final InitialPanel init) {

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
				limparCampos();
			}
		});
        
        lblReparoDeAeronaves = new JLabel("Reparo de Aeronaves");
        lblReparoDeAeronaves.setFont(new Font("Tahoma", Font.PLAIN, 13));
        
        lblCpfDoTcnico = new JLabel("CPF do t\u00E9cnico respons\u00E1vel:");
        
        lblNumDeSrie = new JLabel("Num. de s\u00E9rie da aeronave:");
        
        lblDataDeExecuo = new JLabel("Data de execu\u00E7\u00E3o:");
        
        lblOradoEmR = new JLabel("Or\u00E7ado em R$:");
        
        CPFtec = new JFormattedTextField();
        
        serialAnv = new JFormattedTextField();
        
        data = new JFormattedTextField();
        
        preco = new JFormattedTextField();

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
        				.addComponent(lblReparoDeAeronaves)
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(lblCpfDoTcnico)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(CPFtec, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE))
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(lblNumDeSrie)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(serialAnv, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
        				.addGroup(layout.createParallelGroup(Alignment.TRAILING, false)
        					.addGroup(Alignment.LEADING, layout.createSequentialGroup()
        						.addComponent(lblOradoEmR)
        						.addPreferredGap(ComponentPlacement.UNRELATED)
        						.addComponent(preco))
        					.addGroup(Alignment.LEADING, layout.createSequentialGroup()
        						.addComponent(lblDataDeExecuo)
        						.addPreferredGap(ComponentPlacement.UNRELATED)
        						.addComponent(data, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))))
        			.addContainerGap())
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(lblReparoDeAeronaves)
        			.addGap(18)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblCpfDoTcnico)
        				.addComponent(CPFtec, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblNumDeSrie)
        				.addComponent(serialAnv, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblDataDeExecuo)
        				.addComponent(data, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblOradoEmR)
        				.addComponent(preco, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED, 167, Short.MAX_VALUE)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jButtonVoltar)
        				.addComponent(jButtonSave)
        				.addComponent(jButtonClean))
        			.addContainerGap())
        );
        this.setLayout(layout);
    }
    public void limparCampos() {
    	CPFtec.setValue(null);
    	serialAnv.setValue(null);
    	data.setValue(null);
    	preco.setValue(null);
    }
    
}
