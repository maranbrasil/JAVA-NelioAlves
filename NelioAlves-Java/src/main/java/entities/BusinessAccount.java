package entities;

public class BusinessAccount extends Account{ // business account tem os mesmos metedos e atributos da classe account
  private double loanLimit;

  public BusinessAccount() {
  }

  public BusinessAccount(Integer number, String holder, Double balance, double loanLimit) {
    super(number, holder, balance); // o super chama dentro os atributos da classe mãe desse construtor. OU seja executa a lógica do construtor da classe mae(super classe)
    this.loanLimit = loanLimit;
  }

  public double getLoanLimit() {
    return loanLimit;
  }

  public void setLoanLimit(double loanLimit) {
    this.loanLimit = loanLimit;
  }

  public void loan(double amount) {
    if(amount <= loanLimit) {
      // deposit(amount); // só consigo pegar o metodo da super classe pq eu transformei essa classe que estou mexendo em herança
      balance += amount - 10.0; // dessa forma o balance fica com erro pois na classe mae o atributo é private(só quem é da mesma classe acessa o atributo). PAra acessar basta tranforma=lo em protected na classe mae.
    }
  }
  @Override
  public void withdraw(double amount) {
    super.withdraw(amount); //com o super eu desconto normalmente como no metodo da classe Account
    balance -= 2.0; // mas aqui eu utilizo um metodo diferente que cobra de forma diferente
  }
}
