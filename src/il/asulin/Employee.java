package il.asulin;

public class Employee extends Person {

	/*
	 * Attributes
	 */
	private Salary salary;

	/*
	 * Constructor
	 */
	public Employee(String name, int age, Salary salary) throws CompanyException {
		super(name, age);
		this.salary = salary;
	}

	/*
	 *	Getters & Setters
	 */
	public Salary getSalary() {
		return salary;
	}

	public void setSalary(Salary salary) {
		this.salary = salary;
	}

	/*
	 * toString & HashCode & Equals
	 */
	@Override
	public String toString() {
		return super.toString() + ", salary=" + salary;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((salary == null) ? 0 : salary.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (salary == null) {
			if (other.salary != null)
				return false;
		} else if (!salary.equals(other.salary))
			return false;
		return true;
	}

	
	

	
	
	
	
	

}
