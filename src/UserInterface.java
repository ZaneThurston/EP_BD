
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.Toolkit;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Marcos
 */
public class UserInterface extends JFrame {
    JFrame mainWindow = this;
    int width, height;
    
    // construtor para a janela principal
    public UserInterface() {
        mainWindow.setTitle("Gerenciamento da Companhia");
        Toolkit toolSet = Toolkit.getDefaultToolkit();
        Dimension size = toolSet.getScreenSize();
        width = size.width;
        height = size.height;
        mainWindow.setBounds((width / 2) - 180, (height / 2) - 320, 815, 600);
        mainWindow.setVisible(true);
        mainWindow.setResizable(false);
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    // troca um frame por outro dentro da janela
    public void atualiza(JPanel ant, JPanel prox) {
        mainWindow.remove(ant);
        mainWindow.getContentPane().add(prox);
        mainWindow.revalidate();
    }
}
