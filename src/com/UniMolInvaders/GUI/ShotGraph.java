package UniMolInvaders.GUI;

import UniMolInvaders.Logic.Enemy;
import UniMolInvaders.Logic.Player;
import UniMolInvaders.Logic.Shot;

import javax.swing.*;
import java.awt.*;

public class ShotGraph extends Shot {

    private static final int PLAYER_DIRECTION = -1;
    private static final int ENEMY_DIRECTION = 1;
    private Image image;


    public ShotGraph(Player player) {
        super(player.getPosX(), player.getPosY(), PLAYER_DIRECTION);
        image = new ImageIcon(this.getClass().getResource("./Resources/colpoUp.png")).getImage();
    }

    public ShotGraph(Enemy enemy) {
        super(enemy.getPosX(), enemy.getPosY(), ENEMY_DIRECTION);
        image = new ImageIcon(this.getClass().getResource("./Resources/colpoDown.png")).getImage();
    }

    public void paint(Graphics graphics) {

        Color trasparent = new Color(1f, 0f, 0f, 0f);
        graphics.setColor(trasparent);

//        graphics.setColor(Color.YELLOW);
//        graphics.fillRect(this.getPosX(), this.getPosY(), this.getDimX(), this.getDimY());

        graphics.drawImage(this.image, this.getPosX(), this.getPosY(), trasparent, null);
    }


    public void run() {
        while (this.isSparato()) {
            this.muovi(this.getPosY());
        }
    }

}
