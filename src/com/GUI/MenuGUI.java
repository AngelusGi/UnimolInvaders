package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuGUI extends JPanel implements ActionListener {

    private final int DIM_PULSANTE_X = 100;
    private final int DIM_PULSANTE_Y = 40;

    private Image sfondo;
    private JButton nuovaPartita;
    private JButton esci;
    private JButton crediti;
    private JButton istruzioni;
    private JLabel titolo;

    private IstruzioniGUI finIstruzioni;
    private CreditiGUI finCrediti;
    private IntroGUI finIntro;

    private JFrame finestra;

    private final String bottoneNuovaPartita = "Gioca";
    private final String bottoneEsci = "Esci";
    private final String bottoneCrediti = "Crediti";
    private final String bottoneIstruzioni = "Istruzioni";

    private final int tempoPausaAnimazione = 5000;


    public MenuGUI(JFrame finestra){

        this.finestra = finestra;

        setLayout(null);
        setSize(this.finestra.getWidth(), this.finestra.getHeight());

        sfondo = new ImageIcon(this.getClass().getResource("splash.png")).getImage();

        titolo = new JLabel("UniMol Invaders");
        titolo.setFont(new Font ("Segoe UI Light", Font.BOLD, 50));
        titolo.setForeground(Color.WHITE);
        titolo.setBounds(320, 20, 400, 50);
        add(titolo);

        nuovaPartita = new JButton(bottoneNuovaPartita);
        nuovaPartita.setBorderPainted(false);
        nuovaPartita.setDefaultCapable(true);
        nuovaPartita.addActionListener(this);
        nuovaPartita.setBounds(270, 100, DIM_PULSANTE_X, DIM_PULSANTE_Y);
        add(nuovaPartita);

        esci = new JButton(bottoneEsci);
        esci.setBorderPainted(false);
        esci.addActionListener(this);
        esci.setBounds(270+DIM_PULSANTE_X+30, 100, DIM_PULSANTE_X, DIM_PULSANTE_Y);
        add(esci);

        crediti = new JButton(bottoneCrediti);
        crediti.setBorderPainted(false);
        crediti.addActionListener(this);
        crediti.setBounds(270+DIM_PULSANTE_X+160, 100, DIM_PULSANTE_X, DIM_PULSANTE_Y);
        add(crediti);

        istruzioni = new JButton(bottoneIstruzioni);
        istruzioni.setBorderPainted(false);
        istruzioni.addActionListener(this);
        istruzioni.setBounds(270+DIM_PULSANTE_X+290, 100, DIM_PULSANTE_X, DIM_PULSANTE_Y);
        add(istruzioni);

        setVisible(true);

    }


    @Override
    public void paint(Graphics graphics) {

        super.paint(graphics);
        setBackground(Color.BLACK);

        graphics.drawImage(this.sfondo, 100,170 , Color.BLACK, null);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        switch (e.getActionCommand()){
            case bottoneEsci:
                System.exit(0);
                break;

            case bottoneNuovaPartita:
                this.finestra.remove(this);
                this.finestra.dispose();
                finIntro = new IntroGUI(tempoPausaAnimazione, finestra);
                finestra.add(finIntro);
                finestra.setVisible(true);
                break;

            case bottoneIstruzioni:
                finIstruzioni = new IstruzioniGUI();
                break;

            case bottoneCrediti:
                finCrediti = new CreditiGUI();
                break;

        }
    }

}
