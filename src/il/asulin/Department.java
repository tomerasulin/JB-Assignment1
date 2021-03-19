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
	
	public double averageSalary() {
		double res = 0;
		int totalWorkers = 0;
		
		Manager theManager = getManager();
		res += theManager.getSalary().getAmount();
		totalWorkers++;
		
		Employee[] employees = getEmployees();
		for(int i=0 ; i < employees.length; i++) {
			res += employees[i].getSalary().getAmount();
			totalWorkers++;
		}
		
		return res / totalWorkers;
	}
	
	public double averageBonus() {
		double res = 0;
		int totalWorkers = 0;
		
		Manager theManager = getManager();
		res += theManager.getSalary().getYearlyBonus();
		totalWorkers++;
		
		Employee[] employees = getEmployees();
		for(int i=0 ; i < employees.length; i++) {
			res += employees[i].getSalary().getYearlyBonus();
			totalWorkers++;
		}
		
		return res / totalWorkers;
	}
	
	public double salaryWithoutManagerOfWorkersWithAgeBetween20To30() {
		double res = 0;
		
		Employee[] employees = getEmployees();
		for(int i=0; i < employees.length; i++) {
			if(employees[i].getAge() >= 20 && employees[i].getAge() <= 30) {
				res+= employees[i].getSalary().getAmount();
			}
		}
		return res;
	}
	
	public int numOfWorkersAgesBetween20To30WithoutManager() {
		int totalWorkers = 0;
	
		Employee[] employees = getEmployees();
		for(int i=0; i < employees.length; i++) {
			if(employees[i].getAge() >= 20 && employees[i].getAge() <= 30) {
				totalWorkers++;
			}
		}
		return totalWorkers;
	}
	
	public double SalaryWithoutManagerOfWorkersWithAge31Up() {
		double res = 0;
		
		Employee[] employees = getEmployees();
		for(int i=0; i < employees.length; i++) {
			if(employees[i].getAge() >= 31) {
				res+= employees[i].getSalary().getAmount();			
			}
		}
	
		return res;
	}
	
	public int numOfWorkersAges31UpWithoutManager() {
		int totalWorkers = 0;
	
		Employee[] employees = getEmployees();
		for(int i=0; i < employees.length; i++) {
			if(employees[i].getAge() >= 31) {
				totalWorkers++;
			}
		}
		return totalWorkers;
	}
	
	
	public int ageOfAllWorkers() {
		int age = 0;
		
		Employee[] employees = getEmployees();
		for(Employee e: employees) {
			age += e.getAge();
		}
		
		return age;
	}
	
	public void excellentEmployees() {
		Employee[] employees = getEmployees();
		
		for(Employee employee : employees) {
			if(employee.getSalary().getYearlyBonus() >= 9000) {
				System.out.println(employee.getName());
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
