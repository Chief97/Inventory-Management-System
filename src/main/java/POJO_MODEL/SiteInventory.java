package POJO_MODEL;

public class SiteInventory {

	String siteInventoryId;
	String siteId;
	String itemId;
	int amount;
	public SiteInventory(String siteInventoryId, String siteId, String itemId, int amount) {
		super();
		this.siteInventoryId = siteInventoryId;
		this.siteId = siteId;
		this.itemId = itemId;
		this.amount = amount;
	}
	public String getSiteInventoryId() {
		return siteInventoryId;
	}
	public void setSiteInventoryId(String siteInventoryId) {
		this.siteInventoryId = siteInventoryId;
	}
	public String getSiteId() {
		return siteId;
	}
	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
	
}
