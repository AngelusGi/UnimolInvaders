package com.UnimolInvaders.Logic;

/********************************
 *
 *   user:      angel
 *   date:      02/02/2019
 *   project:   UnimolInvaders
 *   angelus_gi / angelusgi
 *
 ********************************/


public class Alieno extends Nemico {

    private static int VITA_ALIENO_NORMALE = 1;

    public Alieno(){
        this(VITA_ALIENO_NORMALE, ALIENO_NORMALE);
    }

    protected Alieno(int vita, int tipo) {
        super(vita, tipo);

    }


    // todo inserire immagine
    // todo inserire sparo

}
