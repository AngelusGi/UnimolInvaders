package Logica;

/********************************
 *
 *   user:      angel
 *   date:      02/02/2019
 *   project:   UnimolInvaders
 *   angelus_gi / angelusgi
 *
 ********************************/


public abstract class Personaggio {

    private final static int RIGHT = 1;
    private final static int LEFT = -1;

    private int vita;

    private int posX;
    private int posY;

    private String nome;

    boolean isVivo;
    boolean hasFired;

    public Personaggio(String nome) {
        this.vita = 10;
        this.nome = nome;
        isVivo = true;
        hasFired = false;
    }

    protected void moveLeft(int posX, int posY){
        this.posX = posX + LEFT;
    }

    protected void moveRight(int posX, int posY){
        this.posX = posX + RIGHT;
    }

    public int getPosX() {
        return posX;
    }

    public String getNome() {
        return nome;
    }

    public int getPosY() {
        return posY;
    }

    protected void shot(int posX, int posY){

    }


}
