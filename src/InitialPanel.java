
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JPanel;
import javax.swing.JButton;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Marcos
 */
public class InitialPanel extends JPanel{
    JButton CadastroCliFunc,
                CadAeronaves,
                CadAirports,
                CadVoos,
                CadRepairs;
    
    public InitialPanel(UserInterface window) {
        CadastroCliFunc = new JButton("Clientes/Funcionários");
        CadAeronaves = new JButton("Aeronaves");
        CadAirports = new JButton("Aeroportos");
        CadVoos = new JButton("Voos");
        CadRepairs = new JButton("Registro de reparos");
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension buttonSizes = new Dimension();
        buttonSizes.setSize(90, 130);
        this.setVisible(true);
        /*this.CadastroCliFunc.setBounds(90, 10, buttonSizes.height, buttonSizes.width);
        this.CadVoos.setSize(buttonSizes);
        this.CadAeronaves.setSize(buttonSizes);
        this.CadAirports.setSize(buttonSizes);
        this.CadRepairs.setSize(buttonSizes);
        */
        this.add(CadastroCliFunc);
        this.add(CadVoos);
        this.add(CadAeronaves);
        this.add(CadAirports);
        this.add(CadRepairs);
        
    }
}
