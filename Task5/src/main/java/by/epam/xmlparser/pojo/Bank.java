package by.epam.xmlparser.pojo;

public class Bank {
	
	private String bankName;
    private String countryRegistration;
    
	public Bank() {
		super();
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getCountryRegistration() {
		return countryRegistration;
	}
	public void setCountryRegistration(String countryRegistration) {
		this.countryRegistration = countryRegistration;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((bankName == null) ? 0 : bankName.hashCode());
		result = prime
				* result
				+ ((countryRegistration == null) ? 0 : countryRegistration
						.hashCode());
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
		Bank other = (Bank) obj;
		if (bankName == null) {
			if (other.bankName != null)
				return false;
		} else if (!bankName.equals(other.bankName))
			return false;
		if (countryRegistration == null) {
			if (other.countryRegistration != null)
				return false;
		} else if (!countryRegistration.equals(other.countryRegistration))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Bank [bankName=" + bankName + ", countryRegistration="
				+ countryRegistration + "]";
	}
	
	
	
    
    

}
