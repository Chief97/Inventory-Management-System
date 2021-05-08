package POJO_MODEL;

import java.sql.Date;

public class Request {

	String requestId;
	String requestedBy;
	String siteId;
	String itemId;
	int amount;
	Date dateNeeded;
	String status;
	String description;
	public Request(String requestId, String requestedBy, String siteId, String itemId, int amount, Date dateNeeded,
			String status, String description) {
		super();
		this.requestId = requestId;
		this.requestedBy = requestedBy;
		this.siteId = siteId;
		this.itemId = itemId;
		this.amount = amount;
		this.dateNeeded = dateNeeded;
		this.status = status;
		this.description = description;
	}
	
	
	
	public Request(String requestId, String itemId, int amount, Date dateNeeded, String description) {
		super();
		this.requestId = requestId;
		this.itemId = itemId;
		this.amount = amount;
		this.dateNeeded = dateNeeded;
		this.description = description;
	}



	public String getRequestId() {
		return requestId;
	}
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
	public String getRequestedBy() {
		return requestedBy;
	}
	public void setRequestedBy(String requestedBy) {
		this.requestedBy = requestedBy;
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
	public Date getDateNeeded() {
		return dateNeeded;
	}
	public void setDateNeeded(Date dateNeeded) {
		this.dateNeeded = dateNeeded;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	
}
