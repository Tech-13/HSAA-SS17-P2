package logik;

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
    	for (int i = 0; i < würfel.length; i++) {
			if (!würfelb[i]) {
				würfel[i] = (byte)((Math.random()*5)+1);
			}
		}
    }

    public void würfelMarkieren(int nr)
    {
    	if (nr >= 0 && nr < würfelb.length)
    		würfelb[nr] = true;
    	else
    		System.out.println("Fehler: Würfel existiert nicht");
    }

    

    
    /**   Methoden um alle Würfel  abzumarkieren */ 
    public void alleWürfelAbmarkieren() {
    	for (int i = 0; i < würfelb.length; i++) {
			würfelb[i] = false;
		}
    }
    
  
    public int getWürfel(int nr) {
    	if (nr >= 0 && nr < würfel.length)
    		return würfel[nr];
    	else
    		return -1;
    }
    
    public byte[] getAlleWürfel() {
    	return würfel;
    }
        
        
}
