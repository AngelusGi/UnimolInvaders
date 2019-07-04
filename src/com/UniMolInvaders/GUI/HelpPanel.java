package UniMolInvaders.GUI;

import javax.swing.*;
import java.awt.*;

/**
 * Gestisce il pannello di aiuto mostrato nel menù
 */
public class HelpPanel extends JPanel {


    public HelpPanel() {

        String istruzioni = "ISTRUZIONI\n"
                + "\nPer muoverti utilizza le frecce: ◀ ▶"
                + "\nPer sparare utilizza la barra spaziatrice"
                + "\nHai a disposizione solo 3 vite, fai attenzione!"
                + "\nPer terminare anticipatamente la partita utilizza il tasto ESC"
                + "\n\nBuon divertimento! ☺";

        JOptionPane.showConfirmDialog(null, istruzioni, ContentSwitch.TITLE + " - Aiuto", JOptionPane.DEFAULT_OPTION);

    }


    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);

    }

}
