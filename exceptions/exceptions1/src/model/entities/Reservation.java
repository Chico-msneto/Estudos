package model.entities;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import model.exceptions.DomainException;

public class Reservation {
	
	private Integer roomNumber;
	private LocalDate checkin;
	private LocalDate checkout;
	
	public Reservation() {
	}

	public Reservation(Integer roomNumber, LocalDate checkin, LocalDate checkout) {
		LocalDate now = LocalDate.now();
		if (checkin.isBefore(now) || checkout.isBefore(now)) {
			throw new DomainException("Reservation dates must be future dates");
		}
		if (checkout.isBefore(checkin)) {
			throw new DomainException("check-out date must be after check-in date");
		}
		this.roomNumber = roomNumber;
		this.checkin = checkin;
		this.checkout = checkout;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public LocalDate getCheckin() {
		return checkin;
	}

	public LocalDate getCheckout() {
		return checkout;
	}

	public Integer duration() {
		return Period.between(checkin, checkout).getDays();
	}
	
	public void updateDates(LocalDate checkin, LocalDate checkout) {
		LocalDate now = LocalDate.now();
		if (checkin.isBefore(now) || checkout.isBefore(now)) {
			throw new DomainException("Reservation dates for update must be future dates");
		}
		if (checkout.isBefore(checkin)) {
			throw new DomainException("check-out date must be after check-in date");
		}
		this.checkin = checkin;
		this.checkout = checkout;
	}
	
	public String toString() {
		return "Reservation: Room "
				+ roomNumber
				+ ", check-in: "
				+ checkin.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
				+ ", check-out: "
				+ checkout.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
				+ ", "
				+ duration()
				+ " nights";
	}
}
