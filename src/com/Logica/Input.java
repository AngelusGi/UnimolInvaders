package Logica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/********************************
 *
 *   user:      angel
 *   date:      02/02/2019
 *   project:   UnimolInvaders
 *   angelus_gi / angelusgi
 *
 ********************************/



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

    private JLabel label;
    private JTextField textField;
    private JButton button;

    private String nomeGiocatore;

    public Input(){
        setLayout(new FlowLayout());
        label = new JLabel("Inserisci il tuo nomeGiocatore");
        add(label);

        textField = new JTextField(20);
        add(textField);

        button = new JButton("Inizia la partitia");
        add(button);

        scrittura scrittura = new scrittura();
        button.addActionListener(scrittura);
    }

    class scrittura  implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                nomeGiocatore = textField.getText();
                FileWriter stream = new FileWriter(".\\score.txt");
                BufferedWriter out = new BufferedWriter(stream);


                Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Europe/Rome"), Locale.ITALY);
                Date dataPartita = calendar.getTime();

                GameController gameController = new GameController();

                out.write("Giocatore: " + getNomeGiocatore() + " \tData: " + dataPartita.toLocaleString() + " \tPunteggio: " + gameController.getPunteggio()
                + " \tLivello: " + gameController.getLevelNumber());
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
        gui.setTitle("Benvenuto");
        gui.setVisible(true);
    }
}