package GUI;

import javax.swing.*;
import java.awt.*;

public class IstruzioniGUI extends JPanel {

    
    public IstruzioniGUI(){

        String istruzioni = "ISTRUZIONI\n"
                + "\nPer muoverti utilizza le freccette: < >"
                + "\nPer attaccare utilizza la barra spaziatrice"
                + "\nHai a disposizione solo 3 vite, fai attenzione!"
                + "\n\nBuon divertimento! ☺";

        JOptionPane.showConfirmDialog(null, istruzioni, "UniMol Invaders", JOptionPane.DEFAULT_OPTION);
        
    }


    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);

    }

}
