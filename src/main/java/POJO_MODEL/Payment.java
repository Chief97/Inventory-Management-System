package POJO_MODEL;

public class Payment {
	String paymentId;
	String orderId;
	float unitPrice;
	int deliveredAmount;
	int requireAmount;
	String supplierId;
	String status;
	
	
	
	public Payment(String paymentId, String orderId, float unitPrice, int deliveredAmount, int requireAmount,
			String supplierId, String status) {
		super();
		this.paymentId = paymentId;
		this.orderId = orderId;
		this.unitPrice = unitPrice;
		this.deliveredAmount = deliveredAmount;
		this.requireAmount = requireAmount;
		this.supplierId = supplierId;
		this.status = status;
	}


	public String getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public float getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}
	public int getDeliveredAmount() {
		return deliveredAmount;
	}
	public void setDeliveredAmount(int deliveredAmount) {
		this.deliveredAmount = deliveredAmount;
	}
	public int getRequireAmount() {
		return requireAmount;
	}
	public void setRequireAmount(int requireAmount) {
		this.requireAmount = requireAmount;
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
	
	
	
}
