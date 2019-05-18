package GUI;

import javax.swing.*;
import java.awt.*;

public class IntroGui extends JPanel implements Runnable {


    private Image intro1;
    private Image intro2;
    private Image intro3;


    private final int tempoApparizione = 5;

    public IntroGui(){
        intro1 = new ImageIcon(this.getClass().getResource("intro1.png")).getImage();
        intro2 = new ImageIcon(this.getClass().getResource("intro2.png")).getImage();
        intro3 = new ImageIcon(this.getClass().getResource("intro3.png")).getImage();
    }


    @Override
    public void paint(Graphics graphics) {

        super.paint(graphics);

        graphics.setColor(Color.BLACK);

        graphics.drawString("introduzone", 50,20);
        graphics.drawImage(this.intro3, 150, 150, Color.BLACK, null);


    }


//    @todo cambiare schermata ogni 5 secondi
    @Override
    public void run() {
        while (true){
            repaint();
        }
    }
}
