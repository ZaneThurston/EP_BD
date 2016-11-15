
import javax.swing.JButton;
import javax.swing.JPanel;

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
	JButton jButtonVoltar,
                jButtonSave,
                jButtonClean;
    PanelCadAeronaves thisPanel = this;
    
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonVoltar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 523, Short.MAX_VALUE)
                        .addComponent(jButtonClean)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonSave)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 407, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonVoltar)
                    .addComponent(jButtonSave)
                    .addComponent(jButtonClean))
                .addContainerGap())
        );
    }
}
