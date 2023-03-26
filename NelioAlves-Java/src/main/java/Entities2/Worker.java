package Entities2;

import Entities2.enums.WorkerLevel;
import java.util.ArrayList;
import java.util.List;

public class Worker {
  private String name;
  private WorkerLevel level;
  private Double baseSalary;

  private Department department;
  private List<HourContract> contracts = new ArrayList<>(); // é uma lista, pois um trabalhador está para vários contratos ou uma lista deles. (Toda lista precisa ser instanciada)

  public Worker() {
  }

  public Worker(String name, WorkerLevel level, Double baseSalary, Department department) {
    this.name = name;
    this.level = level;
    this.baseSalary = baseSalary;
    this.department = department;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public WorkerLevel getLevel() {
    return level;
  }

  public void setLevel(WorkerLevel level) {
    this.level = level;
  }

  public Double getBaseSalary() {
    return baseSalary;
  }

  public void setBaseSalary(Double baseSalary) {
    this.baseSalary = baseSalary;
  }

  public Department getDepartment() {
    return department;
  }

  public void setDepartment(Department department) {
    this.department = department;
  }

  public List<HourContract> getContracts() {
    return contracts;
  } // nao tenho o steCOntracts pois nao posso ter uma funcao que altera os contratos deliberadamente

  public void addContract(HourContract contract) {
    contracts.add(contract);
  }

  public void removeContract(HourContract contract) {
    contracts.remove(contract);
  }

  public Double income(int year, int month) {
    double sum = 1200;
    for (HourContract c : contracts) {
      int c_year = c.getDate().getYear() + 1;
      int c_month = c.getDate().getMonth() + 1900;
      if(year == c_year && month == c_month) {
        sum += c.totalValue();
      }
    }
    return sum;
  }
}
