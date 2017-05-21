import java.util.*;
/**
 * Write a description of class Würfelbecher here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Würfelbecher
{
    private byte[] würfel;
    private boolean Würfel1b;    private boolean Würfel2b;    private boolean  Würfel3b;    private boolean  Würfel4b;    private boolean  Würfel5b;    private boolean  Würfel6b;
    private int Punktzahl;
    int p = 0;
    int z;
    String x;

    /**
     * Constructor for objects of class Würfelbecher
     */
    public Würfelbecher()
    {
        würfel = new byte[6];
       
    }

    public void würfeln()
    {
        if(Würfel1b == false){würfel[0] = (byte)((Math.random()*6)+1);}    else{würfel[0] = würfel[0];}
        if(Würfel2b == false){würfel[1] = (byte)((Math.random()*6)+1);}    else{würfel[1] = würfel[1];}
        if(Würfel3b == false){würfel[2] = (byte)((Math.random()*6)+1);}    else{würfel[2] = würfel[2];}
        if(Würfel4b == false){würfel[3] = (byte)((Math.random()*6)+1);}    else{würfel[3] = würfel[3];}
        if(Würfel5b == false){würfel[4] = (byte)((Math.random()*6)+1);}    else{würfel[4] = würfel[4];}
        if(Würfel6b == false){würfel[5] = (byte)((Math.random()*6)+1);}    else{würfel[5] = würfel[5];}
        
        System.out.println(würfel[0]+" "+würfel[1]+" "+würfel[2]+" "+ würfel[3]+" "+würfel[4]+" "+würfel[5]+" ");
        return;      
    }
     
    /**   Methoden um einzelne Würfel  an bzw abzumarkieren 
     * 
    public boolean Würfel_1_markieren()
    { if(Würfel1b == true){Würfel1b = false;} else {Würfel1b = true;}  return Würfel1b; }    
    public boolean Würfel_2_markieren()
    { if(Würfel2b == true){Würfel1b = false;} else {Würfel2b = true;}  return Würfel2b; }       
    public boolean Würfel_3_markieren()
    { if(Würfel3b == true){Würfel1b = false;} else {Würfel3b = true;}  return Würfel3b; }       
    public boolean Würfel_4_markieren()
    { if(Würfel4b == true){Würfel1b = false;} else {Würfel4b = true;}  return Würfel4b; }       
    public boolean Würfel_5_markieren()
    { if(Würfel5b == true){Würfel1b = false;} else {Würfel5b = true;}  return Würfel5b; }       
    public boolean Würfel_6_markieren()
    { if(Würfel6b == true){Würfel1b = false;} else {Würfel6b = true;}  return Würfel6b; }       
    
    */
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int Würfel_markieren(int Würfel)
    {
                switch (Würfel) {
            case 1:  if(Würfel1b == true){Würfel1b = false;} else {Würfel1b = true;}
                     break;
            case 2:  if(Würfel2b == true){Würfel1b = false;} else {Würfel2b = true;}
                     break;
            case 3:  if(Würfel3b == true){Würfel1b = false;} else {Würfel3b = true;}
                     break;
            case 4:  if(Würfel4b == true){Würfel1b = false;} else {Würfel4b = true;}
                     break;
            case 5:  if(Würfel5b == true){Würfel1b = false;} else {Würfel5b = true;} 
                     break;
            case 6:  if(Würfel6b == true){Würfel1b = false;} else {Würfel6b = true;}
                     break;                     
            default: System.out.println("Fehler");
                     break;
        }
        return Würfel;
    }

    

    
    /**   Methoden um alle Würfel  abzumarkieren */ 
    public boolean Alle_Würfel_abmarkieren()
    { Würfel1b = false; Würfel2b = false; Würfel3b = false; Würfel4b = false; Würfel5b = false; Würfel6b = false; 
      return Würfel1b &&  Würfel2b && Würfel3b && Würfel4b && Würfel5b && Würfel6b;}  
    

    
    
    /**   Methode um Punkte einzutragen */    
    public String eintragen(String Feld)
    {
        int laenge = Feld.length();
        
        if(laenge == 3){
         StringBuilder builder = new StringBuilder(Feld.substring(0, 1));
         int a = Integer.parseInt(builder.toString());        
         
        if(würfel[0] == a){p=p+a;}
        if(würfel[1] == a){p=p+a;}
        if(würfel[2] == a){p=p+a;}
        if(würfel[3] == a){p=p+a;}
        if(würfel[4] == a){p=p+a;}
        if(würfel[5] == a){p=p+a;}        
        
       } 
        //Eintragen der Punktzahl
        switch (Feld) {
            case "1er":  Punktzahl = p; z=1;
                     break;
            case "2er":  Punktzahl = p; z=2;
                     break;
            case "3er":  Punktzahl = p; z=3;
                     break;
            case "4er":  Punktzahl = p; z=4;
                     break;
            case "5er":  Punktzahl = p; z=5;
                     break;
            case "6er":  Punktzahl = p; z=6;
                     break;
            case "3er-Pasch":  for (byte i = 0; i < würfel.length; i++){Punktzahl += würfel[i];} z=11;
                     break; 
            case "4er-Pasch":  for (byte i = 0; i < würfel.length; i++){Punktzahl += würfel[i];} z=12; 
                     break;
            case "Full House":  Punktzahl = 25; z=13;
                     break;
            case "Kleine Straße":  Punktzahl = 30; z=14;
                     break;
            case "Große Straße":  Punktzahl = 40; z=15;
                     break;
            case "Kniffel":  Punktzahl = 50; z=16;
                     break;
            case "Chance":  for (byte i = 0; i < würfel.length; i++){Punktzahl += würfel[i];} z=17;
                     break;                      
            default: Punktzahl = -1;
                     break;
        }
    
        p=0;
        System.out.println(Punktzahl);
        return Feld;
    }    
   
    public int getPunktzahl(){
      System.out.println(Punktzahl);
        return Punktzahl;
    }    
    
    public int getWürfel1(){return würfel[0];}  
    public int getWürfel2(){return würfel[1];}
    public int getWürfel3(){return würfel[2];}
    public int getWürfel4(){return würfel[3];}
    public int getWürfel5(){return würfel[4];}
    public int getWürfel6(){return würfel[5];}
    



        
        
}
