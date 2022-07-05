/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evaluation2java;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author atdig
 */
public class Calculatrice extends JFrame implements ActionListener{
    JTextField nombre1Box, nombre2Box;
    JComboBox cbChoix;
    JButton btnRes, btnRein, btnRetour;
    String val1, val2, resultat;
    double a, b, result = 0;
    Calculatrice(){
        this.setTitle("Calculatrice");
        this.setSize(600, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        
        //JPanel panMain = new JPanel();
        //Two parts of the main container
        JPanel panTop = new JPanel();
        JPanel panBottom = new JPanel();
        
        panTop.setBorder(new EmptyBorder(50, 20, 20, 20));
        panBottom.setBorder(new EmptyBorder(20, 20, 50, 20));
        
        panTop.setLayout(new FlowLayout());
        panBottom.setLayout(new FlowLayout());
        
        //Input value areas layout
        JPanel panValue1 = new JPanel();
        JPanel panValue2 = new JPanel();
        JPanel panOperation = new JPanel();
        
        panValue1.setLayout(new BorderLayout());
        panValue2.setLayout(new BorderLayout());
        panOperation.setLayout(new BorderLayout());
        
        JLabel nombre1 = new JLabel("Nombre1");
        JLabel nombre2 = new JLabel("Nombre2");
        JLabel operation = new JLabel("Operation");
        
        nombre1Box = new JTextField(15); 
        nombre1Box.setPreferredSize(new Dimension(150, 30));
        nombre2Box = new JTextField(15);
        nombre2Box.setPreferredSize(new Dimension(150, 30));
        
        panValue1.add(nombre1, BorderLayout.NORTH);
        panValue1.add(nombre1Box, BorderLayout.SOUTH);
        panValue2.add(nombre2, BorderLayout.NORTH);
        panValue2.add(nombre2Box, BorderLayout.SOUTH);

        
        String[] choix = {"+","-","*", "/"};
        cbChoix = new JComboBox(choix);
        cbChoix.setPreferredSize(new Dimension(50, 30));
        
        panOperation.add(operation, BorderLayout.NORTH);
        panOperation.add(cbChoix, BorderLayout.SOUTH);
        
        panTop.add(panValue1);
        panTop.add(panOperation);
        panTop.add(panValue2);
        
        btnRes = new JButton("Resultat");
        btnRein = new JButton("Reinitialiser");
        btnRetour = new JButton("Retour");
        
        panBottom.add(btnRes);
        panBottom.add(btnRein);
        panBottom.add(btnRetour);
        
        btnRes.addActionListener(this);
        btnRein.addActionListener(this);
        btnRetour.addActionListener(this);
        
        //Add parts to main
        this.add(panTop, BorderLayout.NORTH);
        this.add(panBottom, BorderLayout.SOUTH);
          
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnRes) {
            a = Double.parseDouble(nombre1Box.getText());
            b = Double.parseDouble(nombre2Box.getText());
            if(cbChoix.getSelectedItem().toString() == "+")
                result = a + b;
            if(cbChoix.getSelectedItem().toString() == "-")
                result = a - b;
            if(cbChoix.getSelectedItem().toString() == "*")
                result = a * b;
            if(cbChoix.getSelectedItem().toString() == "/" && b != 0)
                result = a / b;
            
            resultat = Double.toString(result);
            String message = "Resultat de operation est: " + resultat;
            ImageIcon icon = new ImageIcon("java.png");
            JOptionPane.showMessageDialog(null, message, "Reultat", JOptionPane.PLAIN_MESSAGE, icon);
            //dispose();
        }
        if (e.getSource() == btnRein){
            nombre1Box.setText("");
            nombre2Box.setText("");
            a = 0;  b = 0; result = 0;
        }
        if (e.getSource() == btnRetour){
            //MyMenu menu = new MyMenu();
            dispose();
        }
    }
}
