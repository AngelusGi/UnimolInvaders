package Logica;

public class Colpo {

    private boolean sparato;
    private int danno;

    private int posX;
    private int posY;

    public Colpo(int posX, int posY) {
        setSparato(false);
        setDanno(1);
        setPosX(posX);
        setPosY(posY);
    }

    public int getPosX() {
        return posX;
    }

    private void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    private void setPosY(int posY) {
        this.posY = posY;
    }

    public boolean isSparato() {
        return sparato;
    }

    public void setSparato(boolean sparato) {
        this.sparato = sparato;
    }

    public int getDanno() {
        return danno;
    }

    private void setDanno(int danno) {
        this.danno = danno;
    }

    protected void spara(int posX, int posY, boolean hasFired) {
//        //quando spara ritorna un booleano per sparare un solo colpo per volta

        if (hasFired) {


        } else {
            setHasFired(true);
            colpo = new Colpo(getPosX(), getPosY());
//            todo colpo.muovi();
        }

    }

}
