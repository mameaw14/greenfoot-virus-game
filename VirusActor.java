import greenfoot.*;
/**
 * Write a description of class VirusActor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class VirusActor extends Actor
{
    public int state;
	public int speed;
    /**
     * Constructor for objects of class VirusActor
     */
    public VirusActor()
    {
        
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void die()
    {
        World world;
        world = getWorld();
        world.removeObject(this);
    }
    
    public int getState()
    {
        return state;
    }
}
