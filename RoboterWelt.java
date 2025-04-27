import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Die einzigen aktiven Akteure in der Roboterwelt sind die Roboter.
 * Die Welt besteht aus 14 * 10 Feldern.
 */

public class RoboterWelt extends World
{
    private static int zellenGroesse = 50;

    /**
     * Erschaffe eine Welt mit 14 * 10 Zellen.
     */
    public RoboterWelt()
    {
        super(14, 10, zellenGroesse);
        setBackground("images/Bodenplatte (2).png");
        setPaintOrder(Schraube.class, Akku.class,  Roboter.class, Wand.class);
        Greenfoot.setSpeed(100);
    }
    
    public void act(){
        ///*
        MainGameActor mainGameActor = new MainGameActor();
        addObject(mainGameActor,13,0);
        mainGameActor.act();
        //*/
        //System.out.println(Greenfoot.isKeyDown("space"));
    }

}