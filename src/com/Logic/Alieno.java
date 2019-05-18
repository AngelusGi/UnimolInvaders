package Logic;

import javax.swing.*;
import java.awt.*;

/********************************
 *
 *   user:      angel
 *   date:      02/02/2019
 *   project:   UnimolInvaders
 *   angelus_gi / angelusgi
 *
 ********************************/


public class Alieno extends Nemico {


    private static final int DIM_ALIENO_X = 37;
    private static final int DIM_ALIENO_Y = 50;
    private static final int DISTANZA_ALIENI = 20;
    private static final int POS_X_INIZIALE_ALIENO = 10;
    private static final int POS_Y_INIZIALE_ALIENO = 10;
    private static final int POS_Y_INIZIALE_ALIENO_SECONDA_RIGA = POS_Y_INIZIALE_ALIENO + DIM_ALIENO_Y + DISTANZA_ALIENI;

    private boolean isVivo;
    private int vitaAlieno;

    private int posX;
    private int posY;
    private int spostamentoY = 2;
    private int spostamentoX = 2;

    private Image immagineAlieno;
    private Colpo colpo;


    public Alieno() {
        inizializzazionePredefinita();
    }


    public Alieno(Alieno alienoPrecedente, int index) {
        inizializzazionePredefinita();
        posizionaAlieno(alienoPrecedente, index);
    }

    public static int getDimAlienoX() {
        return DIM_ALIENO_X;
    }

    public Image getImmagineAlieno() {
        return immagineAlieno;
    }

    public static int getDimAlienoY() {
        return DIM_ALIENO_Y;
    }

    public static int getPosXInizialeAlieno() {
        return POS_X_INIZIALE_ALIENO;
    }

    public static int getPosYInizialeAlieno() {
        return POS_Y_INIZIALE_ALIENO;
    }

    public static int getPosYInizialeAlienoSecondaRiga() {
        return POS_Y_INIZIALE_ALIENO_SECONDA_RIGA;
    }

    public Alieno(int index) {
        inizializzazionePredefinita();
        posizionaAlieno(index);
    }


    public void posizionaAlieno(int index) {
        //riempimento primo elemento
        this.setPosX(POS_X_INIZIALE_ALIENO);
        this.setPosY(POS_Y_INIZIALE_ALIENO);

    }


    private void inizializzazionePredefinita() {
        //operazione fatta da tutti i costruttori (costruttore di base)
        setVitaAlieno(1);
        setVivo(true);
        immagineAlieno = new ImageIcon(this.getClass().getResource("alieno.png"), "alieno").getImage();
    }


    public void posizionaAlieno(Alieno alienoPrecedente, int index) {

        //riempimeto prima riga
        if (index < Alieni.getNumAlieni()/2) {
            this.setPosX(alienoPrecedente.getPosX() + DIM_ALIENO_X + DISTANZA_ALIENI);
            this.setPosY(alienoPrecedente.getPosY());

            //primo alieno seconda riga (stessa X alieno della lista superiore)
        } else if (index == Alieni.getNumAlieni()/2) {
            this.setPosX(POS_X_INIZIALE_ALIENO);
            this.setPosY(POS_Y_INIZIALE_ALIENO_SECONDA_RIGA);

            //tutti gli altri alieni della seconda riga
        } else {
            this.setPosX(alienoPrecedente.getPosX() + DIM_ALIENO_X + DISTANZA_ALIENI);
            this.setPosY(alienoPrecedente.getPosY());
        }
    }


    public void disegnaAlieno(Graphics graphics) {
        if (isVivo()) {
            graphics.drawImage(immagineAlieno, getPosX(), getPosY(), DIM_ALIENO_X, DIM_ALIENO_Y, null);
        }
    }

    // todo inserire immagine
    // todo inserire sparo


    @Override
    protected boolean decrementaVita(Colpo colpo) {
        //ammazza il singolo alieno
        setVivo(false);

        return isVivo();
    }


    @Override
    protected void move(int posX, int posY, int spostamentoX, int spostamentoY) {
        super.move(posX, posY, spostamentoX, spostamentoY);
    }


    @Override
    protected void moveDown(int posX, int posY) {
        this.posY = posY + spostamentoY;
    }


    public int getPosX() {
        return posX;
    }


    public void setPosX(int posX) {
        this.posX = posX;
    }


    public int getPosY() {
        return posY;
    }


    public void setPosY(int posY) {
        this.posY = posY;
    }


    public void setVitaAlieno(int vitaAlieno) {
        this.vitaAlieno = vitaAlieno;
    }


    public boolean isVivo() {
        return isVivo;
    }


    public void setVivo(boolean vivo) {
        isVivo = vivo;
    }


    @Override
    protected void setVelocita(int livello) {
        if (livello > 0) {
            this.spostamentoX = spostamentoX * 2;
            this.spostamentoY = spostamentoY * 2;
        }
    }


}
