import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.time.LocalTime;
/**
 * acts as the main method of the programm that controlls the entire system.
 * 
 * @Küllmer (your name) 
 * @27042025 (a version number or a date)
 */
public class MainGameActor extends Actor
{
    boolean GameEnde;
    Robby Player;
    int timebetween;
    int Wande [][] = {
    {1,1,1,1,1,1,2,2,2,2,2,2,2,2,3,3,3,3,3,3,1,1,1,1,1,1,1,2,2,2,2,3,3,3,3,3,2,2,2,2,1,1,1,1,2,1,1,1},
    {1,1,1,1,3,2,2,2,2,2,0,2,2,4,5,1,1,1,1,1,0,1,1,2,2,0,1,1,2,2,2,2,2,2,2},
    {4,4,4,5,5,0,0,0,1,1,1,1,0,1,1,0,2,2,2,2,0,3,3,3,3,0,4,4,4,4,4,0,0,2,2,3,3,4,4,5,5,6,6,7,7,8,8,0,8,0,8,0,8,8,0,0,6,5,4,3,2,1,1,0,1,1}
    };
    int Checkpoints [][] = {
        {0,14,31}, // Werte 1 kleiner als in der Excel !! 
        {0,6,18},
        {0,26,45}
    };
    int curLevel = 0;
    int xFortschritt = 0;
    int maxScore = 0;
    int ZielXWert;
    private long lastTime;
    private int fps; 
    private long lastFPS;
    private long lastMOVE;
    World W;
    GreenfootSound bg_music;
    int MOVE_IN_X_MS = 500; 
    boolean hasWon = false;
    boolean sollUpdaten = true;
    public int getOverallLength(){
        int len = 0;
        for (int i = 0; i < Wande.length; i++){
            len += Wande[i].length-2;
        }
        return len;
    }
    public boolean hasWon(){
        return hasWon;
    }
    public void act(int lvl) // aka main()
    {
        curLevel = lvl;
        instantiation();
        GameLoop();
    }
    public void instantiation(){
        W = getWorld();
        W.setBackground("images/Bodenplatte (2).png");
        Player = new Robby(Wande[curLevel][xFortschritt]+1);
        GameEnde = false;
        ZielXWert = Wande[curLevel].length-2; // -1 wegen Array Out of Bounds // -1 nochmal, damit der Roboter auf dem letzten Wandstück stehen bleibt
        bg_music = new GreenfootSound("bg-music.wav");
        bg_music.playLoop();
    }
    public void GameLoop(){
        int jump = -1;
        boolean deltaInX = false;
        lastFPS = getTime();
        lastMOVE = getTime();
        int lastWallHeight, thisWallHeight = Wande[curLevel][xFortschritt];
        while (xFortschritt < ZielXWert){
            deltaInX = updatexFortschritt(MOVE_IN_X_MS-(int)Math.sqrt(xFortschritt*100));
            if (xFortschritt > maxScore) maxScore = xFortschritt;
            if (deltaInX){
                timebetween = getDelta();
            }
            lastWallHeight = thisWallHeight;
            thisWallHeight = Wande[curLevel][xFortschritt];
            jump = sollSpringen(deltaInX);
            if(Player.yMovement(jump,timebetween, lastWallHeight, thisWallHeight)){
                if (Player.SpielerLeben.getLeben() == 0){
                    GameOver(xFortschritt);
                    break;
                }else {
                    Greenfoot.playSound("lose-life.wav");
                    for (int i = 2; i >= 0; i--){
                        if (Checkpoints[curLevel][i]<=xFortschritt){
                            xFortschritt = Checkpoints[curLevel][i];
                            break;
                        }
                    }
                    Player.setHeight(Wande[curLevel][xFortschritt]+1);
                    W.showText("3 .. 2 .. 1 ..", 6,4);
                    draw();
                    long Time = System.currentTimeMillis();
                    while(System.currentTimeMillis()-Time <= 2000);
                    W.showText("",6,4);
                    lastMOVE = getTime();
                }
            }
            draw(); /** Wändebewegen() entfällt dadurch, dass man sie in der Draw abhängig von x-Fortschritt zeichnet**/
        }
        if (xFortschritt >= ZielXWert){
            maxScore = xFortschritt;
            GameGewonnen();
        }
    }
    public void GameGewonnen(){
        bg_music.stop();
        Greenfoot.playSound("game-sieg.wav");
        W.removeObjects(W.getObjects(null));
        W.showText("Gewonnen!", W.getHeight()/4*3, W.getHeight()/2);        
        W.repaint();
        hasWon = true;
    }
    public void GameOver(int score){
        maxScore = score;
        bg_music.stop();
        Greenfoot.playSound("game-over.wav");
        W.removeObjects(W.getObjects(null));
        W.showText("Leben: "+Player.SpielerLeben.getLeben(), 1,0);
        W.showText("Verloren!", W.getHeight()/4*3, W.getHeight()/2);
        W.repaint();
    }
    public void draw(){
        W.removeObjects(W.getObjects(null));
        W.showText("", W.getHeight()/4*3, W.getHeight()/2);
        //Score
        W.showText("Level " + (curLevel+1) + "  Score: "+maxScore, W.getHeight()+1, 0);
        //Lebensanzeige
        W.showText("Leben: "+Player.SpielerLeben.getLeben(), 1,0);
        //Spieler
        W.addObject(Player, Player.getx(),Player.gety());
        //Wande
        for (int i = 0; i < W.getWidth();i++){
            if (i+xFortschritt >= Wande[curLevel].length) break;
            if (Wande[curLevel][i+xFortschritt] == 0) continue;
            W.addObject(new Wand(),i,W.getHeight()-Wande[curLevel][i+xFortschritt]);
        }
        W.repaint();
    }
    public int getMaxScore(){
        return maxScore;
    }
    public int sollSpringen(boolean xposdiff){ 
        /** returns: 
         * -1 = no jump because no x movement
         *  0 = no jump because no input
         *  1 = small jump 
         *  2 = big jump
         */ 
        if (xposdiff){
            if (Greenfoot.isKeyDown("space")){
                return 2;
            }else if (Greenfoot.isKeyDown("up")){
                return 1;
            }else{
                return 0;
            }
        }else {
            return -1;
        }
    }
    public int getDelta(){
        long time = getTime();
        int delta = (int) (time - lastTime);
        lastTime = time;
        return delta;
    }
    public long getTime() {
        return (System.currentTimeMillis());
    }
    public boolean updatexFortschritt(int movespeed){
        if (getTime() - lastFPS > 1000){
            System.out.println("FPS: " + fps);
            fps = 0;
            lastFPS += 1000;
        }
        fps++;
        if (getTime() - lastMOVE > movespeed) {
            xFortschritt++;
            lastMOVE += movespeed;
            return true;
        }else return false;
    }
}
