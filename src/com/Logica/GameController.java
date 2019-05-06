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


    public GameController(){


        //all'avvio prompt per il nome del personaggio
        inizializzaPersonaggio();

        //se il livello è pari alieni normali, altrimenti BOSS
        if (isPari(numLivello)){

            //se il livello è 0, inizializza punteggio, altrimenti resta invariato
            if (numLivello == 0){
                this.punteggio = 0;
            }

            Alieni alieni = new Alieni(getNumLivello());
            alieni.inizializzaAlieni(alieni.getMatrixAliens());

        } else {
            inizializzaBoss();
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



     private void inizializzaBoss(){
         AlienoBoss alienoBoss = new AlienoBoss();
         alienoBoss.setVelocita(getNumLivello());
     }

     private void inizializzaPersonaggio(){

//        finestra input nome giocatore


        Personaggio giocatore = new Personaggio();
     }

     private void memorizzaPunteggio(Personaggio giocatore){

//        this.punteggio.toString();

        //todo
        //salva punteggio giocatore con data e punteggio
     }

//    public void stampaLivello(){
//        System.out.print("Livello: " + numLivello);
//        System.out.println(" è dispari: " + isPari(numLivello));
//        if (numLivello<=5){
//            numLivello+=1;
//        } else{
//            System.exit(1);
//        }
//
//        stampaLivello();
//    }
//
//    public void stampaAlieni(){
//        for (int i = 0; i < matrixAliens.length; i++) {
//            System.out.print(i+1);
//            for (int j = 0; j < matrixAliens[i].length; j++) {
//                System.out.print(matrixAliens[i][j] + " ");
//            }
//            System.out.println();
//        }
//    }



}
