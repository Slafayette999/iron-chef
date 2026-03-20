package IronChef;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;


public class IronChefApp extends JFrame implements ActionListener {
	
		ArrayList<Ingredient> inventory;
	
		JLabel name = new JLabel("Name of ingredient: ");
		JTextField nameBox = new JTextField(15);
	
		JLabel exMonthLabel = new JLabel("Enter Expiration Month: ");
		JTextField expMonthText = new JTextField(15);
		
		JLabel exDateLabel = new JLabel("Enter Expiration Date: ");
		JTextField expDateText = new JTextField(15);
		
		JLabel exDateYear = new JLabel("Enter Expiration Year: ");
		JTextField expYearText = new JTextField(15);
		
		JButton add = new JButton("Add");
		JButton clear = new JButton("Clear");
		
				
		Container c;
		
	public IronChefApp() {
		 inventory = new ArrayList<Ingredient>();
		c = getContentPane();
		setSize(600, 300);
		c.setLayout(new FlowLayout());
		c.setVisible(true);
		
		c.add(name);
		c.add(nameBox);
		c.add(exMonthLabel);
		c.add(expMonthText);
		c.add(exDateLabel);
		c.add(expDateText);
		c.add(exDateYear);
		c.add(expYearText);
		
		c.add(add);
		c.add(clear);
		
		add.addActionListener(this);
		clear.addActionListener(this);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == add) {
			
			String ingredientName = nameBox.getText();
			
			String expirationMonth = expMonthText.getText();
			
			int expirationDate = Integer.parseInt(expDateText.getText());
			
			int expirationYear = Integer.parseInt(expYearText.getText());
			
			addIngredient(ingredientName, expirationMonth, expirationDate, expirationYear);	
		
		}
		else if (e.getSource() == clear) {
			
			clearFields();
			
		}
		
		
		
		
		
		System.out.println(inventory);
		
		
	}
	
	public void addIngredient(String ingredientName, String expirationMonth, int expirationDate, int expirationYear) {
			
		Ingredient newIngredient = new Ingredient(ingredientName, expirationMonth, expirationDate, expirationYear);
		
		inventory.add(newIngredient);	
	}
		
	
	public void clearFields() {
		
		nameBox.setText("");
		expMonthText.setText("");
		expDateText.setText("");
		expYearText.setText("");
		
	}
	
	
	public static void main(String[] args) {
	
		IronChefApp icApp = new IronChefApp();
		
		icApp.setVisible(true);
		
		//important objects
		    //recipe
			//ingredient
			//inventory
		
		//first lets allow for ingredients to be added to inventory
		
	}
	
}
