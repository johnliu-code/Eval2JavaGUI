/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evaluation2java;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 *
 * @author atdig
 */
public class MyMenu extends JFrame implements ActionListener{
    Calculatrice calcul;
    Calculatrice2 calcul2;
    JMenuBar menu;
    JMenu excercice1, excercice2, quitter;
    JMenuItem enonceItem1, enonceItem2, quitterItem;
    MyMenu () {
    this.setTitle("Evaluation 2");
    this.setSize(500, 500);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    this.setLayout(new FlowLayout());
    
    menu = new JMenuBar();
    excercice1 = new JMenu("Excercice1");
    excercice2 = new JMenu("Excercice2");
    quitter = new JMenu("quitter");
    
    enonceItem1 = new JMenuItem("Enonce");
    enonceItem2 = new JMenuItem("Enonce");
    quitterItem = new JMenuItem("Quitter");
    
    excercice1.add(enonceItem1);
    excercice2.add(enonceItem2);
    quitter.add(quitterItem);

    menu.add(excercice1);
    menu.add(excercice2);
    menu.add(quitter);
    
    enonceItem1.addActionListener(this);
    enonceItem2.addActionListener(this);
    quitterItem.addActionListener(this);
     
    this.setJMenuBar(menu); 
    this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == enonceItem1)
             calcul = new  Calculatrice();
        if (e.getSource() == enonceItem2)
             calcul2 = new  Calculatrice2();
        if (e.getSource() == quitterItem){
             String message = "Veuiilez quitter le system? Yes/No";
             int ans = JOptionPane.showConfirmDialog(null, message, "Quitter? Yes/No", JOptionPane.YES_NO_CANCEL_OPTION);
             if(ans == 0){
                 this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
             }            
        }
 
    }
    
}
