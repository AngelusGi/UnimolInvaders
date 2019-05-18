/********************************
 *
 *   user:      angel
 *   date:      01/02/2019
 *   project:   UnimolInvaders
 *   angelus_gi / angelusgi
 *
 ********************************/

public class UniMolInvaders {

    private static Alieni alieni;

    public static void main(String[] args) {



        GameController gameController = new GameController();

        //verifica la corretta inizializzazione degli oggetti
        gameController.stampaPersonaggi();
        gameController.stampaLivello();


//        JFrame frame = new JFrame("Arkanoid Demo");
//        AlienoGUI gamePanel = new AlienoGUI(alieni);
//        frame.add(gamePanel);
//        frame.setSize(700, 500);
//        frame.setVisible(true);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
