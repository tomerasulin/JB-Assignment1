package il.asulin;

import java.util.Arrays;

public class Company {

	/*
	 * Attributes
	 */
	private final int SIZE = 5;
	Department[] departments;
	
	/*
	 * Constructor
	 */
	public Company() {
		departments = new Department[SIZE];//Setting the size of the departments to 5
	}
	
	/*
	 * Getters & Setters
	 */
	
	public Department[] getDepartments() {
		return departments;
	}

	
	/*
	 * Functions
	 */
	
	//This function calculate the total average salary of all employees(include managers) in the company
	public double getTotalAverageSalary() {
		double avg = 0;
		int amount = 0;
		Department[] departments = getDepartments();
		Employee[] employees;
		Manager manager;
		
		for(int i=0; i < departments.length; i++) {
			employees = (Employee[]) departments[i].getEmployees();
			manager = (Manager) departments[i].getManager();
			avg += manager.getSalary().getAmount();
			amount += employees.length + 1;
			for(int j=0; j < employees.length; j++) {
				avg += employees[i].getSalary().getAmount();
			}
		}	
		return avg / amount;
		
	}
	
	//This function return the average salary of all employees in ages(maxAge - minAge)
	public double getAverageSalaryOfEmployees(int maxAge, int minAge) throws CompanyException {
		double res = 0;
		int totalWorkers = 0;
		
		for(int i=0; i<departments.length; i++) {
			res += departments[i].salaryWithoutManagerOfWorkers(maxAge, minAge);
			totalWorkers += departments[i].numOfWorkersWithoutManager(maxAge,minAge);
		}
		
		if(totalWorkers == 0)
			throw new CompanyException("zero workers");
		return res / totalWorkers;
	}
	
	//Function that return the number of employees between the ages (maxAge - minAge)
	public int getNumberOfEmployeesWithoutManager(int maxAge, int minAge) {
		int totalEmployees = 0;

		for(int i=0; i<departments.length; i++) {
			totalEmployees += departments[i].numOfWorkersWithoutManager(maxAge,minAge);
		}
		
		return totalEmployees;
	}
	
	//Function that calculate the average age of all workers in the company(managers and employees)
	public double getAverageAgeOfAllWorkers() {
		double res = 0;
		int totalWorkers = 0;

		for(int i=0; i<departments.length; i++) {
			res += departments[i].ageOfAllWorkers();
			totalWorkers += departments[i].getEmployees().length + 1;
		}
		
		return res / totalWorkers;
	}
	
	//function that calculate the average salary of all managers
	public double getAverageSalaryOfManagers() {
		double res = 0;
				
		for(Department department : departments) {
			res += department.getManager().getSalary().getAmount();

		}
		return res / departments.length;
	}
	
	//function that calculate the average bonus of all managers
	public double getAverageBonusOfManagers() {
		double res = 0;		
		
		for(Department department : departments) {
			res += department.getManager().getSalary().getYearlyBonus();
		}
		return res / departments.length;
	}
	
	//Function that prints all excellent workers in the company(both managers and employees) with yearly bonus of 9000 and up
	public void getExcellentWorkers() {
		Department[] departments = getDepartments();
		
		for(Department department : departments)
		{
			department.excellentEmployees();
		}
	}
	
	/*
	 * toString & HashCode & Equals
	 */
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(departments);
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
		Company other = (Company) obj;
		if (!Arrays.equals(departments, other.departments))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Company [departments=" + Arrays.toString(departments) + "]";
	}

	
}
