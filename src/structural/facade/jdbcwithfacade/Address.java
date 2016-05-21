package structural.facade.jdbcwithfacade;

public class Address {
	
	private int id;
	private String streetName;
	private String city;
	
	public Address(int id, String streeName, String city) {
		this.id = id;
		this.streetName = streeName;
		this.city = city;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
}
