package MainPackage;


public class Contact {
	
	private String name;
	private String phoneNumber;
	private String location;
	private String birthDay;
	private String gender;
	private String group;
	private String email;
	
	
	//the constructor of Contact class
	public Contact(String name , String phoneNumber , String location , String birthDay , String gender , String group , String email ) {
		
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.location = location;
		this.birthDay = birthDay;
		this.gender = gender;
		this.group = group;
		this.email = email;
	}
	
	//Getter Setter Methods
	String getName () {
		return name;
	}
	String getPhoneNumber () {
		return phoneNumber;
	}
	String getLocation () {
		return location;
	}
	String getBirthDay () {
		return birthDay;
	}
	String getGender () {
		return gender;
	}
	String getGroup () {
		return group;
	}
	String getEmail () {
		return email;
	}
	
	void setName(String name) {
		this.name = name;
	}
	void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	void setLocation(String location) {
		this.location = location;
	}
	void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}
	void setGender(String gender) {
		this.gender = gender;
	}
	void setGroup(String group) {
		this.group = group;
	}
	void setEmail(String email) {
		this.email = email;
	}
	
}
