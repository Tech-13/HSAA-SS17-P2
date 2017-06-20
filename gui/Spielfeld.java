
import java.awt.*;
import java.awt.event.*;
import javax.swing.*; // classes with "J"

public class Spielfeld extends JFrame {

  // declare controls referenced by more than one "block"
  JButton wurfeln;
  JButton wurf1;
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
    JPanel west = new JPanel();
    west.setBackground(Color.GREEN);
    return west;
  }

  public JPanel buildNorthPanel() {
    JPanel north = new JPanel();
    north.setBackground(Color.GREEN);
    
    wurfeln = new JButton("Wurfeln");
    wurfeln.setEnabled(true);
    wurfeln.addActionListener((ActionEvent e) -> {
      System.out.println("gewurfelt");
    });
    north.add(wurfeln);
    
 
    
    return north;
  }

  public JPanel buildCenterPanel() {
    JPanel center = new JPanel();
     center.setBackground(Color.GREEN);
    
    ImageIcon image = new ImageIcon("C:\\Users\\balut\\Documents\\NetBeansProjects\\wurfeltest\\pictures\\1.png");
    JLabel imagelabel = new JLabel(image);
    imagelabel.addMouseListener(new MouseAdapter(){
    public void mouseClicked(MouseEvent e)  {
     System.out.println("Würfel 1 markiert");}});
    
    
    ImageIcon image2 = new ImageIcon("C:\\Users\\balut\\Documents\\NetBeansProjects\\wurfeltest\\pictures\\2.png");
    JLabel imagelabel2 = new JLabel(image2);
    imagelabel2.addMouseListener(new MouseAdapter(){
    public void mouseClicked(MouseEvent e)  {
     System.out.println("Würfel 2 markiert");}});
    
    ImageIcon image3 = new ImageIcon("C:\\Users\\balut\\Documents\\NetBeansProjects\\wurfeltest\\pictures\\3.png");
    JLabel imagelabel3 = new JLabel(image3);
    imagelabel3.addMouseListener(new MouseAdapter(){
    public void mouseClicked(MouseEvent e)  {
     System.out.println("Würfel 3 markiert");}});
    
    
    ImageIcon image4 = new ImageIcon("C:\\Users\\balut\\Documents\\NetBeansProjects\\wurfeltest\\pictures\\4.png");
    JLabel imagelabel4 = new JLabel(image4);
    imagelabel4.addMouseListener(new MouseAdapter(){
    public void mouseClicked(MouseEvent e)  {
     System.out.println("Würfel 4 markiert");}});
    
    
    ImageIcon image5 = new ImageIcon("C:\\Users\\balut\\Documents\\NetBeansProjects\\wurfeltest\\pictures\\5.png");
    JLabel imagelabel5 = new JLabel(image5);
    imagelabel5.addMouseListener(new MouseAdapter(){
    public void mouseClicked(MouseEvent e)  {
     System.out.println("Würfel 5 markiert");}});
    
    
    ImageIcon image6 = new ImageIcon("C:\\Users\\balut\\Documents\\NetBeansProjects\\wurfeltest\\pictures\\6.png");
    JLabel imagelabel6 = new JLabel(image6);
    imagelabel6.addMouseListener(new MouseAdapter(){
    public void mouseClicked(MouseEvent e)  {
     System.out.println("Würfel 6 markiert");}});
    
    
    
   
    
    center.add(imagelabel);
    center.add(imagelabel2);
    center.add(imagelabel3);
    center.add(imagelabel4);
    center.add(imagelabel5);
    
    return center;
  }

  public static void main(String[] args) {
    new FirstWindow().setVisible(true);
    
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


