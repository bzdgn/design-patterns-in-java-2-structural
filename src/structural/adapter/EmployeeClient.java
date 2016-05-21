package structural.adapter;

import java.util.ArrayList;
import java.util.List;

public class EmployeeClient {
	
	public List<Employee> getEmployeeList() {
		
		List<Employee> employees = new ArrayList<>();
		
		Employee employeeFromDB = new EmployeeDB("1234", "Mehmet", "DummyOglu", "dummyoglu@example.com");
		
		employees.add(employeeFromDB);
		
		// Use Adapter Pattern here to get Legacy Code Model Object : EmployeeLdap
		//
		// This won't work ;
		//Employee employeeFromLdap = new EmployeeLdap("1539", "Solo", "Han", "han@example.com");
		EmployeeLdap employeeFromLdap = new EmployeeLdap("1539", "Solo", "Han", "han@example.com");
		
		employees.add(new EmployeeAdapterLdap(employeeFromLdap));
		
		
		EmployeeCSV employeeFromCSV = new EmployeeCSV("567,Sherlock,Holmes,sherlock@example.com");
		
		// Again Use Adapter Pattern, because this won't work;
		//employees.add(employeeFromCSV);
		employees.add(new EmployeeAdapterCSV(employeeFromCSV));
		
		return employees;
	}
	
}
