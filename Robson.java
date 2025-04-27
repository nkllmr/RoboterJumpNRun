import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Die Klasse Robson ist eine Unterklasse von Roboter.
 * Sie erbt damit alle Attribute und Methoden der Klasse Roboter.
 */

public class Robson extends Roboter
{

/**
 * In der Methode "act" koennen Befehle / andere Methoden angewendet werden:
 * Die Methoden werden dort nacheinander "aufgerufen", wenn man
 * nach dem Kompilieren / uebersetzen den Act-Knopf drueckt.
 */

    public void act() 
    {

    } 
    /**
    public void akkusInLinie(){
        int Schritte = 0;
        for (int i = 23; i < 28; ){
            if (akkuAufFeld()) {
                akkuAufnehmen();
                i++;
            }
            if (anGrenze()){
                break;
            }else if (wandVorne()){
                dreheRechts();
                bewegen();
                dreheLinks();
                bewegen();
                bewegen();
                dreheLinks();
                bewegen();
                dreheRechts();
                Schritte += 3;
            }else {
                bewegen();
                Schritte++;
            }
        }
        rueckkehren(Schritte);
    }
    */
}
