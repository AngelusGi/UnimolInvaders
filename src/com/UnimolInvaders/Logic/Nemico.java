package com.UnimolInvaders.Logic;

/********************************
 *
 *   user:      angel
 *   date:      02/02/2019
 *   project:   UnimolInvaders
 *   angelus_gi / angelusgi
 *
 ********************************/


public abstract class Nemico extends Personaggio {

    protected static final int ALIENO_BOSS = 1;
    protected static final int ALIENO_NORMALE = 0;

    private int tipo;

    public Nemico(int vita, int tipo) {
        super(vita);
        this.tipo = tipo;
    }



    protected void moveDown(int posX, int posY){

    }

}
