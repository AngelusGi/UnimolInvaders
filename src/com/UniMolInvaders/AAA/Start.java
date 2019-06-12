package UniMolInvaders.AAA;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class Start extends JFrame {

    public final static int DIM_FINESTRA_LARGHEZZA = 640;
    public final static int DIM_FINESTRA_ALTEZZA = 480;
    public final static int DISTANZA = 20;
    private final static String nome = "UniMol Invaders";
    private GamePanel gamePanel;

    public Start() {
        gamePanel = new GamePanel();
        add(gamePanel);
        setSize(DIM_FINESTRA_LARGHEZZA, DIM_FINESTRA_ALTEZZA);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setFocusable(true);
        setVisible(true);

        addKeyListener(new MyListener());

        gamePanel.run();

    }

    public static void main(String[] args) {

        new Start();

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

