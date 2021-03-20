package il.asulin;

import java.util.Random;
import java.util.Scanner;

import il.asulin.Department.DepartmentName;

//Singleton class
public class CompanyStatistics {

	//Attributes
	private static CompanyStatistics instance = null;
	private static Company company;
	private static Scanner scanner;
	private static Random rand;
	private static Department[] departments;
	
	/*
	 * Constructors
	 */
	private CompanyStatistics() {
		company = new Company();
		scanner = new Scanner(System.in);
		rand = new Random();
		departments = company.getDepartments();
	}
	
	
	public static CompanyStatistics getInstance() {
		if(instance == null) {
			instance = new CompanyStatistics();
		}
		return instance;
	}
	
	/*
	 * Functions
	 */
	//Creating random company
	public static void createCompany() {		
		DepartmentName[] departmentNames = DepartmentName.values();//Getting the names of all departments
		Person person;
		
		try {
			for(int i=0; i < 5; i++) {
				System.out.println("Please enter manager " + (i+1) + " name");
				person = EmployeeFactory.create("manager", scanner.nextLine(), rand.nextInt(40) + 20,new Salary(rand.nextDouble()*25000 + 25000,rand.nextInt(10000)));
				if(person != null && person instanceof Manager) {
					company.departments[i]= addDepartment(departmentNames[i].getName(), (Manager)person);
					Employee[] employees = company.departments[i].getEmployees();
					for(int j=0; j < 15; j++) {
						System.out.println("Please enter employee " + (j+1) + " name");
						person = EmployeeFactory.create("employee", scanner.nextLine(), rand.nextInt(40) + 20,new Salary(rand.nextDouble()*49000 + 1000,rand.nextInt(10000)));
						if(person != null && person instanceof Employee) {
							employees[j] = (Employee)person;
						}
					}
				}
			}
		}catch(CompanyException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	// function that return a new instance of department class
	public static Department addDepartment(String name, Manager manager) {
		return new Department(name, manager);
	}
	
	
	
	//1 
	//Total average salary(Calculated in Company class)
	public static void totalAverageSalary() {
		System.out.println("The total average salary is " + String.format("%.2f",company.getTotalAverageSalary()) + "NIS");
	}
	
	//2
	//Total average salary of each department
	public static void averageSalaryOfEachDepartment() {
		for(int i=0; i<departments.length; i++) {
			System.out.println("Department= " + departments[i].getDepartmentName() + ", the average salary is= " + String.format("%.2f",departments[i].averageSalary()) + "NIS");	
		}
	}
	
	//3
	//Total average bonus of each department
	public static void averageBonusOfEachDepartment() {
		for(int i=0; i<departments.length; i++) {
			System.out.println("Department= " + departments[i].getDepartmentName() + ", the average bonus is= " + String.format("%.2f",departments[i].averageSalary()) + "NIS");	
		}
	}
	
	///Bonuses
	
	//1
	//Number of workers(without managers) ages 20-30, and average salary
	public static void numOfWorkers1AndAverageSalary() {
		System.out.println("The number of employees without managers in ages 20-30= " + company.getNumberOfEmployeesWithoutManager(30, 20));
		try {
			System.out.println("The average salary is= " + String.format("%.2f",company.getAverageSalaryOfEmployees(30,20)) + "NIS");
		}catch(CompanyException e) {
			System.out.println(e.getMessage());
		}
	}
	
	//2
	//Number of workers(without managers) ages 31 and up, and average salary
	public static void numOfWorkers2AndAverageSalary() {
		System.out.println("The number of employees without managers in ages 31 and up= " + company.getNumberOfEmployeesWithoutManager(60,31));
		try {
			System.out.println("The average salary is= " + String.format("%.2f",company.getAverageSalaryOfEmployees(60,31)) + "NIS");
		}catch(CompanyException e) {
			System.out.println(e.getMessage());
		}
	}
	
	//3
	//The average age of all workers in the company
	public static void averageAgeOfAllWorkers() {
		System.out.println("The average age of all workers in the company= " + company.getAverageAgeOfAllWorkers() + " years old");
	}
	
	//4
	//Average salary of all managers
	public static void averageSalaryOfAllManagers() {
		System.out.println("The average salary of all managers in the company= " + String.format("%.2f",company.getAverageSalaryOfManagers()) + "NIS");
	}
	
	//5
	//Average bonus of all managers
	public static void averageBonusOfAllManagers() {
		System.out.println("The average bonus of all managers in the company= " + String.format("%.2f",company.getAverageBonusOfManagers()) + "NIS");
	}
	
	//6
	//List of all excellent workers in the company(bonus >= 9000)
	public static void excellentWorkers() {
		System.out.println("List of excellent workers:");
		company.getExcellentWorkers();
	}

}
