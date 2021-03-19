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

	public void setDepartments(Department[] departments) {
		this.departments = departments;
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
		
		System.out.println("Overall salaries " + avg);
		System.out.println("Amount of people " + amount);
		
		return avg / amount;
		
	}
	
	
	public double getAverageSalaryOfEmployeesWithAgeIn20To30() throws CompanyException {
		double res = 0;
		int totalWorkers = 0;
		
		Department[] departments;
		
		departments = getDepartments();
		for(int i=0; i<departments.length; i++) {
			res += departments[i].salaryWithoutManagerOfWorkersWithAgeBetween20To30();
			totalWorkers += departments[i].numOfWorkersAgesBetween20To30WithoutManager();
		}
		
		if(totalWorkers == 0)
			throw new CompanyException("zero workers");
		return res / totalWorkers;
	}
	
	public int getNumberOfEmployeesInAges20To30() {
		int totalEmployees = 0;
		Department[] departments;
		
		departments = getDepartments();
		for(int i=0; i<departments.length; i++) {
			totalEmployees += departments[i].numOfWorkersAgesBetween20To30WithoutManager();
		}
		
		return totalEmployees;
	}
	
	public double getAverageSalaryOfEmployeesWithAge31Up() throws CompanyException {
		double res = 0;
		int totalWorkers = 0;
		
		Department[] departments;
		
		departments = getDepartments();
		for(int i=0; i<departments.length; i++) {
			res += departments[i].SalaryWithoutManagerOfWorkersWithAge31Up();
			totalWorkers += departments[i].numOfWorkersAges31UpWithoutManager();
		}
		
		if(totalWorkers == 0)
			throw new CompanyException("zero workers");
		return res / totalWorkers;
	}
	
	public int getNumberOfEmployeesInAges31Up() {
		int totalEmployees = 0;
		Department[] departments;
		
		departments = getDepartments();
		for(int i=0; i<departments.length; i++) {
			totalEmployees += departments[i].numOfWorkersAges31UpWithoutManager();
		}
		
		return totalEmployees;
	}
	
	public double getAverageAgeOfAllWorkers() {
		double res = 0;
		int totalWorkers = 0;
		Department[] departments;
		
		departments = getDepartments();
		for(int i=0; i<departments.length; i++) {
			res += departments[i].ageOfAllWorkers();
			totalWorkers += departments[i].getEmployees().length + 1;
		}
		
		return res / totalWorkers;
	}
	
	public double getAverageSalaryOfManagers() {
		double res = 0;
		int numOfManagers = 0;
		
		Department[] departments = getDepartments();
		
		for(Department department : departments) {
			res += department.getManager().getSalary().getAmount();
			numOfManagers++;
		}
		return res / numOfManagers;
	}
	
	public double getAverageBonusOfManagers() {
		double res = 0;
		int numOfManagers = 0;
		
		Department[] departments = getDepartments();
		
		for(Department department : departments) {
			res += department.getManager().getSalary().getYearlyBonus();
			numOfManagers++;
		}
		return res / numOfManagers;
	}
	
	
	public void getExcellentWorkers() {
		Department[] departments = getDepartments();
		
		for(Department department : departments)
		{
			if(department.getManager().getSalary().getYearlyBonus() >= 9000) {
				System.out.println(department.getManager().getName());
			}
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
