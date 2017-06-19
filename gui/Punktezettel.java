import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
class SimpleTableModel extends DefaultTableModel {
    private int rows = 21, cols = 5;
    int i;
    private Object[] rowData = new Object[cols];
    public SimpleTableModel() {
        super();
        Punktetabelle();
    }
    //Punktetabelle mit Punktebeschriftungen
    private void Punktetabelle() {

        for (int i = 0; i < cols; i++) {
            this.addColumn(i + "Spieler");
        }

        String[] Punktebeschreibung = {"1er", "2er", "3er", "4er", "5er", "6er", "gesamt", "Bonus", "gesamt oben", "", "Dreierpasch", "Viererpasch", "Full House", "Kleine Strasse", "Grosse Strasse", "Kniffel", "Chance", "Gesamt unten", "Gesamt oben", "Endsumme"};
        for(int j =0; j < Punktebeschreibung.length; j++)
        {rowData[0] = Punktebeschreibung[j];
        this.addRow(rowData);
        }

    }
} 

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

