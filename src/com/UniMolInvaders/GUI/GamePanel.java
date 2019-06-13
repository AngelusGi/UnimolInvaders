package UniMolInvaders.GUI;


import UniMolInvaders.Logic.Enemy;
import UniMolInvaders.Logic.Player;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GamePanel extends JPanel {


    private static final int numAlieni = 14;
    private static final int ANIMATION_SLEEP = 200;
    private static int MAX_WAIT = 2000;
    private final int INIT_POS_ALIEN = 10;
    private PlayerGraph player;
    private ArrayList<AlienGraph> aliens;
    private BossGraph boss;
    private boolean gameStarted;
    private int levelNumber;
    private Thread gameThread;
    private Thread shooterThread;
    private Image image;


    public GamePanel() {

        setSize(ContentSwitch.WIN_WIDTH, ContentSwitch.WIN_HEIGHT - StatisticsPanel.getWinHeight());
        image = new ImageIcon(this.getClass().getResource("./Resources/background.jpg")).getImage();
        setGameStarted(false);
        setLevelNumber(1);

    }

    public void startGame() {

        initPlayer();

        if (isEven(levelNumber)) {

            // se il livello è pari (0, 2,...) aliens normali, altrimenti BOSS
            initAliens();
            boss = null;

        } else {
            initBoss();
            aliens = null;
        }

        ContentSwitch.getStats().setLifePoints(player.getLifePoints());

        setGameStarted(true);
        gameThread = new Thread(new GameThread());
        gameThread.start();
        shooterThread = new Thread(new ShooterThread());
        shooterThread.start();

    }


    private void muoviBoss() {

        boss.run();

        if (boss.getPosY() + boss.getDimY() >= player.getPosY()) {
            //se raggiongoe il personaggio, game over
            gameOver();
        }
    }


    private void moveAliens() {

        for (int i = 0; i < aliens.size(); i++) {

            if (aliens.get(i).getPosX() + aliens.get(i).getSpeedX() < 0) {
                //gestisce bordo SX e scende tutti gli aliens di 30px

                for (int j = 0; j < aliens.size(); j++) {
                    aliens.get(j).changeDirection(Enemy.CHANGE_DIR);
                    aliens.get(j).setPosY(aliens.get(j).getPosY() + 30);

                }

            } else if (aliens.get(i).getPosX() + aliens.get(i).getSpeedX() > ContentSwitch.WIN_WIDTH - aliens.get(i).getDimX() - 20) {

                //gestisce bordo SX e scende tutti gli aliens di 30px

                for (int j = 0; j < aliens.size(); j++) {
                    aliens.get(j).changeDirection(Enemy.CHANGE_DIR);
                    aliens.get(j).setPosY(aliens.get(j).getPosY() + 30);

                }

            } else {

                //sposta gli aliens lungo l'assse X
                aliens.get(i).setPosX(aliens.get(i).getPosX() + aliens.get(i).getSpeedX());
            }

            if (aliens.get(i).getPosY() + aliens.get(i).getDimY() >= player.getPosY()) {
                //se raggiongono il personaggio, game over
                gameOver();
            }

        }
    }

    protected void gameOver() {
        this.reset();
        ContentSwitch.getIntro().reset();
        ContentSwitch.getEndGame().setPoints();
        ContentSwitch.getEndGame().setLevel();
        ContentSwitch.switchPanel(ContentSwitch.END);
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);

        Graphics2D graphics2D = (Graphics2D) graphics;

        graphics.drawImage(image, 0, 0, null);

        try {
            if (player != null && player.isAlive()) {
                player.paint(graphics2D);
            }

            if (aliens != null && aliens.size() > 0) {
                for (AlienGraph alien : aliens) {
                    alien.paint(graphics2D);
                }
            }

            if (boss != null) {
                boss.paint(graphics2D);
            }

        } catch (Exception ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.INFO, null, ex);
        }

    }


