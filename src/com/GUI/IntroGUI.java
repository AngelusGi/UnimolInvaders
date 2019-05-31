package GUI;

import javax.swing.*;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class IntroGUI extends JPanel implements  Runnable{
    private Image[] immagini;
    private final int immaginiTotali = 3;
    private int immagineCorrente;
    private Thread runner;
    private int tempoPausa;
    private boolean isFinished;
    private JFrame finestra;


    private final int ancoraggioImmagineX = 100;
    private final int ancoraggioImmagineY = 100;

    IntroGUI(int tempoPausa, JFrame finestra) {

        this.isFinished = false;
        this.tempoPausa = tempoPausa;
        immagini = new Image[immaginiTotali];
        immagineCorrente = 0;

        this.finestra = finestra;
        inizializzaImmagini();
        avviaAnimazione();

    }


    private void inizializzaImmagini() {

        for (int i = 0; i < immaginiTotali ; i++) {

            String nomeImmagine = "intro" + (i + 1) + ".png";

            immagini[i] = new ImageIcon(this.getClass().getResource(nomeImmagine)).getImage();

        }
    }


    public void paint (Graphics graphics){

        super.paint(graphics);

        Graphics2D screen2D = (Graphics2D) graphics;
        setBackground(Color.BLACK);

        if (immagini[immagineCorrente] != null) {
            screen2D.drawImage(immagini[immagineCorrente], ancoraggioImmagineX , ancoraggioImmagineY , this);
        }

    }


    private void avviaAnimazione() {
        if (runner == null) {
            runner = new Thread(this);
            runner.start();
        }
    }


    public void run () {
        Thread thisThread = Thread.currentThread();

        while (runner == thisThread) {

            try {
                repaint();
                Thread.sleep(tempoPausa);

                if (immagineCorrente < immagini.length - 1){
                    immagineCorrente++;
                } else {

                    stop();
                }

            } catch (InterruptedException e) {
                Logger.getLogger(this.getClass().getName()).log(Level.INFO, null, e);
            }
        }
    }

    private void stop() {
        if (runner != null) {
            runner = null;
            this.isFinished = true;
            finestra.remove(this);
            finestra.dispose();
            GamePanel gioco = new GamePanel();
            finestra.add(gioco);
            finestra.setVisible(true);
        }
    }

}


