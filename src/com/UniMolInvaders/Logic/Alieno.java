package UniMolInvaders.Logic;


public class Alieno extends Nemico {

 /********************************
 *
 *   user:      angel
 *   date:      02/02/2019
 *   project:   UnimolInvaders
 *   angelus_gi / angelusgi
 *
 ********************************/


    private static final int vitaAlieno = 1;
    private static final int spostamentoY = 10;


    public Alieno(int posX, int posY, int velocita){
        super(posX, posY, velocita);
        setVita(vitaAlieno);
        setSpostamentoY(spostamentoY);
    }

}
