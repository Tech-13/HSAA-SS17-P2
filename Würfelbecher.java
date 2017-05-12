import java.util.*;
/**
 * Write a description of class Würfelbecher here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Würfelbecher
{
    // instance variables - replace the example below with your own
    private int Würfel1;    private int Würfel2;    private int Würfel3;    private int Würfel4;    private int Würfel5;    private int Würfel6;
    private boolean Würfel1b;    private boolean Würfel2b;    private boolean  Würfel3b;    private boolean  Würfel4b;    private boolean  Würfel5b;    private boolean  Würfel6b;
    private int Punktzahl;
    int p = 0;
    /**
     * Constructor for objects of class Würfelbecher
     */
    public Würfelbecher()
    {
        // initialise instance variables
       
    }

    /**   Methode um zu Würfeln   */ 
    public void würfeln()
    {
        // put your code here
        if(Würfel1b == false){Würfel1 = (int)((Math.random()*6)+1);}    else{Würfel1 = Würfel1;}
        if(Würfel2b == false){Würfel2 = (int)((Math.random()*6)+1);}    else{Würfel2 = Würfel2;}
        if(Würfel3b == false){Würfel3 = (int)((Math.random()*6)+1);}    else{Würfel3 = Würfel3;}
        if(Würfel4b == false){Würfel4 = (int)((Math.random()*6)+1);}    else{Würfel4 = Würfel4;}
        if(Würfel5b == false){Würfel5 = (int)((Math.random()*6)+1);}    else{Würfel5 = Würfel5;}
        if(Würfel6b == false){Würfel6 = (int)((Math.random()*6)+1);}    else{Würfel6 = Würfel6;}
        System.out.println(
        Würfel1+" "+
        Würfel2+" "+
        Würfel3+" "+
        Würfel4+" "+
        Würfel5+" "+
        Würfel6+" ");
        return;      
    }
     
    
    /**   Methoden um einzelne Würfel  anzumarkieren */
    public boolean Würfel_1_markieren()
    { Würfel1b = true;   return Würfel1b; }    
    public boolean Würfel_2_markieren()
    { Würfel2b = true;   return Würfel2b; }       
    public boolean Würfel_3_markieren()
    { Würfel3b = true;   return Würfel3b; }       
    public boolean Würfel_4_markieren()
    { Würfel4b = true;   return Würfel4b; }       
    public boolean Würfel_5_markieren()
    { Würfel5b = true;   return Würfel5b; }       
    public boolean Würfel_6_markieren()
    { Würfel6b = true;   return Würfel6b; }   
    
    /**   Methoden um einzelne Würfel  abzumarkieren */
    public boolean Würfel_1_abmarkieren()
    { Würfel1b = false;   return Würfel1b; }    
    public boolean Würfel_2_abmarkieren()
    { Würfel2b = false;   return Würfel2b; }       
    public boolean Würfel_3_abmarkieren()
    { Würfel3b = false;   return Würfel3b; }       
    public boolean Würfel_4_abmarkieren()
    { Würfel4b = false;   return Würfel4b; }       
    public boolean Würfel_5_abmarkieren()
    { Würfel5b = false;   return Würfel5b; }       
    public boolean Würfel_6_abmarkieren()
    { Würfel6b = false;   return Würfel6b; }   
    
    
    /**   Methoden um alle Würfel  abzumarkieren */ 
    public boolean Alle_Würfel_abmarkieren()
    { Würfel1b = false; Würfel2b = false; Würfel3b = false; Würfel4b = false; Würfel5b = false; Würfel6b = false; 
      return Würfel1b &&  Würfel2b && Würfel3b && Würfel4b && Würfel5b && Würfel6b;}  
    

    
    
    /**   Methode um Punkte einzutragen */    
    public String eintragen(String Feld)
    {
        
        StringBuilder builder = new StringBuilder(Feld.substring(0, 1));
        int a = Integer.parseInt(builder.toString());        
        
        if(Würfel1 == a){p=p+a;}
        if(Würfel2 == a){p=p+a;}
        if(Würfel3 == a){p=p+a;}
        if(Würfel4 == a){p=p+a;}
        if(Würfel5 == a){p=p+a;}
        if(Würfel6 == a){p=p+a;}        
        
        
        //Eintragen der Punktzahl
        switch (Feld) {
            case "1er":  Punktzahl = p;
                     break;
            case "2er":  Punktzahl = p;
                     break;
            case "3er":  Punktzahl = p;
                     break;
            case "4er":  Punktzahl = p;
                     break;
            case "5er":  Punktzahl = p;
                     break;
            case "6er":  Punktzahl = p;
                     break;
            case "Pasch":  Punktzahl = Würfel1 + Würfel2 + Würfel3 + Würfel4 + Würfel5 + Würfel6;
                     break;
            case "3er-Pasch":  Punktzahl = Würfel1 + Würfel2 + Würfel3 + Würfel4 + Würfel5 + Würfel6;
                     break; 
            case "4er-Pasch":  Punktzahl = Würfel1 + Würfel2 + Würfel3 + Würfel4 + Würfel5 + Würfel6;
                     break;
            case "Kleine Straße":  Punktzahl = 30;
                     break;
            case "Große Straße":  Punktzahl = 40;
                     break;
            case "Full House":  Punktzahl = 25;
                     break;
            case "Kniffel":  Punktzahl = 50;
                     break;
            case "Chance":  Punktzahl = Würfel1 + Würfel2 + Würfel3 + Würfel4 + Würfel5 + Würfel6;
                     break;                      
            default: Punktzahl = -1;
                     break;
        }
        
       p=0;
        
        System.out.println(Punktzahl);
        return Feld;
    }    
        
       

        
        
        
}
