package MainPackage;

import java.util.ArrayList;

//AddressBook is a outer Class
public class AddressBook {
	
	//Location is a Inner Class
	public class Location {
		
		private String country ;
		private String provice;
		private String city;
		private String parish;
		private String alley;
		private String[] location;
		private int x , y ;
		private double r ;
		
		

		public double getR(int i) {
			Contact c = contactArraylist.get(i);
			location = c.getLocation().split(" ");
			return	Double.parseDouble(location[2]);
		}

		public int getX(int i) {
			Contact c = contactArraylist.get(i);
			location = c.getLocation().split(" ");
			return Integer.parseInt(location[0]);
		}

		public int getY(int i) {
			Contact c = contactArraylist.get(i);
			location = c.getLocation().split(" ");
			return Integer.parseInt(location[1]);
		}

		public String getCountry(int i) {
			Contact c = contactArraylist.get(i);
			location = c.getLocation().split(" ");
			return location[3];
		}


		public String getProvince(int i ) {
			Contact c = contactArraylist.get(i);
			location = c.getLocation().split(" ");
			return location[4];
		}

		public String getCity(int i) {
			Contact c = contactArraylist.get(i);
			location = c.getLocation().split(" ");
			return location[5];
		}


		public String getParish(int i) {
			Contact c = contactArraylist.get(i);
			location = c.getLocation().split(" ");
			return location[6];
		}

		public String getAlley(int i) {
			Contact c = contactArraylist.get(i);
			location = c.getLocation().split(" ");
			return location[7];
		}
		
	}
	
	//the most important array list
	ArrayList<Contact> contactArraylist = new ArrayList<Contact>();
	
	//the size of array list
	int contactNumber ;
	
	//the method to update contact ID
	void addContact(Contact contact) {
		contactArraylist.add(contact);
		contactNumber = contactArraylist.size();
	}
	
	//Getter methods
	String getNameArrayList(int i) {
		Contact c = contactArraylist.get(i);
		return c.getName();
	}
	
	String getNumberArrayList(int i) {
		Contact c = contactArraylist.get(i);
		return c.getPhoneNumber();
	}
	
	String getLocationArrayList(int i) {	
		Contact c = contactArraylist.get(i);
		return c.getLocation();
	}
	
	String getBirthDayArrayList(int i) {	
		Contact c = contactArraylist.get(i);
		return c.getBirthDay();
	}
	
	String getGenderArrayList(int i) {	
		Contact c = contactArraylist.get(i);
		return c.getGender();
	}
	
	String getGroupArrayList(int i) {	
		Contact c = contactArraylist.get(i);
		return c.getGroup();
	}
	
	String getEmailArrayList(int i) {	
		Contact c = contactArraylist.get(i);
		return c.getEmail();
	}

	
}

