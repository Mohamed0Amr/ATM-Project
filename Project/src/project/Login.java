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

public class Login extends JFrame implements ActionListener {

    File fUserPass;
    JPanel p1, p2, p3, p4, p5, p6, p7, p8;
    JTextField t1;
    JLabel l1, l2;
    JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, bc, be, back;
    Font font;
    GridLayout grid1, grid2;
    GridBagLayout gb1;
    BorderFactory border1;
    String accNo, pass, all, line, client;
    Scanner data;

    public Login() {
        setTitle("Login");
        setLocation(490, 50);
        setVisible(true);
    }

    public void initiate() {
        pass = "";
        p1 = new JPanel();
        p2 = new JPanel();
        l1 = new JLabel("Account Login", FlowLayout.LEFT);
        l1.setPreferredSize(new Dimension(350, 50));
        l1.setOpaque(true);
        l1.setForeground(Color.WHITE);
        l1.setBackground(new Color(212, 60, 36));
        p2.add(l1);

        p3 = new JPanel();
        l2 = new JLabel("Account Number: ", FlowLayout.LEFT);
        p3.add(l2);
        t1 = new JTextField();
        t1.setPreferredSize(new Dimension(200, 30));
        t1.addActionListener(this);
        p3.add(t1);

        grid1 = new GridLayout(1, 3);
        grid1.setHgap(5);
        grid1.setVgap(10);

        p4 = new JPanel(grid1);
        p4.setBorder(BorderFactory.createEmptyBorder(0, 155, 0, 20));
        b1 = new JButton("1");
        b1.setPreferredSize(new Dimension(70, 30));
        b1.setBackground(new Color(72, 190, 232));
        b1.setForeground(Color.BLACK);
        b1.addActionListener(this);
        p4.add(b1);

        b2 = new JButton("2");
        b2.setPreferredSize(new Dimension(70, 30));
        b2.setBackground(new Color(72, 190, 232));
        b2.setForeground(Color.BLACK);
        b2.addActionListener(this);
        p4.add(b2);

        b3 = new JButton("3");
        b3.setPreferredSize(new Dimension(70, 30));
        b3.setBackground(new Color(72, 190, 232));
        b3.setForeground(Color.BLACK);
        b3.addActionListener(this);
        p4.add(b3);

        p5 = new JPanel(grid1);
        p5.setBorder(BorderFactory.createEmptyBorder(0, 155, 0, 20));
        b4 = new JButton("4");
        b4.setPreferredSize(new Dimension(70, 30));
        b4.setBackground(new Color(72, 190, 232));
        b4.setForeground(Color.BLACK);
        b4.addActionListener(this);
        p5.add(b4);

        b5 = new JButton("5");
        b5.setPreferredSize(new Dimension(70, 30));
        b5.setBackground(new Color(72, 190, 232));
        b5.setForeground(Color.BLACK);
        b5.addActionListener(this);
        p5.add(b5);

        b6 = new JButton("6");
        b6.setPreferredSize(new Dimension(70, 30));
        b6.setBackground(new Color(72, 190, 232));
        b6.setForeground(Color.BLACK);
        b6.addActionListener(this);
        p5.add(b6);

        p6 = new JPanel(grid1);
        p6.setBorder(BorderFactory.createEmptyBorder(0, 155, 0, 20));
        b7 = new JButton("7");
        b7.setPreferredSize(new Dimension(70, 30));
        b7.setBackground(new Color(72, 190, 232));
        b7.setForeground(Color.BLACK);
        p6.add(b7);

        b8 = new JButton("8");
        b8.setPreferredSize(new Dimension(70, 30));
        b8.setBackground(new Color(72, 190, 232));
        b8.setForeground(Color.BLACK);
        b8.addActionListener(this);
        p6.add(b8);

        b9 = new JButton("9");
        b9.setPreferredSize(new Dimension(70, 30));
        b9.setBackground(new Color(72, 190, 232));
        b9.setForeground(Color.BLACK);
        b9.addActionListener(this);
        p6.add(b9);

        p7 = new JPanel(grid1);
        p7.setBorder(BorderFactory.createEmptyBorder(0, 155, 0, 20));
        b0 = new JButton("0");
        b0.setPreferredSize(new Dimension(70, 30));
        b0.setBackground(new Color(72, 190, 232));
        b0.setForeground(Color.BLACK);
        b0.addActionListener(this);
        p7.add(b0);

        bc = new JButton("Clear");
        bc.setPreferredSize(new Dimension(70, 30));
        bc.setBackground(new Color(72, 190, 232));
        bc.setForeground(Color.BLACK);
        bc.addActionListener(this);
        p7.add(bc);

        be = new JButton("Enter");
        be.setPreferredSize(new Dimension(70, 30));
        be.setBackground(new Color(72, 190, 232));
        be.setForeground(Color.BLACK);
        be.addActionListener(this);
        p7.add(be);

        p8 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p8.setBorder(BorderFactory.createEmptyBorder(0, 305, 0, 20));
        back = new JButton("Back");
        back.setPreferredSize(new Dimension(70, 30));
        back.setBackground(new Color(72, 190, 232));
        back.setForeground(Color.BLACK);
        back.addActionListener(this);
        p8.add(back);
        p1.add(p2);
        p1.add(p3);
        p1.add(p4);
        p1.add(p5);
        p1.add(p6);
        p1.add(p7);
        p1.add(p8);
        add(p1);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            fUserPass = new File("F:\\Fue.Student\\(4)Fourth Semester\\Advanced Programming\\Project\\Project\\fUserPass.txt");
            data = new Scanner(fUserPass);
        } catch (Exception FileNotFoundException) {
            System.err.println("Cannot Find File");
        }

