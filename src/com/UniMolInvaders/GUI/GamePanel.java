package UniMolInvaders.GUI;


import UniMolInvaders.Logic.Alien;
import UniMolInvaders.Logic.Enemy;
import UniMolInvaders.Logic.Player;
import UniMolInvaders.Logic.Shot;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GamePanel extends JPanel {


    private static final int NUM_ALIENS = 8;
    private static final int ANIMATION_SLEEP = 200;
    private static final int REPAINT_SLEEP = 100;
    private static int MAX_WAIT = 5000;
    private final int INIT_POS_ALIEN = 10;
    private final int PLAYER_POS_X = ContentSwitch.WIN_WIDTH / 2 - 40;
    private final int PLAYER_POS_Y = ContentSwitch.WIN_HEIGHT - StatisticsPanel.getWinHeight() - Player.DIM_Y - 50;
    private PlayerGraph player;
    private ArrayList<AlienGraph> aliens;
    private BossGraph boss;
    private boolean gameStarted;
    private int levelNumber;
    private Thread gameThread;
    private Thread shooterThread;
    private Thread paintThread;
    private Image image;
    private ArrayList<ShootGraph> shoot;


    public GamePanel() {

        setSize(ContentSwitch.WIN_WIDTH, ContentSwitch.WIN_HEIGHT - StatisticsPanel.getWinHeight());
        image = new ImageIcon(this.getClass().getResource("./Resources/background.jpg")).getImage();
        setGameStarted(false);
        initPlayer();


    }

    public void startGame() {

        shoot = new ArrayList<>();

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
        paintThread = new Thread(new PaintThread());
        paintThread.start();

    }


    private void muoviBoss() {

        boss.run();

        if (boss.getPosY() + boss.getDimY() >= player.getPosY()) {
            //se raggiunge il personaggio, game over
            gameOver();
        }

    }


    private void moveAliens() {

        for (int i = 0; i < aliens.size(); i++) {

            if (aliens.get(i).getPosX() + aliens.get(i).getSpeedX() < 0) {
                //gestisce bordo SX e scende tutti gli aliens di 30px

                for (Alien alien : aliens) {
                    alien.changeDirection(Enemy.CHANGE_DIR);
                    alien.setPosY(alien.getPosY() + 30);
                }

            } else if (aliens.get(i).getPosX() + aliens.get(i).getSpeedX() > ContentSwitch.WIN_WIDTH - aliens.get(i).getDimX() - 20) {

                //gestisce bordo SX e scende tutti gli aliens di 30px

                for (Alien alien : aliens) {
                    alien.changeDirection(Enemy.CHANGE_DIR);
                    alien.setPosY(alien.getPosY() + 30);
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
        setLevelNumber(0);
        ContentSwitch.getIntro().reset();
        ContentSwitch.getEndGame().setLevel(levelNumber);
        ContentSwitch.getEndGame().setPoints(ContentSwitch.getStats().getPoints());
        ContentSwitch.switchPanel(ContentSwitch.Pannelli.END);
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

                aliens.forEach((alien -> {
                    if (alien.isAlive())
                        alien.paint(graphics2D);
                }));
            }

            if (boss != null) {
                boss.paint(graphics2D);
            }

            if (shoot != null && shoot.size() > 0) {
                shoot.forEach((shot -> {
                    if (shot.isAlive()) {
                        shot.draw(graphics);
                    }
                }));
            }

        } catch (Exception ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.INFO, null, ex);
        }

    }


    protected void winOrLoose() {

        //IF vinto, livello incrementato di 1
        if ((aliens != null && aliens.size() == 0) || (boss != null && !boss.isAlive())) {
            setLevelNumber(getLevelNumber() + 1);
            reset();
            startGame();
            resetPlayerPosition();
        }

        //else
        //todo finestra inserimento TITLE e salvataggio su file
        if (!player.isAlive()) {
            gameOver();
            resetPlayer();
        }


    }

    private void initAliens() {

        int posX = INIT_POS_ALIEN;
        int posY = INIT_POS_ALIEN;

        this.aliens = new ArrayList<>();

        for (int i = 0; i < NUM_ALIENS; i++) {

            AlienGraph alieno = new AlienGraph(posX, posY, getLevelNumber());

            aliens.add(i, alieno);
            posX += alieno.getDimX() + INIT_POS_ALIEN;

            if (i == (NUM_ALIENS / 2) - 1) {
                posX = INIT_POS_ALIEN;
                posY += alieno.getDimY() + INIT_POS_ALIEN;
            }

        }
    }

    private void initBoss() {
        this.boss = new BossGraph(INIT_POS_ALIEN, INIT_POS_ALIEN, getLevelNumber());

    }

    protected void initPlayer() {

        this.player = new PlayerGraph(PLAYER_POS_X, PLAYER_POS_Y);

    }

    private boolean isEven(int levelNumber) {
        //se il livello è pari (0, 2,...) ritorna TRUE, altrimenti FALSE
        return levelNumber % 2 == 0;
    }

    public void reset() {
        setGameStarted(false);
        paintThread = null;
        shooterThread = null;
        gameThread = null;
        aliens = null;
        boss = null;
        shoot = null;
    }

    protected void resetPlayer(){
        player = null;
//        initPlayer();
    }

    protected void resetPlayerPosition(){
        player.setPosX(PLAYER_POS_X);
        player.setPosY(PLAYER_POS_Y);
    }

    private void kill() {

        if (isEven(getLevelNumber())) {

            shoot.forEach(shot -> {
                //player colpito da colpo alieno
                if (shot.isAlive() && shot.getBounds().intersects(player.getBounds()) && (shot.isDirection() != Shot.getPlayerDirection())) {
                    shot.setAlive(false);
                    player.decrementLife();

                }

                aliens.forEach((alien -> {
                    //alieno colpito da colpo player
                    if (alien.isAlive() && shot.getBounds().intersects(alien.getBounds()) && shot.isAlive() && (shot.isDirection() == Shot.getPlayerDirection())) {
                        shot.setAlive(false);
                        alien.decrementLife();
                        ContentSwitch.getStats().raisePoints();
                    }
                }));

            });

        } else {
            shoot.forEach(shot -> {
                //boss colpisce player
                if (shot.isAlive() && shot.getBounds().intersects(player.getBounds()) && (shot.isDirection() != Shot.getPlayerDirection())) {
                    shot.setAlive(false);
                    player.decrementLife();
                }

                //player colpisce boss
                if (boss.isAlive() && shot.getBounds().intersects(boss.getBounds()) && shot.isAlive() && (shot.isDirection() == Shot.getPlayerDirection())) {
                    shot.setAlive(false);
                    boss.decrementLife();
                    ContentSwitch.getStats().raisePoints();
                }
            });
        }

        if (shoot != null) {
            shoot.removeIf(shot -> (!shot.isAlive()));
        }

        if (aliens != null) {
            aliens.removeIf(alien -> (!alien.isAlive()));
        }
    }


    public PlayerGraph getPlayer() {
        return player;
    }

    public void keyReleased(KeyEvent key) {

        switch (key.getKeyCode()) {

            case KeyEvent.VK_ESCAPE:
                gameOver();
                break;

            case KeyEvent.VK_LEFT:

            case KeyEvent.VK_RIGHT:
                player.setSpeedX(player.STOP);
                break;

            case KeyEvent.VK_SPACE:
                player.tryToFire();
                break;
        }
    }


    public void keyPressed(KeyEvent key) {
        switch (key.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                player.setSpeedX(player.LEFT);
                player.move();
                break;

            case KeyEvent.VK_RIGHT:
                player.setSpeedX(player.RIGHT);
                player.move();
                break;
        }
    }

    protected int getLevelNumber() {
        return levelNumber;
    }

    public void setLevelNumber(int livello) {
        this.levelNumber = livello;
    }

    public ArrayList<ShootGraph> getShoot() {
        return shoot;
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
                        int whichAlien = random.nextInt(aliens.size());
                        aliens.get(whichAlien).tryToFire();
                    }


                    if (boss != null) {
                        boss.tryToFire();
                    }


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

                    winOrLoose();

                } catch (Exception e) {
                    //eccezione generic perché possono andarci sia NullPointer, sia Interrupted
                    Logger.getLogger(this.getClass().getName()).log(Level.INFO, null, e);
                }

            }

        }
    }

    private class PaintThread implements Runnable {

        @Override
        public void run() {
            while (isGameStarted()) {
                try {

                    Thread.sleep(REPAINT_SLEEP);
                    repaint();
                    ContentSwitch.getStats().repaint();
                    kill();

                } catch (Exception e) {
                    //eccezione generic perché possono andarci sia NullPointer, sia Interrupted
                    Logger.getLogger(this.getClass().getName()).log(Level.INFO, null, e);
                }

            }

        }
    }

}
