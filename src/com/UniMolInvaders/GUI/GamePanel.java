package UniMolInvaders.GUI;


import UniMolInvaders.Logic.Enemy;
import UniMolInvaders.Logic.Player;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GamePanel extends JPanel {


    private static final int numAlieni = 10;
    private PlayerGraph player;
    private ArrayList<AlienGraph> aliens;
    private BossGraph boss;

    private final int POS_IN_ALIENO = 20;
    private boolean gameStarted;
    private int levelNumber;

    private Thread gameThread;
    private static final int ANIMATION_SLEEP = 200;


    public GamePanel() {

        setSize(ContentSwitch.WIM_WIDTH, ContentSwitch.WIN_HEIGHT - ContentSwitch.getStats().getWinHeight());

        setGameStarted(false);
//        setLevelNumber(0);

    }

    public void startGame(){

        initPlayer();

        if (isEven(levelNumber)) {

            // se il livello è pari (0, 2,...) aliens normali, altrimenti BOSS
            aliens = new ArrayList<>();
            initAliens();

        } else {
            initBoss();
        }

        ContentSwitch.getStats().setLifePoints( player.getLifePoints() );

        setGameStarted(true);
        gameThread = new Thread(new GameThread());
        gameThread.start();

    }


    private void muoviBoss(){

        boss.move();

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
                    aliens.get(j).setSpeedX(Enemy.RIGHT);
                    aliens.get(j).setPosY(aliens.get(j).getPosY() + 30);

                }

            } else if (aliens.get(i).getPosX() + aliens.get(i).getSpeedX() > ContentSwitch.WIM_WIDTH - aliens.get(i).getDimX() - 20) {

                //gestisce bordo SX e scende tutti gli aliens di 30px

                for (int j = 0; j < aliens.size(); j++) {
                    aliens.get(j).setSpeedX(Enemy.LELFT);
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

    private void gameOver(){
        new EndGamePanel(ContentSwitch.getStats().getPoints(), getLevelNumber());
        ContentSwitch.switchPanel(ContentSwitch.MENU);
        resetPartita();
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);

        try {
            if (player != null && player.isAlive()) {
                player.paint(graphics);
            }

            if (aliens != null && aliens.size() > 0) {
                for (AlienGraph alien : aliens) {
                    alien.paint(graphics);
                }
            }

            if (boss != null && boss.isAlive()) {
                boss.paint(graphics);
            }

        } catch (Exception ex){
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
        if ((aliens != null && aliens.size() == 0) || (boss != null && !boss.isAlive() ) ){
            setLevelNumber( getLevelNumber() + 1);
            resetPartita();
        }

        //else
        //todo finestra inserimento TITLE e salvataggio su file
        if (!player.isAlive()){

            new EndGamePanel(ContentSwitch.getStats().getPoints(), getLevelNumber());
        }



    }


    private void initAliens() {
        int posX = POS_IN_ALIENO;
        int posY = POS_IN_ALIENO;

        for (int i = 0; i < numAlieni; i++) {

            AlienGraph alieno = new AlienGraph(posX, posY, getLevelNumber());

            aliens.add(i, alieno);
            posX += alieno.getDimX() + POS_IN_ALIENO;

            if (i == (numAlieni / 2) - 1) {
                posX = POS_IN_ALIENO;
                posY += alieno.getDimY() + POS_IN_ALIENO;
            }

        }
    }

    private void initBoss() {

        this.boss = new BossGraph(POS_IN_ALIENO, POS_IN_ALIENO, getLevelNumber());

    }

    private void initPlayer() {

        this.player = new PlayerGraph(ContentSwitch.WIM_WIDTH / 2 - 40, ContentSwitch.getGame().getHeight() - Player.DIM_Y - 40);
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


    public void resetPartita(){
        setGameStarted(false);
        startGame();
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
//                        muoviBoss();
                        boss.run();
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
