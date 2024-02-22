package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;


public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		System.out.print("Enter department's name: ");
		String department = sc.next();
		System.out.println("Enter worker Data: ");
		System.out.print("Name: ");
		String name = sc.next();
		System.out.print("Level: ");
		String level = sc.next();
		System.out.print("Base salary: ");
		double baseSalary = sc.nextDouble();
		System.out.print("How many contracts to this worker? ");
		int n = sc.nextInt();
		
		Worker worker = new Worker(name, WorkerLevel.valueOf(level), baseSalary, new Department(department));
		
		for (int i=1; i<=n; i++) {
			System.out.println("Enter contract #"+ i +" data:");
			System.out.print("Date (YYYY-MM-DD): ");
			String date = sc.next();
			System.out.print("Value per hour: ");
			double value = sc.nextDouble();
			System.out.print("Duration (Hours): ");
			Integer hours = sc.nextInt();
			LocalDate contdate = LocalDate.parse(date, format);
			HourContract contract = new HourContract(contdate, value, hours);
			worker.addContract(contract);
		}
		
		System.out.print("Enter year and month to calculate income (YYYY-MM-01): ");
		String date = sc.next();
		System.out.println("Name: "+ worker.getName());
		System.out.println("Department: "+ worker.getDepartment().getName());
		LocalDate contdate = LocalDate.parse(date, format);
		System.out.println("income for "+contdate.getYear()+"-"+contdate.getMonthValue()+": "+ worker.income(contdate));
		
		sc.close();
	}
	
}
