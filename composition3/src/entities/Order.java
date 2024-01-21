package entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	
	private LocalDateTime date;
	private OrderStatus status;
	
	List<OrderItem> order = new ArrayList<>();
	Client client;
	
	public Order () {
	}

	public Order(LocalDateTime date, OrderStatus status) {
		this.date = date;
		this.status = status;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	
	public void addItem(OrderItem item) {
		order.add(item);
	}
	
	public void removeItem(OrderItem item) {
		order.remove(item);
	}
	
	public void addClient(Client c) {
		client = c;
	}
	
	public Double total() {
		Double sum = 0.0;
		for (OrderItem c : order) {
			sum += c.subTotal();
		}
		return sum;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Order moment: "+ date + "\n");
		sb.append("Order Status: "+ status + "\n");
		sb.append("Client: "+ client.getName() + " ");
		sb.append("("+ client.getBirthDate()+ ") - "+ client.getEmail()+ "\n");
		sb.append("Order items: \n");
		for (OrderItem c : order) {
			sb.append(c.getProduct().getName()+ ", $");
			sb.append(c.getPrice()+ ", Quantity: ");
			sb.append(c.getQuantity()+ ", Subtotal: $");
			sb.append(c.subTotal()+ "\n");
		}
		sb.append("Total price: $"+ total());
		return sb.toString();
	}
}
