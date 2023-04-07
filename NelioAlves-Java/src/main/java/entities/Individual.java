package entities;

public class Individual extends TaxPayer{
  private Double healthExpenses;

  public Individual(String name, Double annualIncome, Double healthExpenses) {
    super(name, annualIncome);
    this.healthExpenses = healthExpenses;
  }

  public Double getHealthExpenses() {
    return healthExpenses;
  }

  public void setHealthExpenses(Double healthExpenses) {
    this.healthExpenses = healthExpenses;
  }

  @Override
  public Double taxToPay() {
    var annualIncome = getAnnualIncome();
    double tax = 0;
    if (annualIncome <= 20000) {
      tax = annualIncome * 0.15;
    } else {
      tax = annualIncome * 0.25;
    }

    double taxExpenses = 0;
    if (getHealthExpenses() > 0) {
      taxExpenses = getHealthExpenses() * 0.5;
    }
    return tax - taxExpenses;
  }
}
