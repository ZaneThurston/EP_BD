import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.JFormattedTextField;
import javax.swing.GroupLayout;
import javax.swing.JTextField;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Marcos
 */
public class PanelCadVoos extends JPanel {
    static JButton jButtonVoltar,
                jButtonSave,
                jButtonClean;
    PanelCadVoos thisPanel = this;
    static private JLabel lblVoos;
    static private JLabel lblData;
    static private JTextField timeDepart;
    static private JTextField timeArr;
    static private JTextField pilotCPF;
    static private JTextField Orig;
    static private JTextField Dest;
    
    public PanelCadVoos(UserInterface window, BdConnector conectorBD, InitialPanel init) {

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
				salvaCampos(conectorBD);
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
        
        lblVoos = new JLabel("Cria\u00E7\u00E3o de voos");
        lblVoos.setFont(new Font("Tahoma", Font.PLAIN, 13));
        
        lblData = new JLabel("Data:");
        
        JFormattedTextField data = new JFormattedTextField();
        
        JLabel lblHorrioDeSada = new JLabel("Hor\u00E1rio de sa\u00EDda:");
        
        timeDepart = new JTextField();
        timeDepart.setColumns(10);
        
        JLabel lblHorrioDeChegada = new JLabel("Hor\u00E1rio de chegada:");
        
        timeArr = new JTextField();
        timeArr.setColumns(10);
        
        JLabel lblNumAeronave = new JLabel("Num. aeronave:");
        
        JFormattedTextField aerSerial = new JFormattedTextField();
        
        JLabel lblCpfPiloto = new JLabel("CPF do piloto:");
        
        pilotCPF = new JTextField();
        pilotCPF.setColumns(10);
        
        JLabel lblIdDaRota = new JLabel("ID da rota:");
        
        JFormattedTextField routeID = new JFormattedTextField();
        
        JLabel lblOrigem = new JLabel("Origem:");
        
        Orig = new JTextField();
        Orig.setColumns(10);
        
        JLabel lblDestino = new JLabel("Destino:");
        
        Dest = new JTextField();
        Dest.setColumns(10);
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(jButtonVoltar)
        					.addPreferredGap(ComponentPlacement.RELATED, 383, Short.MAX_VALUE)
        					.addComponent(jButtonClean)
        					.addGap(18)
        					.addComponent(jButtonSave))
        				.addComponent(lblVoos)
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(lblData)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(data, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE))
        				.addGroup(layout.createSequentialGroup()
        					.addGroup(layout.createParallelGroup(Alignment.TRAILING, false)
        						.addGroup(Alignment.LEADING, layout.createSequentialGroup()
        							.addComponent(lblNumAeronave)
        							.addPreferredGap(ComponentPlacement.UNRELATED)
        							.addComponent(aerSerial))
        						.addGroup(Alignment.LEADING, layout.createSequentialGroup()
        							.addComponent(lblHorrioDeSada)
        							.addPreferredGap(ComponentPlacement.UNRELATED)
        							.addComponent(timeDepart, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
        					.addGap(18)
        					.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
        						.addGroup(layout.createSequentialGroup()
        							.addComponent(lblHorrioDeChegada)
        							.addPreferredGap(ComponentPlacement.UNRELATED)
        							.addComponent(timeArr, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
        						.addGroup(layout.createSequentialGroup()
        							.addComponent(lblCpfPiloto)
        							.addPreferredGap(ComponentPlacement.UNRELATED)
        							.addComponent(pilotCPF))))
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(lblIdDaRota)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(routeID, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
        					.addGap(18)
        					.addComponent(lblOrigem)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(Orig, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(lblDestino)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(Dest, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
        			.addContainerGap())
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(lblVoos)
        			.addGap(18)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblData)
        				.addComponent(data, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblHorrioDeSada)
        				.addComponent(timeDepart, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblHorrioDeChegada)
        				.addComponent(timeArr, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblNumAeronave)
        				.addComponent(aerSerial, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblCpfPiloto)
        				.addComponent(pilotCPF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblIdDaRota)
        				.addComponent(routeID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblOrigem)
        				.addComponent(Orig, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblDestino)
        				.addComponent(Dest, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED, 152, Short.MAX_VALUE)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jButtonVoltar)
        				.addComponent(jButtonSave)
        				.addComponent(jButtonClean))
        			.addContainerGap())
        );
        this.setLayout(layout);
    }
    
    static void limpaCampos() {
    	timeDepart.setText("");
    	timeArr.setText("");
    	pilotCPF.setText("");
    	Orig.setText("");
    	Dest.setText("");
    }
    
    static void salvaCampos(BdConnector conector) {
    	
    	conector.insere_voo(voo_id, voo_data, voo_horario_saida, voo_horario_chegada, avi_serial_number, rot_codigo, pes_cpf);
    }
}
