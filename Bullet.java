import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends Actor
{
    /**
     * Act - do whatever the Bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    private int burn = 2;
    private int move = 20;
    //private int explosion = 10;
    private GreenfootImage fire;
    private GreenfootImage explode;
    //private MyWorld world;
    
    public Bullet()
    {
        fire = new GreenfootImage("fire.png");
        explode = new GreenfootImage("explode.png");
    }
    
    public void act()
    {
        // Add your action code here.
        move(move);
        //life--;
        touchBullet();
        if(burn == 0)
        {
            getWorld().removeObject(this);
            return;
        }
        
        //if(explosion == 0)
        //{
        //    getWorld().removeObjects(getWorld().getObjects(Explode.class));
        //    return;
        //}
        
            
    }
    
    private void touchBullet()
    {
        
        if(isTouching(Monster.class))
        {
            removeTouching(Monster.class);
            burn--;
            //explosion--;
            setImage(explode);
            Greenfoot.playSound("explosion.mp3");
            //world.updateScore();
            //getWorld().addObject(new Explode(),getX(),getY());
            
        }
        
        else if(atRightEdge()||atLeftEdge()||atTopEdge()||atBottomEdge())
        {
            burn--;
            setImage(explode);
            Greenfoot.playSound("explosion.mp3");
            
        }
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
}
