package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class BalanceInquiry extends JFrame implements ActionListener {

    File cfile;
    Scanner cfileSc;
    String balance, line;
    JPanel p1, p2, p3, p4;
    JButton back;
    JLabel l1, l2;

    public BalanceInquiry(File cfile) throws HeadlessException {
        setTitle("Login");
        setLocation(490, 50);
        setVisible(true);
        this.cfile = cfile;
    }

    public void initiate() throws FileNotFoundException {

        cfileSc = new Scanner(cfile);
        int flag = 0;
        while (flag == 0) {
            line = cfileSc.nextLine();
            if (line.contains("BALANCE: ")) {
                break;
            }
        }

        balance = line.replace("BALANCE: ", "");

        p1 = new JPanel(new GridLayout(3, 1, 5, 5));
        p2 = new JPanel();
        l1 = new JLabel("Balance Inquiry", FlowLayout.LEFT);
        l1.setPreferredSize(new Dimension(350, 50));
        l1.setOpaque(true);
        l1.setForeground(Color.WHITE);
        l1.setBackground(new Color(212, 60, 36));
        p2.add(l1);

        p3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        l2 = new JLabel("Current Balance: " + balance);
        l2.setBackground(new Color(72, 190, 232));
        l2.setPreferredSize(new Dimension(350, 100));
        l2.setOpaque(true);
        l2.setBorder(BorderFactory.createEmptyBorder(0, 100, 20, 20));
        p3.add(l2);
        p4 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        p4.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 20));
        back = new JButton("Back");
        back.setPreferredSize(new Dimension(70, 30));
        back.setBackground(new Color(72, 190, 232));
        back.setForeground(Color.BLACK);
        back.addActionListener(this);
        p4.add(back);
        p1.add(p2);
        p1.add(p3);
        p1.add(p4);
        add(p1);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Back")) {
            playSound("F:\\Fue.Student\\(4)Fourth Semester\\Advanced Programming\\Project\\Project\\Sound2 Cut.wav");
            setVisible(false);
            AccountServices acc1 = new AccountServices(null);
            acc1.setSize(400, 450);
            acc1.setResizable(false);
            acc1.setDefaultCloseOperation(EXIT_ON_CLOSE);
            acc1.initiate();
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
