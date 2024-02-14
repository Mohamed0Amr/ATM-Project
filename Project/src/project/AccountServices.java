package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import java.io.File;
import java.io.FileNotFoundException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class AccountServices extends JFrame implements ActionListener {

    JPanel p1, p2, p3, p4, p5, p6;
    JButton b1, b2, b3, b4, b5, back;
    JLabel l1;
    GridLayout g1, g2;
    String client;
    File cfile;

    public AccountServices(String client) {
        setTitle("Account Services");
        setLocation(490, 50);
        setVisible(true);
        this.client = client;
    }

    void initiate() {

        cfile = new File("F:\\Fue.Student\\(4)Fourth Semester\\Advanced Programming\\Project\\Project\\ACC DATA\\" + client + ".txt");

        p1 = new JPanel(new GridLayout(5, 1));
        p1.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20));

        p2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        l1 = new JLabel("Account Services", FlowLayout.LEFT);
        l1.setPreferredSize(new Dimension(350, 50));
        l1.setForeground(Color.WHITE);
        l1.setBackground(new Color(72, 190, 232));
        l1.setOpaque(true);
        p2.add(l1);

        g1 = new GridLayout(1, 2);
        g1.setHgap(10);
        g1.setVgap(10);

        p3 = new JPanel(g1);
        p3.setSize(new Dimension(400, 300));
        b1 = new JButton("Balance Inquiry");
        b1.setBackground(Color.cyan);
        b1.setForeground(Color.BLACK);
        b1.setPreferredSize(new Dimension(175, 100));
        b1.addActionListener(this);
        p3.add(b1);

        b2 = new JButton("Cash Withdraw");
        b2.setBackground(Color.cyan);
        b2.setForeground(Color.BLACK);
        b2.setPreferredSize(new Dimension(175, 100));
        b2.addActionListener(this);
        p3.add(b2);

        g2 = new GridLayout(1, 2);
        g2.setHgap(10);
        g2.setVgap(10);

        p4 = new JPanel(g2);
        p4.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        b3 = new JButton("Cash Deposit");
        b3.setBackground(Color.cyan);
        b3.setForeground(Color.BLACK);
        b3.setPreferredSize(new Dimension(175, 100));
        b3.addActionListener(this);
        p4.add(b3);

        b4 = new JButton("Transfer Account");
        b4.setBackground(Color.cyan);
        b4.setForeground(Color.BLACK);
        b4.setPreferredSize(new Dimension(175, 100));
        b4.addActionListener(this);
        p4.add(b4);

        p5 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        p5.setBorder(BorderFactory.createEmptyBorder(2, 0, 0, 0));
        b5 = new JButton("Saving Account");
        b5.setBackground(Color.cyan);
        b5.setForeground(Color.BLACK);
        b5.setPreferredSize(new Dimension(175, 75));
        b5.addActionListener(this);
        p5.add(b5);

        p6 = new JPanel(new FlowLayout(FlowLayout.TRAILING));
        back = new JButton("Back");
        back.setPreferredSize(new Dimension(100, 50));
        back.setBackground(Color.cyan);
        back.setForeground(Color.BLACK);
        back.addActionListener(this);
        p6.add(back);

        p1.add(p2);
        p1.add(p3);
        p1.add(p4);
        p1.add(p5);
        p1.add(p6);
        add(p1);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Back")) {
            playSound("F:\\Fue.Student\\(4)Fourth Semester\\Advanced Programming\\Project\\Project\\Sound2 Cut.wav");
            setVisible(false);
            Login login1 = new Login();
            login1.setSize(400, 370);
            login1.setResizable(false);
            login1.setDefaultCloseOperation(EXIT_ON_CLOSE);
            login1.initiate();
        } else if (e.getActionCommand().equals("Balance Inquiry")) {
            playSound("F:\\Fue.Student\\(4)Fourth Semester\\Advanced Programming\\Project\\Project\\Sound2 Cut.wav");
            setVisible(false);
            BalanceInquiry bi1 = new BalanceInquiry(cfile);
            bi1.setSize(400, 300);
            bi1.setResizable(false);
            bi1.setDefaultCloseOperation(EXIT_ON_CLOSE);
            try {
                bi1.initiate();
            } catch (FileNotFoundException ex) {
                System.err.println("FileNotFound");
            }
        } else if (e.getActionCommand().equals("Cash Deposit")) {
            playSound("F:\\Fue.Student\\(4)Fourth Semester\\Advanced Programming\\Project\\Project\\Sound2 Cut.wav");
            setVisible(false);
            CashDep cd1 = new CashDep(cfile);
            cd1.setSize(400, 200);
            cd1.setResizable(false);
            cd1.setDefaultCloseOperation(EXIT_ON_CLOSE);

            cd1.initiate();

        } else if (e.getActionCommand().equals("Cash Withdraw")) {
            playSound("F:\\Fue.Student\\(4)Fourth Semester\\Advanced Programming\\Project\\Project\\Sound2 Cut.wav");
            setVisible(false);
            CashWith cw1 = new CashWith(cfile);
            cw1.setSize(450, 450);
            cw1.setResizable(false);
            cw1.setDefaultCloseOperation(EXIT_ON_CLOSE);

            cw1.initiate();
        } else if (e.getActionCommand().equals("Transfer Account")) {
            playSound("F:\\Fue.Student\\(4)Fourth Semester\\Advanced Programming\\Project\\Project\\Sound2 Cut.wav");
            setVisible(false);
            Transfer trn1 = new Transfer(cfile);
            trn1.setSize(450, 350);
            trn1.setResizable(false);
            trn1.setDefaultCloseOperation(EXIT_ON_CLOSE);

            trn1.initiate();
        }
        else if(e.getActionCommand().equals("Saving Account")){
        playSound("F:\\Fue.Student\\(4)Fourth Semester\\Advanced Programming\\Project\\Project\\Sound2 Cut.wav");
            setVisible(false);
        Saving s = new Saving(cfile);
        s.setSize(450,350);
        s.setResizable(false);
        s.setDefaultCloseOperation(EXIT_ON_CLOSE);
        s.intial();
        
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
