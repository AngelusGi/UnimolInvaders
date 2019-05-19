package GUI;

import javax.swing.*;
import java.awt.*;

public class Intro2GUI extends JPanel {

    private Image intro;

    public Intro2GUI(){

        intro = new ImageIcon(this.getClass().getResource("intro2.png")).getImage();

    }

    @Override
    public void paint(Graphics graphics) {

        super.paint(graphics);
        setBackground(Color.BLACK);

        graphics.drawImage(this.intro, 100,50 , Color.BLACK, null);


    }

}
