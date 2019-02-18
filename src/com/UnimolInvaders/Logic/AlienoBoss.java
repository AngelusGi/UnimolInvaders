package com.UnimolInvaders.Logic;

/********************************
 *
 *   user:      angel
 *   date:      02/02/2019
 *   project:   UnimolInvaders
 *   angelus_gi / angelusgi
 *
 ********************************/


public class AlienoBoss extends Alieno {

    private static int VITA_ALIENO_BOSS = 15;

    public AlienoBoss(){
        this(VITA_ALIENO_BOSS, ALIENO_BOSS);
    }

    private AlienoBoss(int vita, int tipo) {
        super(vita, tipo);
    }

    // todo inserire immagine
    // todo inserire sparo
}
