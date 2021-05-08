package POJO_MODEL;

public class Order {

	String orderId;
	String placedBy;
	String supplierId;
	String status;
	String requestId;
	public Order(String orderId, String placedBy, String supplierId, String status, String requestId) {
		super();
		this.orderId = orderId;
		this.placedBy = placedBy;
		this.supplierId = supplierId;
		this.status = status;
		this.requestId = requestId;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getPlacedBy() {
		return placedBy;
	}
	public void setPlacedBy(String placedBy) {
		this.placedBy = placedBy;
	}
	public String getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRequestId() {
		return requestId;
	}
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
	
	
}