        if (e.getActionCommand().equals("Back")) {
            playSound("F:\\Fue.Student\\(4)Fourth Semester\\Advanced Programming\\Project\\Project\\Sound2 Cut.wav");
            setVisible(false);
            GeneralServices gs1 = new GeneralServices();
            gs1.setSize(400, 450);
            gs1.setResizable(false);
            gs1.setDefaultCloseOperation(EXIT_ON_CLOSE);
            gs1.initiate();
        } else {
            switch (e.getActionCommand()) {
                case "1":
                    pass = pass + "1";
                    playSound("F:\\Fue.Student\\(4)Fourth Semester\\Advanced Programming\\Project\\Project\\Sound2 Cut.wav");
                    break;
                case "2":
                    pass = pass + "2";
                    playSound("F:\\Fue.Student\\(4)Fourth Semester\\Advanced Programming\\Project\\Project\\Sound2 Cut.wav");
                    break;
                case "3":
                    pass = pass + "3";
                    playSound("F:\\Fue.Student\\(4)Fourth Semester\\Advanced Programming\\Project\\Project\\Sound2 Cut.wav");
                    break;
                case "4":
                    pass = pass + "4";
                    playSound("F:\\Fue.Student\\(4)Fourth Semester\\Advanced Programming\\Project\\Project\\Sound2 Cut.wav");
                    break;
                case "5":
                    pass = pass + "5";
                    playSound("F:\\Fue.Student\\(4)Fourth Semester\\Advanced Programming\\Project\\Project\\Sound2 Cut.wav");
                    break;
                case "6":
                    pass = pass + "6";
                    playSound("F:\\Fue.Student\\(4)Fourth Semester\\Advanced Programming\\Project\\Project\\Sound2 Cut.wav");
                    break;
                case "7":
                    pass = pass + "7";
                    playSound("F:\\Fue.Student\\(4)Fourth Semester\\Advanced Programming\\Project\\Project\\Sound2 Cut.wav");
                    break;
                case "8":
                    pass = pass + "8";
                    playSound("F:\\Fue.Student\\(4)Fourth Semester\\Advanced Programming\\Project\\Project\\Sound2 Cut.wav");
                    break;
                case "9":
                    pass = pass + "9";
                    playSound("F:\\Fue.Student\\(4)Fourth Semester\\Advanced Programming\\Project\\Project\\Sound2 Cut.wav");
                    break;
                case "0":
                    pass = pass + "0";
                    playSound("F:\\Fue.Student\\(4)Fourth Semester\\Advanced Programming\\Project\\Project\\Sound2 Cut.wav");
                    break;
                case "Clear":
                    playSound("F:\\Fue.Student\\(4)Fourth Semester\\Advanced Programming\\Project\\Project\\Sound2 Cut.wav");
                    pass = "";
                    t1.setText("");
                    accNo = "";
                    break;
                default:
                    break;
            }

            if (e.getActionCommand().equals("Enter")) {
                playSound("F:\\Fue.Student\\(4)Fourth Semester\\Advanced Programming\\Project\\Project\\Sound2 Cut.wav");
                accNo = t1.getText();
                all = "ACCNO: " + accNo + ", PASS: " + pass;
                while (data.hasNextLine()) {
                    line = data.nextLine();
                    if (all.equals(line) && e.getActionCommand().equals("Enter")) {
                        client = accNo;
                        setVisible(false);
                        AccountServices acc1 = new AccountServices(client);
                        acc1.setSize(400, 450);
                        acc1.setResizable(false);
                        acc1.setDefaultCloseOperation(EXIT_ON_CLOSE);
                        acc1.initiate();

                        break;
                    }
                }
                if ((!(all.equals(line)) && e.getActionCommand().equals("Enter"))) {
                    System.out.println("not");
                    System.out.println(pass + " " + accNo + " " + all + " " + line);
                    JOptionPane.showMessageDialog(this, "Account Number or Password are incorrect, Check your credentials and try again");
                    t1.setText("");
                    pass = "";
                    accNo = "";
                    all = "";
                }
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
