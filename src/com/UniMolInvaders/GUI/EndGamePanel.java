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
    private static final int BUTTON_X = 250;

    private int points;
    private int level;

    private String playerName;
    private static final int BUTTON_Y = 40;
    private static final int POS_BUT_X = 270;
    private static final int POS_BUT_Y = 130;
    private static final int TITLE_X = 400;
    private static final int TITLE_Y = 50;
    private static final int POS_TITLE_X = 320;
    private static final int POS_TITLE_Y = 40;
    private static final String SAVE_BUTTON = "Salva punteggio";
    private JButton save;
    private Image background;
    private JLabel title;

    public EndGamePanel() {

        setSize(ContentSwitch.WIN_WIDTH, ContentSwitch.WIN_HEIGHT);
        setBackground(Color.BLACK);

        background = new ImageIcon(this.getClass().getResource("./Resources/splash.png")).getImage();

        title = new JLabel(ContentSwitch.TITLE);
        title.setFont(MenuPanel.getTitleFont());
        title.setForeground(Color.WHITE);
        title.setBounds(POS_TITLE_X, POS_TITLE_Y, TITLE_X, TITLE_Y);
        add(title);

        endGame = new JLabel("Partita terminata!  Inserisci il tuo nome:");
        endGame.setFont(MenuPanel.getGeneralFont());
        endGame.setForeground(Color.BLACK);
        endGame.setBackground(MenuPanel.getButtonColor());
        endGame.setOpaque(true);
        endGame.setBounds(POS_BUT_X, POS_BUT_Y + 100, BUTTON_X, BUTTON_Y);
        add(endGame);

        name = new JTextField(20);
        name.setFont(MenuPanel.getGeneralFont());
        name.setForeground(Color.BLACK);
        name.setBackground(MenuPanel.getButtonColor());
        name.setOpaque(true);
        name.setBounds(POS_BUT_X, POS_BUT_Y + 200, BUTTON_X, BUTTON_Y);
        name.setVisible(false);
        add(name);

        save = new JButton(SAVE_BUTTON);
        save.setBorderPainted(false);
        save.setFont(MenuPanel.getGeneralFont());
        save.setForeground(Color.BLACK);
        save.addActionListener(new SaveData());
        save.setBackground(MenuPanel.getButtonColor());
        save.setOpaque(true);
        save.setBounds(POS_BUT_X, POS_BUT_Y, BUTTON_X, BUTTON_Y);
        add(save);

        setLayout(null);
        setVisible(true);

    }


    public void paint(Graphics graphics) {
        super.paint(graphics);
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void setPoints() {
        this.points = ContentSwitch.getStats().getPoints();
    }

    public void setLevel() {
        this.level = ContentSwitch.getGame().getLevelNumber();
    }

    class SaveData implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent click) {

            if (click.getActionCommand().equals(SAVE_BUTTON)) {
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
                    JOptionPane.showInputDialog(null, "Salvataggio effettutato con successo!"
                            + "\nIl tuo TITLE: " + getPlayerName() + "\nPunteggio totalizzato: " + points
                            + "\nLivello raggiunto: " + level, ContentSwitch.TITLE, JOptionPane.OK_OPTION);
//                    JOptionPane.showConfirmDialog(null, "Salvataggio effettutato con successo!"
//                            + "\nIl tuo TITLE: " + getPlayerName() + "\nPunteggio totalizzato: " + points
//                            + "\nLivello raggiunto: " + level, ContentSwitch.TITLE, JOptionPane.OK_OPTION);

                    //todo gestire nuova partita
                    ContentSwitch.switchPanel(ContentSwitch.INTRO);
                    ContentSwitch.getGame().reset();


                } catch (IOException ioException) {
                    Logger.getLogger("Errore scrittura file:", ioException.toString());
                    JOptionPane.showMessageDialog(null, "Salvataggio non riuscito!");

                }
            }

        }

    }

}
