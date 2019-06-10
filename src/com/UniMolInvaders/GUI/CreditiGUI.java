package UniMolInvaders.GUI;

import javax.swing.*;
import java.awt.*;

public class CreditiGUI extends JPanel {

    
    public CreditiGUI(){

        String crediti = "CREDITI\n\n"
                + "Grazie per le risorse grafiche:\n"
                    + "\tUniMol - Università del Molise\n"
                    + "\tJermungandr (www.spriters-resource.com)\n"
                    + "\tFattyMcGee (www.spriters-resource.com)\n"
                    + "\tPloaj (www.spriters-resource.com)\n"
                    + "\tMurphmario (www.spriters-resource.com)\n"
                    + "\tOpenClipart-Vectors-30363 (www.spriters-resource.com)\n"
                    + "\tThe Mad Soldier (www.spriters-resource.com)\n"
                
                +"\n\nDISCLAIMER:\nTutti i marchi riportati appartengono ai legittimi proprietari; marchi di terzi,"
                    + "\nnomi di prodotti, nomi commerciali, nomi corporativi e società citati possono essere marchi di"
                    + "\nproprietà dei rispettivi titolari o marchi registrati d’altre società e sono stati utilizzati a puro"
                    + "\nscopo esplicativo ed a beneficio del possessore, senza alcun fine di violazione dei diritti di Copyright vigenti.\n";


        JOptionPane.showConfirmDialog(null, crediti, "UniMol Invaders", JOptionPane.DEFAULT_OPTION);
        
    }


    @Override
    public void paint(Graphics graphics) {

        super.paint(graphics);

    }

}
