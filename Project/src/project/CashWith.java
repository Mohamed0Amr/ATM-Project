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

public class CashWith extends JFrame implements ActionListener {

    JPanel p1, p2, p3, p4, p5;
    JLabel l1, l2;
    JButton dep, back;
    JTextField t1;
    File cfile;
    Scanner cfileSc;
    JButton b100, b200, b500, b1k, b2k, bw;
    double withcash, main;
    PrintWriter pwout;
    String temp1, temp2;
    String balance, pass, dept;

    public CashWith(File cfile) {
        setTitle("Cash Withdraw");
        setLocation(490, 50);
        setVisible(true);
        this.cfile = cfile;
    }

    public void initiate() {
        p1 = new JPanel();
        p1.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 20));
        p2 = new JPanel();
        l1 = new JLabel("Cash Deposit", FlowLayout.LEFT);
        l1.setPreferredSize(new Dimension(350, 50));
        l1.setOpaque(true);
        l1.setForeground(Color.WHITE);
        l1.setBackground(new Color(212, 60, 36));
        p2.add(l1);

        p3 = new JPanel();
        l2 = new JLabel("Custom Amount: ", FlowLayout.LEFT);
        p3.add(l2);
        t1 = new JTextField();
        t1.setPreferredSize(new Dimension(200, 30));
        t1.addActionListener(this);
        p3.add(t1);
        bw = new JButton("Withdraw");
        bw.setPreferredSize(new Dimension(70, 30));
        bw.setBackground(new Color(72, 190, 232));
        bw.addActionListener(this);
        p3.add(bw);

        p4 = new JPanel(new GridLayout(2, 2, 10, 25));
        b100 = new JButton("100 EGP");
        b100.setPreferredSize(new Dimension(150, 75));
        b100.setBackground(new Color(72, 190, 232));
        b100.addActionListener(this);
        p4.add(b100);

        b200 = new JButton("200 EGP");
        b200.setPreferredSize(new Dimension(150, 75));
        b200.setBackground(new Color(72, 190, 232));
        b200.addActionListener(this);
        p4.add(b200);

        b500 = new JButton("500 EGP");
        b500.setPreferredSize(new Dimension(150, 75));
        b500.setBackground(new Color(72, 190, 232));
        b500.addActionListener(this);
        p4.add(b500);

        b1k = new JButton("1000 EGP");
        b1k.setPreferredSize(new Dimension(150, 75));
        b1k.setBackground(new Color(72, 190, 232));
        b1k.addActionListener(this);
        p4.add(b1k);

        p5 = new JPanel();
        p5.setAlignmentX(BOTTOM_ALIGNMENT);
        //p5.setBorder(border);
        b2k = new JButton("2000 EGP");
        b2k.setPreferredSize(new Dimension(100, 75));
        b2k.setBackground(new Color(72, 190, 232));
        b2k.addActionListener(this);
        p5.add(b2k);

        p1.add(p2);
        p1.add(p3);
        p1.add(p4);
        p1.add(p5);
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
        if (e.getActionCommand().equals("100 EGP")) {
            playSound("F:\\Fue.Student\\(4)Fourth Semester\\Advanced Programming\\Project\\Project\\Sound2 Cut.wav");
            withcash = 100;

            balance = balance.replace("BALANCE: ", "");
            balance = balance.replace(" EGP", "");
            System.out.println(balance);
            main = Double.parseDouble(balance);
            if (main >= withcash) {
                double total = main - withcash;
                try {
                    pwout = new PrintWriter(cfile);
                } catch (FileNotFoundException ex) {

                }
                pwout.write(pass+"\n"+("BALANCE: " + total + " EGP")+"\n"+dept);
                pwout.flush();
                JOptionPane.showMessageDialog(this, "Operation Successful, BALANCE: " + total);
            } else {
                JOptionPane.showMessageDialog(this, "Operation Unsuccessful, Balance Insufficient, BALANCE: " + main);
            }
        } else if (e.getActionCommand().equals("200 EGP")) {
            playSound("F:\\Fue.Student\\(4)Fourth Semester\\Advanced Programming\\Project\\Project\\Sound2 Cut.wav");
            withcash = 200;
            balance = balance.replace("BALANCE: ", "");
            balance = balance.replace(" EGP", "");
            System.out.println(balance);
            main = Double.parseDouble(balance);
            if (main >= withcash) {
                double total = main - withcash;
                try {
                    pwout = new PrintWriter(cfile);
                } catch (FileNotFoundException ex) {

                }
                pwout.write(pass+"\n"+("BALANCE: " + total + " EGP")+"\n"+dept);
                pwout.flush();
                JOptionPane.showMessageDialog(this, "Operation Successful, BALANCE: " + total);
            } else {
                JOptionPane.showMessageDialog(this, "Operation Unsuccessful, Balance Insufficient, BALANCE: " + main);
            }
        } else if (e.getActionCommand().equals("500 EGP")) {
            playSound("F:\\Fue.Student\\(4)Fourth Semester\\Advanced Programming\\Project\\Project\\Sound2 Cut.wav");
            withcash = 500;
            balance = balance.replace("BALANCE: ", "");
            balance = balance.replace(" EGP", "");
            System.out.println(balance);
            main = Double.parseDouble(balance);
            if (main >= withcash) {
                double total = main - withcash;
                try {
                    pwout = new PrintWriter(cfile);
                } catch (FileNotFoundException ex) {

                }
                pwout.write(pass+"\n"+("BALANCE: " + total + " EGP")+"\n"+dept);
                pwout.flush();
                JOptionPane.showMessageDialog(this, "Operation Successful, BALANCE: " + total);
            } else {
                JOptionPane.showMessageDialog(this, "Operation Unsuccessful, Balance Insufficient, BALANCE: " + main);
            }

        } else if (e.getActionCommand().equals("1000 EGP")) {
            playSound("F:\\Fue.Student\\(4)Fourth Semester\\Advanced Programming\\Project\\Project\\Sound2 Cut.wav");
            withcash = 1000;
            balance = balance.replace("BALANCE: ", "");
            balance = balance.replace(" EGP", "");
            System.out.println(balance);
            main = Double.parseDouble(balance);
            if (main >= withcash) {
                double total = main - withcash;
                try {
                    pwout = new PrintWriter(cfile);
                } catch (FileNotFoundException ex) {

                }
                pwout.write(pass+"\n"+("BALANCE: " + total + " EGP")+"\n"+dept);
                pwout.flush();
                JOptionPane.showMessageDialog(this, "Operation Successful, BALANCE: " + total);
            } else {
                JOptionPane.showMessageDialog(this, "Operation Unsuccessful, Balance Insufficient, BALANCE: " + main);
            }
        } else if (e.getActionCommand().equals("2000 EGP")) {
            playSound("F:\\Fue.Student\\(4)Fourth Semester\\Advanced Programming\\Project\\Project\\Sound2 Cut.wav");
            withcash = 2000;
            balance = balance.replace("BALANCE: ", "");
            balance = balance.replace(" EGP", "");
            System.out.println(balance);
            main = Double.parseDouble(balance);
            if (main >= withcash) {
                double total = main - withcash;
                try {
                    pwout = new PrintWriter(cfile);
                } catch (FileNotFoundException ex) {

                }
                pwout.write(pass+"\n"+("BALANCE: " + total + " EGP")+"\n"+dept);
                pwout.flush();
                JOptionPane.showMessageDialog(this, "Operation Successful, BALANCE: " + total);
            } else {
                JOptionPane.showMessageDialog(this, "Operation Unsuccessful, Balance Insufficient, BALANCE: " + main);
            }
        } else if (e.getActionCommand().equals("Withdraw")) {
            playSound("F:\\Fue.Student\\(4)Fourth Semester\\Advanced Programming\\Project\\Project\\Sound2 Cut.wav");
            temp1 = t1.getText();
            withcash = Double.parseDouble(temp1);
            balance = balance.replace("BALANCE: ", "");
            balance = balance.replace(" EGP", "");
            System.out.println(balance);
            main = Double.parseDouble(balance);
            if (main >= withcash) {
                double total = main - withcash;
                try {
                    pwout = new PrintWriter(cfile);
                } catch (FileNotFoundException ex) {
                    System.err.println("FileNotFound");
                }
                pwout.write(pass+"\n"+("BALANCE: " + total + " EGP")+"\n"+dept);
                pwout.flush();
                JOptionPane.showMessageDialog(this, "Operation Successful, BALANCE: " + total);
            } else {
                JOptionPane.showMessageDialog(this, "Operation Unsuccessful, Balance Insufficient, BALANCE: " + main);
            }
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
