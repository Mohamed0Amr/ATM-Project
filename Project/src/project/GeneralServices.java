package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class GeneralServices extends HomePage implements ActionListener {

    JPanel p5;
    JButton back;

    public GeneralServices() {
        super();
    }

    @Override
    void initiate() {
        p1 = new JPanel(new GridLayout(4, 1));
        p2 = new JPanel();
        font = new Font("Times New Roman", Font.BOLD, 20);
        l1 = new JLabel("General Services", FlowLayout.LEFT);
        l1.setPreferredSize(new Dimension(350, 50));
        l1.setForeground(Color.WHITE);
        l1.setBackground(new Color(212, 60, 36));
        l1.setOpaque(true);
        p2.add(l1);

        p3 = new JPanel();
        font = new Font("Times New Roman", Font.PLAIN, 12);
        b1 = new JButton("New Account");
        b1.setPreferredSize(new Dimension(350, 90));
        b1.setBackground(new Color(72, 190, 232));
        b1.setForeground(Color.BLACK);
        b1.addActionListener(this);
        p3.add(b1);

        p4 = new JPanel();
        font = new Font("Times New Roman", Font.PLAIN, 12);
        b2 = new JButton("List Services");
        b2.setPreferredSize(new Dimension(350, 90));
        b2.setBackground(new Color(72, 190, 232));
        b2.setForeground(Color.BLACK);
        b2.addActionListener(this);
        p4.add(b2);

        p5 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        font = new Font("Times New Roman", Font.PLAIN, 8);
        back = new JButton("Back");
        back.setPreferredSize(new Dimension(100, 50));
        back.setBackground(new Color(72, 190, 232));
        back.setForeground(Color.BLACK);
        back.addActionListener(this);
        p5.add(back);

        p1.add(p2);
        p1.add(p3);
        p1.add(p4);
        p1.add(p5);
        add(p1);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Back")) {
            playSound("F:\\Fue.Student\\(4)Fourth Semester\\Advanced Programming\\Project\\Project\\Sound2 Cut.wav");
            setVisible(false);
            HomePage hp1 = new HomePage();
            hp1.setSize(400, 450);
            hp1.setDefaultCloseOperation(EXIT_ON_CLOSE);
            hp1.initiate();
        }else if(e.getActionCommand().equals("List Services")){
            playSound("F:\\Fue.Student\\(4)Fourth Semester\\Advanced Programming\\Project\\Project\\Sound2 Cut.wav");
            setVisible(false);
            Login login1= new Login();
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
