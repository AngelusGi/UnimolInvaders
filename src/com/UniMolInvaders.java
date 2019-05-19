import GUI.*;
import Logic.Alieni;
import Logic.FinePartita;
import Logic.GameController;

import javax.swing.*;
import java.awt.*;

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


//        JFrame finestra = new JFrame("UniMol Invader");
//
//        AlienoGUI alieni = new AlienoGUI();
//        finestra.add(alieni);
//
//        AlienoBossGUI alienoBoss = new AlienoBossGUI();
//        finestra.add(alienoBoss);
//
//        PersonaggioGUI personaggio = new PersonaggioGUI();
//        finestra.add(personaggio);
//
//        IntroGui introGui = new IntroGui();
//        finestra.add(introGui);
//
//        MenuGUI menu = new MenuGUI();
//        finestra.add(menu);
//
//
//        ColpoPersonaggio colpo = new ColpoPersonaggio();
//        finestra.add(colpo);
//
//
//        finestra.setSize(1024, 768);
//        finestra.setResizable(false);
//        finestra.setVisible(true);
//        finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//        FinePartita finePartita = new FinePartita();
//        FinePartitaGUI finePartitaGUI = new FinePartitaGUI(finePartita);


        CreditiGUI istruzioniGUI = new CreditiGUI();


    }
}
