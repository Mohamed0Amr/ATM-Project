package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class HomePage extends JFrame implements ActionListener {

    JButton b1, b2;
    JPanel p1, p2, p3, p4;
    JLabel l1;
    Font font;

    public HomePage() {

        setTitle("ATM");
        setLocation(490, 50);
        setVisible(true);

    }

    void initiate() {
        p1 = new JPanel(new GridLayout(3, 1));
        p2 = new JPanel();
        font = new Font("Times New Roman", Font.BOLD, 20);
        l1 = new JLabel("Home Page", FlowLayout.LEFT);
        l1.setPreferredSize(new Dimension(350, 50));
        l1.setForeground(Color.WHITE);
        l1.setBackground(new Color(212, 60, 36));
        l1.setOpaque(true);
        p2.add(l1);
        //new Color(72, 190, 232)
        //new Color(212, 60, 36)
        p3 = new JPanel();
        font = new Font("Times New Roman", Font.PLAIN, 12);
        b1 = new JButton("Account Services");
        b1.setPreferredSize(new Dimension(350, 100));
        b1.setBackground(new Color(72, 190, 232));
        b1.setForeground(Color.BLACK);
        b1.addActionListener(this);
        p3.add(b1);

        p4 = new JPanel();
        font = new Font("Times New Roman", Font.PLAIN, 12);
        b2 = new JButton("General Services");
        b2.setPreferredSize(new Dimension(350, 100));
        b2.setBackground(new Color(72, 190, 232));
        b2.setForeground(Color.BLACK);
        b2.addActionListener(this);
        p4.add(b2);
        p1.add(p2);
        p1.add(p3);
        p1.add(p4);
        add(p1);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("General Services")) {
            playSound("F:\\Fue.Student\\(4)Fourth Semester\\Advanced Programming\\Project\\Project\\Sound1 Cut.wav");
            setVisible(false);
            GeneralServices gs1 = new GeneralServices();
            gs1.setSize(400, 450);
            gs1.setResizable(false);
            gs1.setDefaultCloseOperation(EXIT_ON_CLOSE);
            gs1.initiate();
        } else if (e.getActionCommand().equals("Account Services")) {
            playSound("F:\\Fue.Student\\(4)Fourth Semester\\Advanced Programming\\Project\\Project\\Sound1 Cut.wav");
            setVisible(false);
            Login login1 = new Login();
            login1.setSize(400, 370);
            login1.setResizable(false);
            login1.setDefaultCloseOperation(EXIT_ON_CLOSE);
            login1.initiate();
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
