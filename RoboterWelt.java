import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Die einzigen aktiven Akteure in der Roboterwelt sind die Roboter.
 * Die Welt besteht aus 14 * 10 Feldern.
 */

public class RoboterWelt extends World
{
    private static int zellenGroesse = 50;
    int score;
    public int getScore(){
        return score;
    }
    /**
     * Erschaffe eine Welt mit 14 * 10 Zellen.
     */
    public RoboterWelt()
    {
        super(14, 10, zellenGroesse);
        setBackground("images/Bodenplatte (2).png");
        setPaintOrder(Schraube.class, Akku.class,  Roboter.class, Wand.class);
    }
    
    public boolean act(int lvl){
        MainGameActor mainGameActor = new MainGameActor();
        addObject(mainGameActor,13,0);
        mainGameActor.act(lvl);
        boolean won = mainGameActor.hasWon();
        score = mainGameActor.getMaxScore();
        return won;
        //System.out.println(Greenfoot.isKeyDown("space"));
    }

}