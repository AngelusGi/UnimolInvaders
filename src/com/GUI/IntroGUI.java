package GUI;

import AAA.GamePanel;

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

public class IntroGUI extends JPanel implements  Runnable{

    private ArrayList<Image> immagini;
    private ArrayList<String> testo;
    private final int immaginiTotali = 3;
    private int pos;
    private Thread runner;
    private int tempoPausa;
    private boolean isFinished;
    private JFrame finestra;

    private static final String filePath = "./src/com/GUI/storia.txt";
    private static final int DIM_CARATTERE = 33;

    private GamePanel gamePanel;


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
        inizializzaTesto();
        inizializzaImmagini();
        avviaAnimazione();
    }

    private void inizializzaTesto(){

        this.testo = new ArrayList<>();
        try {
            Scanner scamFile = new Scanner(new File(filePath));
            while (scamFile.hasNextLine()) {
                this.testo.add(scamFile.nextLine());
            }

        }  catch (FileNotFoundException e){
            Logger.getLogger(this.getName()).log(Level.FINE, null, e);

        }
    }



    private void inizializzaImmagini() {

        for (int i = 0; i < this.immaginiTotali ; i++) {

            String nomeImmagine = "intro" + (i + 1) + ".png";

            this.immagini.add(i, new ImageIcon(this.getClass().getResource(nomeImmagine)).getImage());

        }
    }



    public void paint (Graphics graphics){

        super.paint(graphics);

        Graphics2D screen2D = (Graphics2D) graphics;
        setBackground(Color.BLACK);


        if (immagini.get(pos) != null) {
            screen2D.drawImage(immagini.get(pos), ancoraggioImmagineX , ancoraggioImmagineY , this);
            screen2D.setColor(Color.WHITE);
            screen2D.setFont(new Font(MenuGUI.CARATTERE, Font.BOLD, DIM_CARATTERE));
            screen2D.drawString(testo.get(pos),ancoraggioTestoX, ancoraggioTestoY);

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
            gamePanel = new GamePanel();
            finestra.add(gamePanel);
            finestra.setFocusable(true);
            finestra.setVisible(true);
            finestra.addKeyListener(new MyListener());
            gamePanel.run();
//            GamePanel gioco = new GamePanel();
//            finestra.add(gioco);
//            finestra.setVisible(true);
        }
    }


    private class MyListener extends KeyAdapter {

        @Override
        public void keyTyped(KeyEvent tasto) {
        }

        @Override
        public void keyReleased(KeyEvent tasto) {
            gamePanel.keyReleased(tasto);
        }

        @Override
        public void keyPressed(KeyEvent tasto) {
            gamePanel.keyPressed(tasto);
        }

    }
}


