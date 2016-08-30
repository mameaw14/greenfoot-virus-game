import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class Scoreboard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Scoreboard extends Actor
{
    /**
     * Act - do whatever the Scoreboard wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public Scoreboard() 
    {
       setImage(new GreenfootImage("Score: 0", 25, Color.WHITE, Color.BLACK));
    }    
    public void display(int score)
    {
        setImage(new GreenfootImage("Score: " + score, 25, Color.WHITE, Color.BLACK));
    }
}
