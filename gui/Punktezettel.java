package gui;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import logik.Würfelbecher;

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



}

