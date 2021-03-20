package il.asulin;

public class EmployeeFactory {
	
	public static Person create(String type, String name, int age, Salary salary) throws CompanyException {
		Person person = null;
		
		if(type.equalsIgnoreCase("employee")) {
			person = new Employee(name,age,salary);
		}else if(type.equalsIgnoreCase("manager")) {
			person = new Manager(name,age,salary);
		}
		
		return person;
	}
}
