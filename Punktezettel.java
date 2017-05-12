import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class Punktezettel extends JFrame {

    private final int small = 50;
    private final int big = 120;

    private JTable table;
    private Würfelbecher w = new Würfelbecher(); 
    
    public Punktezettel() {
        table = new JTable(new SimpleTableModel());
        setColumnWidth();
        JScrollPane sPane = new JScrollPane(table);

        getContentPane().add(sPane);
        this.setSize(400, 382);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void setColumnWidth() {
        for (int i = 0; i < table.getColumnCount(); i++) {
            TableColumn c = table.getColumnModel().getColumn(i);
            switch (i) {
            case 0:
                c.setPreferredWidth(big);
                break;

            default:
                c.setPreferredWidth(JTable.AUTO_RESIZE_ALL_COLUMNS);
            }
        }
    }

    public static void main(String[] args) {
        new Punktezettel();
    }

    /**   Methode um Punkte einzutragen */    
    public String eintragen(String Feld)
    {
        int Würfel1 = w.getWürfel1();
        int Würfel2 = w.getWürfel2();
        int Würfel3 = w.getWürfel3();
        int Würfel4 = w.getWürfel4();
        int Würfel5 = w.getWürfel5();
        int Würfel6 = w.getWürfel6();
        
        int laenge = Feld.length();
        int Punktzahl;
        int p = 0;
        int z;
        if(laenge == 3){
         StringBuilder builder = new StringBuilder(Feld.substring(0, 1));
         int a = Integer.parseInt(builder.toString());        
         
        if(Würfel1 == a){p=p+a;}
        if(Würfel2 == a){p=p+a;}
        if(Würfel3 == a){p=p+a;}
        if(Würfel4 == a){p=p+a;}
        if(Würfel5 == a){p=p+a;}
        if(Würfel6 == a){p=p+a;}        
        
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
            case "3er-Pasch":  Punktzahl = Würfel1 + Würfel2 + Würfel3 + Würfel4 + Würfel5 + Würfel6; z=11;
                     break; 
            case "4er-Pasch":  Punktzahl = Würfel1 + Würfel2 + Würfel3 + Würfel4 + Würfel5 + Würfel6; z=12; 
                     break;
            case "Full House":  Punktzahl = 25; z=13;
                     break;
            case "Kleine Straße":  Punktzahl = 30; z=14;
                     break;
            case "Große Straße":  Punktzahl = 40; z=15;
                     break;
            case "Kniffel":  Punktzahl = 50; z=16;
                     break;
            case "Chance":  Punktzahl = Würfel1 + Würfel2 + Würfel3 + Würfel4 + Würfel5 + Würfel6; z=17;
                     break;                      
            default: Punktzahl = -1;
                     break;
        }
    
        p=0;
        System.out.println(Punktzahl);
        return Feld;
    } 
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int sampleMethod()
    {
        int Würfel1 = w.getWürfel1();
        System.out.println(Würfel1);
        return Würfel1;
    }

}

