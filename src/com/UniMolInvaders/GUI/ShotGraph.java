package UniMolInvaders.GUI;

import java.awt.*;

public class ShotGraph {

    public static final int ENEMY_DIRECTION = 1;
    protected static final int PLAYER_DIRECTION = -1;
    protected static final int DAMAGE = 1;
    private static final int DIM_X = 11;
    private static final int DIM_Y = 29;
    protected Rectangle area;
    private Image image;
    private boolean shooted;
    private int speed = 20;
    private int posX;
    private int posY;

    public ShotGraph(int posX, int posY, int direction) {
        setShooted(false);
        setPosX(posX);
        setPosY(posY);
        setSpeed(direction);
    }

    public void paint(Graphics2D graphics) {

//        Color trasparent = new Color(1f, 0f, 0f, 0f);
//        graphics.setColor(trasparent);

        graphics.setColor(Color.YELLOW);
        graphics.fillRect(this.getPosX(), this.getPosY(), this.getDimX(), this.getDimY());

//        graphics.drawImage(this.image, this.getPosX(), this.getPosY(), trasparent, null);
    }

    public void run() {
        move(getPosY());

    }

    protected int getDimX() {
        return DIM_X;
    }

    protected int getDimY() {
        return DIM_Y;
    }


    public void setSpeed(int direction) {
        this.speed *= direction;
    }

    protected void move(int posY) {

        setPosY(getPosY() + speed);

    }


    public int getPosX() {
        return posX;
    }


    private void setPosX(int posX) {
        this.posX = posX;
    }


    public int getPosY() {
        return posY;
    }


    private void setPosY(int posY) {
        this.posY = posY;
    }


    public boolean isShooted() {
        return !shooted;
    }


    public void setShooted(boolean shootState) {
        this.shooted = shootState;
    }

    public Rectangle getArea() {
        area = new Rectangle(posX, posX, DIM_X, DIM_Y); //7,15

        return area;
    }
}