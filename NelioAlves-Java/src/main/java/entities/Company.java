package entities;

public class Company extends TaxPayer{
  private int numberOfEmployees;

  public Company(String name, Double annualIncome, int numberOfEmployees) {
    super(name, annualIncome);
    this.numberOfEmployees = numberOfEmployees;
  }

  public int getNumberOfEmployees() {
    return numberOfEmployees;
  }

  public void setNumberOfEmployees(int numberOfEmployees) {
    this.numberOfEmployees = numberOfEmployees;
  }

  @Override
  public Double taxToPay() {
    if (getNumberOfEmployees() > 10) {
      return getAnnualIncome() * 0.14;
    } else {
      return getAnnualIncome() * 0.16;
    }
  }
}
