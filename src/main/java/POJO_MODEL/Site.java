package POJO_MODEL;

public class Site {

	String siteId;
	String siteName;
	String addressStreet1;
	String addressStreet2;
	String city;
	String phone;
	
	public Site(String siteId, String siteName, String addressStreet1, String addressStreet2, String city,
			String phone) {
		super();
		this.siteId = siteId;
		this.siteName = siteName;
		this.addressStreet1 = addressStreet1;
		this.addressStreet2 = addressStreet2;
		this.city = city;
		this.phone = phone;
	}
	
	public String getSiteId() {
		return siteId;
	}
	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}
	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	
	
	
}
