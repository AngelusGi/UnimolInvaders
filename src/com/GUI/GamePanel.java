package GUI;

import Logic.GameController;

import javax.swing.*;

public class GamePanel extends JPanel {

    private AlienoGUI alieni;

//    public GamePanel(GameController logicaGioco){

//        logicaGioco = new GameController();
//        logicaGioco.setNumLivello(0);

    public GamePanel(){
        alieni = new AlienoGUI();

        add(alieni);
        setVisible(true);

        try {
            Thread.sleep(500);
            alieni.muoviAlieni();
            alieni.repaint();
        } catch (Exception e){

        }
    }
}
