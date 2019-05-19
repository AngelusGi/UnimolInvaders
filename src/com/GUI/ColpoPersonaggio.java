package GUI;

import Logic.Colpo;

import javax.swing.*;
import java.awt.*;

public class ColpoPersonaggio extends JPanel implements Runnable {

    private Image immagineColpo;
    private Colpo colpo;

    public ColpoPersonaggio(){
        colpo = new Colpo(10, 10);
        immagineColpo = new ImageIcon(this.getClass().getResource("colpoUp.png")).getImage();
    }

    @Override
    public void print(Graphics graphics) {
        super.print(graphics);

        Color trasparente = new Color(1f,0f,0f,0f );
        graphics.setColor(trasparente);

//        graphics.setColor(Color.BLUE);

        graphics.fillRect(colpo.getPosX(), colpo.getPosY(), colpo.getDimColpoX(), colpo.getDimColpoY());
        graphics.drawImage(this.immagineColpo, colpo.getPosX(), colpo.getPosY(), trasparente, null);
    }

    @Override
    public void run() {
        while (colpo.isSparato()){
            repaint();
        }
    }
}
