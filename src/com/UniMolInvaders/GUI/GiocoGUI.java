package UniMolInvaders.GUI;

import UniMolInvaders.Logic.Nemico;
import UniMolInvaders.Logic.Personaggio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GiocoGUI extends JPanel {


    private static final int numAlieni = 10;
    private PersonaggioGUI giocatore;
    private ArrayList<AlienoGUI> alieni;
    private AlienoBossGUI alienoBoss;

    private int numLivello = 0;
    private final int POS_IN_ALIENO = 20;
    private boolean gameStarted;

//    private int punteggio;


    private Thread animazione;
    private static final int TEMPO_ANIMAZIONE = 50;


    public GiocoGUI() {

        inizializzaPersonaggio();

        if (isPari(numLivello)) {

            // se il livello è pari (0, 2,...) alieni normali, altrimenti BOSS
            // se il livello è 0, inizializza punteggio, altrimenti resta invariato
//            if (numLivello == 0) {
//                this.punteggio = 0;
//
//            }

            alieni = new ArrayList<>();
            inizializzaAlieni();
//            muoviAlieni();

        } else {
            inizializzaBoss();
//            alienoBoss.muovi();
        }


        addKeyListener(new MyListener());
        setFocusable(true);
        setVisible(true);

//        giocatore.muovi();

        setGameStarted(true);

        Thread threadGioco = new Thread(new ThreadGioco());
        threadGioco.start();

    }


//    todo
//    private boolean collision() {
//        return this.giocatore.getDimesnione().intersects(getBounds());
//    }


    private void muoviBoss(){

        alienoBoss.muovi();

        if (alienoBoss.getPosY() + alienoBoss.getDIM_NEMICO_Y() >= giocatore.getPosY()) {
            //se raggiongoe il personaggio, game over

            //todo GAME OVER
        }
    }


    private void muoviAlieni() {

        for (int i = 0; i < alieni.size(); i++) {

            if (alieni.get(i).getPosX() + alieni.get(i).getSpostamentoX() < 0) {
                //gestisce bordo SX e scende tutti gli alieni di 30px

                for (int j = 0; j < alieni.size(); j++) {
                    alieni.get(j).setSpostamentoX(Nemico.DESTRA);
                    alieni.get(j).setPosY(alieni.get(j).getPosY() + 30);

                }

            } else if (alieni.get(i).getPosX() + alieni.get(i).getSpostamentoX() > Start.DIM_FINESTRA_LARGHEZZA - alieni.get(i).getDIM_NEMICO_X() - 20) {

                //gestisce bordo SX e scende tutti gli alieni di 30px

                for (int j = 0; j < alieni.size(); j++) {
                    alieni.get(j).setSpostamentoX(Nemico.SINISTRA);
                    alieni.get(j).setPosY(alieni.get(j).getPosY() + 30);

                }

            } else {

                //sposta gli alieni lungo l'assse X
                alieni.get(i).setPosX(alieni.get(i).getPosX() + alieni.get(i).getSpostamentoX());
            }

            if (alieni.get(i).getPosY() + alieni.get(i).getDIM_NEMICO_Y() >= giocatore.getPosY()) {
                //se raggiongono il personaggio, game over

                //todo GAME OVER
            }

        }
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);

        graphics.setFont(new Font(MenuGUI.CARATTERE, Font.BOLD, MenuGUI.DIM_CARATTERE));
        graphics.drawString("Punti: " + punteggio, 10, 15);
        graphics.drawString("Vite: " + giocatore.getVita(), 30, 15);

        if (giocatore.isVivo()) {
            giocatore.paint(graphics);
        }

        if ((alieni != null) && (alieni.size() > 0)) {
            for (AlienoGUI alien : alieni) {
                alien.paint(graphics);
            }
        }

        if ((alienoBoss != null) && (alienoBoss.isVivo)) {
            alienoBoss.paint(graphics);
        }

    }

    public void keyReleased(KeyEvent tasto) {

        if (tasto.getKeyCode() == KeyEvent.VK_ESCAPE) {
            //todo gameOver
            this.gameStarted = false;
//            System.exit(0);
            vintoPerso();
        }

        giocatore.keyReleased(tasto);

    }


