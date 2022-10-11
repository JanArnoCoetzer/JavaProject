package utill;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener
{
    public boolean isKeyDown_W;
    public boolean isKeyDown_S;
    public boolean isKeyDown_A;
    public boolean isKeyDown_D;
    public boolean isKeyDown_Left;
    public boolean isKeyDown_Right;


    @Override
    public void keyTyped(KeyEvent e)
    {

    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        if(e.getKeyCode() == KeyEvent.VK_W){isKeyDown_W = true;}
        if(e.getKeyCode() == KeyEvent.VK_S){isKeyDown_S = true;}
        if(e.getKeyCode() == KeyEvent.VK_D){isKeyDown_D= true;}
        if(e.getKeyCode() == KeyEvent.VK_A){isKeyDown_A = true;}

        if(e.getKeyCode() == KeyEvent.VK_LEFT){isKeyDown_Left = true;}
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){isKeyDown_Right = true;}
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        if(e.getKeyCode() == KeyEvent.VK_W){isKeyDown_W = false;}
        if(e.getKeyCode() == KeyEvent.VK_S){isKeyDown_S = false;}
        if(e.getKeyCode() == KeyEvent.VK_D){isKeyDown_D= false;}
        if(e.getKeyCode() == KeyEvent.VK_A){isKeyDown_A = false;}

        if(e.getKeyCode() == KeyEvent.VK_LEFT){isKeyDown_Left = false;}
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){isKeyDown_Right = false;}
    }
}
