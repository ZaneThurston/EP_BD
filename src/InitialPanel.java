
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
                CadRepairs;
    InitialPanel thisPanel = this;
    private JLabel Cadastro;
    private JLabel lblConsultas;
    
    // constroi o painel na janela da interface, inicializa componentes
    public InitialPanel(UserInterface window, BdConnector conector) {
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
                PanelCadCli panelCli = new PanelCadCli(window, conector, thisPanel);
                window.atualiza(thisPanel, panelCli);
            }
         });
        
        CadFunc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PanelCadFuncionario panelFunc = new PanelCadFuncionario(window, conector, thisPanel);
                window.atualiza(thisPanel, panelFunc);
            }
         });
        
        CadVoos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PanelCadVoos panelVoos = new PanelCadVoos(window, conector, thisPanel);
                window.atualiza(thisPanel, panelVoos);
            }
        });
        
        CadAeronaves.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PanelCadAeronaves panelAeronaves = new PanelCadAeronaves(window, conector, thisPanel);
                window.atualiza(thisPanel, panelAeronaves);
            }
        });
        
        CadAirports.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PanelCadAeroportos panelAirports = new PanelCadAeroportos(window, conector, thisPanel);
                window.atualiza(thisPanel, panelAirports);
            }
        });
        
        CadRepairs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PanelCadReparo panelRepairs = new PanelCadReparo(window, conector, thisPanel);
                window.atualiza(thisPanel, panelRepairs);
            }
        });
        
        Cadastro = new JLabel("Cadastro");
        Cadastro.setFont(new Font("Tahoma", Font.PLAIN, 13));
        
        lblConsultas = new JLabel("Consultas");
        lblConsultas.setFont(new Font("Tahoma", Font.PLAIN, 13));
        
        JButton btnVoos = new JButton("Voos");
        
        JButton btnFrota = new JButton("Frota");
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
        					.addComponent(btnVoos)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(btnFrota)))
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
        				.addComponent(btnVoos)
        				.addComponent(btnFrota))
        			.addContainerGap(120, Short.MAX_VALUE))
        );
        setLayout(groupLayout);
    }
}
