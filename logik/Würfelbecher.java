package logik;

import java.util.*;
/**
 * Write a description of class Würfelbecher here.
 */
public class Würfelbecher
{
    private byte[] würfel;
    private boolean[] würfelMarkiert;

    /**
     * Erzeugt ein Array zum speichern der Werte der 5 Würfel
     */
    public Würfelbecher()
    {
        würfel = new byte[5];
        würfelMarkiert = new boolean[5];
       
    }

    public void würfeln()
    {
    	for (int i = 0; i < würfel.length; i++) {
			if (!würfelMarkiert[i]) {
				würfel[i] = (byte)((Math.random()*6)+1);
			}
		}
    }

    public void würfelMarkieren(int nr)
    {
    	if (nr >= 0 && nr < würfelMarkiert.length)
    		würfelMarkiert[nr] = true;
    	else
    		System.out.println("Fehler: Würfel existiert nicht");
    }

    

    public void alleWürfelAbmarkieren() {
    	for (int i = 0; i < würfelMarkiert.length; i++) {
			würfelMarkiert[i] = false;
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
