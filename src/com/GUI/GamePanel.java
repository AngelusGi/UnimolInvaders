package GUI;

import Logic.GameController;

import javax.swing.*;
import java.util.logging.Level;
import java.util.logging.Logger;

class GamePanel extends JPanel {

    private AlienoGUI alieni;

//    public GamePanel(GameController logicaGioco){

//        logicaGioco = new GameController();
//        logicaGioco.setNumLivello(0);

    GamePanel(){
        alieni = new AlienoGUI();

        add(alieni);
        setVisible(true);

        try {
            Thread.sleep(500);
            alieni.muoviAlieni();
            alieni.repaint();

        } catch (Exception e){
            Logger.getLogger(this.getClass().getName()).log(Level.INFO, null, e);
        }
    }
}
