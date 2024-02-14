package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.io.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class CashDep extends JFrame implements ActionListener {

    JPanel p1, p2, p3, p4, p5;
    JLabel l1, l2;
    JButton dep, back;
    JTextField t1;
    File cfile;
    Scanner cfileSc;
    double depcash, main;
    PrintWriter pwout;
    String pass, balance, dept;
    public CashDep(File cfile) {
        setTitle("Cash Deposit");
        setLocation(490, 50);
        setVisible(true);
        this.cfile = cfile;
    }

    public void initiate() {
        p1 = new JPanel();
        p2 = new JPanel();
        l1 = new JLabel("Cash Deposit", FlowLayout.LEFT);
        l1.setPreferredSize(new Dimension(350, 50));
        l1.setOpaque(true);
        l1.setForeground(Color.WHITE);
        l1.setBackground(new Color(212, 60, 36));
        p2.add(l1);

        p3 = new JPanel();
        l2 = new JLabel("Enter Amount: ", FlowLayout.LEFT);
        p3.add(l2);
        t1 = new JTextField();
        t1.setPreferredSize(new Dimension(200, 30));
        t1.addActionListener(this);
        p3.add(t1);

        p4 = new JPanel();
        dep = new JButton("Deposit Amount");
        dep.setForeground(Color.BLACK);
        dep.setBackground(new Color(72, 190, 232));
        dep.addActionListener(this);
        p4.add(dep);

        p1.add(p2);
        p1.add(p3);
        p1.add(p4);
        add(p1);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            cfileSc = new Scanner(cfile);
        } catch (FileNotFoundException ex) {
            System.err.println("FileNotFound");
        }
        pass = cfileSc.nextLine();
        balance = cfileSc.nextLine();
        dept = cfileSc.nextLine();
        if (e.getActionCommand().equals("Deposit Amount")) {
            playSound("F:\\Fue.Student\\(4)Fourth Semester\\Advanced Programming\\Project\\Project\\Sound2 Cut.wav");
            String temp1, temp2;
            temp1 = t1.getText();
            depcash = Double.parseDouble(temp1);
            
            balance=balance.replace("BALANCE: ", "");
            balance=balance.replace(" EGP", "");
            temp2=balance;
            main = Double.parseDouble(temp2);
            double total = depcash + main;
            try {
                pwout = new PrintWriter(cfile);
            } catch (FileNotFoundException ex) {

            }
            pwout.write(pass+"\n"+("BALANCE: " + total + " EGP")+"\n"+dept);
            pwout.flush();
            JOptionPane.showMessageDialog(this, "Operation Successful");
        }

    }
    public void playSound(String soundName) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }
    }

}
