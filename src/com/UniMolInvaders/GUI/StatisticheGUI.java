package UniMolInvaders.GUI;

import javax.swing.*;
import java.awt.*;

public class StatisticheGUI extends JPanel {

    private int punti;
    private int punteggioAlto;
    private int numVite;
    private Image iconaVite;

    private static final int DISTANZA_ELEMENTI = 50;
    private static final int DISTANZA_CUORE = DISTANZA_ELEMENTI * 3;
    private static final int DIM_CUORE = 30;
    private static final String testoPunti = "PUNTI ";
    private static final String testoPunteggioMax = "PUNTEGGIO PIÙ ALTO: ";
    private static final String testoPunteggioMaxGiocatore = " DI: ";
    private static final String testoVite = "VITE: ";
    private static final String testoLivello = "LIVELLO:: ";

    public StatisticheGUI(){

        this.setBackground(Color.BLACK);
        iconaVite = new ImageIcon(this.getClass().getResource("./Resources/cuore.png")).getImage();

    }

    @Override
    public void paint(Graphics grafica) {
        super.paint(grafica);

        grafica.setColor(Color.WHITE);

        grafica.setFont(MenuGUI.getFontGioco());
        grafica.drawString(testoLivello + Start.getGioco().getNumLivello(), DISTANZA_ELEMENTI, DISTANZA_ELEMENTI);
        grafica.drawString(testoPunti + Start.getGioco().getPunteggio(), DISTANZA_ELEMENTI * 6, DISTANZA_ELEMENTI);

        grafica.drawString(testoVite + Start.getGioco().getGiocatore().getVita(), DISTANZA_ELEMENTI * 3, DISTANZA_ELEMENTI);
        for (int i = 1; i <= Start.getGioco().getGiocatore().getVita(); i++) {
            grafica.drawImage(iconaVite, DISTANZA_ELEMENTI * i, DISTANZA_ELEMENTI, 30, 30, null );
        }

        grafica.drawString(testoPunti + Start.getGioco().getPunteggio(), DISTANZA_ELEMENTI * 6, DISTANZA_ELEMENTI);
    }
}
