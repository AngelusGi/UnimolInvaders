package UniMolInvaders.Logic;

import UniMolInvaders.GUI.ContentSwitch;

/********************************
 *
 *   user:      angel
 *   date:      02/02/2019
 *   project:   UnimolInvaders
 *   angelus_gi / angelusgi
 *
 ********************************/


public abstract class Enemy {

    public static final int DESTRA = 1;
    public static final int SINISTRA = -1;
    private static final int DIREZIONE_COLPO = 1;

    private int posX;
    private int posY;
    private int speedX;
    private int speedY;

    private int dimX;
    private int dimY;

    public boolean alive;
    private int lifePoints;

    private Shot shot;


    public Enemy(int posX, int posY, int speed){

        setPosX(posX);
        setPosY(posY);
        setAlive(true);
        setVelocita(speed);

    }

    protected boolean decrementLife(){
        //se la lifePoints è maggiore di 1 la decrementa
        if (getLifePoints() > 1) {
            setLifePoints(getLifePoints() - 1 );
        } else {
            //altrimenti lo setta come morto
            setAlive(false);
        }

        return isAlive();
    }


    public void move(){

        //BORDO SX
        if (this.posX + getSpeedX()  < 0){
            setSpeedX( getSpeedX() * DESTRA);
//            this.posY = posY + 67;
            setSpeedY( getSpeedY() + 50);

        //BORDO DX
        } else if (this.posX + getSpeedX() > ContentSwitch.WIM_WIDTH - getDimX() - 20) {
            setSpeedX(getSpeedX() * SINISTRA);
            setSpeedY( getSpeedY() + 50);

        }

        this.posX += getSpeedX();
    }

    public void spara(){

        if (!shot.isSparato()){
            shot = new Shot(this.getPosX(), this.getPosY(), DIREZIONE_COLPO);
            shot.setSparato(true);
            shot.muovi(getPosY());
        }

    }


    public void setVelocita(int livello){

        if ((livello <= 1)){
            setSpeedX(10);
//            setSpeedY(getSpeedY() * livello);
        }
        setSpeedX(getSpeedX() * livello);
        setSpeedY(getSpeedY() * livello);
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

    public int getSpeedX() {
        return speedX;
    }

    public void setSpeedX(int speedX) {
        this.speedX = speedX;
    }

    private int getSpeedY() {
        return speedY;
    }

    protected void setSpeedY(int speedY) {
        this.speedY = speedY;
    }

    protected int getLifePoints() {
        return lifePoints;
    }

    protected void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
    }

    protected boolean isAlive() {
        return alive;
    }

    private void setAlive(boolean alive) {
        this.alive = alive;
    }

    public int getDimX() {
        return dimX;
    }

    protected void setDimX(int dimX) {
        this.dimX = dimX;
    }

    public int getDimY() {
        return dimY;
    }

    protected void setDimY(int dimY) {
        this.dimY = dimY;
    }
}
