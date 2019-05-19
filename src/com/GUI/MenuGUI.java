package GUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MenuGUI extends JPanel {

    private Image sfondo;
    private JButton nuovaPartita;
    private JButton esci;
    private JButton crediti;
    private JButton istruzioni;
    private JTextArea punteggioMassimo;

    public MenuGUI(){
        sfondo = new ImageIcon(this.getClass().getResource("menu.png")).getImage();

        //todo
        nuovaPartita = new JButton("Gioca");
        esci = new JButton("Esci");
        crediti = new JButton("Crediti");
        istruzioni = new JButton("Istruzioni");

        punteggioMassimo = new JTextArea();

        setLayout(new FlowLayout());
        setSize(300,150);

        add(nuovaPartita);
//        add(crediti);
//        add(istruzioni);
//        add(esci);


        setVisible(true);

    }


    @Override
    public void paint(Graphics graphics) {

        super.paint(graphics);

    }

}
