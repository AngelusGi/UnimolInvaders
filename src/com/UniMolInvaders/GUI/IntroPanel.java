package UniMolInvaders.GUI;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class IntroPanel extends JPanel {

    private static final String filePath = "./src/com/UniMolInvaders/GUI/Resources/storia.txt";
    private final Color textColor = Color.WHITE;

    private final int totalImages = 3;

    private final int imageX = 100;
    private final int imageY = 100;

    private final int textX = 30;
    private final int textY = 550;

    private ArrayList<Image> images;
    private ArrayList<String> text;

    private boolean finish;
    private Thread animation;

    private int pos;
    private int pause;


    IntroPanel(int pause) {


        this.images = new ArrayList<>();

        this.pause = pause;
        this.finish = false;
        this.pos = 0;

        setSize(ContentSwitch.WIN_WIDTH, ContentSwitch.WIN_HEIGHT);

        initText();
        initImages();

    }

    protected void reset() {
        this.finish = false;
        this.pos = 0;
        startAnimation();
    }


    private void initText() {

        this.text = new ArrayList<>();
        try {
            Scanner historyScan = new Scanner(new File(filePath));
            while (historyScan.hasNextLine()) {
                this.text.add(historyScan.nextLine());
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(this.getName()).log(Level.FINE, null, ex);

        }
    }


    private void initImages() {

        for (int i = 0; i < this.totalImages; i++) {

            String imageName = "./Resources/intro" + (i + 1) + ".png";
            this.images.add(i, new ImageIcon(this.getClass().getResource(imageName)).getImage());
        }
    }


    public void paint(Graphics graphics) {

        super.paint(graphics);

        graphics.setColor(Color.BLACK);
        graphics.fillRect(0, 0, ContentSwitch.WIN_WIDTH, ContentSwitch.WIN_HEIGHT);


        if ((images.get(pos) != null) && (text.get(pos) != null)) {
            graphics.drawImage(images.get(pos), imageX, imageY, this);
            graphics.setColor(textColor);
            graphics.setFont(MenuPanel.getGeneralFont());
            graphics.drawString(text.get(pos), textX, textY);

        } else {
            graphics.setColor(textColor);
            graphics.setFont(MenuPanel.getGeneralFont());
            graphics.drawString("ERRORE CARICAMENTO CONTENUTO", textX, textY);

        }

    }


    public void startAnimation() {

        this.animation = new Thread(new AnimationThread());
        this.animation.start();
    }


    private void stop() {

        this.finish = true;
        this.animation = null;

        ContentSwitch.switchPanel(ContentSwitch.GAME);
        repaint();

    }


    private class AnimationThread implements Runnable {
        @Override
        public void run() {

            while (!finish) {
                try {

                    repaint();
                    Thread.sleep(pause);

                    if (pos < images.size() - 1) {
                        pos++;

                    } else {

                        stop();
                    }

                } catch (InterruptedException ex) {
                    Logger.getLogger(this.getClass().getName()).log(Level.INFO, null, ex);
                }
            }
        }
    }

}


