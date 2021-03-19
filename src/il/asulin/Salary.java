package il.asulin;

public class Salary {
	
	/**********Attributes********/
	private double amount;
	private int yearlyBonus;
	
	/********Constructor
	 * @throws CompanyException ******/
	public Salary(double amount, int yearlyBonus) throws CompanyException {
		setAmount(amount);
		setYearlyBonus(yearlyBonus);
	}
	
	
	/*********Getters & Setters******/
	
	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) throws CompanyException {
		if(amount < 1000 || amount > 50000)
			throw new CompanyException("invalid amount");
		this.amount = amount;
	}

	public int getYearlyBonus() {
		return yearlyBonus;
	}

	public void setYearlyBonus(int yearlyBonus) throws CompanyException {
		if(yearlyBonus < 0 || yearlyBonus > 10000)
			throw new CompanyException("invalid bonus");
		this.yearlyBonus = yearlyBonus;
	}

	/************toString && Equals && HashCode****************/
	
	@Override
	public String toString() {
		return "Salary [amount=" + amount + ", yearlyBonus=" + yearlyBonus + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + yearlyBonus;
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
		Salary other = (Salary) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (yearlyBonus != other.yearlyBonus)
			return false;
		return true;
	}
	
	
	

}
