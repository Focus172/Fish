import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.jetbrains.annotations.NotNull;
import java.awt.image.AffineTransformOp;

public class Screen extends JPanel implements ActionListener, KeyListener {

    // controlling the frame rate
    public static final int DELAY = 25;
    public static final int FPS = 1000 / DELAY;

    // controls the size of the board
    public static final int MAX_X = 1280;
    public static final int MAX_Y = 720;

    // suppress serialization warning
    private static final long serialVersionUID = 490905409104883233L;

    // runs the main game timer
    private Timer timer;

    private boolean onMenu = true;

    public Screen() {
        // set the game board size
        setPreferredSize(new Dimension(MAX_X, MAX_Y));
        // set the game board background color
        setBackground(new Color(20, 150, 200, 30));

        // initialize the game state
        // player = new Player();

        // this timer will call the actionPerformed() method every DELAY ms
        // somehow this references actionPerformed()
        timer = new Timer(DELAY, this);
        timer.start();



    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // this method is called by the timer every DELAY ms.
        // use this space to update the state of your game or animation
        // before the graphics are redrawn.

        if (onMenu) {
            //gaming
            //set variables
            repaint(); // has special case for onMenu
        } else {
            tickAll();
            repaint(); //see paintComponent()
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // when calling g.drawImage() we can use "this" for the ImageObserver 
        // because Component implements the ImageObserver interface, and JPanel 
        // extends from Component. So "this" Board instance, as a Component, can 
        // react to imageUpdate() events triggered by g.drawImage()

        //g.fillRect(x, y, length, width);

        if (onMenu) {
            //paint the level select

            //Point p = MouseInfo.getPointerInfo().getLocation()

            int buffer = 50;
            int textSize = 78;

            int thingSize = 50;

            g.setColor(new Color(150, 20, 100, 30));
            g.fillRect(buffer, buffer, MAX_X-2*buffer, textSize);
            g.setFont(new Font("Lato", Font.BOLD, thingSize));
            g.setColor(new Color(0, 0, 0));
            g.drawString("Feish Game~!", buffer, buffer);



            for (int i = 1; i <= 4; i++) {
                g.setColor(new Color(30, 201, 139));
                g.fillRect(thingSize, i*thingSize, MAX_X-2*thingSize, thingSize);

                g.setFont(new Font("Lato", Font.BOLD, thingSize));
                g.setColor(new Color(0, 0, 0));
                g.drawString("Level "+i, thingSize, (i+1)*thingSize);

                if (i == 1) {
                    g.setColor(new Color(255, 0, 0));
                    g.fillRect(0, i*thingSize, thingSize, thingSize);
                }
            }

            // this smooths out animations on some systems
            Toolkit.getDefaultToolkit().sync();

        } else {
            // you are in the game loop






            //BufferedImage img;

            // draw our graphics.

            //drawing the health

            // set the text to be displayed
            String text = "60" + "/100";

            // we need to cast the Graphics to Graphics2D to draw nicer text
            // set the text color and font

            //filling green section
            /*
            g.setColor(new Color(30, 201, 139));
            g.fillRect(0, MAX_Y, (int)((60/100.0)*MAX_X), HEALTH_BAR_Y);

            //filling red section
            g.setColor(new Color(200, 0, 0));
            g.fillRect((int)((60/100.0)*MAX_X), MAX_Y, MAX_X, HEALTH_BAR_Y);

            g.setFont(new Font("Lato", Font.BOLD, 25));
            g.setColor(new Color(0, 0, 0));
            g.drawString(text, 0, MAX_Y);

            */

            // this smooths out animations on some systems
            Toolkit.getDefaultToolkit().sync();

        }
    }


    @Override
    public void keyTyped(KeyEvent e) {
        // this is not used but must be defined as part of the KeyListener interface
    }

    @Override
    public void keyPressed(@NotNull KeyEvent press) {
        // when player presses key call method of that player
        // will set pushingKey to true
        press.getKeyCode();
        int key = press.getKeyCode();
        //if (key == KeyEvent.VK_UP) { upPressed = true; }
        //if (key == KeyEvent.VK_DOWN) { downPressed = true; }
        //if (key == KeyEvent.VK_SPACE) { spacePressed = true; }

        //player.keyPressed(key)

    }

    @Override
    public void keyReleased(@NotNull KeyEvent release) {
        // when player releases key call method of that player
        // will set the pushingKey to false

        //gets the code of the key being pressed
        int key = release.getKeyCode();

        //if (key == KeyEvent.VK_UP) { upPressed = false; }
        //if (key == KeyEvent.VK_DOWN) { downPressed = false; }
        //if (key == KeyEvent.VK_SPACE) { spacePressed = false; }


    }

    private void tickAll() {

        //object.tick();
    }

}