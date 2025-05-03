import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Menu here.
 * 
 * @NKullmer (your name) 
 * @02052025 (a version number or a date)
 */
public class Menu extends World
{
    int score = 0, bestScore = 0;
    public Menu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        setBackground("images/space.jpg");
        addObject(new Logo(), 300, 100);
        showText("Drücke Leertaste zum Starten", 300, 275);
    }
    public void act(){
        showText("", 300, 200);
        showText("", 300, 275);
        while(Greenfoot.isKeyDown("space")==false);
        RoboterWelt R = new RoboterWelt();
        Greenfoot.setWorld(R);
        removeObjects(getObjects(null));
        long Time;
        score = 0;
        for(int i = 0; i < 3; i++){
            if(R.act(i) == false) {
                score += R.getScore();
                break;
            }
            score += R.getScore();
            Greenfoot.setWorld(this);
            showText("Level " + (i+1) + " abgeschlossen", 300, 150);
            repaint();
            Time = System.currentTimeMillis();
            while(System.currentTimeMillis()-Time <= 2500);
            Greenfoot.setWorld(R);
        }
        Greenfoot.setWorld(this);
        showText("Score: "+score, 300,150);
        if (UserInfo.isStorageAvailable()) {
            UserInfo myInfo = UserInfo.getMyInfo();
            if (score > myInfo.getScore()) {
                bestScore = score;
                myInfo.setScore(score);
                myInfo.store();
            }
            else{
                bestScore = myInfo.getScore();
            }
        }
        
        addObject(new Logo(), 300, 50);
        showText("Bester Score: "+ bestScore, 300, 200);
        showText("Leertaste zum Neustarten", 300,300);
        if (score >= new MainGameActor().getOverallLength()){
            showText("Du hast alle Level gemeistert!",300,150);
        }
    }
}
