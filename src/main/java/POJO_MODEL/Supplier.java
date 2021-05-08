package POJO_MODEL;

public class Supplier {

	
	String supplierId;
	String supplierName;
	String addressStreet1;
	String addressStreet2;
	String city;
	String email;
	String phone;
	String itemId;
	float unitPrice;
	public Supplier(String supplierId, String supplierName, String addressStreet1, String addressStreet2, String city,
			String email, String phone, String itemId, float unitPrice) {
		super();
		this.supplierId = supplierId;
		this.supplierName = supplierName;
		this.addressStreet1 = addressStreet1;
		this.addressStreet2 = addressStreet2;
		this.city = city;
		this.email = email;
		this.phone = phone;
		this.itemId = itemId;
		this.unitPrice = unitPrice;
	}
	public String getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public String getAddressStreet1() {
		return addressStreet1;
	}
	public void setAddressStreet1(String addressStreet1) {
		this.addressStreet1 = addressStreet1;
	}
	public String getAddressStreet2() {
		return addressStreet2;
	}
	public void setAddressStreet2(String addressStreet2) {
		this.addressStreet2 = addressStreet2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public float getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	
}
