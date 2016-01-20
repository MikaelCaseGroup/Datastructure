package p2;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * UI klass för att testa klassen hashtable. Systemet fungerar genom att mata in nyckelord som
 * exempelvis hej för att få fram value (fungerar som översättning). Det finns möjlighet att söka 
 * igenom hela hashtable med show, och delete kommer att radera nyckelordet som finns inmatat i 
 * textfältet. 
 * @author mikaelhorvath
 *
 */
public class HashUI extends JPanel implements ActionListener {
	private Hashtable table = new Hashtable(15); // Skapar vår hashtable här
	private JTextField txtField = new JTextField();
	private JButton search = new JButton("Search");
	private JButton show = new JButton("Show");
	private JButton delete = new JButton("Delete");
	private JLabel lbl = new JLabel("");
	
	/**
	 * Konstruktorn designar upp systemet samt anropar metoden fillTable() som fyller
	 * vår hashtable med data. 
	 */
	public HashUI(){
		setLayout(null);
		setPreferredSize(new Dimension(380,160));
		
		fillTable(); // Fyller vår Hashtable
		
		txtField.setBounds(3, 3, 375, 35);
		search.setBounds(3, 45, 120, 45);
		show.setBounds(255, 45, 120, 45);
		delete.setBounds(129, 45, 120, 45);
		lbl.setBounds(3, 110, 250, 45);
		
		search.addActionListener(this);
		show.addActionListener(this);
		delete.addActionListener(this);
		
		add(txtField);
		add(search);
		add(show);
		add(delete);
		add(lbl);
	}
	
	/**
	 * Metod som fyller hashtable med data
	 */
	public void fillTable(){
		table.put("hej", "hello");
		table.put("nej", "no");
		table.put("senare", "later");
		table.put("idag", "today");
		table.put("igår", "yesterday");
	}
	
	/**
	 * Main-metoden skapar vårt Frame där komponenten JPanel (HashUI) läggs till
	 * @param args
	 */
	public static void main(String[] args) {	
		HashUI ui = new HashUI();
		JFrame frame = new JFrame();
		frame.add(ui);
		frame.pack();
		frame.setTitle("Hashtable Test");
		frame.setResizable(false);
		frame.setVisible(true);
	}


	/**
	 * actionPerformed() hanterar våra knapptryck i UI:et. Med hjälp av dom olika knappar som finns
	 * utförs olika operationer emot klassen Hashtable. 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == search){
			String str = txtField.getText();
			lbl.setText((String)table.get(str));
		}
		
		if(e.getSource() == show){
			System.out.println("---- Följande ord finns ----");
			System.out.println(table.getInsertionOrder());
			System.out.println("----------------------------");
		}
		
		if(e.getSource() == delete){
			String str = txtField.getText();
			table.remove(str);
			lbl.setText(str+" "+"was removed!");
		}
	}
}
