package POJO_MODEL;

public class Approval {

	String approvalId;
	String supplierId;
	String itemId;
	String requestId;
	String siteId;
	String approval;

	public Approval(String approvalId, String supplierId, String itemId, String requestId, String siteId,
			String approval) {
		super();
		this.approvalId = approvalId;
		this.supplierId = supplierId;
		this.itemId = itemId;
		this.requestId = requestId;
		this.siteId = siteId;
		this.approval = approval;
	}
	public String getApprovalId() {
		return approvalId;
	}
	public void setApprovalId(String approvalId) {
		this.approvalId = approvalId;
	}
	public String getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public String getRequestId() {
		return requestId;
	}
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
	public String getSiteId() {
		return siteId;
	}
	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}
	public String getApproval() {
		return approval;
	}
	public void setApproval(String approval) {
		this.approval = approval;
	}
	
	
}
