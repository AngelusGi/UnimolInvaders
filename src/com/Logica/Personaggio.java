package Logica;

/********************************
 *
 *   user:      angel
 *   date:      02/02/2019
 *   project:   UnimolInvaders
 *   angelus_gi / angelusgi
 *
 ********************************/


public class Personaggio {

    private final static int DESTRA = 1;
    private final static int SINISTRA = -1;

    private int vita;

    private int posX;
    private int posY;

    boolean isVivo;
    boolean hasFired;

    private Colpo colpo;

    public Personaggio() {
        setVita(10);
        setVivo(true);
        setHasFired(false);
        setPosX(350);
        setPosY(700);
    }


    public boolean isVivo() {
        return isVivo;
    }


    public void setVivo(boolean vivo) {
        isVivo = vivo;
    }


    public boolean isHasFired() {
        return hasFired;
    }


    public void setHasFired(boolean hasFired) {
        this.hasFired = hasFired;
    }


    protected void moveLeft(int posX, int posY){
        this.posX = posX + SINISTRA;
    }


    protected void moveRight(int posX, int posY){
        this.posX = posX + DESTRA;
    }


    public int getPosX() {
        return posX;
    }


    public int getPosY() {
        return posY;
    }


    public void setVita(int vita) {
        this.vita = vita;
    }


    public void setPosX(int posX) {
        this.posX = posX;
    }


    public void setPosY(int posY) {
        this.posY = posY;
    }


}
