package UniMolInvaders.Logic;

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
    private int spostamentoY = 30;

    public AlienoBoss(int posX, int posY, int livello) {
        super(posX, posY, livello);
        setVita(vitaAlienoBoss);
        setSpostamentoY(spostamentoY);

    }


}
