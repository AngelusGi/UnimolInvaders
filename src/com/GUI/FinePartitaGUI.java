package GUI;

import Logic.FinePartita;

import javax.swing.*;
import java.awt.*;

public class FinePartitaGUI  extends JPanel {

    public FinePartitaGUI(FinePartita finePartita){
        finePartita = new FinePartita();
        finePartita.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        finePartita.setSize(300,150);
        finePartita.setResizable(false);
        finePartita.setTitle("UniMol Invaders");
        finePartita.setVisible(true);
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
    }

}
