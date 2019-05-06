package Logica;

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

        //se il livello è pari alieni normali, altrimenti BOSS
        if (isPari(numLivello)){

            //se il livello è 0, inizializza punteggio, altrimenti resta invariato
            if (numLivello == 0){
                this.punteggio = 0;
            }

            this.alieni = new Alieni(getNumLivello());
            this.alieni.inizializzaAlieni(alieni.getMatrixAliens());

        } else {
            this.alienoBoss = inizializzaBoss();
        }
    }

    protected int getNumLivello() {
        return numLivello;
    }

    protected int getPunteggio() {
        return punteggio;
    }

    private boolean isPari(int levelNumber) {

        //se il livello è pari (0, 2,...) ritorna TRUE, altrimenti FALSE
        return levelNumber % 2 == 0;
    }

    public void setNumLivello(int incremento) {
        this.numLivello += incremento;
    }

    private void vintoPerso() {
        //todo

        //IF vinto, livello incrementato di 1
        setNumLivello(1);

        //else
        //finestra inserimento nome e salvataggio su file
    }


    private AlienoBoss inizializzaBoss() {
         AlienoBoss alienoBoss = new AlienoBoss();
         alienoBoss.setVelocita(getNumLivello());

        return alienoBoss;
     }

    private Personaggio inizializzaPersonaggio() {

//        finestra input nome giocatore


        Personaggio giocatore = new Personaggio();

        return giocatore;
     }

     private void memorizzaPunteggio(Personaggio giocatore){

//        this.punteggio.toString();

        //todo
        //salva punteggio giocatore con data e punteggio
     }

//     //testa la corretta inizializzazione dei livelli e la gestione dei livelli (pari/dispari)
//    public void stampaLivello(){
//        System.out.print("Livello: " + numLivello);
//        System.out.println(" è pari: " + isPari(numLivello));
//        if (numLivello<=5){
//            numLivello+=1;
//        } else{
//            System.exit(1);
//        }
//
//        stampaLivello();
//    }
//
//    public void stampaPersonaggi(){
//
//        this.alieni = new Alieni(getNumLivello());
//        this.alieni.inizializzaAlieni(this.alieni.getMatrixAliens());
//        Alieno[][] matrixAliens =  this.alieni.getMatrixAliens();
//
//        for (int riga = 0; riga < matrixAliens.length; riga++) {
//            System.out.print("NumRiga: \t" + riga + "\n");
//            for (int colonna = 0; colonna < matrixAliens[riga].length; colonna++) {
//                System.out.print("Alieno[" + riga + "][" + colonna + "] > " + matrixAliens[riga][colonna] + " \t ");
//            }
//            System.out.println("\n");
//        }
//
//        alienoBoss = inizializzaBoss();
//        System.out.println("\nBoss > " + alienoBoss + "\n");
//
//
//        giocatore = inizializzaPersonaggio();
//        System.out.println("giocatore > " + giocatore + "\n");
//
//    }



}
