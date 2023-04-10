import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Crab here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Crab extends Monster
{
    /**
     * Act - do whatever the Crab wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int X;
    private int Y;

    
    public void act()
    {
        // Add your action code here.
        turnAtEdge();
        MyWorld myWorld = (MyWorld) getWorld();
        Hero hero = myWorld.getHero();
        detectHeroDirection(hero.getX()-getX(),hero.getY()-getY());
            
        this.setLocation(getX()+X, getY()+Y);

    }
    
    public void detectHeroDirection(int heroX, int heroY)
    {
        if(heroX<0)
            X = -1;
        else
            X = 1;
            
        if(heroY<0)
            Y = -1;
        else
            Y = 1;
    }
     
}
