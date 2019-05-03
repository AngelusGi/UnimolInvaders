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

    private final int AlieniX = 5;
    private final int AlieniY = 3;
    
    private int levelNumber = 0;
    private int punteggio = 0;


    private Alieno[][] matrixAliens = new Alieno[AlieniX][AlieniY];


    public GameController(){


        //all'avvio prompt per il nome del personaggio
        inizializzaPersonaggio();

        if (!isDipari(levelNumber)){
            inizializzaAlieni(matrixAliens);
        } else {
            inizializzaBoss();
        }
    }

    private boolean isDipari(int levelNumber) {

        return (levelNumber % 2) != 0;
    }

    private void inizializzaAlieni(Alieno[][] matrixAliens){
        for (int i = 0; i < matrixAliens.length; i++) {
            for (int j = 0; j < matrixAliens[i].length; j++) {
                matrixAliens[i][j] = new Alieno();
            }

        }
    }

     private void inizializzaBoss(){
         AlienoBoss alienoBoss = new AlienoBoss();
     }

     private void inizializzaPersonaggio(){

//        finestra input nome giocatore

        String nome;
        Personaggio giocatore = new Personaggio(nome);
     }

     private void memorizzaPunteggio(Personaggio giocatore){
        String nomeGiocatore = giocatore.getNome();
        this.punteggio.toString();

        //todo
        //salva punteggio giocatore con data e punteggio
     }

//    public void stampaLivello(){
//        System.out.print("Livello: " + levelNumber);
//        System.out.println(" è dispari: " + isDipari(levelNumber));
//        if (levelNumber<=5){
//            levelNumber+=1;
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
