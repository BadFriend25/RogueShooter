import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Counter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Counter extends Actor
{
    /**
     * Act - do whatever the Counter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int score;

    public Counter()
    {
        score = 0;
        setImage(new GreenfootImage("Score: " + score, 24, Color.WHITE, new Color(0, 0, 0, 0)));
    }

    public void updateScore(int points)
    {
        score += points;
        setImage(new GreenfootImage("Score: " + score, 24, Color.WHITE, new Color(0, 0, 0, 0)));
    }

    public int getScore()
    {
        return score;
    }
}
