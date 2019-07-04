package UniMolInvaders.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import java.util.logging.Logger;

import static UniMolInvaders.GUI.MenuPanel.*;


/**
 * Gestisce il pannello di fine partita
 */
public class EndPanel extends JPanel implements ActionListener {

    private static final String SAVE_BUTTON = "Salva punteggio";
    private static final String CHART_BOTTON = "Mostra classifica";
    private static final String MENU_BUTTON = "Menù";
    private static final int BUTTON_X = 200;
    private static final int POS_BUT_X = 100;
    private static final String SCORE_FILE_NAME = ".\\score.txt";
    private JButton save;
    private JButton chart;
    private JButton menu;
    private JTextField nameField;
    private int points;
    private int level;
    private String playerName;
    private Image background;
    private JLabel title;
    private ArrayList<String> scores;

    public EndPanel() {

        setSize(ContentSwitch.WIN_WIDTH, ContentSwitch.WIN_HEIGHT);
        setBackground(Color.BLACK);
        background = ContentSwitch.getMenu().getImageBackground();

        title = new JLabel(ContentSwitch.TITLE);
        title.setFont(TITLE_FONT);
        title.setForeground(Color.WHITE);
        title.setBounds(POS_TITLE_X, POS_TITLE_Y, TITLE_X, TITLE_Y);
        add(title);

        nameField = new JTextField("Inserisci il tuo nome", 100);
        nameField.setFont(GENERAL_FONT);
        nameField.setBounds(30, POS_BUT_Y, 220, BUTTON_Y);
        nameField.setForeground(Color.BLACK);
        nameField.setBackground(ORANGE_UNIMOL);
        nameField.setOpaque(true);
        nameField.setVisible(true);
        add(nameField);

        save = new JButton(SAVE_BUTTON);
        save.setBorderPainted(false);
        save.setFont(GENERAL_FONT);
        save.addActionListener(this);
        save.setForeground(Color.BLACK);
        save.setBackground(ORANGE_UNIMOL);
        save.setOpaque(true);
        save.setBounds(POS_BUT_X + 190, POS_BUT_Y, BUTTON_X, BUTTON_Y);
        save.setVisible(true);
        add(save);

        chart = new JButton(CHART_BOTTON);
        chart.setBorderPainted(false);
        chart.setFont(GENERAL_FONT);
        chart.setForeground(Color.BLACK);
        chart.addActionListener(this);
        chart.setBackground(ORANGE_UNIMOL);
        chart.setOpaque(true);
        chart.setBounds(POS_BUT_X + 430, POS_BUT_Y, BUTTON_X, BUTTON_Y);
        chart.setVisible(true);
        add(chart);

        menu = new JButton(MENU_BUTTON);
        menu.setBorderPainted(false);
        menu.setFont(GENERAL_FONT);
        menu.setForeground(Color.BLACK);
        menu.addActionListener(this);
        menu.setBackground(ORANGE_UNIMOL);
        menu.setOpaque(true);
        menu.setBounds(ContentSwitch.WIN_WIDTH - BUTTON_X - 50, POS_BUT_Y, BUTTON_X, BUTTON_Y);
        menu.setVisible(true);
        add(menu);

        nameField.setVisible(false);
        save.setVisible(false);
        chart.setVisible(false);
        menu.setVisible(false);

        setLayout(null);
    }

    protected void hidePanel() {
        nameField.setVisible(false);
        save.setVisible(false);
        chart.setVisible(false);
        menu.setVisible(false);
    }

    protected void initPanel() {
        nameField.setVisible(true);
        save.setVisible(true);
        chart.setVisible(true);
        menu.setVisible(true);
    }

    /**
     * Setta il punteggio totalizzato nella partita
     *
     * @param points punteggio totalizzato
     */
    public void setPoints(int points) {
        this.points = points;
    }

    /**
     * Setta il livello raggiunto nella partita
     * @param level livello raggiunto
     */
    public void setLevel(int level) {
        this.level = level;
    }

    public void paint(Graphics graphics) {

        super.paint(graphics);
        setBackground(Color.BLACK);

        graphics.drawImage(this.background, BACKGROUND_X, BACKGROUND_Y, Color.BLACK, null);

    }

    /**
     * Mostra la classifica
     */
    private void showChart() {

        scores = new ArrayList<>();

        try {
            Scanner inputStream = new Scanner(new File(SCORE_FILE_NAME));

            while (inputStream.hasNext()) {
                String line = inputStream.nextLine();
                scores.add(line);
                scores.add("" + "\n" + "");

            }
            inputStream.close();

        } catch (FileNotFoundException fileNotFoundEx) {
            Logger.getLogger("Errore apertura file:", fileNotFoundEx.toString());
            JOptionPane.showMessageDialog(null, "Lettura file non riuscita!");
        }

        JOptionPane.showConfirmDialog(null, scores.toString(), ContentSwitch.TITLE, JOptionPane.OK_OPTION);

    }

    /**
     * Memorizza i dati della partita (livello, punteggio e nome giocatore)
     */
    private void saveResult() {

        try {

            playerName = nameField.getText();

            PrintWriter outputFile = new PrintWriter(new FileOutputStream(SCORE_FILE_NAME, true));

            Calendar today = new GregorianCalendar(Locale.ITALY);
            Date dateGame = today.getTime();

            outputFile.write("Giocatore: " + playerName + " \tData: " + dateGame.toLocaleString()
                    + " \tPunteggio: " + points + " \tLivello: " + level + "\n\n");

            outputFile.close();

            //finestra per riepilogo dati salvati
            JOptionPane.showConfirmDialog(null, "Salvataggio effettutato con successo!"
                    + "\nNome: " + playerName + "\nPunteggio totalizzato: " + points
                    + "\nLivello raggiunto: " + level, ContentSwitch.TITLE, JOptionPane.OK_OPTION);

        } catch (IOException ioException) {
            Logger.getLogger("Errore scrittura file:", ioException.toString());
            JOptionPane.showMessageDialog(null, "Salvataggio non riuscito!");

        }
    }

    @Override
    public void actionPerformed(ActionEvent click) {

        switch (click.getActionCommand()) {
            case SAVE_BUTTON:
                saveResult();
                break;

            case CHART_BOTTON:
                showChart();
                break;

            case MENU_BUTTON:
                ContentSwitch.switchPanel(ContentSwitch.Pannelli.MENU);
                break;


        }
    }
}
