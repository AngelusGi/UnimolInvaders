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

    private int spostamentoY = 2;
    private int spostamentoX = 2;


    public Alieno() {
        inizializzazionePredefinita();
    }


    public Alieno(Alieno alienoPrecedente, int index) {
        inizializzazionePredefinita();
        posizionaAlieno(alienoPrecedente, index);
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
        setVita(1);
        setVivo(true);
        setSpostamentoX(spostamentoX);
        setSpostamentoY(spostamentoY);

//        immagineAlieno = new ImageIcon(this.getClass().getResource("alieno.png")).getImage();
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


    @Override
    protected boolean decrementaVita(Colpo colpo) {
        //ammazza il singolo alieno
        setVivo(false);
        return isVivo();
    }


    public void muovi(int posX, int posY){
        move(getPosX(), getPosY(), getSpostamentoX(), getSpostamentoY(), DIM_ALIENO_X, DIM_ALIENO_Y, 800, 1000);
    }

    @Override
    protected void spara(Colpo colpo) {
        super.spara(colpo);
    }

    @Override
    protected void move(int posX, int posY, int spostamentoX, int spostamentoY, int xDimNemico, int yDimNemico, int larghezzaFinestra, int altezzaFinestra) {
        super.move(posX, posY, spostamentoX, spostamentoY, xDimNemico, yDimNemico, larghezzaFinestra, altezzaFinestra);
    }

    @Override
    protected void moveDown(int posX, int posY, int spostamentoX, int spostamentoY, int larghezzaFinestra) {
        super.moveDown(posX, posY, spostamentoX, spostamentoY, larghezzaFinestra);
    }

    @Override
    protected void setVelocita(int livello) {
        super.setVelocita(livello);
    }

    @Override
    public int getPosX() {
        return super.getPosX();
    }

    @Override
    public void setPosX(int posX) {
        super.setPosX(posX);
    }

    @Override
    public int getPosY() {
        return super.getPosY();
    }

    @Override
    public void setPosY(int posY) {
        super.setPosY(posY);
    }

    @Override
    public int getSpostamentoX() {
        return super.getSpostamentoX();
    }

    @Override
    public void setSpostamentoX(int spostamentoX) {
        super.setSpostamentoX(spostamentoX);
    }

    @Override
    public int getSpostamentoY() {
        return super.getSpostamentoY();
    }

    @Override
    public void setSpostamentoY(int spostamentoY) {
        super.setSpostamentoY(spostamentoY);
    }

    @Override
    public int getVita() {
        return super.getVita();
    }

    @Override
    public void setVita(int vita) {
        super.setVita(vita);
    }

    @Override
    public boolean isVivo() {
        return super.isVivo();
    }

    @Override
    public void setVivo(boolean vivo) {
        super.setVivo(vivo);
    }


    public static int getDimAlienoX() {
        return DIM_ALIENO_X;
    }

    public static int getDimAlienoY() {
        return DIM_ALIENO_Y;
    }

    public static int getDistanzaAlieni() {
        return DISTANZA_ALIENI;
    }
}
