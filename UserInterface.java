
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Toolkit;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowStateListener;

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
        mainWindow.addWindowListener(new WindowListener() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				// TODO Auto-generated method stub
				BdConnector.CloseConnection();
				
			}

			@Override
			public void windowActivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowClosed(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeactivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeiconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowIconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowOpened(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
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
