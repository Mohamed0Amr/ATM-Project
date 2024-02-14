package project;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class ATM extends JFrame {

    //First fram
    void myfram() {
        JFrame f;
        f = new JFrame();
        f.setVisible(true);
        f.setSize(400, 350);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
        f.setResizable(false);
        f.setLocation(540, 220);
        f.setLayout(null);
//        --------------------------
        JButton b, b1, b2;
//        ------------
//first 
        b2 = new JButton("ATM Project1");
        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.RED);
        b2.setBounds(10, 10, 365, 30);
        f.add(b2);
//------------------
//Second 
        b = new JButton("Account Service");
        b.setForeground(Color.WHITE);
        b.setBackground(Color.BLUE);
        b.setBounds(50, 70, 290, 80);
        f.add(b);
//------------------
//Third
        b1 = new JButton("General Service");
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.BLUE);
        b1.setBounds(50, 170, 290, 80);
        f.add(b1);
        b1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
                myfram1();
            }
        });
    }

//    ----------------------------
//    Second Fram
    void myfram1() {
        JFrame f1;
        f1 = new JFrame();
        f1.setVisible(true);
        f1.setSize(400, 450);
        f1.setDefaultCloseOperation(EXIT_ON_CLOSE);
        f1.setResizable(false);
        f1.setLocation(150, 220);
        f1.setLayout(null);
//        -----------------------
        JButton b, b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13;
        JLabel l;
        JTextField t;
        String password="";
        int counter=0;
//---------------------------
//First
        b = new JButton("ATM Project2");
        b.setForeground(Color.WHITE);
        b.setBackground(Color.RED);
        b.setBounds(10, 10, 365, 30);
        f1.add(b);
//-----------------
//Second
        l = new JLabel("account #:");
        l.setForeground(Color.BLACK);
        l.setBounds(20, 76, 90, 30);
        t = new JTextField();
        t.setBounds(90, 70, 280, 40);
        f1.add(l);
        f1.add(t);
//---------------
//Third
        b1 = new JButton("1");
        b1.setBounds(90, 120, 80, 30);
        f1.add(b1);
        b1.setBackground(Color.BLUE);
        b2 = new JButton("2");
        b2.setBounds(190, 120, 80, 30);
        b2.setBackground(Color.BLUE);
        f1.add(b2);
        b3 = new JButton("3");
        b3.setBounds(290, 120, 80, 30);
        b3.setBackground(Color.BLUE);
        f1.add(b3);
//end of the first three
        b4 = new JButton("4");
        b4.setBounds(90, 170, 80, 30);
        b4.setBackground(Color.BLUE);
        f1.add(b4);
        b5 = new JButton("5");
        b5.setBounds(190, 170, 80, 30);
        b5.setBackground(Color.BLUE);
        f1.add(b5);
        b6 = new JButton("6");
        b6.setBounds(290, 170, 80, 30);
        b6.setBackground(Color.BLUE);
        f1.add(b6);
//end Second Three
        b7 = new JButton("7");
        b7.setBounds(90, 220, 80, 30);
        b7.setBackground(Color.BLUE);
        f1.add(b7);
        b8 = new JButton("8");
        b8.setBounds(190, 220, 80, 30);
        b8.setBackground(Color.BLUE);
        f1.add(b8);
        b9 = new JButton("9");
        b9.setBounds(290, 220, 80, 30);
        b9.setBackground(Color.BLUE);
        f1.add(b9);
//end other three
//-----------
        b10 = new JButton("0");
        b10.setBounds(90, 270, 80, 30);
        b10.setBackground(Color.BLUE);
        f1.add(b10);
        b11 = new JButton("Clear");
        b11.setBounds(190, 270, 80, 30);
        b11.setBackground(Color.BLUE);
        f1.add(b11);
        b12 = new JButton("Enter");
        b12.setBounds(290, 270, 80, 30);
        b12.setBackground(Color.BLUE);
        f1.add(b12);
//end of the key
//--------------------------------
//Fourth 
        b13 = new JButton("Back");
        b13.setBounds(290, 330, 80, 30);
        b13.setBackground(Color.red);
        f1.add(b13);
    }

