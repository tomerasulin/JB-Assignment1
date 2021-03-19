package il.asulin;

public class PersonFactory {
	
	public static Person create(String type, String name, int age, Salary salary) throws CompanyException {
		Person person = null;
		
		if(type.equalsIgnoreCase("Employee")) {
			person = new Employee(name,age,salary);
		}else if(type.equalsIgnoreCase("Manager")) {
			person = new Manager(name,age,salary);
		}
		
		return person;
	}
}
