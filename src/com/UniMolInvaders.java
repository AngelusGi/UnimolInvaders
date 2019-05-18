import GUI.*;
import Logic.Alieni;
import Logic.Colpo;
import Logic.GameController;

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

    public static void main(String[] args) {



        GameController gameController = new GameController();

        //verifica la corretta inizializzazione degli oggetti
//        gameController.stampaPersonaggi();
//        gameController.stampaLivello();


        JFrame finestra = new JFrame("UniMol Invader");

        AlienoGUI alieni = new AlienoGUI();
//        finestra.add(alieni);

        AlienoBossGUI alienoBoss = new AlienoBossGUI();
//        finestra.add(alienoBoss);

        PersonaggioGUI personaggio = new PersonaggioGUI();
        finestra.add(personaggio);

        IntroGui introGui = new IntroGui();
//        finestra.add(introGui);

        MenuGUI menu = new MenuGUI();
//        finestra.add(menu);

        ColpoGUI colpo = new ColpoGUI();
//        finestra.add(colpo);

        finestra.setSize(1000, 800);
        finestra.setResizable(false);
        finestra.setVisible(true);
        finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
