import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class GameOver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOver extends Actor
{
    /**
     * Act - do whatever the GameOver wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public GameOver(int score,int highscore)
    {
        GreenfootImage image = new GreenfootImage("GAME OVER\nHigh score: "+highscore+"\n Score: "+score,50,Color.WHITE,Color.BLACK);
        setImage(image);
    }
    public void act() 
    {
        // Add your action code here.
        
    }    
}
