package by.epam.xmlparser.pojo;

public class Depositor {
	
	private String depositorName;
	private String accountId;
	
	public Depositor() {
		super();
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((accountId == null) ? 0 : accountId.hashCode());
		result = prime * result
				+ ((depositorName == null) ? 0 : depositorName.hashCode());
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
		Depositor other = (Depositor) obj;
		if (accountId == null) {
			if (other.accountId != null)
				return false;
		} else if (!accountId.equals(other.accountId))
			return false;
		if (depositorName == null) {
			if (other.depositorName != null)
				return false;
		} else if (!depositorName.equals(other.depositorName))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Depositor [depositorName=" + depositorName + ", accountId="
				+ accountId + "]";
	}
	
	

}
