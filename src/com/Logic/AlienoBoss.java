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


public class AlienoBoss extends Alieno {

    private int vitaAlienoBoss = 15;
    private boolean isVivo;

    private int posX;
    private int posY;
    private int spostamentoY = 5;
    private int spostamentoX = 5;

//    private Image immagineBoss;
    private final int DIM_BOSS_X = 89;
    private final int DIM_BOSS_Y = 100;

    private Colpo colpo;


    public AlienoBoss() {
        // posiziona il boss sempre alle coordinate (10, 10) come pos iniziale
        setPosX(10);
        setPosY(10);
        setVitaAlienoBoss(vitaAlienoBoss);
        setVivo(true);
//        immagineBoss = new ImageIcon(this.getClass().getResource("bossAlieno.png")).getImage();
    }

    // todo inserire
    // todo inserire sparo


    @Override
    protected boolean decrementaVita(Colpo colpo) {
        //se la vita è maggiore di 1 la decrementa
        if (getVitaAlienoBoss() > 1) {
            setVitaAlienoBoss(colpo.getDanno());
        } else {
            //altrimenti lo setta come morto
            setVivo(false);
        }

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


//    public Image getImmagineBoss() {
//        return immagineBoss;
//    }


    @Override
    public void setVitaAlieno(int vitaAlieno) {
        super.setVitaAlieno(vitaAlieno);
    }


    protected void setVelocita(int livello) {
        if (livello > 1) {
            this.spostamentoX = spostamentoX * 2;
            this.spostamentoY = spostamentoY * 2;
        }
    }


    @Override
    public int getPosX() {
        return posX;
    }


    @Override
    public void setPosX(int posX) {
        this.posX = posX;
    }


    @Override
    public int getPosY() {
        return posY;
    }


    @Override
    public void setPosY(int posY) {
        this.posY = posY;
    }


    public int getVitaAlienoBoss() {
        return vitaAlienoBoss;
    }


    public void setVitaAlienoBoss(int vitaAlienoBoss) {
        this.vitaAlienoBoss -= vitaAlienoBoss;
    }


    public boolean isVivo() {
        return isVivo;
    }


    public void setVivo(boolean vivo) {
        isVivo = vivo;
    }


    public int getDimBossX() {
        return DIM_BOSS_X;
    }


    public int getDimBossY() {
        return DIM_BOSS_Y;
    }


}
