package master;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Graphics;

import entity.Player;

public class Screen extends JPanel implements Runnable, ActionListener { //, KeyListener

    // controlling the frame rate
    //public static final int DELAY = 25;
    public static final int FPS = 60;

    // controls the size of the board
    public static final int BASE_TILE_SIZE = 16;
    public static final int SCALE_SIZE = 3;
    public static final int TILE_SIZE = BASE_TILE_SIZE*SCALE_SIZE; // 48

    public static final int MAX_COL = 16;
    public static final int MAX_ROW = 12;
    public static final int MAX_X = MAX_COL*TILE_SIZE; // 768
    public static final int MAX_Y = MAX_ROW*TILE_SIZE; // 576

    // suppress serialization warning
    private static final long serialVersionUID = 490905409104883233L;

    // runs the main game timer


    private boolean onMenu = true;

    private Timer timer;
    private Thread gameThread;

    public Player p;

    public static final InputManager inpMan = new InputManager();

    public Screen() {

        this.setPreferredSize(new Dimension(MAX_X, MAX_Y));
        this.setBackground(Color.cyan); // new Color(20, 150, 200, 30)
        this.setDoubleBuffered(true);

        this.addKeyListener(inpMan);
        this.setFocusable(true);

        p = new Player(100, 100, this); //, inpMan

        // this timer will call the actionPerformed() method every DELAY ms
        // somehow this references actionPerformed()



        startThread();


        //timer = new Timer(DELAY, this);
        //timer.start();

    }

    private void startThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    public static double delta;

    @Override
    public void run() {

        double nanoFrame = 1000000000/FPS; // 0.0166 seconds
        double delta = 0;
        long lastTime = System.nanoTime();
        long curTime;

        //only nessisary for showing FPS
        long timer = 0;
        int drawCount = 0;

        while (gameThread != null) {

            curTime = System.nanoTime();
            delta += (curTime - lastTime) / nanoFrame;
            timer += (curTime - lastTime); //only for displaying FPS
            lastTime = curTime;

            if (delta >= 1) {
                tickAll();
                repaint();
                delta--;
                drawCount++;
            }

            ///* display FPS
            if(timer >= 1000000000) {
                System.out.println("fps: " + drawCount);
                timer = 0;
                drawCount = 0;
            }
            //*/

        }
    }


    private void tickAll() {

        p.tick();
        //System.out.println("x: " + p.pos.x + ", y: " + p.pos.y);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // when calling g.drawImage() we can use "this" for the ImageObserver
        // because Component implements the ImageObserver interface, and JPanel
        // extends from Component. So "this" Board instance, as a Component, can
        // react to imageUpdate() events triggered by g.drawImage()

        //g.fillRect(x, y, length, width);
        Graphics2D g2 = (Graphics2D)g;

        p.draw(g2, this);

        //Point mousePos = MouseInfo.getPointerInfo().getLocation();
        //g2.fillRect(mousePos.x, mousePos.y, 10, 10);

        g2.dispose();


        /*
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

            JButton myButton = new JButton("My Button");
            add(myButton);

            /*
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

            // this smooths out animations on some systems
            Toolkit.getDefaultToolkit().sync();
         }
         */
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

}