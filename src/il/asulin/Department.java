package il.asulin;

import java.util.Arrays;

public class Department {
	
	/*
	 * Enum Of Departments
	 */
	enum DepartmentName{
		Sales("Sales"),
		Finance("Finance"),
		Administration("Administration"),
		Engineering("Engineering"),
		Marketing("Marketing");
		
		String name;
		
		DepartmentName(String name) {
			this.name = name;
		}
		
		public String getName() {
			return this.name;
		}	
	}
	
	/*
	 * Attributes
	 */
	private String departmentName;
	private Manager manager;
	private Employee[] employees;
	private final int SIZE = 15;
	

	/*
	 * Constructor
	 */
	public Department(String departmentName, Manager manager) {
		this.departmentName = departmentName;
		this.manager = manager;
		employees = new Employee[SIZE];//Setting the size of employees of each department to 15 employees
	}

	/*
	 * Getters & Setters
	 */
	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public Employee[] getEmployees() {
		return employees;
	}

	public void setEmployees(Employee[] employees) {
		this.employees = employees;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
	/*
	 * Functions
	 */
	
	//Function that calculate the average salary of each department
	public double averageSalary() {
		double res = 0;
		
		res += getManager().getSalary().getAmount();
	
		for(Employee employee : employees){
			res += employee.getSalary().getAmount();
		}
		
		return res / (employees.length + 1);
	}
	
	//Function that calculate the average bonus of each department
	public double averageBonus() {
		double res = 0;

		res += getManager().getSalary().getYearlyBonus();

		for(Employee employee : employees){
			res += employee.getSalary().getYearlyBonus();
		}
		
		return res / (employees.length + 1);
	}
	
	//function that calculate the salary of all employees in the current department between the ages(maxAge - minAge)
	public double salaryWithoutManagerOfWorkers(int maxAge, int minAge) {
		double res = 0;
		
		for(int i=0; i < employees.length; i++) {
			if(employees[i].getAge() >= minAge && employees[i].getAge() <= maxAge) {
				res+= employees[i].getSalary().getAmount();
			}
		}
		return res;
	}
	
	//This function calculate the numbers of employees without manager between the ages(maxAge - minAge)
	public int numOfWorkersWithoutManager(int maxAge, int minAge) {
		int totalWorkers = 0;
	
		for(int i=0; i < employees.length; i++) {
			if(employees[i].getAge() >= minAge && employees[i].getAge() <= maxAge) {
				totalWorkers++;
			}
		}
		return totalWorkers;
	}
	
	
	//This function return the total age of all workers
	public int ageOfAllWorkers() {
		int age = 0;
		
		for(Employee e: employees) {
			age += e.getAge();
		}
		
		age+= getManager().getAge();
		
		return age;
	}
	
	//this function prints all excellent employees in the current department
	public void excellentEmployees() {
		
		if(getManager().getSalary().getYearlyBonus() >= 9000) {
			System.out.println("Manager: "+getManager().getName());
		}
		
		for(Employee employee : employees) {
			if(employee.getSalary().getYearlyBonus() >= 9000) {
				System.out.println("Employee: "+employee.getName());
			}
		}
	}
	
	
	/*
	 * toString & HashCode & Equals
	 */
	
	
	@Override
	public String toString() {
		return "Department [departmentName=" + departmentName + ", manager=" + manager + ", employees="
				+ Arrays.toString(employees) + "]";
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((departmentName == null) ? 0 : departmentName.hashCode());
		result = prime * result + Arrays.hashCode(employees);
		result = prime * result + ((manager == null) ? 0 : manager.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Department other = (Department) obj;
		if (departmentName == null) {
			if (other.departmentName != null)
				return false;
		} else if (!departmentName.equals(other.departmentName))
			return false;
		if (!Arrays.equals(employees, other.employees))
			return false;
		if (manager == null) {
			if (other.manager != null)
				return false;
		} else if (!manager.equals(other.manager))
			return false;
		return true;
	}

	
}
