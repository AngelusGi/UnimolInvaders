package Logic;

import java.util.ArrayList;

/********************************
 *
 *   user:      angel
 *   date:      02/02/2019
 *   project:   UnimolInvaders
 *   angelus_gi / angelusgi
 *
 ********************************/



public class GameController {
    
    private int numLivello = 0;
    private int punteggio;

    private Alieni alieni;
    private AlienoBoss alienoBoss;
    private Personaggio giocatore;


    public GameController(){

        //all'avvio prompt per il nome del personaggio
        this.giocatore = inizializzaPersonaggio();

        //se il livello è pari (0, 2,...) alieni normali, altrimenti BOSS
        if (isPari(numLivello)){

            //se il livello è 0, inizializza punteggio, altrimenti resta invariato
            if (numLivello == 0){
                this.punteggio = 0;
            }

            this.alieni = new Alieni(getNumLivello());
            this.alieni.inizializzaAlieni(alieni.getListaAlieni());

        } else {
            this.alienoBoss = inizializzaBoss();
        }
    }


    private void vintoPerso() {
        //todo

        //IF vinto, livello incrementato di 1
        setNumLivello(1);

        //else
        //todo finestra inserimento nome e salvataggio su file
        memorizzaPunteggio(giocatore);
    }


    private AlienoBoss inizializzaBoss() {
         AlienoBoss alienoBoss = new AlienoBoss();
         alienoBoss.setVelocita(getNumLivello());

        return alienoBoss;
     }

    private Personaggio inizializzaPersonaggio() {

//        todo
        Personaggio giocatore = new Personaggio();

        return giocatore;
     }

    private boolean isPari(int levelNumber) {
        //se il livello è pari (0, 2,...) ritorna TRUE, altrimenti FALSE
        return levelNumber % 2 == 0;
    }


    private void memorizzaPunteggio(Personaggio giocatore) {

//        this.punteggio.toString();

        //todo
        //salva punteggio giocatore con data e punteggio
     }



    protected int getNumLivello() {
        return numLivello;
    }


    public void setNumLivello(int incremento) {
        this.numLivello += incremento;
    }


    protected int getPunteggio() {
        return punteggio;
    }


//    //testa la corretta inizializzazione dei livelli e la gestione dei livelli (pari/dispari)
//    public void stampaLivello() {
//        System.out.print("Livello: " + numLivello);
//        System.out.println(" è pari: " + isPari(numLivello));
//        if (numLivello <= 5) {
//            numLivello += 1;
//        } else {
//            System.exit(1);
//        }
//
//        stampaLivello();
//    }
//
//    public void stampaPersonaggi() {
//
//        this.alieni = new Alieni(getNumLivello());
//        this.alieni.inizializzaAlieni(this.alieni.getListaAlieni());
//        ArrayList<Alieno> listaAlieni = this.alieni.getListaAlieni();
//
//        for (int num = 0; num < listaAlieni.size(); num++) {
//            System.out.print("Alieno[" + num + "] > " + listaAlieni.get(num) + " \t ");
//            System.out.println("\n");
//        }
//
//        alienoBoss = inizializzaBoss();
//        System.out.println("\nBoss > " + alienoBoss + "\n");
//
//        giocatore = inizializzaPersonaggio();
//        System.out.println("giocatore > " + giocatore + "\n");
//
//    }


}
