/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evaluation2java;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.Math.sqrt;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author atdig
 */
public class Calculatrice2 extends JFrame implements ActionListener {
    JTextField nombre1Box, nombre2Box, nombre3Box;
    JButton btnRes, btnGuide;
    String val1, val2, resultat;
    double a, b, c, delta, x, x1, x2, result;
    Calculatrice2(){
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
        JPanel panValue3 = new JPanel();
        
        panValue1.setLayout(new BorderLayout());
        panValue2.setLayout(new BorderLayout());
        panValue3.setLayout(new BorderLayout());
        
        JLabel nombre_a = new JLabel("Nombre a");
        JLabel nombre_b = new JLabel("Nombre b");
        JLabel nombre_c = new JLabel("Nombre c");
        
        nombre1Box = new JTextField(15); 
        nombre1Box.setPreferredSize(new Dimension(150, 30));
        nombre2Box = new JTextField(15);
        nombre2Box.setPreferredSize(new Dimension(150, 30));
        nombre3Box = new JTextField(15);
        nombre3Box.setPreferredSize(new Dimension(150, 30));
        
        panValue1.add(nombre_a, BorderLayout.NORTH);
        panValue1.add(nombre1Box, BorderLayout.SOUTH);
        panValue2.add(nombre_b, BorderLayout.NORTH);
        panValue2.add(nombre2Box, BorderLayout.SOUTH);     
        panValue3.add(nombre_c, BorderLayout.NORTH);
        panValue3.add(nombre3Box, BorderLayout.SOUTH);
        
        panTop.add(panValue1);
        panTop.add(panValue2);
        panTop.add(panValue3);
        
        btnRes = new JButton("Resultat");
        btnGuide = new JButton("Guide");
        
        panBottom.add(btnRes);
        panBottom.add(btnGuide);
        
        btnRes.addActionListener(this);
        btnGuide.addActionListener(this);
        
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
            c = Double.parseDouble(nombre3Box.getText());
                    
            delta = b*2- 4*a*c;
            
            if (delta < 0)
                resultat = null;
            if (delta == 0){
                x =  -b / (2*a);  
                result = x;
                resultat = Double.toString(result);
            }
                  
            if (delta > 0){
                x1 =(-b- sqrt(delta))/2*a;
                x2 =(-b+ sqrt(delta))/2*a;              
                resultat = "x1= " + Double.toString(x1) + ", x2 = " + Double.toString(x2);
            }

            String message = "Resultat de operation est: " + resultat;
            ImageIcon icon = new ImageIcon("java.png");
            JOptionPane.showMessageDialog(null, message, "Reultat", JOptionPane.PLAIN_MESSAGE, icon);
            //dispose();
        }
        if (e.getSource() == btnGuide){
            JFileChooser fichier = new JFileChooser();
            int reponse = fichier.showOpenDialog(null);
            if (reponse == 0){
                try {
                    readFile(fichier.getSelectedFile().getAbsolutePath());
                } catch (Exception ex){
                    System.out.println("Erreur");
                }
            }
        }
    }
    
        private void readFile(String absolutePath){
        BufferedReader reader;
        FileReader lire;
        String ligne;
        try{
            lire = new FileReader(new File(absolutePath));
            reader = new BufferedReader(lire);
            do {
                ligne = reader.readLine();
                System.out.println(ligne + "\n");
            } while (ligne != null);
        }catch(IOException ex){
            System.out.println("Le fichier n'a pas trouve!");
        }
    }
}
