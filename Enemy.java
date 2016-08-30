import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class anemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends VirusActor
{
    static int count = 0;
    /**
     * Act - do whatever the anemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Enemy(int x)
    {
        Color[] pen = {Color.CYAN,Color.GREEN,Color.RED,Color.ORANGE,Color.MAGENTA};
        state = x;
		speed = Greenfoot.getRandomNumber(7)+1;
        GreenfootImage image = new GreenfootImage(x,x);
        image.setColor(pen[x%5]);
        image.fillOval(0,0,x,x);
        setImage(image);
    }
    public void act() 
    {
       moveAndTurn();
    }    
    public void moveAndTurn()
    {
        move(speed); 
       if(Greenfoot.getRandomNumber(100) < 10)
        {
            turn(Greenfoot.getRandomNumber(30)-15);
        }
       if(isAtEdge()){
            turn(180);
        }
    }
}
