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

//
//        MenuGUI menu = new MenuGUI();
//        finestra.add(menu);
//
//
//        ColpoPersonaggio colpo = new ColpoPersonaggio();
//        finestra.add(colpo);


        finestra.setSize(1024, 768);
        finestra.setResizable(false);
        finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //todo codice per fare animazione iniziale storia
        try {
            Intro1GUI intro1GUI = new Intro1GUI();
            finestra.add(intro1GUI);
            finestra.setVisible(true);
            Thread.sleep(5000);

            finestra.remove(intro1GUI);
            Intro2GUI intro2GUI = new Intro2GUI();
            finestra.add(intro2GUI);
            finestra.setVisible(true);
            Thread.sleep(5000);

            finestra.remove(intro2GUI);
            Intro3GUI intro3GUI = new Intro3GUI();
            finestra.add(intro3GUI);
            finestra.setVisible(true);

        } catch (Exception e){

        }


//        FinePartita finePartita = new FinePartita();
//        FinePartitaGUI finePartitaGUI = new FinePartitaGUI(finePartita);



//        CreditiGUI istruzioniGUI = new CreditiGUI();


    }
}
