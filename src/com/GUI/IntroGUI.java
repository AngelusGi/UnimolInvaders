package GUI;

import javax.swing.*;

public class IntroGUI {

    private Intro1GUI intro1;
    private Intro2GUI intro2;
    private Intro3GUI intro3;

    public IntroGUI(JFrame finestraIntro){

        //produce l'animazione iniziale della storia per 15 secondi (5 per schermata)

        try {

            finestraIntro.dispose();
            finestraIntro.setFocusable(true);
            intro1 = new Intro1GUI();
            finestraIntro.add(intro1);
            finestraIntro.add(intro1);
            finestraIntro.setVisible(true);
            Thread.sleep(5000);

            finestraIntro.remove(intro1);
            intro2 = new Intro2GUI();
            finestraIntro.add(intro2);
            finestraIntro.setVisible(true);

            Thread.sleep(5000);

            finestraIntro.remove(intro2);
            intro3 = new Intro3GUI();
            finestraIntro.add(intro3);
            finestraIntro.setVisible(true);

            Thread.sleep(5000);
            finestraIntro.setVisible(false);
            finestraIntro.dispose();

        } catch (Exception e){

        }
    }
}
