package UniMolInvaders.AAA;

abstract class Personaggio {

    int posX;
    int posY;
    int velocita;

    private int vite;

    Personaggio(int posX, int posY, int velocita) {

        this.posX = posX;
        this.posY = posY;

        this.velocita = velocita;

        this.vite = 3;
    }
}
