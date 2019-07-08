package UniMolInvaders.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class ContentSwitch extends JFrame {

    /**
     * Gestisce la selezione dei pannelli
     */
    public enum Pannelli {
        MENU,
        INTRO,
        GAME,
        END
    }


    public final static int WIN_WIDTH = 1024;
    public final static int WIN_HEIGHT = 768;
    public final static int TEST_PAUSE = 500;
    public final static int PAUSE = 3000;
    protected final static String TITLE = "UniMol Invaders";
    private static final Point ORIGIN = new Point(0, 0);
    private static final Point GAME_ANCHOR = new Point(0, 50);
    private static IntroPanel intro;
    private static GamePanel game;
    private static MenuPanel menu;
    private static StatisticsPanel stats;
    private static EndPanel endGame;

    /**
     * Si occupa di cambiare il pannello visibile a video
     */
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

        intro = new IntroPanel(PAUSE);
        intro.setLocation(ORIGIN);
        getContentPane().add(intro);

        game = new GamePanel();
        game.setLocation(GAME_ANCHOR);
        game.setDoubleBuffered(true);
        getContentPane().add(game);

        stats = new StatisticsPanel();
        stats.setLocation(ORIGIN);
        getContentPane().add(stats);

        endGame = new EndPanel();
        endGame.setLocation(ORIGIN);
        getContentPane().add(endGame);

        setVisible(true);

    }

    /**
     * effettua il cambio del cannello
     *
     * @param panel : ID del pannello da visualizzare
     */
    public static void switchPanel(Pannelli panel) {
        switch (panel) {

            case MENU:
                intro.setVisible(false);
                game.setVisible(false);
                stats.setVisible(false);
                endGame.setVisible(false);
                endGame.hidePanel();
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
                game.initPlayer();
                break;

            case END:
                intro.setVisible(false);
                menu.setVisible(false);
                stats.setVisible(false);
                game.setVisible(false);
                endGame.setVisible(true);
                endGame.initPanel();
                break;
        }
    }

    /**
     * Accede al game panel
     * @return GamePanel
     */
    public static GamePanel getGame() {
        return game;
    }

    /**
     * Accede al pannello statistiche
     * @return StatisticPanel
     */
    public static StatisticsPanel getStats() {
        return stats;
    }

    /**
     * Accede al pannello introduttivo
     * @return IntroPanel
     */
    public static IntroPanel getIntro() {
        return intro;
    }

    /**
     * Accede al pannello del menu
     * @return MenuPanel
     */
    public static MenuPanel getMenu() {
        return menu;
    }

    /**
     * Accede al pannello di fine partita
     * @return EndPanel
     */
    public static EndPanel getEndGame() {
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

