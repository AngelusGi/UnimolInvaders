package GUI;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class IntroGUI extends JPanel implements  Runnable{
    private Image[] immagini;
    private ArrayList<String> testo;
    private final int immaginiTotali = 3;
    private int pos;
    private Thread runner;
    private int tempoPausa;
    private boolean isFinished;
    private JFrame finestra;

    private static final String filePath = "./src/com/GUI/storia.txt";
    private static final int DIM_CARATTERE = 33;


    private final int ancoraggioImmagineX = 100;
    private final int ancoraggioImmagineY = 100;

    private final int ancoraggioTestoX = 30;
    private final int ancoraggioTestoY = 550;

    IntroGUI(int tempoPausa, JFrame finestra) {

        this.isFinished = false;
        this.tempoPausa = tempoPausa;
        immagini = new Image[immaginiTotali];
        pos = 0;

        this.finestra = finestra;
        inizializzaTesto();
        inizializzaImmagini();
        avviaAnimazione();
    }

    private void inizializzaTesto(){

        testo = new ArrayList<>();
        try {
            Scanner scamFile = new Scanner(new File(filePath));
            while (scamFile.hasNextLine()) {
                testo.add(scamFile.nextLine());
            }

        }  catch (FileNotFoundException e){
            System.out.println("Errore");

        }
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

        if (immagini[pos] != null) {
            screen2D.drawImage(immagini[pos], ancoraggioImmagineX , ancoraggioImmagineY , this);
            screen2D.setColor(Color.WHITE);
            screen2D.setFont(new Font(MenuGUI.CARATTERE, Font.BOLD, DIM_CARATTERE));
            screen2D.drawString(testo.get(pos),ancoraggioTestoX, ancoraggioTestoY);

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

                if (pos < immagini.length - 1){
                    pos++;
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


