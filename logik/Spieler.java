package logik;
/**
 * Mit der Klasse Spieler kann für jeden am Spiel teilnehmenden Spieler ein Objekt erzeugt werden, 
 * in dem Daten wie Name und Aktivität gespeichert werden, und das die entsprechenden Methoden bereitstellt.
 */

public class Spieler
{
    private String name; //Name des Spielers
    private boolean aktivität; //Ist der jeweilige Spieler gerade an der Reihe oder nicht?
    
    public Spieler() //Aktivität des Spielers wird mit "nicht aktiv" initiiert
    {
        aktivität = false;
    }
    
    public void spielernameEingeben(String spielername) //Methode zum Eingeben des Spielernamens
    {
        name = spielername;
    }
    
    /** Methode zum Ausgeben des Spielernamens
     * 
     * public String spielernamenAusgeben()
       {
        return name;
       }
    */
   
    public void spielerAktiv() //Methode um die Aktivität des Spielers auf "an der Reihe" zu setzen
    {
        aktivität = true;
    }
    
    public void spielerNichtAktiv() //Methode um die Aktivität des Spielers auf "nicht an der Reihe" zu setzen
    {
        aktivität = false;
    }
    
    public boolean spielerAktivät() //Methode zum Feststellen ob Spieler aktiv ist oder nicht
    {
        return aktivität;
    }
    
}
