/**
 * Write a description of class Leben here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Leben  
{
    // instance variables - replace the example below with your own
    private int AnzahlLeben;

    /**
     * Constructor for objects of class Leben
     */
    public Leben()
    {
        AnzahlLeben = 3;
    }
    public void verringern()
    {
        AnzahlLeben--;
    }
    public void vergroﬂern(){
        AnzahlLeben++;
    }
    public int getLeben(){
        return AnzahlLeben;
    }
}
