import GUI.AlienoBossGUI;
import GUI.AlienoGUI;
import GUI.PersonaggioGUI;
import Logic.Alieni;
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
//        AlienoGUI alieni = new AlienoGUI();
//        AlienoBossGUI alienoBoss = new AlienoBossGUI();
//        finestra.add(alieni);
//        finestra.add(alienoBoss);
        PersonaggioGUI personaggio = new PersonaggioGUI();
        finestra.add(personaggio);
        finestra.setSize(1024, 768);
        finestra.setResizable(false);
        finestra.setVisible(true);
        finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
