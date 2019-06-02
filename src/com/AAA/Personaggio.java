package AAA;

public abstract class Personaggio {

    int posX;
    int posY;
    int velocita;

    int vite;

    public Personaggio(int posX, int posY, int velocita){

        this.posX = posX;
        this.posY = posY;

        this.velocita = velocita;

        this.vite = 3;
    }
}
