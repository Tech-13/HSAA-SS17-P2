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

}

class SimpleTableModel extends DefaultTableModel {

    private int rows = 21, cols = 5;
    int i;
   
    private Object[] rowData = new Object[cols];
    

    
    public SimpleTableModel() {
        super();
        initModelData();
    }

    private void initModelData() {
        int Zeile;

        
        /**"Erkennen" der Zeile
        switch (Feld) {
            case "1er":  Zeile = 1;
                     break;
            case "2er":  Zeile = 2;
                     break;
            case "3er":  Zeile = 3;
                     break;
            case "4er":  Zeile = 4;
                     break;
            case "5er":  Zeile = 5;
                     break;
            case "6er":  Zeile = 6;
                     break;
            case "3er-Pasch":  Zeile =10; 
                     break; 
            case "4er-Pasch":  Zeile =11; 
                     break;
            case "Full House":  Zeile =12; 
                     break;
            case "Kleine Straße":  Zeile =13;
                     break;
            case "Große Straße":  Zeile =14; 
                     break;
            case "Kniffel":  Zeile = 15;
                     break;
            case "Chance":  Zeile =16; 
                     break;                      
            default: Zeile = -1;
                     break;
        }
        */
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        //Spieleranzahl
        for (int i = 0; i < cols; i++) {
            this.addColumn(i + "Spieler");
        }


        //1er-6er
         for (int j = 0; j < 6; j++) {
            for (int i = 0; i < 1; i++) {
                rowData[i] = j+1 + "er";
            }
            this.addRow(rowData);
        }       
        //gesamt
         for (int j = 6; j < 7; j++) {
            for (int i = 0; i < 1; i++) {
                rowData[i] = "gesamt";
            }
            this.addRow(rowData);
        }         
        //Bonus
         for (int j = 7; j < 8; j++) {
            for (int i = 0; i < 1; i++) {
                rowData[i] = "Bonus bei 63 oder mehr";
            }
            this.addRow(rowData);
        }        
        //gesamt
         for (int j = 8; j < 9; j++) {
            for (int i = 0; i < 1; i++) {
                rowData[i] = "gesamt oberer Teil";
            }
            this.addRow(rowData);
        }        
        //Leerzeichen
         for (int j = 9; j < 10; j++) {
            for (int i = 0; i < 1; i++) {
                rowData[i] = "";
            }
            this.addRow(rowData);
        }        
        //Dreierpasch
         for (int j = 10; j < 11; j++) {
            for (int i = 0; i < 1; i++) {
                rowData[i] = "Dreierpasch";
            }
            this.addRow(rowData);
        }         
        //Viererpasch
         for (int j = 11; j < 12; j++) {
            for (int i = 0; i < 1; i++) {
                rowData[i] = "Viererpasch";
            }
            this.addRow(rowData);
        }        
        //Full House
         for (int j = 12; j < 13; j++) {
            for (int i = 0; i < 1; i++) {
                rowData[i] = "Full House";
            }
            this.addRow(rowData);
        }        
        //Kleine Straße
         for (int j = 13; j < 14; j++) {
            for (int i = 0; i < 1; i++) {
                rowData[i] = "Kleine Straße";
            }
            this.addRow(rowData);
        }        
        //Große Straße
         for (int j = 14; j < 15; j++) {
            for (int i = 0; i < 1; i++) {
                rowData[i] = "Große Straße";
            }
            this.addRow(rowData);
        }        
        //Kniffel
         for (int j = 15; j < 16; j++) {
            for (int i = 0; i < 1; i++) {
                rowData[i] = "Kniffel";
            }
            this.addRow(rowData);
        }         
        //Chance
         for (int j = 16; j < 17; j++) {
            for (int i = 0; i < 1; i++) {
                rowData[i] = "Chance";
            }
            this.addRow(rowData);
        }          
        //gesamt unten
         for (int j = 17; j < 18; j++) {
            for (int i = 0; i < 1; i++) {
                rowData[i] = "gesamt unterer Teil";
            }
            this.addRow(rowData);
        }        
        //gesamt oben
         for (int j = 18; j < 19; j++) {
            for (int i = 0; i < 1; i++) {
                rowData[i] = "gesamt oberer Teil";
            }
            this.addRow(rowData);
        }            
        //Endsumme
         for (int j = 19; j < 20; j++) {
            for (int i = 0; i < 1; i++) {
                rowData[i] = "Endsumme";
            }
            this.addRow(rowData);
        }        
        
        
        
        

        
        
    }
} 