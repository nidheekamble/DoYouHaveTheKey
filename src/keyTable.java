import javax.swing.*; // JFrame and components
import java.awt.*; // for Font class(es)
import java.awt.event.*; // for actionListeners
import java.util.Random; // for image idices picked randomly
import java.util.Scanner;
import java.io.*;
import javax.swing.table.DefaultTableModel;
//import javax.swing.Timer;



public class keyTable extends JFrame implements ActionListener
{
	JLabel il, timer;
	Integer seconds = new Integer(300);
	ImageIcon i = new ImageIcon();
	JButton next, giveUp;
	JTextField tf;
	Font f = new Font("Helvlight", Font.BOLD, 18);
	int score=0;
	String[][] row = new String[11][5];   
	String column[]={"","","","",""}; 
	DefaultTableModel model = new DefaultTableModel(row, column);
	JTable table = new JTable(model);
	String n, temp;
	
	
	String[][] keywords = 
	{{"ABSTRACT", "ASSERT", "BOOLEAN", "BREAK", "BYTE"}, {"CASE", "CATCH", "CHAR", "CLASS", "CONTINUE"}, {"DEFAULT", "DO", "DOUBLE", "ELSE", "ENUM"}, {"EXTENDS", "FINAL", "FINALLY", "FLOAT", "FOR"}, {"IF", "IMLPEMENTS", "IMPORT", "INSTANCEOF", "INT"}, {"INERFACE", "LONG", "NATIVE", "NEW", "PACKAGE"}, {"PRIVATE", "PROTECTED", "PUBLIC", "RETURN", "SHORT"}, {"STATIC", "STRICTFP", "SUPER", "SWITCH", "SYNCHRONIZED"}, {"THIS", "THROW", "THROWS", "TRANSIENT", "TRY"}, {"VOID", "VOLATILE", "WHILE", "TRUE", "NULL"}, {"FALSE", "CONST", "GOTO"}};

	keyTable()
	{
		table.setRowHeight(30);
		table.setBounds(45,320,800,330); 
		table.setFont(f);
		
		add(table);
	    setSize(920,900);
	    setTitle("53 Keywords");
	    
	    /*
	    timer = new Timer(1000, this);
	    timer.setInitialDelay(pause);
	    timer.start(); 
	    new Timer(1000, taskPerformer).start();
	    */
	    
		i = new ImageIcon(getClass().getResource("fast.jpg"));
		il = new JLabel(i);
    	il.setBounds(0,0,900, 300);
    	add(il);
    	
    	tf = new JTextField();
    	tf.setBounds(45,700,300,50);
    	
    	next = new JButton("NEXT");
    	next.setBounds(360,700,100,50);
    	next.setFont(f);
    	giveUp = new JButton("I GIVE UP");
    	giveUp.setBounds(470,700,200,50);
    	giveUp.setFont(f);
    	
    	next.addActionListener(this);
    	giveUp.addActionListener(this);
    	
    	timer = new JLabel(seconds.toString());
    	timer.setFont(new Font("Helvlight", Font.BOLD, 50));
    	timer.setBounds(740,690,150,75);
    	
    	add(timer);
    	add(tf);
    	add(next);
    	add(giveUp);
	    setLayout(null);
	    setLocation(690,230);
	    setVisible(true);  // frame visible hai (how stupid)
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		
    	if(e.getSource()==next)
        {
    		n = tf.getText().toUpperCase();
            int i=0, j;
            while(i<11)
            {
            	j=0;
            	while(j<5)
            	{
            		temp = (keywords[i][j]).toString(); 
	            	if((temp).equals(n))
	            	{
	            		score++;
	            		n = n.toLowerCase();
	            		model.setValueAt((tf.getText().toUpperCase()),1,1);
	            		tf.setText("");
	            		break;
	            	}
    				j++;
            	}
            	i++;
            }
        }
    	
    	if(e.getSource()==giveUp)
        {
    		int i, j;
            for(i=0; i<11; i++)
            {
            	for(j=0;j<5;j++)
            	{
            		String temp = (keywords[i][j]).toString().toLowerCase(); 
	            	model.setValueAt(temp,i,j);
            	}
            }
    		JOptionPane.showMessageDialog(this,"You got "+score+" of them. Try again?");
        }
    }
	public static void main(String args[])
	{
		new keyTable();
	}
}
