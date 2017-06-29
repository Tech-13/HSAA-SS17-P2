package oldSwingGui;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*; // classes with "J"

public class Spielfeld extends JFrame {

  // declare controls referenced by more than one "block"
  static final ImageIcon[] IMAGES = new ImageIcon[] {
    new ImageIcon("pictures\\0.png"),
    new ImageIcon("pictures\\1.png"),
    new ImageIcon("pictures\\2.png"),
    new ImageIcon("pictures\\3.png"),
    new ImageIcon("pictures\\4.png"),
    new ImageIcon("pictures\\5.png"),
    new ImageIcon("pictures\\6.png"),
  };
  static final ImageIcon[] IMAGES_MARKED = new ImageIcon[] {
    new ImageIcon("pictures\\0m.png"),
    new ImageIcon("pictures\\1m.png"),
    new ImageIcon("pictures\\2m.png"),
    new ImageIcon("pictures\\3m.png"),
    new ImageIcon("pictures\\4m.png"),
    new ImageIcon("pictures\\5m.png"),
    new ImageIcon("pictures\\6m.png"),
  }; 
  
  JButton wurfeln;
  JButton wurf1;
  
  int Würfel1;
  public Spielfeld() {
    super("Spielfeld");
    setDefaultCloseOperation(EXIT_ON_CLOSE);

    // menubar comes first
    buildMenuBar();
    // then comes content in "reading-order" north-west-center-east-south
    Container contentPane = getContentPane();
    // north stuff
    contentPane.add(buildNorthPanel(), BorderLayout.NORTH);
    // west stuff
    contentPane.add(buildWestPanel(), BorderLayout.WEST);
    // center stuff
    contentPane.add(buildCenterPanel(), BorderLayout.CENTER);
    pack();
    setLocationRelativeTo(null); // center on screen (=relative to nothing)
  }

  public void buildMenuBar() {
    JMenuBar menuBar = new JMenuBar();
    
    
    JMenu aktionenMenu = new JMenu("Aktionen");
    JMenuItem wurfelnItem = new JMenuItem("Wurfeln");
    wurfelnItem.addActionListener((e) -> {System.out.println("Test");  });
    aktionenMenu.add(wurfelnItem);
    menuBar.add(aktionenMenu);
    
    JMenu markierenMenu = new JMenu("Markieren");
    JMenuItem EinserItem = new JMenuItem("Erster");
    EinserItem.addActionListener((e) -> JOptionPane.showMessageDialog(this, "Erster Wuerfel markiert"));
    markierenMenu.add(EinserItem);
    
    JMenuItem AbmarkierenItem = new JMenuItem("Alle abmarkieren");
    AbmarkierenItem.addActionListener((e) -> JOptionPane.showMessageDialog(this, "Alle Würfel abmarkiert"));
    markierenMenu.add(AbmarkierenItem);
    
    menuBar.add(markierenMenu);
    

    menuBar.add(Box.createGlue());
    JMenu helpMenu = new JMenu("Help");
    JMenuItem aboutItem = new JMenuItem("About");
    aboutItem.addActionListener((e) -> JOptionPane.showMessageDialog(this, "Beispiel für Vorlesung"));
    helpMenu.add(aboutItem);
    menuBar.add(helpMenu);
    setJMenuBar(menuBar);
  }

  public JPanel buildWestPanel() {
    
    JLabel imagelabels[] = new JLabel[5];
    
    JPanel west = new JPanel();
    west.setBackground(Color.GREEN);
    west.setLayout( new GridLayout( 6, 1, 1, 10));
    
    
    
    wurfeln = new JButton("Wurfeln");
    wurfeln.setEnabled(true);
    wurfeln.addActionListener((ActionEvent e) -> {
      for(int j=0; j<5; j++){
        int augenzahl = (int)((Math.random()*6)+1); System.out.println(augenzahl);
      imagelabels[j].setIcon(IMAGES[augenzahl]);
      }
    });
    west.add(wurfeln);
    
    for(int index=0; index<imagelabels.length; index++){
        int wuerfelNummer = index + 1;
        JLabel imagelabel = new JLabel(IMAGES[0]);
        imagelabel.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e)  {
             System.out.println("Würfel "+ wuerfelNummer +" markiert");
            }
        });
        west.add(imagelabel);
        imagelabels[index] = imagelabel;
    }
    
    
    
    
    
    
    
    
   

    
    
    
    
    return west;
  }

  public JPanel buildNorthPanel() {
    JPanel north = new JPanel();
    north.setBackground(Color.GREEN);
    
    
    
    
    
    return north;
  }

  public JPanel buildCenterPanel() {
    JPanel center = new JPanel();
    center.setBackground(Color.GREEN);
    
    
    String[] columnNames = {"First Name","Last Name", "Sport", "# of Years","Vegetarian"};
    
    
    Object[][] data = {
    {"Kathy", "Smith",
     "Snowboarding", new Integer(5), new Boolean(false)},
    {"John", "Doe",
     "Rowing", new Integer(3), new Boolean(true)},
    {"Sue", "Black",
     "Knitting", new Integer(2), new Boolean(false)},
    {"Jane", "White",
     "Speed reading", new Integer(20), new Boolean(true)},
    {"Joe", "Brown",
     "Pool", new Integer(10), new Boolean(false)}
};
   
   JTable table = new JTable(data, columnNames); 
   JScrollPane scrollPane = new JScrollPane(table);
   center.add(scrollPane); 
   center.setSize(3000, 150);
   center.setVisible(true);  
    
   
   center.add(table); 
    
    
    return center;
  }

  public static void main(String[] args) {
    new Spielfeld().setVisible(true);
    
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Object rowData[][] = { { " ", " ", " " },
        { " ", " ", " " } };
    Object columnNames[] = { "1.Spieler", "2.Spieler", "3Spieler" };
    JTable table = new JTable(rowData, columnNames);
    JScrollPane scrollPane = new JScrollPane(table);
    frame.add(scrollPane, BorderLayout.CENTER);
    frame.setSize(300, 150);
    frame.setVisible(true);
  
     
  
  }
}


