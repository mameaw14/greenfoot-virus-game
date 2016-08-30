import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    GreenfootSound backgroundMusic = new GreenfootSound("sound2.wav");
    private Scoreboard scoreboard;
    private Me me = new Me();
    public int score = 0;
    static public int highscore = 0;
    static int count = 0;
    private boolean isOver = false;
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        isOver = false;
        prepare();
        backgroundMusic.play();
    }
    public void act()
    {   
        if(!isOver){
            genEnemy();
            score = me.getScore();
            if(score>highscore) {
                highscore = score;
            }
           
            if(isGameOver()){
                backgroundMusic.pause();
                GreenfootSound overSound = new GreenfootSound("gameover.wav");
                overSound.play();
                isOver = true;
                removeObjects(getObjects(null));
                GameOver gameover = new GameOver(getScore(),getHighscore());
                TryAgain tryagain = new TryAgain();
                addObject(gameover, getWidth()/2, getHeight()/2);
                addObject(tryagain, getWidth()/2, getHeight()/2+100);
            }
        }
    }
    

    private void prepare()
    {
        addObject(me,422,301);
        scoreboard = new Scoreboard();
        addObject(scoreboard,50,20);
    }


    public Scoreboard getScoreboard()
    {
        return scoreboard;
    }
    public void genEnemy()
    {
        int base = me.getState();
       if(count%(50+base) == 0)
       {
           Enemy enemy = new Enemy(base-(int)(base*0.4));
           addObject(enemy,Greenfoot.getRandomNumber(getWidth()),Greenfoot.getRandomNumber(getHeight()));
       }
       if(count%(500-base) == 0)
        {
            Enemy enemy = new Enemy(base+(int)(base*0.5));
           addObject(enemy,Greenfoot.getRandomNumber(getWidth()),Greenfoot.getRandomNumber(getHeight()));
           count = 0;
        }
       count++;
    }
    private boolean isGameOver()
    {
        if(!getObjects(Me.class).isEmpty()) return false;
        return true;
    }
    public int getScore()
    {
        return score;
    }
    public int getHighscore()
    {
        return highscore;
    }
    public void stopped()
    {
        backgroundMusic.pause();
    }
    public void started()
    {
        backgroundMusic.playLoop();
    }
}
