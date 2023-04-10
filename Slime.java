import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Slime here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Slime extends Monster
{
    /**
     * Act - do whatever the Slime wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int time;
    private int X;
    private int Y;
    
    
    public void act()
    {
        // Add your action code here.\
        turnAtEdge();
        delayTurn(100);
        this.setLocation
        (
            getX()+X,
            getY()+Y
        );
    }
    
    private void delayTurn(int delay)
    {
        time++;
        if(time%delay<=2)
        {
            if(Greenfoot.getRandomNumber(3)==2)
            X = -2;
            else if(Greenfoot.getRandomNumber(3)==1)
            X = 2;
            else
            X = 0;
            
            if(Greenfoot.getRandomNumber(3)==2)
            Y = -2;
            else if(Greenfoot.getRandomNumber(3)==1)
            Y= 2;
            else
            Y= 0;
        }
    }
}
