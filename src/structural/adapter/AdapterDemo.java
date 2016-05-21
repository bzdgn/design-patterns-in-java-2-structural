package structural.adapter;

import java.util.List;

public class AdapterDemo {

	public static void main(String[] args) {
		
		EmployeeClient client = new EmployeeClient();
		
		List<Employee> employees = client.getEmployeeList();
		
//		System.out.println(employees);
		printList(employees);
		
	}
	
	private static void printList(List<Employee> list) {
		for(Employee e : list)
			System.out.printf(
				"[Id: %s, Name: %s, Last: %s, Email: %s] \n", 
				e.getId(),
				e.getFirstName(),
				e.getLastName(),
				e.getEmail()
			);
	}

}
