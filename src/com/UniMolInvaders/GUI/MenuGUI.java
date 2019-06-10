package UniMolInvaders.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuGUI extends JPanel implements ActionListener {



        private static final int DIM_PULSANTE_X = 100;
        private static final int DIM_PULSANTE_Y = 40;
        private static final int POS_PULSANTE_Y = 130;

        private static final int POS_SFONDO_X = 100;
        private static final int POS_SFONDO_Y = 170;

        private static final int POS_TITOLO_X = 320;
        private static final int POS_TITOLO_Y = 40;
        private static final int DIM_TITOLO_X = 400;
        private static final int DIM_TITOLO_Y = 50;


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

        static final String CARATTERE = "Bauhaus 93";
        static final int DIM_CARATTERE = 18;

        private static final String GIOCA = "Gioca";
        private static final String ESCI = "Esci";
        private static final String CREDITI = "Crediti";
        private static final String ISTRUZIONI = "Aiuto";

        private static final Color ARACIO = new Color(253,164,8);

        private static final int TEMPO_PAUSA_ANIMAZIONE = 5000;
        private static Font FONT_GIOCO = new Font(CARATTERE, Font.BOLD, DIM_CARATTERE);


        public MenuGUI(JFrame finestra){

            this.finestra = finestra;

            setLayout(null);
            setSize(this.finestra.getWidth(), this.finestra.getHeight());

            sfondo = new ImageIcon(this.getClass().getResource("./Resources/splash.png")).getImage();

            titolo = new JLabel(Start.NOME_GIOCO);
            titolo.setFont(new Font (CARATTERE, Font.BOLD, 50));
            titolo.setForeground(Color.WHITE);
            titolo.setBounds(POS_TITOLO_X, POS_TITOLO_Y, DIM_TITOLO_X, DIM_TITOLO_Y);
            add(titolo);

            nuovaPartita = new JButton(GIOCA);
            nuovaPartita.setBorderPainted(false);
            nuovaPartita.setFont(FONT_GIOCO);
            nuovaPartita.setForeground(Color.BLACK);
            nuovaPartita.setDefaultCapable(true);
            nuovaPartita.addActionListener(this);
            nuovaPartita.setBackground(ARACIO);
            nuovaPartita.setOpaque(true);
            nuovaPartita.setBounds(270, POS_PULSANTE_Y, DIM_PULSANTE_X, DIM_PULSANTE_Y);
            add(nuovaPartita);

            esci = new JButton(ESCI);
            esci.setBorderPainted(false);
            esci.setFont(FONT_GIOCO);
            esci.setForeground(Color.BLACK);
            esci.addActionListener(this);
            esci.setBackground(ARACIO);
            esci.setOpaque(true);
            esci.setBounds(270+DIM_PULSANTE_X+30, POS_PULSANTE_Y, DIM_PULSANTE_X, DIM_PULSANTE_Y);
            add(esci);

            crediti = new JButton(CREDITI);
            crediti.setBorderPainted(false);
            crediti.setFont(FONT_GIOCO);
            crediti.setForeground(Color.BLACK);
            crediti.addActionListener(this);
            crediti.setBackground(ARACIO);
            crediti.setOpaque(true);
            crediti.setBounds(270+DIM_PULSANTE_X+160, POS_PULSANTE_Y, DIM_PULSANTE_X, DIM_PULSANTE_Y);
            add(crediti);

            istruzioni = new JButton(ISTRUZIONI);
            istruzioni.setBorderPainted(false);
            istruzioni.setFont(FONT_GIOCO);
            istruzioni.setForeground(Color.BLACK);
            istruzioni.addActionListener(this);
            istruzioni.setBackground(ARACIO);
            istruzioni.setOpaque(true);
            istruzioni.setBounds(270+DIM_PULSANTE_X+290, POS_PULSANTE_Y, DIM_PULSANTE_X, DIM_PULSANTE_Y);
            add(istruzioni);

            setVisible(true);

        }


        @Override
        public void paint(Graphics graphics) {

            super.paint(graphics);
            setBackground(Color.BLACK);

            graphics.drawImage(this.sfondo, POS_SFONDO_X,POS_SFONDO_Y, Color.BLACK, null);

        }

        @Override
        public void actionPerformed(ActionEvent e) {

            switch (e.getActionCommand()){
                case GIOCA:
                    this.finestra.remove(this);
                    this.finestra.dispose();
                    finIntro = new IntroGUI(TEMPO_PAUSA_ANIMAZIONE, finestra);
                    finIntro.setVisible(true);
//                    finestra.add(finIntro);
//                    finestra.setVisible(true);
                    break;

                case ISTRUZIONI:
                    finIstruzioni = new IstruzioniGUI();
                    break;

                case CREDITI:
                    finCrediti = new CreditiGUI();
                    break;

                case ESCI:
                    System.exit(0);
                    break;

            }
        }

    public static Font getFontGioco() {
        return FONT_GIOCO;
    }
}
