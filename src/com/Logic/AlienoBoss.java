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


public class AlienoBoss extends Nemico {

    private int vitaAlienoBoss = 15;

    private int posX;
    private int posY;
    private int spostamentoY = 5;
    private int spostamentoX = 5;

    private final int DIM_BOSS_X = 89;
    private final int DIM_BOSS_Y = 100;


    public AlienoBoss() {
        // posiziona il boss sempre alle coordinate (10, 10) come posizione iniziale
        setPosX(10);
        setPosY(10);
        setVita(vitaAlienoBoss);
        setVivo(true);
//        setVelocita(livello);
    }


    @Override
    protected boolean decrementaVita(Colpo colpo) {
        //se la vita è maggiore di 1 la decrementa
        if (getVita() > 1) {
            setVita(getVita() - 1 );
        } else {
            //altrimenti lo setta come morto
            setVivo(false);
        }

        return isVivo();
    }


    public void muovi(int posX, int posY){
        move(posX, posY, getSpostamentoX(), getSpostamentoY(), getDimBossX(), getDimBossY(), 800, 1000);
    }


    @Override
    protected void move(int posX, int posY, int spostamentoX, int spostamentoY, int xDimNemico, int yDimNemico, int larghezzaFinestra, int altezzaFinestra) {
        super.move(posX, posY, spostamentoX, spostamentoY, xDimNemico, yDimNemico, larghezzaFinestra, altezzaFinestra);
    }

    @Override
    protected void spara(Colpo colpo) {
        super.spara(colpo);
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

    public int getDimBossX() {
        return DIM_BOSS_X;
    }


    public int getDimBossY() {
        return DIM_BOSS_Y;
    }


}
