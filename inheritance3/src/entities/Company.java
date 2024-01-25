package entities;

public class Company extends TaxPayer{
	
	private Integer employees;
	
	public Company() {
	}
	
	public Company(String name, Double anualIncome, Integer employees) {
		super(name, anualIncome);
		this.employees = employees;
	}

	public Integer getEmployees() {
		return employees;
	}

	public void setEmployees(Integer employees) {
		this.employees = employees;
	}

	@Override
	public Double tax() {
		if (getEmployees() <= 10) {
			return getAnualIncome() * 0.16;
		}
		else {
			return getAnualIncome() * 0.14;
		}
	}
	
	
}
