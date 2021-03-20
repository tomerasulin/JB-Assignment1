package il.asulin;

public class Main {

	public static void main(String[] args) {
		
		//Creating the one and only instance of the CompanyStatistics class
		CompanyStatistics.getInstance();
		
		//Initialize the company
		CompanyStatistics.createCompany();
		
		//1
		//total average salary
		CompanyStatistics.totalAverageSalary();
		
		//2
		//total average salary of each department
		CompanyStatistics.averageSalaryOfEachDepartment();
		
		//3
		//total average bonus of each department
		CompanyStatistics.averageBonusOfEachDepartment();
		
		//Bonus
		//1
		//number of workers(without managers) ages 20-30 and average salary
		CompanyStatistics.numOfWorkers1AndAverageSalary();
		
		//2
		//number of workers(without managers) ages 31 and up and average salary
		CompanyStatistics.numOfWorkers2AndAverageSalary();
		
		//3
		//The average age of total of workers
		CompanyStatistics.averageAgeOfAllWorkers();
		
		//4
		//The average salary of all managers in the company
		CompanyStatistics.averageSalaryOfAllManagers();
		
		//5
		//The average bonus of all managers in the company
		CompanyStatistics.averageBonusOfAllManagers();
		
		//6
		//List of excellent workers in the company(bonus >= 9000)
		CompanyStatistics.excellentWorkers();
		
		
	}
}
