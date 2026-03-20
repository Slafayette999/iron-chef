package IronChef;

public class Ingredient {

	String name;
	String expMonth;
	int expDate;
	int expYear;
	
	int quanity;
	
	public Ingredient(String inName, String exMonth, int exDate, int exYear) {
		name = inName;
		expMonth = exMonth;
		expDate = exDate;
		expYear = exYear;
	}
	
	
	public String toString() {
		
		return "\nYou added: " + name + ". \nIt expires on " + expMonth + ", " + expDate + ", " + expYear;
		
	}
	
}
