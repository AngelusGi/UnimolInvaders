package UniMolInvaders.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class ContentSwitch extends JFrame {

    public final static int WIN_WIDTH = 1024;
    public final static int WIN_HEIGHT = 768;
    public final static int TEST_PAUSE = 500;
    public final static int PAUSE = 5000;
    protected final static String TITLE = "UniMol Invaders";
    protected static final int END = 3;
    protected static final int GAME = 2;
    protected static final int INTRO = 1;
    protected static final int MENU = 0;
    private static final Point ORIGIN = new Point(0, 0);
    private static final Point GAME_ANCHOR = new Point(0, 50);
    private static IntroPanel intro;
    private static GamePanel game;
    private static MenuPanel menu;
    private static StatisticsPanel stats;
    private static EndGamePanel endGame;

    public ContentSwitch() {

        setTitle(TITLE);
        setSize(WIN_WIDTH, WIN_HEIGHT);
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
        game.setDoubleBuffered(true);
        getContentPane().add(game);

        stats = new StatisticsPanel();
        stats.setLocation(ORIGIN);
        getContentPane().add(stats);

        endGame = new EndGamePanel();
        endGame.setLocation(ORIGIN);
        getContentPane().add(endGame);

        setVisible(true);

    }

    public static void switchPanel(int panel) {
        switch (panel) {

            case MENU:
                intro.setVisible(false);
                game.setVisible(false);
                stats.setVisible(false);
                endGame.setVisible(false);
                menu.setVisible(true);
                break;

            case INTRO:
                game.setVisible(false);
                menu.setVisible(false);
                stats.setVisible(false);
                endGame.setVisible(false);
                intro.setVisible(true);
                intro.startAnimation();
                break;

            case GAME:
                intro.setVisible(false);
                menu.setVisible(false);
                endGame.setVisible(false);
                stats.setVisible(true);
                game.setVisible(true);
                game.startGame();
                break;

            case END:
                intro.setVisible(false);
                menu.setVisible(false);
                stats.setVisible(false);
                game.setVisible(false);
                endGame.setVisible(true);
                break;
        }
    }

    public static GamePanel getGame() {
        return game;
    }

    public static StatisticsPanel getStats() {
        return stats;
    }

    public static IntroPanel getIntro() {
        return intro;
    }

    public static MenuPanel getMenu() {
        return menu;
    }

    public static EndGamePanel getEndGame() {
        return endGame;
    }

    private class PlayerListner implements KeyListener {

        public void keyTyped(KeyEvent key) {
        }

        @Override
        public void keyReleased(KeyEvent key) {

            game.keyReleased(key);


            if (key.getKeyCode() == KeyEvent.VK_ESCAPE) {
                game.gameOver();
            }

        }

        @Override
        public void keyPressed(KeyEvent key) {

            game.keyPressed(key);
        }

    }

}

