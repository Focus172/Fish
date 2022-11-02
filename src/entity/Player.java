package entity;

import entity.Entity;
import master.InputManager;
import master.Screen;

public class Player extends Entity {

    private InputManager inpMan;

    private int xVelocity = 0;
    private int yVelocity = 0;

    //this can be changed by items so is left public
    public int acceleration = 2;
    public int deceleration = 1;
    public int xVeloCap = 8;
    public int yVeloCap = 8;

    public Player(int x, int y, Screen screen) {
        super(x, y, screen);
        inpMan = scr.inpMan;

        //other details that might be nessisary
    }

    //@Override
    public void tick() {

        //handles all the y movement
        if (inpMan.wPressed && !inpMan.sPressed) { yVelocity -= acceleration; }
        else if (inpMan.sPressed && !inpMan.wPressed) { yVelocity += acceleration; }
        else if (yVelocity < 0) { yVelocity += deceleration; if (yVelocity > 0) { yVelocity = 0;} }
        else if (yVelocity > 0) { yVelocity -= deceleration; if (yVelocity < 0) { yVelocity = 0;} }

        //handles all the x movement
        if (inpMan.aPressed && !inpMan.dPressed) { xVelocity -= acceleration; }
        else if (inpMan.dPressed && !inpMan.aPressed) { xVelocity += acceleration; }
        else if (xVelocity < 0) { xVelocity += deceleration; if (xVelocity > 0) { xVelocity = 0;} }
        else if (xVelocity > 0) { xVelocity -= deceleration; if (xVelocity < 0) { xVelocity = 0;} }

        if (xVelocity < -xVeloCap ) { xVelocity = -xVeloCap; }
        if (xVelocity > xVeloCap) { xVelocity = xVeloCap; }
        if (yVelocity < -yVeloCap) { yVelocity = -yVeloCap; }
        if (yVelocity > yVeloCap) { yVelocity = yVeloCap; }

        pos.translate(xVelocity, yVelocity);

        //then check if you are cholliding with anything
        //or you are out of the side

    }
}
