import GUI.*;
import Logic.Alieni;
import Logic.FinePartita;

import javax.swing.*;

/********************************
 *
 *   user:      angel
 *   date:      01/02/2019
 *   project:   UnimolInvaders
 *   angelus_gi / angelusgi
 *
 ********************************/

public class UniMolInvaders {

    private static Alieni alieni;
    private final static String nomeFinestra = "UniMol Invaders";

    public static void main(String[] args) {

        JFrame finestra = new JFrame(nomeFinestra);
        finestra.setSize(1024, 768);
        finestra.setResizable(false);
        finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // CreditiGUI istruzioniGUI = new CreditiGUI();
        MenuGUI menu = new MenuGUI();
    }
}
