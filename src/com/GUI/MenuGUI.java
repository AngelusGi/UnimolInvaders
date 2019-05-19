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

    private final String bottoneNuovaPartita = "Gioca";
    private final String bottoneEsci = "Esci";
    private final String bottoneCrediti = "Crediti";
    private final String bottoneIstruzioni = "Istruzioni";


    public MenuGUI(int dimX, int dimY){

        setLayout(null);
        setSize(dimX,dimY);

        sfondo = new ImageIcon(this.getClass().getResource("menu2.png")).getImage();

        titolo = new JLabel("UniMol Invaders");
        titolo.setFont(new Font ("Segoe UI Light", 1, 50));
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
        setBackground(Color.BLUE);

        graphics.drawImage(this.sfondo, 100,170 , Color.BLUE, null);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(bottoneEsci)){
            System.exit(0);
        } else if (e.getActionCommand().equals(bottoneNuovaPartita)){

            //todo switch panel
//            finIntro = new IntroGUI();
        } else if (e.getActionCommand().equals(bottoneIstruzioni)){
            finIstruzioni = new IstruzioniGUI();
        } else if (e.getActionCommand().equals(bottoneCrediti)){
            finCrediti = new CreditiGUI();
        }
    }

}
