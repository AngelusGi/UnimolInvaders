package GUI;

import javax.swing.*;
import java.awt.*;

public class Intro3GUI extends JPanel {

    private Image intro;

    public Intro3GUI(){

        intro = new ImageIcon(this.getClass().getResource("intro3.png")).getImage();

    }

    @Override
    public void paint(Graphics graphics) {

        super.paint(graphics);
        setBackground(Color.BLACK);

        graphics.drawImage(this.intro, 100,50 , Color.BLACK, null);


    }

}
