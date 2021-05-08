package POJO_MODEL;

public class Item {

	String itemId;
	String itemName;
	String description;
	String units;
	int lowStock;
	
	
	
	public Item(String itemId, String itemName, String description, String units, int lowStock) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.description = description;
		this.units = units;
		this.lowStock = lowStock;
	}
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUnits() {
		return units;
	}
	public void setUnits(String units) {
		this.units = units;
	}
	public int getLowStock() {
		return lowStock;
	}
	public void setLowStock(int lowStock) {
		this.lowStock = lowStock;
	}
	
	
	
}