//    todo
//    private boolean collision() {
//        return this.player.getDimesnione().intersects(getBounds());
//    }


    protected void winOrLoose() {
        //todo

        //IF vinto, livello incrementato di 1
        if ((aliens != null && aliens.size() == 0) || (boss != null && !boss.isAlive())) {
            setLevelNumber(getLevelNumber() + 1);
            reset();
        }

        //else
        //todo finestra inserimento TITLE e salvataggio su file
        if (!player.isAlive()) {
            gameOver();
        }


    }


    private void initAliens() {

        int posX = INIT_POS_ALIEN;
        int posY = INIT_POS_ALIEN;

        this.aliens = new ArrayList<>();

        for (int i = 0; i < numAlieni; i++) {

            AlienGraph alieno = new AlienGraph(posX, posY, getLevelNumber());

            aliens.add(i, alieno);
            posX += alieno.getDimX() + INIT_POS_ALIEN;

            if (i == (numAlieni / 2) - 1) {
                posX = INIT_POS_ALIEN;
                posY += alieno.getDimY() + INIT_POS_ALIEN;
            }

        }
    }

    private void initBoss() {
        this.boss = new BossGraph(INIT_POS_ALIEN, INIT_POS_ALIEN, getLevelNumber());

    }

    private void initPlayer() {

        this.player = new PlayerGraph(ContentSwitch.WIN_WIDTH / 2 - 40, ContentSwitch.getGame().getHeight() - Player.DIM_Y - 50);

    }

    private boolean isEven(int levelNumber) {
        //se il livello è pari (0, 2,...) ritorna TRUE, altrimenti FALSE
        return levelNumber % 2 == 0;
    }


//    //testa la corretta inizializzazione dei livelli e la gestione dei livelli (pari/dispari)
//    public void stampaLivello() {
//        System.out.print("Livello: " + levelNumber);
//        System.out.println(" è pari: " + isEven(levelNumber));
//        if (levelNumber <= 5) {
//            levelNumber += 1;
//        } else {
//            System.exit(1);
//        }
//
//        stampaLivello();
//    }

//    public void stampaPersonaggi() {
//
//        initAliens();
//
//        for (int num = 0; num < aliens.size(); num++) {
//            System.out.print("Alien[" + num + "] > " + aliens.get(num) + " \t ");
//            System.out.println("\n");
//        }
//
//        initBoss();
//        System.out.println("\nBoss > " + boss + "\n");
//
//        initPlayer();
//        System.out.println("player > " + player + "\n");
//
//    }


    public void reset() {
        shooterThread = null;
        gameThread = null;
        aliens = null;
        boss = null;
        player = null;
        setLevelNumber(0);
        setGameStarted(false);
    }

    public PlayerGraph getPlayer() {
        return player;
    }

    protected int getLevelNumber() {
        return levelNumber;
    }


    public void setLevelNumber(int livello) {
        this.levelNumber = livello;
    }

    public boolean isGameStarted() {
        return gameStarted;
    }

    public void setGameStarted(boolean gameStarted) {
        this.gameStarted = gameStarted;
    }

    private class ShooterThread implements Runnable {

        @Override
        public void run() {
            while (isGameStarted()) {
                try {
                    Random random = new Random();

                    Thread.sleep(random.nextInt(MAX_WAIT));

                    if (aliens != null) {
                        aliens.get(random.nextInt(aliens.size())).shoot();
                    }

                    if (boss != null) {
                        boss.run();
                    }

                    repaint();
                    ContentSwitch.getStats().repaint();

                } catch (Exception e) {
                    //eccezione generic perché possono andarci sia NullPointer, sia Interrupted
                    Logger.getLogger(this.getClass().getName()).log(Level.INFO, null, e);
                }

            }

        }
    }

    private class GameThread implements Runnable {

        @Override
        public void run() {
            while (isGameStarted()) {
                try {

                    Thread.sleep(ANIMATION_SLEEP);

                    if (aliens != null) {
                        moveAliens();
                    }

                    if (boss != null) {
                        muoviBoss();
                    }

                    player.move();
                    winOrLoose();
                    repaint();
                    ContentSwitch.getStats().repaint();

                } catch (Exception e) {
                    //eccezione generic perché possono andarci sia NullPointer, sia Interrupted
                    Logger.getLogger(this.getClass().getName()).log(Level.INFO, null, e);
                }

            }

        }
    }

}
