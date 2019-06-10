package UniMolInvaders.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.logging.Logger;

public class FinePartitaGUI  extends JPanel {


    private JLabel finePartita;
    private JTextField campoNome;
    private JButton inserisciNome;

    private int numPunti;
    private int livello;

    private String nomeGiocatore;


    public FinePartitaGUI(int numPunti, int livello){

        this.numPunti = numPunti;
        this.livello = livello;

        setSize(300,150);

        finePartita = new JLabel("Partita terminata!  Inserisci il tuo NOME_GIOCO:");
        add(finePartita);

        campoNome = new JTextField(20);
        add(campoNome);

        inserisciNome = new JButton("Salva punteggio");
        add(inserisciNome);

        SalvaDati salvaDati = new SalvaDati();
        inserisciNome.addActionListener(salvaDati);

        setLayout(null);
//        setLayout(new FlowLayout());
        setVisible(true);

    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
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

//                GameController gameController = new GameController();

                outputFile.write("Giocatore: " + getNomeGiocatore() + " \tData: " + dataPartita.toLocaleString()
                        + " \tPunteggio: " + numPunti + " \tLivello: " + livello + "\n\n");

                outputFile.close();

                //finestra per riepilogo dati salvati
                JOptionPane.showMessageDialog(null, "Salvataggio effettutato con successo!"
                        + "\nIl tuo NOME_GIOCO: " + getNomeGiocatore() + "\nPunteggio totalizzato: " + numPunti
                        + "\nLivello raggiunto: " + livello);


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
