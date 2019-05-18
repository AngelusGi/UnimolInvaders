/********************************
 *
 *   user:      angel
 *   date:      01/05/2019
 *   project:   UnimolInvaders
 *   angelus_gi / angelusgi
 *
 ********************************/


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;


// public class Input implements KeyListener {
//
//     @Override
//    public void keyTyped(KeyEvent e) {
//    }
//
//    @Override
//    public void keyPressed(KeyEvent e) {
//        System.out.println("keyPressed="+KeyEvent.getKeyText(e.getKeyCode()));
//    }
//
//
//    //todo
//    //se non è stato rilasciato non far sparare altro colpo
//    @Override
//    public void keyReleased(KeyEvent e) {
//        System.out.println("keyReleased="+KeyEvent.getKeyText(e.getKeyCode()));
//    }
//
// }

public class Input extends JFrame {

    private JLabel etichetta;
    private JTextField campoNome;
    private JButton inserisciNome;

    private String nomeGiocatore;

    public Input(){
        setLayout(new FlowLayout());
        etichetta = new JLabel("Inserisci il tuo nomeGiocatore");
        add(etichetta);

        campoNome = new JTextField(20);
        add(campoNome);

        inserisciNome = new JButton("Inizia la partitia");
        add(inserisciNome);

        scrittura scrittura = new scrittura();
        inserisciNome.addActionListener(scrittura);
    }

    class scrittura  implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                nomeGiocatore = campoNome.getText();
                FileWriter stream = new FileWriter(".\\score.txt");
                BufferedWriter out = new BufferedWriter(stream);


                Calendar dataOdierna = new GregorianCalendar(Locale.ITALY);
//                Calendar dataOdierna = Calendar.getInstance(TimeZone.getTimeZone("Europe/Rome"), Locale.ITALY);
                Date dataPartita = dataOdierna.getTime();

                GameController gameController = new GameController();

                out.write("Giocatore: " + getNomeGiocatore() + " \tData: " + dataPartita.toLocaleString() + " \tPunteggio: " + gameController.getPunteggio()
                + " \tLivello: " + gameController.getNumLivello());
                out.close();
            } catch (Exception ex){

            }
        }

        public String getNomeGiocatore(){
            return nomeGiocatore;
        }
    }


    public static void main(String[] args){
        Input gui = new Input();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setSize(300,150);
        gui.setTitle("Benvenuto UniMol Invaders");
        gui.setVisible(true);
    }
}