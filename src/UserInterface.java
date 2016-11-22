
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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
        mainWindow.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        mainWindow.addWindowListener(new WindowAdapter() {
        	public void windowClosing(WindowEvent e) {
        		try {
        			BdConnector.CloseConnection();
        		} catch (java.lang.NullPointerException exc) {
        			
        		}
        		System.exit(0);
        	}     	
        });
    }
    
    // troca um frame por outro dentro da janela
    public void atualiza(JPanel ant, JPanel prox) {
        mainWindow.remove(ant);
        mainWindow.getContentPane().add(prox);
        mainWindow.revalidate();
    }
}
