package AAA;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class GamePanel extends JPanel implements Runnable {

    private static final int LARGHEZZA = 640;
    private static final int ALTEZZA = 480;

    private Thread animazione;
    private static final int TEMPO_ANIMAZIONE = 50;

    private static final int numAlieni = 10;
    private Giocatore giocatore;
    private ArrayList<Alieno> alieni;

    private boolean gameStarted;
    private Dimension dimensioni;

    private int punti;
    private final static String punteggio = "Punteggio: ";


    public GamePanel(){

        dimensioni = new Dimension(LARGHEZZA, ALTEZZA);
        giocatore = new Giocatore(LARGHEZZA/2, ALTEZZA-70, 5);
        alieni = new ArrayList<>();

        inizializzaAlieni();
        muoviAlieni();

        setFocusable(true);

        giocatore.muovi();
        gameStarted = true;

    }



    public void keyReleased(KeyEvent tasto) {

        if ( tasto.getKeyCode() == KeyEvent.VK_ESCAPE ){
            //todo gameOver
            this.gameStarted = false;
            System.exit(0);
        }

        giocatore.keyReleased(tasto);

    }


    public void keyPressed(KeyEvent tasto) {
        giocatore.keyPressed(tasto);
    }

    private void inizializzaAlieni(){
        int posX = 20;
        int posY = 20;

        for (int i = 0; i < numAlieni; i++) {

            Alieno alieno = new Alieno(posX, posY, 2);

            alieni.add(i, alieno);
            posX += 40;

            if (i == (numAlieni/2)-1){
                posX = 20;
                posY += 40;
            }

        }
    }


    private void muoviAlieni(){

        for (int i = 0; i < alieni.size(); i++) {

            if (alieni.get(i).posX + alieni.get(i).velocita < 0){
//                alieni.get(i).velocita = Alieno.DESTRA;
//                alieni.get(i).posY += 30;
                for (int j = 0; j < alieni.size(); j++) {
                    alieni.get(j).velocita = Alieno.DESTRA;
                    alieni.get(j).posY += 30;

                }

            } else

            if (alieni.get(i).posX + alieni.get(i).velocita > Start.DIM_FINESTRA_LARGHEZZA - Alieno.DIM_ALINEO - 20) {
                //BORDO DX
//                alieni.get(i).velocita = Alieno.SINISTRA;
//                alieni.get(i).posY += 30;
                for (int j = 0; j < alieni.size(); j++) {
                    alieni.get(j).velocita = Alieno.SINISTRA;
                    alieni.get(j).posY += 30;

                }

            } else {
                alieni.get(i).posX += alieni.get(i).velocita;
            }


        }
//        for (Alieno alieno : alieni){
//            //BORDO SX
//            if (alieno.posX + alieno.velocita < 0){
//                alieno.velocita = Alieno.DESTRA;
//                alieno.posY += 67;
//
//            } else
//
//            if (alieno.posX + alieno.velocita > Start.DIM_FINESTRA_LARGHEZZA - Alieno.DIM_ALINEO - 20) {
//                //BORDO DX
//                alieno.velocita = Alieno.SINISTRA;
//                alieno.posY +=  + 67;
//                alieno.posX += alieno.velocita - 30;
//
//            } else {
//                alieno.posX += alieno.velocita;
//            }
//
//        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        g.drawString(punteggio + punti, 10, 15);

        giocatore.paint(g);

        for (Alieno alien: alieni){
            alien.paint(g);
        }

    }

    @Override
    public void run() {

        while (gameStarted){

            try {

                this.muoviAlieni();

                this.repaint();

                animazione.sleep(TEMPO_ANIMAZIONE);
            } catch (InterruptedException ex){

                System.out.println("ERRORE THREAD");
            }
        }

    }

}
