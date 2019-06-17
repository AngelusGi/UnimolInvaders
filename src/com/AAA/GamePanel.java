package AAA;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

public class GamePanel extends JPanel implements Runnable {

    private static final int LARGHEZZA = 640;
    private static final int ALTEZZA = 480;
    private static final int TEMPO_ANIMAZIONE = 50;
    private static final int numAlieni = 6;
    private final static String punteggio = "Punteggio: ";
    private Thread animazione;
    private Giocatore giocatore;
    private ArrayList<Alieno> alieni;
    private boolean gameStarted;
    private Dimension dimensioni;
    private int punti;
    private ArrayList<Colpo> colpi;


    public GamePanel() {

        dimensioni = new Dimension(LARGHEZZA, ALTEZZA);
        giocatore = new Giocatore(LARGHEZZA / 2, ALTEZZA - 70, 5);
        alieni = new ArrayList<>();

        inizializzaAlieni();
        muoviAlieni();

        setFocusable(true);

        colpi = new ArrayList<>();

        giocatore.muovi();
        gameStarted = true;

    }


    public void keyReleased(KeyEvent tasto) {

        if (tasto.getKeyCode() == KeyEvent.VK_ESCAPE) {
            //todo gameOver
            this.gameStarted = false;
            System.exit(0);
        }

        giocatore.keyReleased(tasto);

        if (tasto.getKeyCode() == KeyEvent.VK_SPACE) {

            colpi.add(giocatore.getColpo(true));
        }
    }


    public void keyPressed(KeyEvent tasto) {
        giocatore.keyPressed(tasto);

    }

    private void inizializzaAlieni() {
        int posX = 20;
        int posY = 20;

        for (int i = 0; i < numAlieni; i++) {

            Alieno alieno = new Alieno(posX, posY, 2);

            alieni.add(i, alieno);
            posX += 40;

            if (i == (numAlieni / 2) - 1) {
                posX = 20;
                posY += 40;
            }

        }
    }


    private void muoviAlieni() {

        for (int i = 0; i < alieni.size(); i++) {
            if (alieni.get(i).isVisibile()) {

                if (alieni.get(i).posX + alieni.get(i).velocita < 0) {
//                alieni.get(i).velocita = Alien.RIGHT;
//                alieni.get(i).posY += 30;
                    for (int j = 0; j < alieni.size(); j++) {
                        alieni.get(j).velocita = Alieno.DESTRA;
                        alieni.get(j).posY += 30;

                    }

                } else if (alieni.get(i).posX + alieni.get(i).velocita > Start.DIM_FINESTRA_LARGHEZZA - Alieno.DIM_ALINEO - 20) {
                    //BORDO DX
//                alieni.get(i).velocita = Alien.CHANGE_DIR;
//                alieni.get(i).posY += 30;
                    for (int j = 0; j < alieni.size(); j++) {
                        alieni.get(j).velocita = Alieno.SINISTRA;
                        alieni.get(j).posY += 30;

                    }

                } else {
                    alieni.get(i).posX += alieni.get(i).velocita;
                }
            }

        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        g.drawString(punteggio + punti, 10, 15);

        if (giocatore.isVisibile()) {

            giocatore.paint(g);
        }


        alieni.forEach((alieno -> {
            if (alieno.isVisibile()) {
                alieno.paint(g);
            }
        }));

        g.setColor(Color.BLACK);
        colpi.forEach((colpo -> {
            if (colpo.isVivo()) {
                g.fillRect(colpo.getBounds().x, colpo.getBounds().y, colpo.getBounds().width, colpo.getBounds().height);
            }
        }));

    }

    private void colpisci() {

        colpi.forEach(colpo -> {
            if (colpo.isVivo() && colpo.getBounds().intersects(giocatore.getBounds()) && colpo.isVivo()) {
                colpo.setVivo(false);
                giocatore.setVisibile(false);
            }

            alieni.forEach((alieno -> {
                if (alieno.isVisibile() && colpo.getBounds().intersects(alieno.getBounds()) && colpo.isVivo()) {
                    colpo.setVivo(false);
                    alieno.setVisibile(false);
                    punti++;

                }
            }));

        });

    }

    private void attacca() {
        Random randomAlien = new Random();
        if (alieni.size() >= ((numAlieni / 2) - 1)) {
            int numAlieno = randomAlien.nextInt(alieni.size() / 2);
            if (alieni.get(numAlieno).visibile) {
                alieni.get(numAlieno).tryToFire(false);
                colpi.add(alieni.get(numAlieno).getColpo(false));
            } else {
                if (alieni.get(numAlieno).visibile) {
                    alieni.get(numAlieno).tryToFire(false);
                    colpi.add(alieni.get(numAlieno).getColpo(false));
                }
            }


        }
    }


    @Override
    public void run() {

        while (gameStarted) {

            try {

                this.muoviAlieni();
                colpisci();
                attacca();
                this.repaint();


                //pulisciColpi();

                Thread.sleep(TEMPO_ANIMAZIONE);

            } catch (InterruptedException ex) {

                System.out.println("ERRORE THREAD");
            }
        }

    }

}
