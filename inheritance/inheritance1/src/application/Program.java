package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;
import entities.OutsourcedEmployee;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Employee> list = new ArrayList<>();

		System.out.print("Enter the number of employees: ");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.println("Employee #" + i + " data:");
			System.out.print("Outsourced? (y/n) ");
			char x = sc.next().charAt(0);
			System.out.print("Name: ");
			String name = sc.next();
			System.out.print("Hours: ");
			int hours = sc.nextInt();
			System.out.print("Value per hour: ");
			Double valuePerHours = sc.nextDouble();
			if (x == 'y') {
				System.out.print("Additional charge: ");
				Double additionalCharge = sc.nextDouble();
				list.add(new OutsourcedEmployee(name, hours, valuePerHours, additionalCharge));
			} else
				list.add(new Employee(name, hours, valuePerHours));
		}
		
		System.out.println();
		System.out.println("PAYMENTS: ");
		
		for (Employee emp: list) {
			System.out.println(emp.getName()+" - $ "+emp.payment());
		}

		sc.close();
	}

}
