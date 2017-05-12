import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn; 
public class Punktezettel extends JFrame {

    private final int small = 50;
    private final int big = 150;

    private JTable table;

    public Punktezettel() {
        table = new JTable(new SimpleTableModel());
        setColumnWidth();
        JScrollPane sPane = new JScrollPane(table);

        getContentPane().add(sPane);
        this.setSize(600, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void setColumnWidth() {
        for (int i = 0; i < table.getColumnCount(); i++) {
            TableColumn c = table.getColumnModel().getColumn(i);
            switch (i) {
            case 1:
                c.setPreferredWidth(JTable.AUTO_RESIZE_ALL_COLUMNS);
                break;
            case 2:
                c.setPreferredWidth(JTable.AUTO_RESIZE_ALL_COLUMNS);
                break;
            case 3:
                c.setPreferredWidth(JTable.AUTO_RESIZE_ALL_COLUMNS);
                break;
            case 4:
                c.setPreferredWidth(JTable.AUTO_RESIZE_ALL_COLUMNS);
                break;
            default:
                c.setPreferredWidth(small);
            }
        }
    }

    public static void main(String[] args) {
        new Punktezettel();
    }

}

class SimpleTableModel extends DefaultTableModel {

    private int rows = 30, cols = 5;
    
    private Object[] rowData = new Object[cols];

    public SimpleTableModel() {
        super();
        initModelData();
    }

    private void initModelData() {
        
        for (int i = 0; i < cols; i++) {
            this.addColumn(Integer.toString(i));
        }

      
        for (int j = 0; j < 1; j++) {
            for (int i = 1; i < cols; i++) {
                rowData[i] = i +". Spieler";
            }
            this.addRow(rowData);
        }
        
        
        
       
        
        
        

        
 

    }
} 
