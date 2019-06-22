package UniMolInvaders.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPanel extends JPanel implements ActionListener {

    protected static final int BUTTON_Y = 40;
    protected static final int POS_BUT_X = 100;
    protected static final int POS_BUT_Y = 130;
    protected static final int BACKGROUND_X = 100;
    protected static final int BACKGROUND_Y = 170;
    protected static final int TITLE_X = 400;
    protected static final int TITLE_Y = 50;
    protected static final int POS_TITLE_X = 320;
    protected static final int POS_TITLE_Y = 20;
    protected static final Color ORANGE_UNIMOL = new Color(253, 164, 8);

    private static final String FONT = "Bauhaus 93";
    private static final int DIM_FONT_NORMAL = 18;
    private static final int BUTTON_X = 150;
    private static final String GAME = "Gioca";
    private static final String EXIT = "Esci";
    private static final String CREDITS = "Crediti";
    private static final String HELP = "Aiuto";
    protected static Font GENERAL_FONT = new Font(FONT, Font.BOLD, DIM_FONT_NORMAL);
    protected static Font TITLE_FONT = new Font(FONT, Font.BOLD, 50);
    private Image background;
    private JButton newGame;
    private JButton exit;
    private JButton credits;
    private JButton help;
    private JLabel title;

    private HelpPanel winHelp;
    private AboutPanel winAbout;


    public MenuPanel() {

        setSize(ContentSwitch.WIN_WIDTH, ContentSwitch.WIN_HEIGHT);
        setLayout(null);

        background = new ImageIcon(this.getClass().getResource("./Resources/splash.png")).getImage();

        title = new JLabel(ContentSwitch.TITLE);
        title.setFont(TITLE_FONT);
        title.setForeground(Color.WHITE);
        title.setBounds(POS_TITLE_X, POS_TITLE_Y, TITLE_X, TITLE_Y);
        add(title);

        newGame = new JButton(GAME);
        newGame.setBorderPainted(false);
        newGame.setFont(GENERAL_FONT);
        newGame.setForeground(Color.BLACK);
        newGame.setDefaultCapable(true);
        newGame.addActionListener(this);
        newGame.setBackground(ORANGE_UNIMOL);
        newGame.setOpaque(true);
        newGame.setBounds(POS_BUT_X, POS_BUT_Y, BUTTON_X, BUTTON_Y);
        add(newGame);

        exit = new JButton(EXIT);
        exit.setBorderPainted(false);
        exit.setFont(GENERAL_FONT);
        exit.setForeground(Color.BLACK);
        exit.addActionListener(this);
        exit.setBackground(ORANGE_UNIMOL);
        exit.setOpaque(true);
        exit.setBounds(POS_BUT_X + BUTTON_X + 70, POS_BUT_Y, BUTTON_X, BUTTON_Y);
        add(exit);

        credits = new JButton(CREDITS);
        credits.setBorderPainted(false);
        credits.setFont(GENERAL_FONT);
        credits.setForeground(Color.BLACK);
        credits.addActionListener(this);
        credits.setBackground(ORANGE_UNIMOL);
        credits.setOpaque(true);
        credits.setBounds(POS_BUT_X + BUTTON_X + 280, POS_BUT_Y, BUTTON_X, BUTTON_Y);
        add(credits);

        help = new JButton(HELP);
        help.setBorderPainted(false);
        help.setFont(GENERAL_FONT);
        help.setForeground(Color.BLACK);
        help.addActionListener(this);
        help.setBackground(ORANGE_UNIMOL);
        help.setOpaque(true);
        help.setBounds(POS_BUT_X + BUTTON_X + 500, POS_BUT_Y, BUTTON_X, BUTTON_Y);
        add(help);

        setVisible(true);

    }

    public static Color getButtonColor() {
        return ORANGE_UNIMOL;
    }

    public Image getImageBackground() {
        return background;
    }

    public static Font getTitleFont() {
        return TITLE_FONT;
    }

    public static Font getGeneralFont() {
        return GENERAL_FONT;
    }

    public JLabel getTitle() {
        return title;
    }


    public void paint(Graphics graphics) {

        super.paint(graphics);
        setBackground(Color.BLACK);

        graphics.drawImage(this.background, BACKGROUND_X, BACKGROUND_Y, Color.BLACK, null);

    }

    @Override
    public void actionPerformed(ActionEvent click) {

        switch (click.getActionCommand()) {
            case GAME:
                ContentSwitch.switchPanel(ContentSwitch.INTRO);
                break;

            case HELP:
                winHelp = new HelpPanel();
                break;

            case CREDITS:
                winAbout = new AboutPanel();
                break;

            case EXIT:
                System.exit(0);
                break;

        }
    }
}
