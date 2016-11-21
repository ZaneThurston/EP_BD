import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;

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
public class Main {
    public static void main (String args[]) {
        UserInterface janela = new UserInterface();
        BDLogin t = new BDLogin(janela, new InitialPanel(janela));
        janela.atualiza(new JPanel(), t);
        
    }
}
