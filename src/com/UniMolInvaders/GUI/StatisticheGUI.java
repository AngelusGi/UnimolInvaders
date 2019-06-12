package UniMolInvaders.GUI;

import javax.swing.*;
import java.awt.*;

public class StatisticheGUI extends JPanel {

    private int points;
    private int life;
    private Image lifeIcon;

    private static final int DISTANCE = 30;
    private static final int LIFE_DIM = 15;
    private static final int WIN_HEIGHT = 50;
    private static final String POINT = "PUNTI: ";
    private static final String HIGH_SCORE = "HIGHEST SCORE: ";
    private static final String PLAYER_HIGHT_SCORE = " DI: ";
    private static final String LIFE = "VITE: ";
    private static final String LEVEL = "LIVELLO: ";

    public StatisticheGUI() {

        setSize(ContentSwitch.WIM_WIDTH, WIN_HEIGHT);
        lifeIcon = new ImageIcon(this.getClass().getResource("./Resources/cuore.png")).getImage();

    }

    @Override
    public void paint(Graphics grafica) {
        super.paint(grafica);

        grafica.setColor(Color.BLACK);

        grafica.setFont(MenuPanel.getGeneralFont());
        grafica.drawString(LEVEL + ContentSwitch.getGame().getLevelNumber(), DISTANCE, DISTANCE);
        grafica.drawString(POINT + points, DISTANCE * 5, DISTANCE);

//        grafica.drawString(LIFE + life, DISTANCE * 10, DISTANCE);
        grafica.drawString(LIFE, DISTANCE * 10, DISTANCE);

        for (int i = 1; i <= 3; i++) {

            grafica.drawImage(lifeIcon, (DISTANCE * 11) + DISTANCE * i, DISTANCE - 15, LIFE_DIM, LIFE_DIM, null);
        }


//        grafica.drawString(HIGH_SCORE + getHighestScore(), DISTANCE * 6, DISTANCE);
//        grafica.drawString(PLAYER_HIGHT_SCORE + getTopPlayer(), DISTANCE * 6, DISTANCE);
//
        grafica.drawString(HIGH_SCORE + 10000, DISTANCE * 19, DISTANCE);
        grafica.drawString(PLAYER_HIGHT_SCORE + "Angelo", DISTANCE * 27, DISTANCE);

    }


    public void setPoints(int points) {
        this.points = points;
    }

    public int getPoints() {
        return points;
    }

    public void setLifePoints(int life) {
        this.life = life;
    }

    public static int getWinHeight() {
        return WIN_HEIGHT;
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
