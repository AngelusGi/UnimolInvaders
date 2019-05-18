package GUI;

import javax.swing.*;
import java.awt.*;

public class MenuGUI extends JPanel implements Runnable {

    private Image sfondo;
    private JButton nuovaPartita;
    private JButton esci;
    private JTextArea punteggioMassimo;

    public MenuGUI(){
        sfondo = new ImageIcon(this.getClass().getResource("menu.png")).getImage();

        //todo
        nuovaPartita = new JButton();
        esci = new JButton();
        punteggioMassimo = new JTextArea();
    }


    @Override
    public void paint(Graphics graphics) {

        super.paint(graphics);

        graphics.setColor(Color.BLACK);

        graphics.drawImage(this.sfondo, 150, 150, null, null);


    }

    @Override
    public void run() {
        while (true){
            repaint();
        }
    }

}
