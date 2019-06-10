package UniMolInvaders.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class IntroGUI extends JFrame implements  Runnable{

    private ArrayList<Image> immagini;
    private ArrayList<String> testo;
    private final int immaginiTotali = 3;
    private int pos;
    private Thread runner;
    private int tempoPausa;
    private boolean isFinished;
    private JFrame finestra;

    private static final String pathStoria = "./src/com/UniMolInvaders/GUI/Resources/storia.txt";
    private static final int DIM_CARATTERE = 33;

    private GiocoGUI gamePanel;


    private final int ancoraggioImmagineX = 100;
    private final int ancoraggioImmagineY = 100;

    private final int ancoraggioTestoX = 30;
    private final int ancoraggioTestoY = 550;

    IntroGUI(int tempoPausa, JFrame finestra) {

        this.isFinished = false;
        this.tempoPausa = tempoPausa;
        this.immagini = new ArrayList<>();
        this.pos = 0;

        this.finestra = finestra;
        setSize(Start.DIM_FINESTRA_LARGHEZZA, Start.DIM_FINESTRA_ALTEZZA);
        setResizable(false);
        setLocationRelativeTo(null);

        inizializzaTesto();
        inizializzaImmagini();
        avviaAnimazione();
    }

    private void inizializzaTesto(){

        this.testo = new ArrayList<>();
        try {
            Scanner scamFile = new Scanner(new File(pathStoria));
            while (scamFile.hasNextLine()) {
                this.testo.add(scamFile.nextLine());
            }

        }  catch (FileNotFoundException e){
            Logger.getLogger(this.getName()).log(Level.FINE, null, e);

        }
    }



    private void inizializzaImmagini() {

        for (int i = 0; i < this.immaginiTotali ; i++) {

            String nomeImmagine = "./Resources/intro" + (i + 1) + ".png";

            this.immagini.add(i, new ImageIcon(this.getClass().getResource(nomeImmagine)).getImage());

        }
    }



    public void paint (Graphics graphics){

        super.paint(graphics);


        Graphics2D screen2D = (Graphics2D) graphics;

        screen2D.setColor(Color.BLACK);
        screen2D.fillRect(0,0, Start.DIM_FINESTRA_LARGHEZZA, Start.DIM_FINESTRA_ALTEZZA);


        if ((immagini.get(pos) != null) && (testo.get(pos) != null) ) {
            screen2D.drawImage(immagini.get(pos), ancoraggioImmagineX , ancoraggioImmagineY , this);
            screen2D.setColor(Color.WHITE);
            screen2D.setFont(MenuGUI.getFontGioco()+
                    );
            screen2D.drawString(testo.get(pos),ancoraggioTestoX, ancoraggioTestoY);
        } else {
            screen2D.setColor(Color.WHITE);
            screen2D.setFont(MenuGUI.getFontGioco());
            screen2D.drawString("ERRORE CARICAMENTO CONTENUTO",ancoraggioTestoX, ancoraggioTestoY);
        }

    }


    private void avviaAnimazione() {
        if (this.runner == null) {
            this.runner = new Thread(this);
            this.runner.start();
        }
    }



    public void run () {
        Thread thisThread = Thread.currentThread();

        while (this.runner == thisThread) {

            try {
                repaint();
                Thread.sleep(tempoPausa);

                if (this.pos < this.immagini.size() - 1){
                    this.pos++;
                } else {

                    stop();
                }

            } catch (InterruptedException e) {
                Logger.getLogger(this.getClass().getName()).log(Level.INFO, null, e);
            }
        }
    }

    private void stop() {
        if (this.runner != null) {
            this.runner = null;
            this.isFinished = true;
            finestra.remove(this);
            finestra.dispose();

            gamePanel = new GiocoGUI();
            removeAll();
            add(gamePanel);
            setFocusable(true);
            setVisible(true);

            finestra.add(gamePanel);
            finestra.setFocusable(true);
            finestra.setVisible(true);
            Start.cambiaPannello(Start.GIOCO);
//            finestra.addKeyListener(new MyListener());
            repaint();
//            gamePanel.run();
        }
    }


//    private class MyListener extends KeyAdapter {
//
//        @Override
//        public void keyTyped(KeyEvent tasto) {
//        }
//
//        @Override
//        public void keyReleased(KeyEvent tasto) {
//            gamePanel.keyReleased(tasto);
//        }
//
//        @Override
//        public void keyPressed(KeyEvent tasto) {
//            gamePanel.keyPressed(tasto);
//        }

    }

}


