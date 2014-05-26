package by.epam.task1.entity;

/**
 * Created by Максим&Маша on 18.05.14.
 */
public class BankCredit extends BaseCredit {

    private String bankCreditor;
    private String ensuringType;
    private String description;

    public BankCredit() {
    }

    public String getBankCreditor() {
        return bankCreditor;
    }

    public void setBankCreditor(String bankCreditor) {
        this.bankCreditor = bankCreditor;
    }

    public String getEnsuringType() {
        return ensuringType;
    }

    public void setEnsuringType(String ensuringType) {
        this.ensuringType = ensuringType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        BankCredit that = (BankCredit) o;

        if (bankCreditor != null ? !bankCreditor.equals(that.bankCreditor) : that.bankCreditor != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (ensuringType != null ? !ensuringType.equals(that.ensuringType) : that.ensuringType != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (bankCreditor != null ? bankCreditor.hashCode() : 0);
        result = 31 * result + (ensuringType != null ? ensuringType.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return super.toString() + "{" +
            "bankCreditor='" + bankCreditor + '\'' +
            ", ensuringType='" + ensuringType + '\'' +
            ", description='" + description + '\'' +
            '}';
    }
}
