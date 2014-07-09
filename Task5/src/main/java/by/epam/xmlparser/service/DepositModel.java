package by.epam.xmlparser.service;

public class DepositModel {
	
	private String bankName;
    private String countryRegistration;
    private String depositorName;
	private String accountId;
    private String depositType;
    private long amountOnDeposit;
    private double profitability;
    private int timeConstraints;
    
	public DepositModel() {
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
	public String getDepositorName() {
		return depositorName;
	}
	public void setDepositorName(String depositorName) {
		this.depositorName = depositorName;
	}
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public String getDepositType() {
		return depositType;
	}
	public void setDepositType(String depositType) {
		this.depositType = depositType;
	}
	public long getAmountOnDeposit() {
		return amountOnDeposit;
	}
	public void setAmountOnDeposit(long amountOnDeposit) {
		this.amountOnDeposit = amountOnDeposit;
	}
	public double getProfitability() {
		return profitability;
	}
	public void setProfitability(double profitability) {
		this.profitability = profitability;
	}
	public int getTimeConstraints() {
		return timeConstraints;
	}
	public void setTimeConstraints(int timeConstraints) {
		this.timeConstraints = timeConstraints;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((accountId == null) ? 0 : accountId.hashCode());
		result = prime * result
				+ (int) (amountOnDeposit ^ (amountOnDeposit >>> 32));
		result = prime * result
				+ ((bankName == null) ? 0 : bankName.hashCode());
		result = prime
				* result
				+ ((countryRegistration == null) ? 0 : countryRegistration
						.hashCode());
		result = prime * result
				+ ((depositType == null) ? 0 : depositType.hashCode());
		result = prime * result
				+ ((depositorName == null) ? 0 : depositorName.hashCode());
		long temp;
		temp = Double.doubleToLongBits(profitability);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + timeConstraints;
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
		DepositModel other = (DepositModel) obj;
		if (accountId == null) {
			if (other.accountId != null)
				return false;
		} else if (!accountId.equals(other.accountId))
			return false;
		if (amountOnDeposit != other.amountOnDeposit)
			return false;
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
		if (depositType == null) {
			if (other.depositType != null)
				return false;
		} else if (!depositType.equals(other.depositType))
			return false;
		if (depositorName == null) {
			if (other.depositorName != null)
				return false;
		} else if (!depositorName.equals(other.depositorName))
			return false;
		if (Double.doubleToLongBits(profitability) != Double
				.doubleToLongBits(other.profitability))
			return false;
		if (timeConstraints != other.timeConstraints)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "DepositModel [bankName=" + bankName + ", countryRegistration="
				+ countryRegistration + ", depositorName=" + depositorName
				+ ", accountId=" + accountId + ", depositType=" + depositType
				+ ", amountOnDeposit=" + amountOnDeposit + ", profitability="
				+ profitability + ", timeConstraints=" + timeConstraints + "]";
	}
    
    

}
