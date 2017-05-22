import java.util.*;
/**
 * Write a description of class Würfelbecher here.
 */
public class Würfelbecher
{
    private byte[] würfel;
    private boolean[]würfelb;
    private int punktzahl;
    int p = 0;
    int z;
    String x;

    /**
     * Erzeugt ein Array zum speichern der Werte der 5 Würfel
     */
    public Würfelbecher()
    {
        würfel = new byte[5];
        würfelb = new boolean[5];
       
    }

    public void würfeln()
    {
        if(würfelb[0] == false){würfel[0] = (byte)((Math.random()*6)+1);}    else{würfel[0] = würfel[0];}
        if(würfelb[1] == false){würfel[1] = (byte)((Math.random()*6)+1);}    else{würfel[1] = würfel[1];}
        if(würfelb[2] == false){würfel[2] = (byte)((Math.random()*6)+1);}    else{würfel[2] = würfel[2];}
        if(würfelb[3] == false){würfel[3] = (byte)((Math.random()*6)+1);}    else{würfel[3] = würfel[3];}
        if(würfelb[4] == false){würfel[4] = (byte)((Math.random()*6)+1);}    else{würfel[4] = würfel[4];}
        
        System.out.println(würfel[0]+" "+würfel[1]+" "+würfel[2]+" "+ würfel[3]+" "+würfel[4]+" ");
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
     * 
     */
    public int würfelMarkieren(int würfel)
    {
                switch (würfel) {
            case 1:  if(würfelb[0] == true){würfelb[0] = false;} else {würfelb[0] = true;}
                     break;
            case 2:  if(würfelb[1] == true){würfelb[0] = false;} else {würfelb[1] = true;}
                     break;
            case 3:  if(würfelb[2] == true){würfelb[0] = false;} else {würfelb[2] = true;}
                     break;
            case 4:  if(würfelb[3] == true){würfelb[0] = false;} else {würfelb[3] = true;}
                     break;
            case 5:  if(würfelb[4] == true){würfelb[0] = false;} else {würfelb[4] = true;} 
                     break;
            default: System.out.println("Fehler");
                     break;
        }
        return würfel;
    }

    

    
    /**   Methoden um alle Würfel  abzumarkieren */ 
    public boolean alleWürfelAbmarkieren()
    { würfelb[0] = false; würfelb[1] = false; würfelb[2] = false; würfelb[3] = false; würfelb[4] = false; 
      return würfelb[0] &&  würfelb[1] && würfelb[2] && würfelb[3] && würfelb[4];}  
    

    
    
    /**   Methode um Punkte einzutragen */    
    public String eintragen(String feld)
    {
        int laenge = feld.length();
        
        if(laenge == 3){
         StringBuilder builder = new StringBuilder(feld.substring(0, 1));
         int a = Integer.parseInt(builder.toString());        
         
        if(würfel[0] == a){p=p+a;}
        if(würfel[1] == a){p=p+a;}
        if(würfel[2] == a){p=p+a;}
        if(würfel[3] == a){p=p+a;}
        if(würfel[4] == a){p=p+a;}        
        
       } 
        //Eintragen der Punktzahl
        switch (feld) {
            case "1er":  punktzahl = p; z=1;
                     break;
            case "2er":  punktzahl = p; z=2;
                     break;
            case "3er":  punktzahl = p; z=3;
                     break;
            case "4er":  punktzahl = p; z=4;
                     break;
            case "5er":  punktzahl = p; z=5;
                     break;
            case "3er-Pasch":  for (byte i = 0; i < würfel.length; i++){punktzahl += würfel[i];} z=11;
                     break; 
            case "4er-Pasch":  for (byte i = 0; i < würfel.length; i++){punktzahl += würfel[i];} z=12; 
                     break;
            case "Full House":  punktzahl = 25; z=13;
                     break;
            case "Kleine Straße":  punktzahl = 30; z=14;
                     break;
            case "Große Straße":  punktzahl = 40; z=15;
                     break;
            case "Kniffel":  punktzahl = 50; z=16;
                     break;
            case "Chance":  for (byte i = 0; i < würfel.length; i++){punktzahl += würfel[i];} z=17;
                     break;                      
            default: punktzahl = -1;
                     break;
        }
    
        p=0;
        System.out.println(punktzahl);
        return feld;
    }    
   
    public int getPunktzahl(){
      System.out.println(punktzahl);
        return punktzahl;
    }    
    
    public int getWürfel0(){return würfel[0];}  
    public int getWürfel1(){return würfel[1];}
    public int getWürfel2(){return würfel[2];}
    public int getWürfel3(){return würfel[3];}
    public int getWürfel4(){return würfel[4];}
    
    



        
        
}
