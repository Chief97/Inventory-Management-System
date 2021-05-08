package POJO_MODEL;

import java.sql.Date;

public class Employee {

	String employeeId;
	String firstName;
	String middleName;
	String lastName;
	String gender;
	String addressStreet1;
	String addressStreet2;
	String city;
	String province;
	String zipCode;
	String nic;
	Date dob;
	String email;
	String phone;
	String role;
	String site;
	String username;
	String password;
	
	public Employee(String employeeId, String firstName, String middleName, String lastName, String gender,
			String addressStreet1, String addressStreet2, String city, String province, String zipCode, String nic,
			Date dob, String email, String phone, String role, String site, String username, String password) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.gender = gender;
		this.addressStreet1 = addressStreet1;
		this.addressStreet2 = addressStreet2;
		this.city = city;
		this.province = province;
		this.zipCode = zipCode;
		this.nic = nic;
		this.dob = dob;
		this.email = email;
		this.phone = phone;
		this.role = role;
		this.site = site;
		this.username = username;
		this.password = password;
	}
	
	

	public Employee(String employeeId, String firstName, String middleName, String lastName, String gender,
			String addressStreet1, String addressStreet2, String city, String province, String zipCode, String nic,
			Date dob, String email, String phone) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.gender = gender;
		this.addressStreet1 = addressStreet1;
		this.addressStreet2 = addressStreet2;
		this.city = city;
		this.province = province;
		this.zipCode = zipCode;
		this.nic = nic;
		this.dob = dob;
		this.email = email;
		this.phone = phone;
	}



	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getNic() {
		return nic;
	}

	public void setNic(String nic) {
		this.nic = nic;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	 
}
