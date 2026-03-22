package IronChef;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.ListSelectionListener;


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
		
		String[] inventoryColumns = {"Name", "Exp Month", "Exp Date", "Exp Year"};
		
		DefaultTableModel inventoryModel = new DefaultTableModel(inventoryColumns, 0) {
		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
			}
		};
		
			
		JTable inventoryTable = new JTable(inventoryModel);
		
		
		
		JScrollPane inventoryScroll = new JScrollPane(inventoryTable);
		
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
		JPanel liveInventory = new JPanel(new BorderLayout());
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
		
		inventoryTable.setAutoCreateRowSorter(true);
		
		//creates an object to listen for selection changes
		//valueChanged() is called whenever the selection changes (clicking a row in live inventory)
		inventoryTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					int viewRow = inventoryTable.getSelectedRow();
					
					if (viewRow != -1) {
						int modelRow = inventoryTable.convertRowIndexToModel(viewRow);
						
						Ingredient ing = inventory.get(modelRow);
						
						nameBox.setText(ing.getName());
						expMonthText.setText(ing.getExpMonth());
						expDateText.setText(String.valueOf(ing.getExpDate()));
						expYearText.setText(String.valueOf(ing.getExpYear()));
					}
				}
			}
		});
		
		liveInventory.setBorder(BorderFactory.createTitledBorder("Live Inventory"));
		liveInventory.add(inventoryScroll, BorderLayout.CENTER);
		
		centerPanel.add(inventoryForm);
		centerPanel.add(liveInventory);
		centerPanel.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 10));
		
		buttons.add(add);
		
		bottomPanel.add(messagesScroll, BorderLayout.CENTER);
		
		bottomPanel.add(buttons, BorderLayout.SOUTH);
		bottomPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		
		
		
		c.setLayout(new BorderLayout());
		
		c.add(header, BorderLayout.NORTH);
		c.add(centerPanel, BorderLayout.CENTER);
		c.add(bottomPanel, BorderLayout.SOUTH);
				
		add.addActionListener(this);
		
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
		
			clearFields();
		}
		
		
		//System.out.println(inventory);
		
		
	}
	
	public void addIngredient(String ingredientName, String expirationMonth, int expirationDate, int expirationYear) {
			
		Ingredient newIngredient = new Ingredient(ingredientName, expirationMonth, expirationDate, expirationYear);
		
		inventory.add(newIngredient);
		
		inventoryModel.addRow(new Object[] { 
				ingredientName,
				expirationMonth,
				expirationDate,
				expirationYear
		});
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
			
	}
	
}
