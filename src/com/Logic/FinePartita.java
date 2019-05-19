package Logic; /********************************
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
import java.io.*;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.logging.Logger;


// public class FinePartita implements KeyListener {
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

public class FinePartita extends JFrame {

    private JLabel finePartita;
    private JTextField campoNome;
    private JButton inserisciNome;

    private String nomeGiocatore;

    public FinePartita(){

        setLayout(new FlowLayout());

        finePartita = new JLabel("Partita terminata!  Inserisci il tuo nome:");
        add(finePartita);


        campoNome = new JTextField(20);
        add(campoNome);

        inserisciNome = new JButton("Salva punteggio");
        add(inserisciNome);

        SalvaDati salvaDati = new SalvaDati();
        inserisciNome.addActionListener(salvaDati);

    }

    class SalvaDati implements ActionListener {

        private final int NUOVA_PARTITA = 0;

        @Override
        public void actionPerformed(ActionEvent e) {
            try{

                setNomeGiocatore(campoNome.getText());

                String file = ".\\score.txt";
                PrintWriter outputFile = new PrintWriter(new FileOutputStream(file, true));

                Calendar dataOdierna = new GregorianCalendar(Locale.ITALY);
                Date dataPartita = dataOdierna.getTime();

                GameController gameController = new GameController();

                outputFile.write("Giocatore: " + getNomeGiocatore() + " \tData: " + dataPartita.toLocaleString()
                        + " \tPunteggio: " + gameController.getPunteggio() + " \tLivello: " + gameController.getNumLivello() + "\n\n");

                outputFile.close();

                //finestra per riepilogo dati salvati
                JOptionPane.showMessageDialog(null, "Salvataggio effettutato con successo!"
                        + "\nIl tuo nome: " + getNomeGiocatore() + "\nPunteggio totalizzato: " + gameController.getPunteggio()
                        + "\nLivello raggiunto: " + gameController.getNumLivello());


                int risposta = JOptionPane.showConfirmDialog(null, "Vuoi giocare ancora?",
                        "UniMol Invaders", JOptionPane.YES_NO_OPTION);


                if (risposta == NUOVA_PARTITA){
                    //todo gestire nuova partita
                } else{
                    System.exit(0);
                }


            } catch (IOException ioException){
                Logger.getLogger("Errore scrittura file:", ioException.toString());
                JOptionPane.showMessageDialog(null, "Salvataggio non riuscito!");

            }
        }

    }


    public String getNomeGiocatore(){
        return nomeGiocatore;
    }


    public void setNomeGiocatore(String nomeGiocatore){
        this.nomeGiocatore = nomeGiocatore;
    }


}