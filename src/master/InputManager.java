package master;

import org.jetbrains.annotations.NotNull;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputManager implements KeyListener {

    public boolean wPressed = false;
    public boolean aPressed = false;
    public boolean sPressed = false;
    public boolean dPressed = false;

    @Override
    public void keyTyped(KeyEvent e) {
        // this is not used but must be defined as part of the KeyListener interface
    }

    @Override
    public void keyPressed(KeyEvent k) {

        k.getKeyCode();
        int key = k.getKeyCode();
        if (key == KeyEvent.VK_W) { wPressed = true; }
        if (key == KeyEvent.VK_A) { aPressed = true; }
        if (key == KeyEvent.VK_S) { sPressed = true; }
        if (key == KeyEvent.VK_D) { dPressed = true; }

    }

    @Override
    public void keyReleased(KeyEvent k) {

        k.getKeyCode();
        int key = k.getKeyCode();
        if (key == KeyEvent.VK_W) { wPressed = false; }
        if (key == KeyEvent.VK_A) { aPressed = false; }
        if (key == KeyEvent.VK_S) { sPressed = false; }
        if (key == KeyEvent.VK_D) { dPressed = false; }

    }
}
