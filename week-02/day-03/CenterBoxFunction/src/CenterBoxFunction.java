import java.util.Random;

import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class CenterBoxFunction {

    public static void mainDraw(Graphics graphics){

        Random square = new Random();

        for (int i =0; i < 3; i++){
            int sizea = square.nextInt(320)+0;
            int sizeb = square.nextInt(343)+0;
            drawSquares(graphics, sizea, sizeb, WIDTH, HEIGHT);
        }
        // create a square drawing function that takes 1 parameter:
        // the square size
        // and draws a square of that size to the center of the canvas.
        // draw 3 squares with that function.
        // avoid code duplication.



    }
    public static void drawSquares (Graphics graphics, int sizea, int sizeb, int WIDTH, int HEIGHT){
        graphics.drawRect(WIDTH/2, HEIGHT/2, sizea, sizeb);
    }

    //    Don't touch the code below
    static int WIDTH = 320;
    static int HEIGHT = 343;

    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Drawing");
        jFrame.setSize(new Dimension(WIDTH, HEIGHT));
        jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        jFrame.add(new ImagePanel());
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }
    static class ImagePanel extends JPanel{
        @Override
        protected void paintComponent(Graphics graphics) {
            super.paintComponent(graphics);
            mainDraw(graphics);

        }
    }

}