//    -----------------------------
//    Third Fram
    void myfram2() {
        JFrame f2;
        f2 = new JFrame();
        f2.setVisible(true);
        f2.setSize(400, 380);
        f2.setDefaultCloseOperation(EXIT_ON_CLOSE);
        f2.setResizable(false);
        f2.setLocation(840, 220);
        f2.setLayout(null);
//        --------------------------
        JButton b, b1, b2, b3;
//        ------------
//first 
        b2 = new JButton("ATM Project/General Service3");
        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.RED);
        b2.setBounds(10, 10, 365, 30);
        f2.add(b2);
//------------------
//Second 
        b = new JButton("New Account");
        b.setForeground(Color.WHITE);
        b.setBackground(Color.BLUE);
        b.setBounds(50, 70, 290, 80);
        f2.add(b);
//------------------
//Third
        b1 = new JButton("List Service");
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.BLUE);
        b1.setBounds(50, 170, 290, 80);
        f2.add(b1);
//------------------
// final button
        b3 = new JButton("Back");
        b3.setBounds(280, 280, 80, 30);
        b3.setBackground(Color.red);
        f2.add(b3);

    }

//    ---------------------------
//    The fourth Fram
    void myfram3() {
        JFrame f3;
        f3 = new JFrame();
        f3.setVisible(true);
        f3.setSize(435, 450);
        f3.setDefaultCloseOperation(EXIT_ON_CLOSE);
        f3.setResizable(false);
        f3.setLocation(950, 220);
        f3.setLayout(null);
//  -----------------------
        JButton b, b1, b2, b3, b4, b5, b6;
//        ------------
//first 
        b2 = new JButton("ATM Project/General Service4");
        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.RED);
        b2.setBounds(10, 10, 400, 30);
        f3.add(b2);
//------------------------
//Second
        b = new JButton("Balance Inquiry");
        b.setBounds(20, 60, 180, 80);
        b.setBackground(Color.BLUE);
        f3.add(b);
//------------------------
        b1 = new JButton("Cash Withdraw");
        b1.setBounds(220, 60, 180, 80);
        b1.setBackground(Color.BLUE);
        f3.add(b1);
//------------------------
        b3 = new JButton("Cash Deposit");
        b3.setBounds(20, 160, 180, 80);
        b3.setBackground(Color.BLUE);
        f3.add(b3);
//---------------------
        b4 = new JButton("Transfer");
        b4.setBounds(220, 160, 180, 80);
        b4.setBackground(Color.BLUE);
        f3.add(b4);
//-------------------------
        b5 = new JButton("Salefny Service");
        b5.setBounds(120, 260, 180, 80);
        b5.setBackground(Color.BLUE);
        f3.add(b5);
//-----------------
        b6 = new JButton("Back");
        b6.setBounds(320, 350, 80, 30);
        b6.setBackground(Color.red);
        f3.add(b6);

    }

//    -----------------
//    The final Fram
    void myfram4() {
        JFrame f4;
        f4 = new JFrame();
        f4.setVisible(true);
        f4.setSize(350, 300);
        f4.setDefaultCloseOperation(EXIT_ON_CLOSE);
        f4.setResizable(false);
        f4.setLocation(1100, 220);
        f4.setLayout(null);
//  ----------------------
        JButton b, b1, b2;
//    ------------------
//first 
        b2 = new JButton("ATM Project / Account Service / Balance Inquiry5");
        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.RED);
        b2.setBounds(10, 10, 315, 30);
        f4.add(b2);
//-------------
//Second
        b = new JButton("Current Balance:.......EGP");
        b.setBounds(40, 90, 260, 80);
        b.setBackground(Color.BLUE);
        f4.add(b);
//---------------
//third
        b1 = new JButton("Back");
        b1.setBounds(240, 200, 80, 30);
        b1.setBackground(Color.red);
        f4.add(b1);

    }

}
