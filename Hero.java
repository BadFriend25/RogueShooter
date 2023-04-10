import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Hero here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hero extends Actor
{
    /**
     * Act - do whatever the Hero wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage heroD1;
    private GreenfootImage heroD2;
    private GreenfootImage heroL1;
    private GreenfootImage heroL2;
    private GreenfootImage heroR1;
    private GreenfootImage heroR2;
    private GreenfootImage heroU1;
    private GreenfootImage heroU2;

    private int run;
    private int score;
    private int lives;
    private int direction = 4;
    int time = 0;
    int dx = 0; int dy = 0;
    

    Counter counter;
    
    public void act()
    {
        // Add your action code here.
        time++;
        controlHero();
        detectCollision();
        animateHero(run, direction);
        turnAtEdge();
        shootMouse();
        if(isTouching(Monster.class))
        {
            updateLives();
        }
        youDied();
    }
    
    public Hero()
    {
        heroD1 = new GreenfootImage("heroD1.png");
        heroD2 = new GreenfootImage("heroD2.png");
        heroL1 = new GreenfootImage("heroL1.png");
        heroL2 = new GreenfootImage("heroL2.png");
        heroR1 = new GreenfootImage("heroR1.png");
        heroR2 = new GreenfootImage("heroR2.png");
        heroU1 = new GreenfootImage("heroU1.png");
        heroU2 = new GreenfootImage("heroU2.png");
        
        lives = 5;
    }
    
    
    private void controlHero()
    {
        setLocation(getX()+dx, getY()+dy);
        if (Greenfoot.isKeyDown("D"))
        {
            run = 10;
            direction = 3;
            dx = 4;
            dy = 0;
            return;
        }
        else if (Greenfoot.isKeyDown("A"))
        {
            run = 10;
            direction = 2;
            dx = -4;
            dy = 0;
            return;
        }
        else if (Greenfoot.isKeyDown("W"))
        {
            run = 10;
            direction = 1;
            dx = 0;
            dy = -4;
            return;
        }
        else if (Greenfoot.isKeyDown("S"))
        {
            run = 10;
            direction = 4;
            dx = 0;
            dy = 4;
            return;
        }
        else
        {
            run = 35;
            dx = 0;
            dy = 0;
            return;
        }
        
    }
    
    public void detectCollision() {
        if (isTouching(Solid.class))
        {
            if(dx > 1 || dy > 1)
            setLocation(getX()-dx-1, getY()-dy-1);
            else
            setLocation(getX()-dx+1, getY()-dy+1);
        }
    }
    
    private void animateHero(int delay, int direction)
    {
        time++;
        if(direction==1)
        {
            if(time%delay<=delay/2)
            {
                //change image
                setImage(heroU1);
            }
            else
            {
                //change image
                setImage(heroU2);
            }
        }
        if(direction==2)
        {
            if(time%delay<=delay/2)
            {
                //change image
                setImage(heroL1);
            }
            else
            {
                //change image
                setImage(heroL2);
            }
        }
        if(direction==3)
        {
            if(time%delay<=delay/2&&direction==3)
            {
                //change image
                setImage(heroR1);
            }
            else
            {
                //change image
                setImage(heroR2);
            }                
        }
        if(direction==4)
        {
            if(time%delay<=delay/2&&direction==4)
            {
                //change image
                setImage(heroD1);
            }
            else
            {
                //change image
                setImage(heroD2);
            }
        }
    }
    
    private void turnAtEdge()
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
    
    public void shootMouse()
    {
        MouseInfo mouse = Greenfoot.getMouseInfo();
            
        if(mouse!=null)
        {
            if(mouse.getButton()==1)
            {
                Bullet bullet = new Bullet();
                getWorld().addObject(bullet
                ,getX()
                ,getY());
                Greenfoot.playSound("fire.mp3");
                
                bullet.setRotation((int)(180*Math.atan2(
                mouse.getY()-getY(),
                mouse.getX()-getX()
                )/Math.PI));
                
                //Bullet.setRotation(getRotation());
                
            }
            
        }
    }
    
    private void updateLives()
    {
        lives--;
    }
        
    private void youDied()
    {
        if(lives == 0)
        {
            getWorld().showText("YOU DIED", getWorld().getWidth()/2, getWorld().getHeight()/2);
            getWorld().showText("TIME : "+(time/60)+ " SECONDS", getWorld().getWidth()/2+40, getWorld().getHeight()/2+40);
            Greenfoot.stop();
        }
    }
    
    
}
