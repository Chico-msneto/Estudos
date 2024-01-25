package entities;

public class Individual extends TaxPayer{
	
	private Double healthExp;
	
	public Individual() {
	}
	
	public Individual(String name, Double anualIncome, Double healthExp) {
		super(name, anualIncome);
		this.healthExp = healthExp;
	}

	public Double getHealthExp() {
		return healthExp;
	}

	@Override
	public Double tax() {
		if (getAnualIncome() < 20000.0) {
			if (getHealthExp() != 0.0) {
				return (getAnualIncome() * 0.15) - (getHealthExp() * 0.50); 
			}
			else {
				return getAnualIncome() * 0.15;
			}
		}
		else {
			if (getHealthExp() != 0.0) {
				return (getAnualIncome() * 0.25) - (getHealthExp() * 0.50); 
			}
			else {
				return getAnualIncome() * 0.25;
			}
		}
	}
	
}
