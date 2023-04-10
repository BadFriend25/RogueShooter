import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    int count = 0;
    int spawnSpeed = 50;
    private int score;
    int randomSpawn;
    
    public Hero thehero = new Hero();
    Counter counter = new Counter();
    
    
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(900, 600, 1); 
        prepare();
    }
    
    public void act()
    {
        count++;
        spawnMonster();
    }
    
    public void spawnMonster()
    {
        if (count % spawnSpeed == 0)
        {
            randomSpawn = Greenfoot.getRandomNumber(10);
            switch(randomSpawn){
                case 0 : addObject(new Slime(), 50, 50); break;
                case 1 : addObject(new Slime(), getWidth()-50, 50); break;
                case 2 : addObject(new Slime(), 50,getHeight()-50); break;
                case 3 : addObject(new Slime(), getWidth()-50, getHeight()-50); break;
                case 4 : addObject(new Crab(), 50, getHeight()/2); break;
                case 5 : addObject(new Crab(), getWidth()-50, getHeight()/2); break;
                case 6 : addObject(new Crab(), getWidth()/2, 50); break;
                case 7 : addObject(new Crab(), getWidth()/2,getHeight()-50); break;
                case 8 : addObject(new Witch(), getWidth()-50, getHeight()/3); break;
                case 9 : addObject(new Witch(), getWidth()-50, getHeight()*2/3); break;
            }
        }
    }
    
    private void prepare()
    {
        addObject(thehero, 90, 100);
        summonForest();
        addObject(counter, 760, 100);

    }
    
    public Hero getHero()
    {
        return thehero;
    }
    
    public void summonForest()
    {
        for(int i = 0;i < 900; i++)
        {
            for(int j = 0; j < 600; j++)
            {
                if(i>850)
                    addObject(new Tree(), i, j);
                if(i<60)
                    addObject(new Tree(), i, j);
                if(j>550)
                    addObject(new Tree(), i, j);
                if(j<20)
                    addObject(new Tree(), i, j);
                j = j +80;
            }
            i = i + 80;
        }
        addObject(new Bush(), 200, 200);
        addObject(new Bush(), 300, 200);
        addObject(new Bush(), 600, 200);
        addObject(new Bush(), 700, 200);
        addObject(new Bush(), 350, 380);
        addObject(new Bush(), 450, 380);
        addObject(new Bush(), 550, 380);
    }
    
    public void updateScore()
    {
        score++;     
        counter.updateScore(1);
    }
}
