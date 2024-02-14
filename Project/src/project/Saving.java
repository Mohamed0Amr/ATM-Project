/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Hamoudi
 */
public class Saving extends JFrame implements ActionListener {

    JTextField t;
    JButton b;
    File file1;
    String balance, pass, debt;
    double hg;
    Scanner cfileSc;

    public Saving(File file1) {
        setTitle("Saving");
        setLocation(490, 50);
        setVisible(true);
        this.file1 = file1;

    }

    void intial() {
        
        try {
            cfileSc = new Scanner(file1);
            String line;
            int flag = 0;
            while (flag == 0) {
                line = cfileSc.nextLine();
                if (line.contains("BALANCE: ")) {

                    balance = line.replace("BALANCE: ", "");
                    balance = balance.replace(" EGP", "");
                    hg = Double.parseDouble(balance);
                    break;
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Saving.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        JPanel p, p1, p2;

        p = new JPanel(new GridLayout(1, 2));
        p1 = new JPanel();

        t = new JTextField(""+hg);
        
        

        t.setPreferredSize(new Dimension(100, 50));
        t.addActionListener(this);
        p1.add(t);
        p.add(p1);
        p2 = new JPanel();
        b = new JButton("Calculate interset");
        p2.add(b);
        p.add(p2);
        add(p);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("Calculate interset")) {
            
            t.setText((hg + hg * 0.12) + "");
            

        }
    }

}
