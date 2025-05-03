import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Die Klasse Robby ist eine Unterklasse von Roboter.
 * Sie erbt damit alle Attribute und Methoden der Klasse Roboter.
 */

public class Robby extends Roboter
{
    /** -- Attribute */
    Leben SpielerLeben = new Leben();
    int hohe;
    int xposition = 1;
    int yspeed = 0;
    
    /** -- Methoden -- */
    public Robby(int h){
        hohe = h;
    }
    public void setHeight(int h){
        hohe = h;
    }
    public int getx(){
        return xposition;
    }
    public int gety(){
        return 10-hohe;
    }
    public boolean yMovement(int shouldJump, int timeSinceLast /**in ms*/, int lastWallHeight, int thisWallHeight){
        if (shouldJump == -1){
            
        }else {
            if ((shouldJump == 2 || shouldJump == 1) && hohe-1 == thisWallHeight){
                hohe+=shouldJump;
                yspeed = 0;
            }else{
                if(hohe-(yspeed+2)>= thisWallHeight||hohe<thisWallHeight+1){
                    hohe-= ++yspeed;
                }else {
                    yspeed = 0;
                    if(thisWallHeight == 0) hohe = 0;
                    else hohe = thisWallHeight+1;
                }
            }
        }
        if (hohe <= 0) {
            hohe = 0;
            SpielerLeben.verringern();
            return true;
        }else {
            return false;
        }
    }
}

