import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Schraubenesser here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Schraubenesser extends Roboter
{
    public void act() 
    {
        
    }    
    /** --Unterricht--
    /** Methodendefinitionen
    public void seite52Nr5aI (){
        while(wandVorne()){
            dreheRechts();
        }
    }
    public void seite52Nr5aII (){
        do {
            dreheRechts();
        }while(wandVorne());
    }
    public void seite52Nr5bI (){
        while(!akkuAufFeld()){
            bewegen();
        }
    }
    public void seite52Nr5bII (){
        do {
            bewegen();
        }while(!akkuAufFeld());
    }
    public void seite52Nr5cI (){
        while(!wandRechts()){
            if(akkuAufFeld()){
                akkuAufnehmen();
            }
            bewegen();
        }
    }
    public void seite52Nr5cII (){
        do{
            if(akkuAufFeld()){
                akkuAufnehmen();
            }
            bewegen();
        }while(!wandRechts());
    }
    public void seite52Nr6 (){
        int AkkusUeber = 3;
        while(AkkusUeber > 0){
            if(akkuAufFeld()){
                AkkusUeber--;
                akkuAufnehmen();
            }
            if(wandVorne()){
                dreheRechts();
                bewegen();
                dreheLinks();
                for(int i = 0; i < 3; i++){
                    bewegen();
                }
                dreheLinks();
                bewegen();
                dreheRechts();
            }else{
                bewegen();
            }
        }
    }
    public void seite52Nr7a (){
        while(wandVorne()){
            dreheLinks();
            bewegen();
            dreheRechts();
            bewegen();
        }
    }
    public void seite52Nr7b (){
        while(wandVorne()){
            dreheLinks();
            bewegen();
            dreheRechts();
            do{
                bewegen();
            }while(wandRechts()&&!wandVorne());
        }
    }
    public void wandBesteigen (){ /**S.52 Nr. 7c
        while(wandVorne()){
            dreheLinks();
            while(wandRechts()){
                bewegen();
            }
            dreheRechts();
            do{
                bewegen();
            }while(wandRechts()&&!wandVorne()&&!anGrenze());
        }
    }
    public void akkuAufnehmenWennWandLinks(){
        if (wandLinks() && akkuAufFeld()){
            akkuAufnehmen();
        } 
        bewegen();
    }
    public void labyrinth(){
        while(!akkuAufFeld()){
            if(wandVorne()){
                if(!wandLinks()){
                    dreheLinks();
                }else if(!wandRechts()){
                    dreheRechts();
                }else{
                    System.out.println("gefangen!");
                }
            }
            bewegen();
        }
        akkuAufnehmen();
        schraubeAblegen();
    }
    public void seite51DreiA(){
        bewegen();
        while(akkuAufFeld()){
            akkuAufnehmen();
            bewegen();
        }
    }
    public void seite51DreiB(){
        while(akkuAufFeld()){
            akkuAufnehmen();
            schraubeAblegen();
            bewegen();
        }
    }
    public void seite51DreiC(){
        while(!anGrenze()){
            bewegen();
            if(akkuAufFeld()){
                akkuAufnehmen();
                schraubeAblegen();
            }else {
                dreheRechts();
                dreheRechts();
                bewegen();
                dreheRechts();
            }
        }
    }
    /**
     * IF-Anweisungen Übungsfunktionen
     * 
    public void seiteVierzigDreiA(){
        if (wandRechts()){
            dreheRechts();
        }else {
            dreheLinks();
        }
    }
    public void seiteVierzigDreiB(){
        if(wandRechts()){
            bewegen();
        }
    }
    public void seiteVierzigDreiC(){
        if (wandRechts()){
            schraubeAblegen();
        }else{
            bewegen();
        }
    }
    public void seiteVierzigVier(){
        if(!wandLinks() && akkuAufFeld()){
            akkuAufnehmen();
            bewegen();
        }else {
            bewegen();
        }
    }
    public void seiteVierzigFunf(){
        if (akkuAufFeld() && wandVorne()){
            dreheLinks();
        } else if (akkuAufFeld()) {
            bewegen();
        }
    }
    */
}