//    todo
//    private boolean collision() {
//        return this.giocatore.getDimesnione().intersects(getBounds());
//    }


    private void vintoPerso() {
        //todo

        //IF vinto, livello incrementato di 1
        setNumLivello(getNumLivello() + 1);

        //else
        //todo finestra inserimento NOME_GIOCO e salvataggio su file
        if (giocatore.getVita() == 0) {
            this.setVisible(false);

            //            FinePartitaGUI finePartita = new FinePartitaGUI(getPunteggio(), getNumLivello());
            new FinePartitaGUI(getPunteggio(), getNumLivello());


        }
    }

    private void inizializzaAlieni() {
        int posX = POS_IN_ALIENO;
        int posY = POS_IN_ALIENO;

        for (int i = 0; i < numAlieni; i++) {

            AlienoGUI alieno = new AlienoGUI(posX, posY, getNumLivello());

            alieni.add(i, alieno);
            posX += alieno.getDIM_NEMICO_X() + POS_IN_ALIENO;

            if (i == (numAlieni / 2) - 1) {
                posX = POS_IN_ALIENO;
                posY += alieno.getDIM_NEMICO_Y() + POS_IN_ALIENO;
            }

        }
    }

    private void inizializzaBoss() {

        this.alienoBoss = new AlienoBossGUI(POS_IN_ALIENO, POS_IN_ALIENO, getNumLivello());

    }

    private void inizializzaPersonaggio() {

        this.giocatore = new PersonaggioGUI(UniMolInvaders.GUI.Start.DIM_FINESTRA_LARGHEZZA / 2, UniMolInvaders.GUI.Start.DIM_FINESTRA_ALTEZZA - Personaggio.DIM_GIOCATORE_Y - 10);

    }

    private boolean isPari(int levelNumber) {
        //se il livello è pari (0, 2,...) ritorna TRUE, altrimenti FALSE
        return levelNumber % 2 == 0;
    }


    protected int getNumLivello() {
        return numLivello;
    }


    public void setNumLivello(int incremento) {
        this.numLivello = incremento;
    }


    protected int getPunteggio() {
        return punteggio;
    }

    public boolean isGameStarted() {
        return gameStarted;
    }

    public void setGameStarted(boolean gameStarted) {
        this.gameStarted = gameStarted;
    }


//    //testa la corretta inizializzazione dei livelli e la gestione dei livelli (pari/dispari)
//    public void stampaLivello() {
//        System.out.print("Livello: " + numLivello);
//        System.out.println(" è pari: " + isPari(numLivello));
//        if (numLivello <= 5) {
//            numLivello += 1;
//        } else {
//            System.exit(1);
//        }
//
//        stampaLivello();
//    }

//    public void stampaPersonaggi() {
//
//        inizializzaAlieni();
//
//        for (int num = 0; num < alieni.size(); num++) {
//            System.out.print("Alieno[" + num + "] > " + alieni.get(num) + " \t ");
//            System.out.println("\n");
//        }
//
//        inizializzaBoss();
//        System.out.println("\nBoss > " + alienoBoss + "\n");
//
//        inizializzaPersonaggio();
//        System.out.println("giocatore > " + giocatore + "\n");
//
//    }


    private class MyListener extends KeyAdapter {

        @Override
        public void keyTyped(KeyEvent tasto) {
        }

        @Override
        public void keyReleased(KeyEvent tasto) {
            giocatore.keyReleased(tasto);
        }

        @Override
        public void keyPressed(KeyEvent tasto) {
            giocatore.keyPressed(tasto);
        }

    }

    private class ThreadGioco implements Runnable {

        @Override
        public void run() {
            while (isGameStarted()) {
                try {

                    Thread.sleep(TEMPO_ANIMAZIONE);

                    if (alieni != null) {
                        muoviAlieni();
                    }

                    if (alienoBoss != null) {
                        muoviBoss();
                    }

                    giocatore.muovi();

                    repaint();

                    vintoPerso();

                } catch (InterruptedException e) {
                    Logger.getLogger(this.getClass().getName()).log(Level.INFO, null, e);
                }

            }

        }
    }

    public PersonaggioGUI getGiocatore() {
        return giocatore;
    }
}
