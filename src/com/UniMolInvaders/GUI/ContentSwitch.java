package UniMolInvaders.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class ContentSwitch extends JFrame {

    protected final static String TITLE = "UniMol Invaders";
    public final static int WIM_WIDTH = 1024;
    public final static int WIN_HEIGHT = 768;
    public final static int DISTANZA = 20;

    public final static int TEST_PAUSE = 500;
    public final static int PAUSE = 5000;

    private static IntroPanel intro;
    private static GamePanel game;
    private static MenuPanel menu;
    private static StatisticheGUI stats;

    protected static final int GAME = 2;
    protected static final int INTRO = 1;
    protected static final int MENU = 0;

    private static final Point ORIGIN = new Point(0,0);
    private static final Point GAME_ANCHOR = new Point(0,50);

    public ContentSwitch(){

        setSize(WIM_WIDTH, WIN_HEIGHT);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        addKeyListener(new PlayerListner());
        setFocusable(true);

        menu = new MenuPanel();
        menu.setLocation(ORIGIN);
        getContentPane().add(menu);

        intro = new IntroPanel(TEST_PAUSE);
        intro.setLocation(ORIGIN);
        getContentPane().add(intro);

        game = new GamePanel();
        game.setLocation(GAME_ANCHOR);
        getContentPane().add(game);

        stats = new StatisticheGUI();
        stats.setLocation(ORIGIN);
        getContentPane().add(stats);

        setVisible(true);

    }

    public static void switchPanel(int panel){
        switch (panel){

            case MENU:
                intro.setVisible(false);
                game.setVisible(false);
                stats.setVisible(false);
                menu.setVisible(true);
                break;

            case INTRO:
                game.setVisible(false);
                menu.setVisible(false);
                stats.setVisible(false);
                intro.setVisible(true);
                intro.startAnimation();
                break;

            case GAME:
                intro.setVisible(false);
                menu.setVisible(false);
                stats.setVisible(true);
                game.setVisible(true);
                game.startGame();
                break;
        }
    }

    public static GamePanel getGame() {
        return game;
    }

    public static StatisticheGUI getStats() {
        return stats;
    }

    private class PlayerListner implements KeyListener {

        public void keyTyped(KeyEvent key) {
        }

        @Override
        public void keyReleased(KeyEvent key) {
            if (key.getKeyCode() == KeyEvent.VK_ESCAPE) {
                //todo gameOver
                getGame().setGameStarted(false);
                getGame().winOrLoose();
//                System.exit(1);
            }

            getGame().getPlayer().keyReleased(key);
        }

        @Override
        public void keyPressed(KeyEvent key) {
            System.out.println("press");
            getGame().getPlayer().keyPressed(key);
        }

    }

}

