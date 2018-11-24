import javax.swing.*; // JFrame and components
import java.awt.*; // for Font class(es)
import java.awt.event.*; // for actionListeners
import java.util.Random; // for image idices picked randomly
import java.util.Scanner;
import java.io.*;
import javax.swing.table.DefaultTableModel;



public class keyTable extends JFrame implements ActionListener
{
	JLabel il;
	ImageIcon i = new ImageIcon();
	JButton next, giveUp;
	JTextField tf;
	String[][] row = new String[11][5];   
	String column[]={"","","","",""}; 
	DefaultTableModel model = new DefaultTableModel(row, column);
	JTable table = new JTable(model);
	
	String[][] keywords = 
	{{"ABSTRACT", "ASSERT", "BOOLEAN", "BREAK", "BYTE"}, {"CASE", "CATCH", "CHAR", "CLASS", "CONTINUE"}, {"DEFAULT", "DO", "DOUBLE", "ELSE", "ENUM"}, {"EXTENDS", "FINAL", "FINALLY", "FLOAT", "FOR"}, {"IF", "IMLPEMENTS", "IMPORT", "INSTANCEOF", "INT"}, {"INERFACE", "LONG", "NATIVE", "NEW", "PACKAGE"}, {"PRIVATE", "PROTECTED", "PUBLIC", "RETURN", "SHORT"}, {"STATIC", "STRICTFP", "SUPER", "SWITCH", "SYNCHRONIZED"}, {"THIS", "THROW", "THROWS", "TRANSIENT", "TRY"}, {"VOID", "VOLATILE", "WHILE", "TRUE", "NULL"}, {"FALSE", "CONST", "GOTO"}};

	keyTable()
	{
		table.setRowHeight(30);
		table.setBounds(45,320,800,330);    
		add(table);
	    setSize(920,900);
	    setTitle("53 Keywords");
	    
		i = new ImageIcon(getClass().getResource("fast.jpg"));
		il = new JLabel(i);
    	il.setBounds(0,0,900, 300);
    	add(il);
    	
    	tf = new JTextField();
    	tf.setBounds(45,680,300,50);
    	
    	next = new JButton("Next");
    	next.setBounds(360,680,100,50);
    	giveUp = new JButton("I give up");
    	giveUp.setBounds(470,680,200,50);
    	
    	next.addActionListener(this);
    	giveUp.addActionListener(this);
    	
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
    		String n = tf.getText().toUpperCase();
            int i, j;
            for(i=0; i<11; i++)
            {
            	for(j=0;j<5;j++)
            	{
	            	if((keywords[i][j]).equals(n))
	            	{
	            		n = n.toLowerCase();
	            		model.setValueAt(n,i,j);
	            		break;
	            	}
            	}
            }
            
        }
    	
    	if(e.getSource()==giveUp)
        {
    		JOptionPane.showMessageDialog(this,"You got these many right. Try again?");
        }
    }
	public static void main(String args[])
	{
		new keyTable();
	}
}
