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

public class EndGamePanel extends JPanel {


    private JLabel endGame;
    private JTextField name;
    private JButton insertName;

    private int points;
    private int level;

    private String playerName;


    public EndGamePanel(int points, int level) {

        this.points = points;
        this.level = level;

        setSize(300, 150);

        endGame = new JLabel("Partita terminata!  Inserisci il tuo TITLE:");
        add(endGame);

        name = new JTextField(20);
        add(name);

        insertName = new JButton("Salva punteggio");
        add(insertName);

        saveDate saveDate = new saveDate();
        insertName.addActionListener(saveDate);

        setLayout(null);
//        setLayout(new FlowLayout());
        setVisible(true);


    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    class saveDate implements ActionListener {

        private final int NEW_GAME = 0;

        @Override
        public void actionPerformed(ActionEvent e) {
            try {

                setPlayerName(name.getText());

                String hightScore = ".\\score.txt";
                PrintWriter outputFile = new PrintWriter(new FileOutputStream(hightScore, true));

                Calendar today = new GregorianCalendar(Locale.ITALY);
                Date dateGame = today.getTime();

                outputFile.write("Giocatore: " + getPlayerName() + " \tData: " + dateGame.toLocaleString()
                        + " \tPunteggio: " + points + " \tLivello: " + level + "\n\n");

                outputFile.close();

                //finestra per riepilogo dati salvati
                JOptionPane.showMessageDialog(null, "Salvataggio effettutato con successo!"
                        + "\nIl tuo TITLE: " + getPlayerName() + "\nPunteggio totalizzato: " + points
                        + "\nLivello raggiunto: " + level);


                int response = JOptionPane.showConfirmDialog(null, "Vuoi giocare ancora?",
                        "UniMol Invaders", JOptionPane.YES_NO_OPTION);


                if (response == NEW_GAME) {
                    //todo gestire nuova partita
                    ContentSwitch.switchPanel(ContentSwitch.INTRO);
                    ContentSwitch.getGame().resetPartita();

                } else {
                    ContentSwitch.switchPanel(ContentSwitch.MENU);
//                    System.exit(0);
                }


            } catch (IOException ioException) {
                Logger.getLogger("Errore scrittura file:", ioException.toString());
                JOptionPane.showMessageDialog(null, "Salvataggio non riuscito!");

            }
        }

    }

}
