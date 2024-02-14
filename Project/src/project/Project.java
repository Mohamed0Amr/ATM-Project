package project;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Project {

    public static void main(String[] args) {
        //ATM a = new ATM();
        //a.myfram();
        HomePage hp1 = new HomePage();
        hp1.setSize(400, 400);
        hp1.setResizable(false);
        hp1.setDefaultCloseOperation(EXIT_ON_CLOSE);
        hp1.initiate();

    }

}
