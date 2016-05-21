package structural.facade.jdbcwithfacade;

import java.util.List;

public class JdbcWithFacadeDemo {

	public static void main(String[] args) {
		JdbcFacade jdbcFacade = new JdbcFacade();
		
		int count = jdbcFacade.createTable();
		System.out.println("Table Create Count : " + count);
		
		count = jdbcFacade.insertIntoTable();
		System.out.println("Record Insert Count : " + count);
		
		List<Address> adresses = jdbcFacade.getAddreses();
		
		for(Address address : adresses)
			System.out.println(
				"Id: " + address.getId() + 
				", City: " + address.getCity() + 
				", Street: " + address.getStreetName()
			);
	}

}
