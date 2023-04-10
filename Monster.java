import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Monster here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Monster extends Actor
{
    /**
     * Act - do whatever the Monster wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int health = 1;
    Counter counter;
    
    public void updateCounter()
    {
        this.counter = counter;
    }
    
    public void act()
    {
        // Add your action code here.
        turnAtEdge();
        attacked();
    }
    
    public boolean atTopEdge()
    {
        if (getY() < 6)
            return true;
        else
            return false;
    }
    
    public boolean atLeftEdge()
    {
        if (getX() <  6)
            return true;
        else
            return false;
    }
    
    public boolean atBottomEdge()
    {
        if(getY() > getWorld().getHeight()-20)
            return true;
        else
            return false;    
    }
    
    public boolean atRightEdge()
    {
        if(getX() > getWorld().getWidth() -20)
            return true;
        else
            return false;
    }
    
    public void turnAtEdge()
    {
        if(atRightEdge()){
            setLocation(6,getY());
        }
        else if(atBottomEdge()){
            setLocation(getX(),6);
        }
        else if(atLeftEdge()){
            setLocation(getWorld().getWidth()-20,getY());
        }
        else if(atTopEdge()){
            setLocation(getX(),getWorld().getHeight()-20);
        }
    }
    
    public void attacked()
    {
        Actor bullet = getOneIntersectingObject(Bullet.class);
        if(bullet!=null)
        {
            health--; 
            getWorld() .removeObject(bullet);
        }
        
        if(health == 0)
        {
            getWorld().removeObject(this);
        }
    }
}
