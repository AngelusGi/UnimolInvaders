package UniMolInvaders.GUI;

import javax.swing.*;
import java.awt.*;

public class StatisticheGUI extends JPanel {

    private int points;
    private int lifes;
    private Image lifeIcon;

    private static final int DISTANCE = 50;
    private static final int LIFE_DIM = 15;
    private static final String POINT = "PUNTI ";
    private static final String HIGH_SCORE = "PUNTEGGIO PIÙ ALTO: ";
    private static final String PLAYER_HIGHT_SCORE = " DI: ";
    private static final String LIFE = "VITE: ";
    private static final String LEVEL = "LIVELLO:: ";

    public StatisticheGUI(){

        this.setBackground(Color.BLACK);
        lifeIcon = new ImageIcon(this.getClass().getResource("./Resources/cuore.png")).getImage();
        lifes = ContentSwitch.getGame().getGiocatore().getLifePoints();
        points = ContentSwitch.getStats().getPoints();

    }

    @Override
    public void paint(Graphics grafica) {
        super.paint(grafica);

        grafica.setColor(Color.WHITE);

        grafica.setFont(MenuPanel.getGeneralFont());
        grafica.drawString(LEVEL + ContentSwitch.getGame().getLevelNumber(), DISTANCE, DISTANCE);
        grafica.drawString(POINT + points, DISTANCE * 6, DISTANCE);

        grafica.drawString(LIFE + lifes, DISTANCE * 3, DISTANCE);

        for (int i = 1; i <= lifes; i++) {

            grafica.drawImage(lifeIcon, DISTANCE * i, DISTANCE, LIFE_DIM, LIFE_DIM, null);
        }

        grafica.drawString(POINT + getPoints(), DISTANCE * 6, DISTANCE);
        grafica.drawString(HIGH_SCORE + getPunteggioMax(), DISTANCE * 6, DISTANCE);
        grafica.drawString(PLAYER_HIGHT_SCORE + nomeGiocatoreMax(), DISTANCE * 6, DISTANCE);
        grafica.drawString(POINT + getPoints(), DISTANCE * 6, DISTANCE);

    }


    public void setPoints(int points) {
        this.points = points;
    }

    public int getPoints() {
        return points;
    }

    public void setLifes(int lifes) {
        this.lifes = lifes;
    }

    private String nomeGiocatoreMax(){
        //todo
        return ;
    }

    private String getPunteggioMax(){
        //todo
        return ;
    }

}
