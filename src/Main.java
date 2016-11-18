
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
    static BdConnector conector;
    public static void main (String args[]) {
        UserInterface janela = new UserInterface();
        InitialPanel t = new InitialPanel(janela, conector);
        janela.atualiza(new JPanel(), t);
    }
}
