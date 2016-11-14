
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowStateListener;

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
        InitialPanel t = new InitialPanel(janela);
        janela.add(t);
    }
}
