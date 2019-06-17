package UniMolInvaders.GUI;

import javax.swing.*;
import java.awt.*;

public class StatisticsPanel extends JPanel {

    private static final int DISTANCE = 30;
    private static final int LIFE_DIM = 15;
    private static final int WIN_HEIGHT = 50;
    private static final String POINT = "PUNTI: ";
    private static final String HIGH_SCORE = "HIGHEST SCORE: ";
    private static final String PLAYER_HIGHT_SCORE = "BY: ";
    private static final String LIFE = "VITE: ";
    private static final String LEVEL = "LIVELLO: ";
    private int points;
    private int life;
    private Image lifeIcon;

    public StatisticsPanel() {

        setSize(ContentSwitch.WIN_WIDTH, WIN_HEIGHT);
        setBackground(Color.BLACK);
        lifeIcon = new ImageIcon(this.getClass().getResource("./Resources/cuore.png")).getImage();

    }

    public static int getWinHeight() {
        return WIN_HEIGHT;
    }


    public void paint(Graphics graphics) {
        super.paint(graphics);

        graphics.setColor(Color.WHITE);

        graphics.setFont(MenuPanel.getGeneralFont());
        graphics.drawString(LEVEL + ContentSwitch.getGame().getLevelNumber(), DISTANCE, DISTANCE);
        graphics.drawString(POINT + points, DISTANCE * 5, DISTANCE);

        graphics.drawString(LIFE, DISTANCE * 10, DISTANCE);

        if (ContentSwitch.getGame().getPlayer() != null) {

            for (int i = 1; i <= ContentSwitch.getGame().getPlayer().getLifePoints(); i++) {

                graphics.drawImage(lifeIcon, (DISTANCE * 11) + DISTANCE * i, DISTANCE - 15, LIFE_DIM, LIFE_DIM, null);
            }
        }


//        graphics.drawString(HIGH_SCORE + getHighestScore(), DISTANCE * 6, DISTANCE);
//        graphics.drawString(PLAYER_HIGHT_SCORE + getTopPlayer(), DISTANCE * 6, DISTANCE);
//
        graphics.drawString(HIGH_SCORE + 10000, DISTANCE * 19, DISTANCE);
        graphics.drawString(PLAYER_HIGHT_SCORE + "Angelo", DISTANCE * 27, DISTANCE);

    }

    public int getPoints() {
        return points;
    }

    public void raisePoints() {
        this.points += 20;
    }

    public void setLifePoints(int life) {
        this.life = life;
    }

    //    private String getTopPlayer(){
//        //todo
//        return ;
//    }
//
//    private String getHighestScore(){
//        //todo
//        return ;
//    }

}
