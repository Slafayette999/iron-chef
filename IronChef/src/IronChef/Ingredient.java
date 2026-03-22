package IronChef;

public class Ingredient {

	private String name;
	private String expMonth;
	private int expDate;
	private int expYear;
	
	int quanity;
	
	public Ingredient(String inName, String exMonth, int exDate, int exYear) {
		name = inName;
		expMonth = exMonth;
		expDate = exDate;
		expYear = exYear;
	}
	
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getExpMonth() {
		return expMonth;
	}
	
	public void setExpMonth(String expMonth) {
		this.expMonth = expMonth;
	}
	
	public int getExpDate() {
		return expDate;
	}
	
	public void setExpDate(int expDate) {
		this.expDate = expDate;
	}
	
	public int getExpYear() {
		return expYear;
	}
	
	public void setExpYear(int expYear) {
		this.expYear = expYear;
	}
	
	public String toString() {
		
		return "\nYou added: " + name + ". \nIt expires on " + expMonth + ", " + expDate + ", " + expYear;
		
	}
	
}
