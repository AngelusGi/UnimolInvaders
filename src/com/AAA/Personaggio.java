package AAA;

import java.awt.*;

abstract class Personaggio {

    int posX;
    int posY;
    int velocita;
    int dimX;
    int dimY;
    long ultimoColpo;
    Colpo colpo;
    boolean visibile;

    private int vite;

    Personaggio(int posX, int posY, int velocita, int dimX, int dimY) {

        this.posX = posX;
        this.posY = posY;

        this.velocita = velocita;

        this.vite = 3;
        this.dimX = dimX;
        this.dimY = dimY;
        visibile = true;
    }

    public boolean isVisibile() {
        return visibile;
    }

    public void setVisibile(boolean visibile) {
        this.visibile = visibile;
    }

    public void tryToFire(boolean direction) {

        if (System.currentTimeMillis() - ultimoColpo > (long) 30000) {

            // if we waited long enough, create the shot entity, and record the time.
            ultimoColpo = System.currentTimeMillis();
            getColpo(direction);
        } else {
            return;
        }
    }

    public Colpo getColpo(boolean direction) {
        return colpo = new Colpo(this.posX, this.posY, direction);
    }

    public Rectangle getBounds() {
        return new Rectangle(posX, posY, dimX, dimY);
    }

    public boolean colpito(Colpo colpo) {
        return getBounds().getBounds().intersects(colpo.getBounds().getBounds());
    }
}
