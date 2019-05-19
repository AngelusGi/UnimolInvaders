package GUI;

import javax.swing.*;

public class IntroGUI {

    private Intro1GUI intro1;
    private Intro2GUI intro2;
    private Intro3GUI intro3;

    public IntroGUI(JFrame finestraIntro){

        //produce l'animazione iniziale della storia per 15 secondi (5 per schermata)

        try {
            Intro1GUI intro1GUI = new Intro1GUI();
            finestraIntro.add(intro1GUI);
            finestraIntro.setVisible(true);
            Thread.sleep(5000);

            finestraIntro.remove(intro1GUI);
            Intro2GUI intro2GUI = new Intro2GUI();
            finestraIntro.add(intro2GUI);
            finestraIntro.setVisible(true);
            Thread.sleep(5000);

            finestraIntro.remove(intro2GUI);
            Intro3GUI intro3GUI = new Intro3GUI();
            finestraIntro.add(intro3GUI);
            finestraIntro.setVisible(true);
            Thread.sleep(5000);
            finestraIntro.setVisible(false);

        } catch (Exception e){

        }
    }
}
