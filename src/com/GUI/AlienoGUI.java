//package GUI;
//
///********************************
// *
// *   user:      angel
// *   date:      04/05/2019
// *   project:   UnimolInvaders
// *   angelus_gi / angelusgi
// *
// ********************************/
//
//import Alieni;
//import com.Alieno;
//
//import javax.swing.*;
//import java.awt.*;
//import java.util.ArrayList;
//
//public class AlienoGUI extends JPanel implements Runnable {
//
//    private static int DISTANZA_ALIENI = 10;
//    private static int DIM_ALIENI = 20;
//
//    private ArrayList<Alieno> listaAlieni;
//
//    private Alieni alieni;
//
//    public AlienoGUI(Alieni alieni){
//        this.alieni = alieni;
//        listaAlieni = alieni.getListaAlieni();
//
//
//    }
//
//    @Override
//    public void run() {
//        while (true) {
//            repaint();
//        }
//    }
//
//    public void paint(Graphics graphics) {
//
//        super.paint(graphics);
//
//        graphics.setColor(Color.RED);
//
//        listaAlieni.get(0).setPosX(50);
//        listaAlieni.get(0).setPosY(50);
//
//        graphics.fillRect(listaAlieni.get(0).getPosX(), listaAlieni.get(0).getPosY(), DIM_ALIENI, DIM_ALIENI);
//
//
////        for (int riga = 0; riga < matrixAliens.length; riga++) {
////            for (int colonna = 0; colonna < matrixAliens[riga].length; colonna++) {
////
////                //CREA UN RETTANGOLO DI DIM_ALIENIxDIM_ALIENI PER OGNI ALIENO NELLA MATRICE
////                graphics.fillRect(matrixAliens[riga][colonna].getPosX(),matrixAliens[riga][colonna].getPosY(), DIM_ALIENI,DIM_ALIENI);
////            }
////
////        }
////        elemento.paint(graphics2D);
////
////        elemento.paint(graphics2D);
////
//        //stampa punteggio nel game over
//        graphics.setColor(Color.GRAY);
//        graphics.setFont(new Font("Verdana", Font.BOLD, 30));
////        graphics.drawString(String.valueOf(getPunteggio()), 10, 30);
//        graphics.drawString("PROVA STRINGA", 10, 30);
//    }
//
//
////    public void paint(Graphics2D graphics2D) {
////
////        //RENDE I BORDI DEI COMPONENTI 2D PIù SMUSSATI
////        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
////
//////        graphics2D.fillRect();
////
////    }
//
//    public Rectangle getBounds() {
//        return new Rectangle();
//    }
//
//}
