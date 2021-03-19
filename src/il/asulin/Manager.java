package il.asulin;

public class Manager extends Employee {

	/*
	 * Constructor
	 */
	public Manager(String name, int age, Salary salary) throws CompanyException {
		super(name, age, salary);
		
	}
	
	@Override
	public Salary getSalary() {
		// TODO Auto-generated method stub
		return super.getSalary();
	}
	
}
