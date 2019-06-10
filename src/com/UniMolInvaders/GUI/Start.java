package UniMolInvaders.GUI;

import javax.swing.*;
import java.awt.*;


public class Start extends JFrame {

    protected final static String NOME_GIOCO = "UniMol Invaders";
    public final static int DIM_FINESTRA_LARGHEZZA = 1024;
    public final static int DIM_FINESTRA_ALTEZZA = 768;
    public final static int DISTANZA = 20;

    private static IntroGUI introduzione;
    private static GiocoGUI gioco;
    private static MenuGUI menu;
    private static StatisticheGUI statistiche;

    protected static final int GIOCO = 2;
    protected static final int INTRO = 1;
    protected static final int MENU = 0;
    private static final Point ORIGINE = new Point(0,0);
    private static final Point ANCORAGGIO_GIOCA = new Point(0,50);

    public Start(){
        setSize(DIM_FINESTRA_LARGHEZZA, DIM_FINESTRA_ALTEZZA);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setFocusable(true);

        menu = new MenuGUI(this);
        gioco = new GiocoGUI();
        introduzione = new IntroGUI();
        statistiche = new StatisticheGUI();

        menu.setLocation(ORIGINE);
        statistiche.setLocation(ORIGINE);
        gioco.setLocation(ANCORAGGIO_GIOCA);
        introduzione.setLocation(ORIGINE);

        getContentPane().add(introduzione);
        getContentPane().add(gioco);
        getContentPane().add(menu);

//        addKeyListener(new MyListener());

    }

    public static void cambiaPannello(int numPannello){
        switch (numPannello){

            case MENU:
                introduzione.setVisible(false);
                gioco.setVisible(false);
                statistiche.setVisible(false);
                menu.setVisible(true);
                break;
            case GIOCO:
                introduzione.setVisible(false);
                menu.setVisible(false);
                statistiche.setVisible(true);
                gioco.setVisible(true);
                break;
            case INTRO:
                gioco.setVisible(false);
                menu.setVisible(false);
                statistiche.setVisible(false);
                introduzione.setVisible(true);
        }
    }

    public static GiocoGUI getGioco() {
        return gioco;
    }

    public static StatisticheGUI getStatistiche() {
        return statistiche;
    }

    //    private class MyListener extends KeyAdapter {
//
//        @Override
//        public void keyTyped(KeyEvent tasto) {
//        }
//
//        @Override
//        public void keyReleased(KeyEvent tasto) {
//            menu.keyReleased(tasto);
//        }
//
//        @Override
//        public void keyPressed(KeyEvent tasto) {
//            menu.keyPressed(tasto);
//        }
//
//    }
//
//
//    public static void main(String[] args) {
//
//        new Start();
//
//    }

}

