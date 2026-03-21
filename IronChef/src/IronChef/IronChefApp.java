package IronChef;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;


public class IronChefApp extends JFrame implements ActionListener {
	
		ArrayList<Ingredient> inventory;
		
		Container c;
		
		JTextField nameBox = new JTextField(15);
		JTextField expMonthText = new JTextField(15);
		JTextField expDateText = new JTextField(15);
		JTextField expYearText = new JTextField(15);
		
		JTextArea messages = new JTextArea(8, 30);
		
		JScrollPane messagesScroll = new JScrollPane(messages);
		
		JButton add = new JButton("Add");
		JButton clear = new JButton("Clear");
		
	public IronChefApp() {
		
		inventory = new ArrayList<Ingredient>();
		
		c = getContentPane();	
		
		setSize(800, 500);
				
		JLabel headerTitle = new JLabel("IRON CHEF");
		
		JLabel name = new JLabel("Ingredient Name: ");
		
		JLabel exMonthLabel = new JLabel("Expiration Month: ");
		
		JLabel exDateLabel = new JLabel("Expiration Date: ");
		
		JLabel exDateYear = new JLabel("Expiration Year: ");
				
		JPanel header = new JPanel();
		header.add(headerTitle);
		header.setBorder(BorderFactory.createEmptyBorder(10, 5, 5, 5));
		
		JPanel centerPanel = new JPanel(new GridLayout(1, 2, 15, 15));
		JPanel inventoryForm = new JPanel(new GridLayout(5, 2, 10, 10));
		JPanel liveInventory = new JPanel();
		JPanel bottomPanel = new JPanel(new BorderLayout(10, 10));
		JPanel buttons = new JPanel();
		
		messages.setEditable(false);
		
		inventoryForm.add(name);
		inventoryForm.add(nameBox);
		inventoryForm.add(exMonthLabel);
		inventoryForm.add(expMonthText);
		inventoryForm.add(exDateLabel);
		inventoryForm.add(expDateText);
		inventoryForm.add(exDateYear);
		inventoryForm.add(expYearText);
		inventoryForm.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		
		centerPanel.add(inventoryForm);
		centerPanel.add(liveInventory);
		centerPanel.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 10));
		
		buttons.add(add);
		buttons.add(clear);
		
		bottomPanel.add(messagesScroll, BorderLayout.CENTER);
		
		bottomPanel.add(buttons, BorderLayout.SOUTH);
		bottomPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		
		
		
		c.setLayout(new BorderLayout());
		
		c.add(header, BorderLayout.NORTH);
		c.add(centerPanel, BorderLayout.CENTER);
		c.add(bottomPanel, BorderLayout.SOUTH);
				
		add.addActionListener(this);
		clear.addActionListener(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
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
			
		
		//System.out.println(inventory);
		
		
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
		
		
		//important objects
		    //recipe
			//ingredient
			//inventory
		
		//first lets allow for ingredients to be added to inventory
		
	}
	
}
