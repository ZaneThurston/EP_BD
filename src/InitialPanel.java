
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
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
public class InitialPanel extends JPanel{
    
    // botões
    JButton CadCli,
                CadFunc,
                CadAeronaves,
                CadAirports,
                CadVoos,
                CadRepairs,
    			conVoos,
    			btnFrota,
    			conFunc,
    			ConReparos;
    InitialPanel thisPanel = this;
    private JLabel Cadastro;
    private JLabel lblConsultas;
    
    
    // constroi o painel na janela da interface, inicializa componentes
    public InitialPanel(final UserInterface window) {
        CadCli = new JButton("Clientes");
        CadFunc = new JButton("Funcion\u00E1rios");
        CadAeronaves = new JButton("Aeronaves");
        CadAirports = new JButton("Aeroportos");
        CadVoos = new JButton("Voos");
        CadRepairs = new JButton("Registro de reparos");
        Dimension buttonSizes = new Dimension();
        buttonSizes.setSize(90, 130);
        this.setVisible(true);
        
        
        // action listeners para os botoes de cadastro
        CadCli.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PanelCadCli panelCli = new PanelCadCli(window, thisPanel);
                window.atualiza(thisPanel, panelCli);
            }
         });
        
        CadFunc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PanelCadFuncionario panelFunc = new PanelCadFuncionario(window, thisPanel);
                window.atualiza(thisPanel, panelFunc);
            }
         });
        
        CadVoos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PanelCadVoos panelVoos = new PanelCadVoos(window, thisPanel);
                window.atualiza(thisPanel, panelVoos);
            }
        });
        
        CadAeronaves.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PanelCadAeronaves panelAeronaves = new PanelCadAeronaves(window, thisPanel);
                window.atualiza(thisPanel, panelAeronaves);
            }
        });
        
        CadAirports.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PanelCadAeroportos panelAirports = new PanelCadAeroportos(window, thisPanel);
                window.atualiza(thisPanel, panelAirports);
            }
        });
        
        CadRepairs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PanelCadReparo panelRepairs = new PanelCadReparo(window, thisPanel);
                window.atualiza(thisPanel, panelRepairs);
            }
        });
        
        Cadastro = new JLabel("Cadastro");
        Cadastro.setFont(new Font("Tahoma", Font.PLAIN, 13));
        
        lblConsultas = new JLabel("Consultas");
        lblConsultas.setFont(new Font("Tahoma", Font.PLAIN, 13));
        
     // action listeners para os botos de consultas
        
        conVoos = new JButton("Voos");
        conVoos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panelConsVoos panelVoos = new panelConsVoos(window, thisPanel);
				window.atualiza(thisPanel, panelVoos);
			}
		});
        
   
        btnFrota = new JButton("Frota");
        btnFrota.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panelConsAnv panelFrota = new panelConsAnv(window, thisPanel);
				window.atualiza(thisPanel, panelFrota);
			}
		});
        
        conFunc = new JButton("Funcion\u00E1rios");
        conFunc.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panelConsFunc panelConFunc = new panelConsFunc(window, thisPanel);
				window.atualiza(thisPanel, panelConFunc);
			}
		});
        
        ConReparos = new JButton("Reparos");
        ConReparos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panelConsReparo panelConReps = new panelConsReparo(window, thisPanel);
				window.atualiza(thisPanel, panelConReps);
			}
		});
        
        GroupLayout groupLayout = new GroupLayout(this);
        groupLayout.setHorizontalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        				.addComponent(Cadastro)
        				.addGroup(groupLayout.createSequentialGroup()
        					.addComponent(CadCli)
        					.addGap(5)
        					.addComponent(CadFunc)
        					.addGap(5)
        					.addComponent(CadVoos)
        					.addGap(5)
        					.addComponent(CadAeronaves)
        					.addGap(5)
        					.addComponent(CadAirports)
        					.addGap(5)
        					.addComponent(CadRepairs))
        				.addComponent(lblConsultas)
        				.addGroup(groupLayout.createSequentialGroup()
        					.addComponent(conFunc)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(conVoos)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(btnFrota)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(ConReparos)))
        			.addContainerGap(82, Short.MAX_VALUE))
        );
        groupLayout.setVerticalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(Cadastro)
        			.addGap(18)
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        				.addComponent(CadCli)
        				.addComponent(CadFunc)
        				.addComponent(CadVoos)
        				.addComponent(CadAeronaves)
        				.addComponent(CadAirports)
        				.addComponent(CadRepairs))
        			.addGap(55)
        			.addComponent(lblConsultas)
        			.addGap(18)
        			.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(conFunc)
        				.addComponent(conVoos)
        				.addComponent(btnFrota)
        				.addComponent(ConReparos))
        			.addContainerGap(120, Short.MAX_VALUE))
        );
        setLayout(groupLayout);
    }
}
