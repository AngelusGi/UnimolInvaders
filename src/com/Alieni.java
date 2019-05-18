import java.util.ArrayList;

/********************************
 *
 *   user:      angel
 *   date:      06/05/2019
 *   project:   UnimolInvaders
 *   angelus_gi / angelusgi
 *
 ********************************/

public class Alieni extends Alieno {

    private int numAlieni = 8;
    private int numAlieniY = 4;
    private int numAlieniX = 4;
    private int livello;

    private Alieno alieno;
    private ArrayList<Alieno> listaAlieni;


    public Alieni(int livello) {

        listaAlieni = new ArrayList<>();
        inizializzaAlieni(listaAlieni);

        setLivello(livello);

    }


    protected void inizializzaAlieni(ArrayList<Alieno> listaAlieni) {

        alieno = new Alieno(0);
        alieno.setVelocita(getLivello());
        listaAlieni.add(0, alieno);

        for (int attuale = 1; attuale < numAlieni; attuale++) {
            int alienoPrecedente = attuale - 1;

            alieno = new Alieno(listaAlieni.get(alienoPrecedente), attuale);
            alieno.setVelocita(getLivello());
            listaAlieni.add(attuale, alieno);
        }

    }


    public ArrayList<Alieno> getListaAlieni() {
        return listaAlieni;
    }

    public int getLivello() {
        return livello;
    }

    public void setLivello(int livello) {
        this.livello = livello;
    }


}
