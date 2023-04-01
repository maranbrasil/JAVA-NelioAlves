package entities;

public class SavingAccount extends Account{

   private Double interestRate;

   public SavingAccount() {
    super();
   }

  public SavingAccount(Integer number, String holder, Double balance, Double interestRate) {
    super(number, holder, balance);
    this.interestRate = interestRate;
  }

  public Double getInterestRate() {
    return interestRate;
  }

  public void setInterestRate(Double interestRate) {
    this.interestRate = interestRate;
  }

  public void updateBalance() {
     balance += balance * interestRate;
  }

  // Na classe Account eu tenho o metodo withdraw que cobra 5 por cada saque. Mas queremos que na poupança nao haja cobranca dessa taxa. entao
  // utilizamos a anotaçao @Override e implementamos a funçao como queremos a
  @Override // sem override nao dá problema, mas é melhor usar pra avisar o compilador e os outros devs.
  public void withdraw(double amount) {
     balance -= amount;
  }
}
