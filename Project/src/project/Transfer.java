package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Transfer extends JFrame implements ActionListener {

    JPanel p1, p2, p3, p4, p5, p6;
    JLabel l1, l2, l3;
    JButton b1, back;
    JTextField tf1, tf2;
    File cfile, tfile;
    String tranAcc;
    double val;
    Scanner cfileSc, tfileSc;

    public Transfer(File cfile) {
        setTitle("Transfer");
        this.cfile = cfile;
        setVisible(true);
        setLocation(490, 50);
    }

    void initiate() {
        p1 = new JPanel(new GridLayout(4, 1, 5, 5));
        p2 = new JPanel();
        l1 = new JLabel("Cash Transfer", FlowLayout.LEFT);
        l1.setPreferredSize(new Dimension(350, 50));
        l1.setOpaque(true);
        l1.setForeground(Color.WHITE);
        l1.setBackground(new Color(212, 60, 36));
        p2.add(l1);

        p3 = new JPanel();
        l2 = new JLabel("Account Number: ", FlowLayout.LEFT);
        p3.add(l2);
        tf1 = new JTextField();
        tf1.setPreferredSize(new Dimension(200, 30));
        tf1.addActionListener(this);
        p3.add(tf1);

        p4 = new JPanel();
        l3 = new JLabel("Amount To Transfer: ", FlowLayout.LEFT);
        p4.add(l3);
        tf2 = new JTextField();
        tf2.setPreferredSize(new Dimension(200, 30));
        tf2.addActionListener(this);
        p4.add(tf2);

        p5 = new JPanel();
        b1 = new JButton("Transfer");
        b1.setPreferredSize(new Dimension(100, 40));
        b1.setForeground(Color.BLACK);
        b1.setBackground(new Color(72, 190, 232));
        b1.addActionListener(this);
        p5.add(b1);
        p1.add(p2);
        p1.add(p3);
        p1.add(p4);
        p1.add(p5);
        // p1.add(p6);
        add(p1);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Transfer")) {
            playSound("F:\\Fue.Student\\(4)Fourth Semester\\Advanced Programming\\Project\\Project\\Sound2 Cut.wav");
            tranAcc = tf1.getText();
            tfile = new File("F:\\Fue.Student\\(4)Fourth Semester\\Advanced Programming\\Project\\Project\\ACC DATA\\" + tranAcc + ".txt");
            try {
                tfileSc = new Scanner(tfile);
            } catch (FileNotFoundException ex) {
                System.err.println("FileNotFound");
            }
            String tpass = tfileSc.nextLine();
            String tbalance = tfileSc.nextLine();
            String tdebt = tfileSc.nextLine();

            tbalance = tbalance.replace("BALANCE: ", "");
            tbalance = tbalance.replace(" EGP", "");

            double mainT = Double.parseDouble(tbalance);

            try {
                cfileSc = new Scanner(cfile);
            } catch (FileNotFoundException ex) {
                System.err.println("FileNotFound");
            }

            String cpass = cfileSc.nextLine();
            String cbalance = cfileSc.nextLine();
            String cdebt = cfileSc.nextLine();

            cbalance = cbalance.replace("BALANCE: ", "");
            cbalance = cbalance.replace(" EGP", "");

            double mainC = Double.parseDouble(cbalance);

            String temp = tf2.getText();
            double transVal = Double.parseDouble(temp);

            if ((mainC >= transVal) && !(cfile.getPath().equals(tfile.getPath()))) {
                mainC -= transVal;
                mainT += transVal;

                try {
                    PrintWriter pwC = new PrintWriter(cfile.getPath());
                    pwC.write(cpass + "\n" + "BALANCE: " + mainC + " EGP" + "\n" + cdebt);
                    pwC.flush();
                    System.out.println(cpass + "\n" + "BALANCE: " + mainC + " EGP" + "\n" + cdebt);
                } catch (FileNotFoundException ex) {
                    System.err.println("FileNotFound");
                }

                try {
                    PrintWriter pwT = new PrintWriter(tfile.getPath());
                    pwT.write(tpass + "\n" + "BALANCE: " + mainT + " EGP" + "\n" + tdebt);
                    pwT.flush();
                    System.out.println(tpass + "\n" + "BALANCE: " + mainT + " EGP" + "\n" + tdebt);
                } catch (FileNotFoundException ex) {
                    System.err.println("FileNotFound");
                }
                JOptionPane.showMessageDialog(this, "Operation Successful");

            } else {
                JOptionPane.showMessageDialog(this, "Operation Unsuccessful, Insufficient balance or incorrect Account number.");
                tf1.setText("");
                tf2.setText("");

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
