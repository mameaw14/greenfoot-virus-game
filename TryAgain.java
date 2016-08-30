import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class TryAgain here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TryAgain extends Actor
{
    boolean mouseOver = false;
    
    public TryAgain()
    {
        GreenfootImage image = new GreenfootImage(">TRY AGAIN<",45,Color.WHITE,Color.RED);
        setImage(image);
    }
    public void act() 
    {
        if (Greenfoot.mouseClicked(this))
        {
            MyWorld world = (MyWorld)getWorld();
            Greenfoot.setWorld(new MyWorld());
            world.removeObject(this);
            
        }
        if (!mouseOver&&Greenfoot.mouseMoved(this))
        {
            GreenfootImage image = new GreenfootImage(">>TRY AGAIN<<",40,Color.WHITE,Color.RED);
            setImage(image);
            mouseOver = true;
        }else if(mouseOver&&!Greenfoot.mouseMoved(this)&&Greenfoot.mouseMoved(null)){
            GreenfootImage image = new GreenfootImage(">TRY AGAIN<",45,Color.WHITE,Color.RED);
            setImage(image);
            mouseOver = false;
        }
    }    
}
