package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.print("Room number: ");
			int roomNumber = sc.nextInt();
			System.out.print("Check-in date (YYYY-MM-DD): ");
			LocalDate checkin = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			System.out.print("Check-out date (YYYY-MM-DD): ");
			LocalDate checkout = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		
			Reservation room = new Reservation(roomNumber, checkin, checkout);
			System.out.println(room);
			
			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in date (YYYY-MM-DD): ");
			checkin = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			System.out.print("Check-out date (YYYY-MM-DD): ");
			checkout = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		
			room.updateDates(checkin, checkout);
			System.out.println(room);
		}
		catch (DomainException e) {
			System.out.println("Error in reservation: "+ e.getMessage());
		}
		
		sc.close();
	}

}
