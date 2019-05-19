package GUI;

import Logic.GameController;

import javax.swing.*;
import java.awt.*;

public class GiocoGUI extends JPanel implements Runnable {

    public GiocoGUI(GameController gameController){
        gameController = new GameController();
    }

    @Override
    public void run() {

    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
    }
}
