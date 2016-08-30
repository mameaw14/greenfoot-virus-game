import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class cyan here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Me extends VirusActor
{
    private int score = 0;
    public Me(){
        state = 15;
        speed = 4;
        GreenfootImage image = new GreenfootImage(state,state);
        image.setColor(Color.WHITE);
        image.fillOval(0,0,state,state);
        setImage(image);
    }
    public void act() 
    {
        moveAndTurn();
        Enemy enemy = (Enemy)getOneIntersectingObject(Enemy.class);
        if(enemy != null)
        {
            if(enemy.getState()<=state) eat(enemy);
            else die();
        }
    }    
    public void moveAndTurn()
    {
       if(Greenfoot.isKeyDown("up"))
       {
           setLocation(getX(),getY()-speed);
       }
       if(Greenfoot.isKeyDown("down"))
       {
           setLocation(getX(),getY()+speed);
       }
       if(Greenfoot.isKeyDown("left"))
       {
           setLocation(getX()-speed,getY());
       }
       if(Greenfoot.isKeyDown("right"))
       {
           setLocation(getX()+speed,getY());
       }
       if(isAtEdge()){
            turn(180);
        }
    }
    public void eat(Enemy enemy)
    {
        GreenfootSound deathSound = new GreenfootSound("die.wav");
        deathSound.setVolume(90);
        deathSound.play();
		state += 1;
        increaseSize();
        score += 10 + enemy.getState()/5;
        enemy.die();
        updateScoreBoard();
    }
    private void updateScoreBoard()
    {
        MyWorld world = (MyWorld) getWorld();
        Scoreboard scoreboard = world.getScoreboard();
        scoreboard.display(score);
    }
    public void increaseSize()
    {
		GreenfootImage image = new GreenfootImage(state,state);
		image.setColor(Color.WHITE);
        image.fillOval(0,0,state,state);
        setImage(image);
    }
    public int getScore()
    {
        return score;
    }
}
