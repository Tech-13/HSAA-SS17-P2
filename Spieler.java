

public class Spieler
{
    private String name;
    private boolean aktivität;
    
    public Spieler()
    {
        aktivität = false;
    }
    
    public void spielernameEingeben(String spielername)
    {
        name = spielername;
    }
    
    public String spielernamenAusgeben()
    {
        return name;
    }
    
    public void spielerAktiv()
    {
        aktivität = true;
    }
    
    public void spielerNichtAktiv()
    {
        aktivität = false;
    }
    
    public boolean spielerAktivät()
    {
        return aktivität;
    }
    
}
